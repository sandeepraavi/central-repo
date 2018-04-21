package ucmo.cs.networking.project;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GoBackNApproach extends Applet implements ActionListener, Runnable {

	private static final long serialVersionUID = 1L;
	private static final int window_packet_size = 4;
	// Default values for the packet to be sent in the process
	final int default_sender_window_size = 4;
	// the maximum number of the packets the receiver can hold at a time. In Go-Back-N it is 1
	final int default_receiver_window_size_ = 1;
	// The following are the user interface components for displaying the process of transmission.
	
	//Indication of packets and acknowledgments with different colors in the user interface.
	final Color no_ack_clr = new Color(12,122,144);
	final Color ack_clr = new Color(255,255,10);
	final Color selected_clr = new Color(255,0,0);
	final Color moving_pckt_clr = new Color(255,218,185);
	final Color moving_ack_clr = new Color(255,255,10);
	final Color destination_clr = new Color(22,142,14);
	final Color ack_received = new Color(37, 135, 234);
	
	final int default_packet_width = 18;
	final int default_packet_height = 28;
	final int default_offset_height = 110;
	final int default_offset_width = 60;
	final int default_clearance_width = 280;
	final int timeOut_Multiplier = 1000;

	final int minimum_frames_per_sec = 4;
	final int step_fps = 3;
	final int de_selected = -1;
	final int default_fps = 5;
	final int default_packets_size = 24; // for simplicity packets are constant
	final int default_time_out_sec = 25; // retransmission time

	int base, base_receiver, next_sequence, frames_per_sec, selected = de_selected, time_out,
			time_out_pckt, last_succ_pckt;
	boolean timer_Flag, timer_Sleep;

	// define our command buttons for actions available which can be controlled by the user
	Button start, clean, fast, slow, stop, kill ;
	/*
	 * 2 threads runs for the go back n approach 
	 * gbnTread - runs and creates the user interface which is intractable with the user.
	 * timerThread - is created and runs based on the timeouts given in the program.
	 *  This is responsible for the retransmission of the lost packets or acks.
	 */
	Thread gobnThread, timerThread;

	TextArea commentsBox; // Comments section for displaying the happenning process
	Dimension dimensions;
	Image image; // implements double buffering to provide a smoother animation
	Graphics graphics; // graphics component used for drawing the process happenning
	GBNPacket sender_array[]; // sender array - holds the packets being sent

	// Declaring properties of our window
	int length_window, pckt_width, packt_height, offset_height, offset_width, clearance_width,
	pckts_total, time_out_sec;

	/**
	 * Init method is to set up the applet running for the process. First method is for loading the code and helps in
	 * setting up the parameters for the user interface
	 */
	public void init() {
		setLayout(null);
		setSize(1200, 1200);
		commentsBox = new TextArea(150, 150); // creates text area for console comments box
		commentsBox.setBounds(100, 500, 1000, 150); // dimensions for the comment box
		commentsBox.setEditable(false); //Non editable comments box
		add(commentsBox); // Shows the comment box with the inputs obtained from the results
		setupLayoutParameters();

		base = 0; 
		base_receiver = 0; 
		next_sequence = 0; 
		frames_per_sec = default_fps; 
		sender_array = new GBNPacket[pckts_total];

		start = new Button("Send New Packet(s)"); // Command button for sending the packets
		start.setActionCommand("rdt"); // to determine which button was pressed in the actionPerformed method
		start.addActionListener(this); 	//appropriate action is taken depending on the button pressed
		start.setBounds(100, 20, 130, 20); // dimensions for the button placed in the layout

		fast = new Button("Increase Speed"); // Increase the speed of the animation
		fast.setActionCommand("fast");
		fast.addActionListener(this);
		fast.setBounds(290, 20, 110, 20);

		slow = new Button("Decrease Speed"); // Reduce  the speed of the animation
		slow.setActionCommand("slow");
		slow.addActionListener(this);
		slow.setBounds(400, 20, 110, 20);

		kill = new Button("Kill Pckt/Ack"); // Kill the packet or the acknowledgment
		kill.setActionCommand("kl");
		kill.addActionListener(this);
		kill.setEnabled(false);
		kill.setBounds(510, 20, 90, 20);

		clean = new Button("Reset"); //Resets all the process
		clean.setActionCommand("rst");
		clean.addActionListener(this);
		clean.setBounds(600, 20, 90, 20);
		
		stop = new Button("Pause"); // Pauses the transmission (visual purpose)
		stop.setActionCommand("stopanim");
		stop.addActionListener(this);
		stop.setBounds(230, 20, 60, 20);
		//Adding all the declared buttons to the layout 
		add(start);
		add(stop); 
		add(fast);
		add(slow);
		add(kill);
		add(clean);
		commentsBox.append("GoBackN Process Starts\n");
		commentsBox.append("Ready to run. Press 'Send New Packet(s)' button to start.\n"); 
	}
	
	private void setupLayoutParameters() {
		String window_length, packet_width, packet_height, h_offset, v_offset, v_clearance, tot_packts, timer_timeOut;
		window_length = getParameter("window_length");
		packet_width = getParameter("packet_width");
		packet_height = getParameter("packet_height");
		h_offset = getParameter("horizontal_offset");
		v_offset = getParameter("vertical_offset");
		v_clearance = getParameter("vertical_clearance");
		tot_packts = getParameter("total_packets");
		timer_timeOut = getParameter("timer_time_out");
		try {
			if (window_length != null) {
				length_window = Integer.parseInt(window_length);
				length_window = (length_window > 0) ? length_window : default_sender_window_size;
			} else
				length_window = default_sender_window_size;
			if (packet_width != null) {
				pckt_width = Integer.parseInt(packet_width);
				pckt_width = (pckt_width > 0) ? pckt_width : default_packet_width;
			} else
				pckt_width = default_packet_width;
			if (packet_height != null) {
				packt_height = Integer.parseInt(packet_height);
				packt_height = (packt_height > 0) ? packt_height : default_packet_height;
			} else
				packt_height = default_packet_height;
			if (h_offset != null) {
				offset_height = Integer.parseInt(h_offset);
				offset_height = (offset_height > 0) ? offset_height : default_offset_height;
			} else
				offset_height = default_offset_height;
			if (v_offset != null) {
				offset_width = Integer.parseInt(v_offset);
				offset_width = (offset_width > 0) ? offset_width : default_offset_width;
			} else
				offset_width = default_offset_width;
			if (v_clearance != null) {
				clearance_width = Integer.parseInt(v_clearance);
				clearance_width = (clearance_width > 0) ? clearance_width : default_clearance_width;
			} else
				clearance_width = default_clearance_width;
			if (tot_packts != null) {
				pckts_total = Integer.parseInt(tot_packts);
				pckts_total = (pckts_total > 0) ? pckts_total : default_packets_size;
			} else
				pckts_total = default_packets_size;
			if (timer_timeOut != null) {
				time_out_sec = Integer.parseInt(timer_timeOut);
				time_out_sec = (time_out_sec > 0) ? time_out_sec : default_time_out_sec;
			} else
				time_out_sec = (time_out_sec > 0) ? time_out_sec : default_time_out_sec;
		} catch (Exception e) {
			length_window = (length_window > 0) ? length_window : default_sender_window_size;
			pckt_width = (pckt_width > 0) ? pckt_width : default_packet_width;
			packt_height = (packt_height > 0) ? packt_height : default_packet_height;
			offset_height = (offset_height > 0) ? offset_height : default_offset_height;
			offset_width = (offset_width > 0) ? offset_width : default_offset_width;
			clearance_width = (clearance_width > 0) ? clearance_width : default_clearance_width;
			pckts_total = (pckts_total > 0) ? pckts_total : default_packets_size;
			time_out_sec = (time_out_sec > 0) ? time_out_sec : default_time_out_sec;
		}
	}
	public void start() {
		if (gobnThread == null)
			gobnThread = new Thread(this);
		gobnThread.start();
	}

	public void run() {
		if (sender_array[pckts_total - 1] != null)
			if (sender_array[pckts_total - 1].pckt_acknowledged) {
				sender_array[pckts_total - 1].pckt_position += window_packet_size;
				gobnThread = null;
				commentsBox.append("Data Transferred and the Simulation is completed\n");
				return;
			}
		System.gc();
		Thread currenthread = Thread.currentThread();
		while (currenthread == gobnThread) {
			if (on_The_Way(sender_array)) {
				for (int i = 0; i < pckts_total; i++)
					if (sender_array[i] != null) 
						if (sender_array[i].on_the_way) 
							if (sender_array[i].pckt_position < (clearance_width - packt_height))
								sender_array[i].pckt_position += window_packet_size; 
							else if (sender_array[i].pckt_ack) {
								deliveringThePackets(i);
							} else if (!sender_array[i].pckt_ack) {
								if (sender_array[i].ack_for != i) {
									int location = sender_array[i].ack_for;
									if (!sender_array[location].pckt_acknowledged) {
										commentsBox.append("Cumulative Ack received for Packet(s) up to and including Packet " + location + ". Timer for Packet(s) up to and including " + location + " stopped\n");
										sender_array[location].pckt_received = true;
										sender_array[location].on_the_way = false;
										sender_array[location].pckt_acknowledged = true;
										sender_array[i].pckt_ack = false;
										sender_array[i].on_the_way = false;
										goBackNSimulation(location);
									} else {
										commentsBox.append("Cumulative Ack for Packet(s) up to and including " + sender_array[i].ack_for + " received again \n");
										sender_array[i].pckt_position = packt_height + window_packet_size;
										sender_array[i].pckt_ack = false;
										sender_array[i].on_the_way = false;
									}
								} else {
									commentsBox.append("Cumulative Ack received for Packet(s) up to and including  " + i  + "\n");
									commentsBox.append("Timer(s) for Packet(s) up to and including " + i + " stopped\n");
									sender_array[i].pckt_received = true;
									sender_array[i].on_the_way = false;
									goBackNSimulation(i);
								}
							}
				repaint();
				try {
					Thread.sleep(timeOut_Multiplier / frames_per_sec);
					time_out = (timeOut_Multiplier / frames_per_sec);
				} catch (InterruptedException e) {
					commentsBox.append("Help\n");
				}
			}
			else
				gobnThread = null;
		}

		while (currenthread == timerThread) {
			if (timer_Sleep) {
				timer_Sleep = false;
				try {
					Thread.sleep(time_out_sec * timeOut_Multiplier);
					time_out = (time_out_sec * timeOut_Multiplier);
				} catch (InterruptedException e) {
					commentsBox.append("Timer interrupted.\n");
					return;
				}
			} else
				retransmitionOfKilledPackets();
		}
	}
	public boolean on_The_Way(GBNPacket pac[]) {
		for (int i = 0; i < pac.length; i++)
			if (pac[i] == null)
				return false;
			else if (pac[i].on_the_way)
				return true;
		return false;
	}
	private void deliveringThePackets(int packetNumber) {
		sender_array[packetNumber].destination_reached = true;
		if (sender_array[packetNumber].ack_for != packetNumber) {
			commentsBox.append("Cumulative Ack for Packets up to and including " + sender_array[packetNumber].ack_for + " received again \n");
			sender_array[packetNumber].pckt_position = packt_height + window_packet_size;
			sender_array[packetNumber].pckt_ack = false;
		} else if (check_packetSize(packetNumber) && packetNumber >= base_receiver) {
			sender_array[packetNumber].pckt_position = packt_height + window_packet_size;
			sender_array[packetNumber].pckt_ack = false;
			last_succ_pckt = packetNumber;
			commentsBox.append("Packet " + packetNumber + " received. Cumulative Ack for Packets up to and including " + packetNumber  + " sent. Packet " + packetNumber + " delivered to application\n");
			if (base_receiver + 1 < pckts_total && base_receiver <= last_succ_pckt)
				base_receiver = base_receiver + 1;
		}
		else {
			if (base == 0 && sender_array[0].pckt_ack && base_receiver ==0) {
				commentsBox.append("Packet " + packetNumber + " received out of order - no Packets acknowledged. Special case -  No Ack sent\n");
				sender_array[packetNumber].pckt_position = packt_height + window_packet_size;
				sender_array[packetNumber].on_the_way = false;
				sender_array[packetNumber].destination_reached = false;
			}
			else if(packetNumber < base_receiver){
				sender_array[packetNumber].pckt_position = packt_height + window_packet_size;
				sender_array[packetNumber].pckt_ack = false;
				commentsBox.append("Packet " + packetNumber + " received out of order Dropping Packet " + packetNumber + ". Cumulative Ack for Packets up to and including " + (last_succ_pckt) + " sent\n");
			}
			else {
				sender_array[packetNumber].pckt_position = packt_height + window_packet_size;
				sender_array[packetNumber].pckt_ack = false;
				sender_array[packetNumber].ack_for = last_succ_pckt;
				sender_array[packetNumber].destination_reached = false;
				sender_array[packetNumber].out_of_order = true;
				commentsBox.append("Packet " + packetNumber + " received out of order. Dropping Packet " + packetNumber + ". Cumulative Ack for Packets up to and including " + (last_succ_pckt) + " sent\n");
				if (packetNumber == selected) {
					selected = de_selected;
					kill.setEnabled(false);
				}
			}
		}
	}
	private void retransmitionOfKilledPackets() {
		for (int n = (base == 0) ? 0 : base - 1; n < base + length_window; n++) {
			if (sender_array[n] != null)
				if (!sender_array[n].pckt_acknowledged) {
					sender_array[n].on_the_way = true;
					sender_array[n].pckt_ack = true;
					sender_array[n].pckt_position = packt_height + window_packet_size;
					sender_array[n].ack_for = n;
				}
			timer_Sleep = true;
			if (gobnThread == null) {
				gobnThread = new Thread(this);
				gobnThread.start();
			}
		}
		for(int i = base; i < pckts_total; i++)
			if(sender_array[i].pckt_acknowledged == false)
			{
				commentsBox.append("Timeout occurred for Packet " + (i) + ". \n");
				break;
			}
		commentsBox.append("All outstanding Packet(s) from " + base + " to " + (next_sequence - 1) + " are restransmitted. Timer(s) restarted for Packet(s)\n");
	}
	public void goBackNSimulation(int i) {
		for (int n = 0; n <= i; n++) {
			sender_array[n].pckt_acknowledged = true;
		}
		if (i == selected) {
			selected = de_selected;
			kill.setEnabled(false);
		}
		timerThread = null; 
		if (i + length_window < pckts_total)
			base = i + 1;
		if (next_sequence < base + length_window)
			start.setEnabled(true);
		if (base != next_sequence) {
			if (last_succ_pckt < (pckts_total - 1))
				if (sender_array[last_succ_pckt + 1] != null && i != last_succ_pckt)
					commentsBox.append("Timer still running for Packet " + (last_succ_pckt) + ".\n");
				else if (sender_array[last_succ_pckt + 1] != null)
					commentsBox.append("Timer still running for Packet " + (last_succ_pckt + 1) + ".\n");
			timerThread = new Thread(this);
			timer_Sleep = true;
			timerThread.start();
		} else
			sender_array[i].out_of_order = false;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == "rdt" && next_sequence < base + length_window) {
			sender_array[next_sequence] = new GBNPacket(true, packt_height + window_packet_size, next_sequence);
			commentsBox.append("Packet " + next_sequence + " sent\n");
			commentsBox.append("Timer started for Packet " + next_sequence + "\n");
			if (base == next_sequence)
			{
				if (timerThread == null)
					timerThread = new Thread(this);
				timer_Sleep = true;
				timerThread.start();
			}
			repaint();
			next_sequence++;
			if (next_sequence == base + length_window)
				start.setEnabled(false);
			start();
		}
		else if (cmd == "fast"){
			frames_per_sec += step_fps;
			commentsBox.append("Simulation speed increased\n");
		}
		else if (cmd == "slow" && frames_per_sec > minimum_frames_per_sec) {
			frames_per_sec -= step_fps;
			commentsBox.append("Simulation speed decreased\n");
		}
		else if (cmd == "stopanim") {
			commentsBox.append("Simulation paused\n");
			gobnThread = null;
			if (timerThread != null) {
				timer_Flag = true;
				timerThread = null;
			}
			stop.setLabel("Resume");
			stop.setActionCommand("startanim");
			start.setEnabled(false);
			slow.setEnabled(false);
			fast.setEnabled(false);
			kill.setEnabled(false);
			repaint();
		}
		else if (cmd == "startanim") {
			commentsBox.append("Simulation resumed.\n");
			stop.setLabel("Pause");
			stop.setActionCommand("stopanim");
			if (timer_Flag) {
				timerThread = new Thread(this);
				timer_Sleep = true;
				timerThread.start();
			}
			start.setEnabled(true);
			slow.setEnabled(true);
			fast.setEnabled(true);
			kill.setEnabled(true);
			repaint(); 
			start();
		}
		else if (cmd == "kl") {
			if (sender_array[selected].pckt_ack) {
				commentsBox.append("Packet " + selected + " lost\n");
			} else
				commentsBox.append("Cumulative Ack of Packet " + selected + " lost.\n");
			sender_array[selected].on_the_way = false;
			kill.setEnabled(false);
			selected = de_selected;
			repaint();
		}
		else if (cmd == "rst")
			resetToNew();
	}
	public boolean mouseDown(Event e, int x, int y) {
		int location, xpos, ypos;
		location = (x - offset_height) / (pckt_width + 7);
		if (location >= pckts_total || location < 0){
			selected = de_selected;
			return false;
		}
		if (sender_array[location] != null) {
			xpos = offset_height + (pckt_width + 7) * location;
			ypos = sender_array[location].pckt_position;
			System.out.println("xpos"+xpos+"ypos"+ypos);
			if (x >= xpos && x <= xpos + pckt_width && sender_array[location].on_the_way) {
				if ((sender_array[location].pckt_ack && y >= offset_width + ypos && y <= offset_width + ypos + packt_height) || 
						((!sender_array[location].pckt_ack) && y >= offset_width + clearance_width - ypos && y <= offset_width + clearance_width - ypos + packt_height)) {
					if (sender_array[location].pckt_ack)
						commentsBox.append("Packet " + location + " selected.\n");
					else
						commentsBox.append("Cumulative Ack " + location + " selected.\n");
					sender_array[location].pckt_selected = true;
					selected = location;
					kill.setEnabled(true);
					repaint();
				} else {
					commentsBox.append("Click on a moving Packet to select.\n");
					selected = de_selected;
				}
			} else {
				commentsBox.append("Click on a moving Packet to select.\n");
				selected = de_selected;
			}
		}

		return true;
	}
	public void paint(Graphics g){
		update(g);
	}
	public void update(Graphics g) {
		Dimension d = getSize();
		if ((graphics == null) || (d.width != dimensions.width)
				|| (d.height != dimensions.height)) {
			dimensions = d;
			image = createImage(d.width, d.height);
			graphics = image.getGraphics();
		}
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, d.width, d.height);
		graphics.setColor(Color.black);
		graphics.draw3DRect(offset_height + base * (pckt_width + 7) - 4, offset_width - 3, (length_window) * (pckt_width + 7) + 1, packt_height + 6, true);
		graphics.draw3DRect(offset_height + base_receiver * (pckt_width + 7) - 4,offset_width + 222, ((default_receiver_window_size_) * (pckt_width + 7) + 1),packt_height + 6, true);
		for (int i = 0; i < pckts_total; i++) {
			graphics.setColor(Color.black);
			graphics.drawString("" + i, offset_height + (pckt_width + 7) * i, offset_width - 4);
			graphics.drawString("" + i, offset_height + (pckt_width + 7) * i, offset_width + clearance_width + 30);
			if (sender_array[i] == null) {
				graphics.setColor(Color.black);
				graphics.draw3DRect(offset_height + (pckt_width + 7) * i,offset_width, pckt_width, packt_height, true);
				graphics.draw3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width, pckt_width, packt_height, true);
			} else {
				if (sender_array[i].pckt_acknowledged)
					graphics.setColor(ack_received);
				else
					graphics.setColor(no_ack_clr);
				graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width, pckt_width, packt_height, true);
				if (sender_array[i].is_buffered)
					graphics.setColor(Color.GRAY);
				else
					graphics.setColor(destination_clr);
				if (sender_array[i].destination_reached)
					graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width, pckt_width, packt_height, true);
				else {
					graphics.setColor(Color.black);
					graphics.draw3DRect(offset_height + (pckt_width + 7) * i, offset_width + clearance_width, pckt_width, packt_height, true);
				}
				if (sender_array[i].on_the_way) {
					if (i == selected)
						graphics.setColor(selected_clr);
					else if (sender_array[i].pckt_ack)
						graphics.setColor(moving_pckt_clr);
					else if (sender_array[i].pckt_received)
						graphics.setColor(ack_received);
					else
						graphics.setColor(moving_ack_clr);
					if (sender_array[i].pckt_ack) {
						graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width + sender_array[i].pckt_position, pckt_width,packt_height, true);
						graphics.setColor(Color.black);
						graphics.drawString("" + i, offset_height+ (pckt_width + 7) * i, offset_width+ sender_array[i].pckt_position);
					} else {
						graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width - sender_array[i].pckt_position,pckt_width, packt_height, true);
						if (sender_array[i].out_of_order) {
							graphics.setColor(Color.black);
							graphics.drawString("" + sender_array[i].ack_for,offset_height + (pckt_width + 7) * i, offset_width+ clearance_width - sender_array[i].pckt_position);
						} else {
							graphics.setColor(Color.black);
							graphics.drawString("" + i, offset_height + (pckt_width + 7) * i, offset_width + clearance_width - sender_array[i].pckt_position);
						}
					}
				} 
			} 
		} 
		graphics.setColor(Color.black);
		int newvOffset = offset_width + clearance_width + packt_height;
		int newHOffset = offset_height;
		graphics.drawString("(S) - Action at Sender(R) - Action at Receiver",newHOffset + 60, newvOffset + 90);
		graphics.drawString("Packet", newHOffset + 15, newvOffset + 60);
		graphics.drawString("Ack Received", newHOffset + 225,newvOffset + 60);
		graphics.drawString("Ack", newHOffset + 170, newvOffset + 60);
		graphics.drawString("Received", newHOffset + 85, newvOffset + 60);
		graphics.drawString("Selected", newHOffset + 335, newvOffset + 60);
		graphics.drawString("base = " + base, offset_height + (pckt_width + 7)* pckts_total + 10, offset_width + 33);
		graphics.drawString("nextseqnum = " + next_sequence, offset_height + (pckt_width + 7) * pckts_total + 10, offset_width + 50);
		graphics.setColor(Color.blue);
		graphics.drawString("Sender (Send Window Size = " + length_window + ")", offset_height + (pckt_width + 7) * pckts_total + 10, offset_width + 12);
		graphics.drawString("Receiver (Receiver Window Size = " +  default_receiver_window_size_ + ")", offset_height + (pckt_width + 7) * pckts_total + 10, offset_width + clearance_width + 12);
		graphics.setColor(Color.gray);
		graphics.draw3DRect(newHOffset - 10, newvOffset + 42, 400, 25, true);
		graphics.setColor(moving_pckt_clr);
		graphics.fill3DRect(newHOffset, newvOffset + 50, 10, 10, true);
		graphics.setColor(moving_ack_clr);
		graphics.fill3DRect(newHOffset + 155, newvOffset + 50, 10, 10, true);
		graphics.setColor(ack_received);
		graphics.fill3DRect(newHOffset + 210, newvOffset + 50, 10, 10, true);
		graphics.setColor(destination_clr);
		graphics.fill3DRect(newHOffset + 70, newvOffset + 50, 10, 10, true);
		graphics.setColor(selected_clr);
		graphics.fill3DRect(newHOffset + 320, newvOffset + 50, 10, 10, true);
		g.drawImage(image, 0, 0, this);
	}
	
	public boolean check_packetSize(int packno) {
		for (int i = 0; i < packno; i++)
			if (!sender_array[i].destination_reached)
				return false;
		return true;
	}
	public void resetToNew() {

		for (int i = 0; i < pckts_total; i++)
			if (sender_array[i] != null)
				sender_array[i] = null;
		base = 0;
		base_receiver = 0;
		next_sequence = 0;
		selected = de_selected;
		frames_per_sec = default_fps;
		timer_Flag = false;
		timer_Sleep = false;
		gobnThread = null;
		timerThread = null;

		if (stop.getActionCommand() == "startanim")	{
			slow.setEnabled(true);
			fast.setEnabled(true);
		}
		start.setEnabled(true);
		kill.setEnabled(false);
		stop.setLabel("Pause");
		stop.setActionCommand("Stop the process");
		commentsBox.append("Simulation restarted. Press 'Send New Packet(s)' to start.\n");
		repaint();
	}
}