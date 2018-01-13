package ucmo.cs.networking.project;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectiveRepeat extends Applet implements ActionListener, Runnable {

	private static final long serialVersionUID = 1L;
	
	//Indication of packets and acknowledgments with different colors
    final Color no_ack_clr = new Color(12,122,144);
    final Color ack_clr = new Color(255,255,10);
    final Color selected_clr =  new Color(255,0,0);
    final Color moving_pckt_clr = new Color(255,218,185);
    final Color moving_ack_clr = new Color(255,255,10);
    final Color destination_clr = new Color(22,142,14);
    final Color ack_received = new Color(37, 135, 234);
    
	private static final int window_packt_size = 5;
    final int default_sender_window_size = 5; // Default values for the packet to be sent in the output
    final int default_receiver_window_size_ = 5;  // the maximum number of the packets the receiver can hold..
	final int default_packet_width = 18;  // The following are the user interface components for displaying.
	final int default_packet_height = 28;
	final int default_offset_height = 110;
	final int default_offset_width = 60;
	final int default_clearance_width = 280;
	final int timeOut_Multiplier = 1000;
	
	final int minimum_frames_per_sec = 4;
	final int step_fps = 3;
	final int de_selected = -1;
	final int default_fps = 5;
	final int default_packets_size = 24;// for simplicity packets are constant
	final int default_time_out_sec = 22;// retransmission time
	 
    //define our buttons for actions available to be taken by the user
    Button start, stop, fast, slow, kill, clean;
  
    int base, base_receiver, next_seq_sum, frames_per_sec, selected = de_selected, time_out,
	time_out_Pckt, last_Suc_Pckt;
    boolean timer_Flag, timer_Sleep;
   
	/*
	 * 2 threads runs for the selective repeat approach 
	 * srThread - runs and creates the user interface which is intractable with the user. 
	 * timerThread -  is created and runs based on the timeouts given in the program. 
	 * This is responsible for the retransmission of the lost packets or acks.
	 */
	Thread srApproachThread, timerThread;

	TextArea commentsBox; // Comments section for displaying the happening process
	Dimension dimensions;
	Image image;  // implements double buffering to provide a smoother animation
	Graphics graphics; // graphics component used for drawing the process happening
	Packet sender_array[];  // sender array - holds the packets being sent

	// Declaring properties of our window
	int length_window, pckt_width, pckt_height, offset_height, offset_width, clearance_width,
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
	next_seq_sum = 0; 
	frames_per_sec = default_fps; 
	sender_array = new Packet[pckts_total];
	
	start = new Button("Send New Packet(s)"); // Command button for sending the packets
	start.setActionCommand("rdt"); // to determine which button was pressed in the actionPerformed method
	start.addActionListener(this); 	//appropriate action is taken depending on the button pressed
	start.setBounds(100, 20, 130, 20); // dimensions for the button placed in the layout
	
	stop = new Button("Pause"); // Stop Button
	stop.setActionCommand("stopanim");
	stop.addActionListener(this);
	stop.setBounds(230, 20, 60, 20);
	
	fast = new Button("Increase Speed"); // Speed Increase Button
	fast.setActionCommand("fast");
	fast.addActionListener(this);
	fast.setBounds(290, 20, 110, 20);
	
	slow = new Button("Decrease Speed"); // Speed Reduce Button
	slow.setActionCommand("slow");
	slow.addActionListener(this);
	slow.setBounds(400, 20, 110, 20);
	
	kill = new Button("Kill Pckt/Ack"); // Kill the packet or the acknowledgement
	kill.setActionCommand("kl");
	kill.addActionListener(this);
	kill.setEnabled(false);
	kill.setBounds(510, 20, 90, 20);
	
	clean = new Button("Reset"); //Resets all the process
	clean.setActionCommand("rst");
	clean.addActionListener(this);
	clean.setBounds(600, 20, 90, 20);
	//Adding all the declared buttons to the layout 
	add(start);
	add(stop); 
	add(fast);
	add(slow);
	add(kill);
	add(clean);
	commentsBox.append("Selective Repeat Process Starts\n");
	commentsBox.append("Ready to run. Press 'Send New Packet(s)' button to start.\n"); 
			}
private void setupLayoutParameters() {
	
	String window_length = getParameter("window_length");
	String packet_width = getParameter("Packet_width");
	String packet_height = getParameter("Packet_height");
	String h_offset = getParameter("horizontal_offset");
	String v_offset = getParameter("vertical_offset");
	String v_clearance = getParameter("vertical_clearance");
	String total_packets = getParameter("total_Packets");
	String timer_timeOut = getParameter("timer_time_out");
	try {
	if (window_length != null) {
		length_window = Integer.parseInt(window_length);
		length_window = (length_window > 0) ? length_window: default_sender_window_size;
	} else
		length_window = default_sender_window_size;
	if (packet_width != null) {
		pckt_width = Integer.parseInt(packet_width);
		pckt_width = (pckt_width > 0) ? pckt_width : default_packet_width;
	} else
		pckt_width = default_packet_width;
	if (packet_height != null) {
		pckt_height = Integer.parseInt(packet_height);
		pckt_height = (pckt_height > 0) ? pckt_height : default_packet_height;
	} else
		pckt_height = default_packet_height;
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
	if (total_packets != null) {
		pckts_total = Integer.parseInt(total_packets);
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
		pckt_height = (pckt_height > 0) ? pckt_height : default_packet_height;
		offset_height = (offset_height > 0) ? offset_height : default_offset_height;
		offset_width = (offset_width > 0) ? offset_width : default_offset_width;
		clearance_width = (clearance_width > 0) ? clearance_width : default_clearance_width;
		pckts_total = (pckts_total > 0) ? pckts_total : default_packets_size;
		time_out_sec = (time_out_sec > 0) ? time_out_sec : default_time_out_sec;
	System.out.println("in exception : "+e);
	}
}

   
public void start() {
	if (srApproachThread == null)
	    srApproachThread = new Thread(this);
	srApproachThread.start();
}
    
public void run() {
	boolean stopCheck = false;
	if (sender_array[pckts_total - 1] != null) {
	    for (int i = pckts_total - length_window; i < pckts_total; i++)
		if (!sender_array[i].pckt_acknowledged) {
		    stopCheck = false;
		    break;
		} else {
		    stopCheck = true;
		}
	    if (stopCheck) {
	    	commentsBox.append("Stop and Check.\n");
	    	commentsBox.append("Data transferred and the simulation is finished.\n");
		srApproachThread = null;
		return;
    }
	}
	Thread currenthread = Thread.currentThread();
	while (currenthread == srApproachThread)
	    if (on_The_Way(sender_array)) 
	{
	    for (int i = 0; i < pckts_total; i++){
			if (sender_array[i] != null) {
			    if (sender_array[i].on_the_way) {
					if (sender_array[i].postion_pckt < (clearance_width - pckt_height))
					    sender_array[i].postion_pckt += 5;
					else if (sender_array[i].Pckt_ack) {
					    sender_array[i].destination_reached = true;
					    if (check_tot_packets(i)) {
							sender_array[i].postion_pckt = pckt_height + 5;
							sender_array[i].Pckt_ack = false;
							if (sender_array[i].is_buffered || sender_array[i].pckt_acknowledged) {
							    commentsBox.append("Packet " + i + " received. Selective acknowledge for only Packet " + i + " sent.\n");
	    sender_array[i].pckt_received = true;
	} else if (!sender_array[i].pckt_received) {
	    commentsBox.append("Packet " + i + " received. Selective acknowledge for only Packet " + i + " sent. Packet " + i + " delivered to application.\n");
	    sender_array[i].pckt_received = true;
	} else
	    commentsBox.append("Packet " + i + " received out of order. Selective acknowledge for only Packet " + i + " sent again\n");
		sender_array[i].pckt_received = true;
		deliver_Buffered_Packets(i);
	}
	else if (sender_array[i].pckt_acknowledged) {
		sender_array[i].postion_pckt = pckt_height + 5;
		sender_array[i].Pckt_ack = false;
		commentsBox.append("Packet " + i + " received. Selective acknowledge for only Packet " + i + " sent.\n");
		sender_array[i].pckt_received = true;
		deliver_Buffered_Packets(i);
	} else {
		sender_array[i].is_buffered = true;
		sender_array[i].postion_pckt = pckt_height + 5;
		sender_array[i].Pckt_ack = false;
		commentsBox.append("Packet " + i + " received out of order.  Packet buffered. Selective acknowledge for only Packet " + i + " sent.\n");
			sender_array[i].pckt_received = true;
			deliver_Buffered_Packets(i);
			if (i == selected) {
			    selected = -1;
			    kill.setEnabled(false);
			}
	    }
	} else if (!sender_array[i].Pckt_ack) {
	    commentsBox.append("Selective ACK for only Packet " + i + " received. Timer for Packet " + i + " stopped.\n");
	sender_array[i].on_the_way = false;
	if (check_tot_packets(i)) {
		sender_array[i].pckt_acknowledged = true;
		sender_array[i].is_buffered = false;
	} else {
		sender_array[i].pckt_acknowledged = true;
		sender_array[i].is_buffered = true;
	}
	if (i == selected) {
		selected = -1;
		kill.setEnabled(false);
	}
	timerThread = null; 
				    for (int k = base; k < pckts_total; k++) {
						if (sender_array[k] != null) {
						    if (sender_array[base].pckt_acknowledged) {
						    	sender_array[base].is_buffered = false;
								if (k + length_window < pckts_total){
									base = base + 1;
								}
						    }
						} else
					    break;
				    }
				    if (next_seq_sum < base + length_window)
					start.setEnabled(true);
				    if (base != next_seq_sum) {
						timerThread = new Thread(this);
						timer_Sleep = true;
						timerThread.start();
				    }
				}
			    }
			}
	    }
	repaint();
	try {
	Thread.sleep(1000 / frames_per_sec);
	} catch (InterruptedException e) {
	System.out.println("Help");
		    }
		} else
		    srApproachThread = null;
	while (currenthread == timerThread)
	    if (timer_Sleep) {
		timer_Sleep = false;
		try {
		    Thread.sleep(time_out_sec * 1000);
		} catch (InterruptedException e) {
		    System.out.println("Timer interrupted.");
		}
	    } else
		retransmitionOfKilledPackets();
}
public boolean on_The_Way(Packet pac[]) {
	for (int i = 0; i < pac.length; i++)
	    if (pac[i] == null)
		return false;
	    else if (pac[i].on_the_way)
		return true;
	
	return false;
}
void deliver_Buffered_Packets(int PacketNumber) {
	int j = 0;
	while (j < PacketNumber) {
	    if (sender_array[j] == null)
		return;
	    else if (sender_array[j].pckt_acknowledged) {
		sender_array[j].is_buffered = false;
		j++;
	    } else
		break;
	}
	if (j > 0)
	    j--;
	for (int k = j; k < pckts_total; k++) {
	    if (sender_array[k] == null)
		break;
	    else if (sender_array[k].is_buffered) {
		sender_array[k].is_buffered = false;
		commentsBox.append("Buffered Packet " + k + " delivered to application.\n");
	} else if (sender_array[k].pckt_acknowledged) {
	sender_array[k].pckt_acknowledged = true;
	sender_array[k].is_buffered = false;
	} else if (!sender_array[k].Pckt_ack) {
	sender_array[k].is_buffered = false;
	    } else
		break;
	}
	int count = 0;
	for (int i = 0; i < pckts_total; i++)
	    if (sender_array[i] != null) {
		if (sender_array[i].pckt_received){
		    if (i + 1 <= (pckts_total - default_receiver_window_size_))
			count = i + 1;
		}else 
		    break;
	    } else
		break;
	base_receiver = count;
}
private void retransmitionOfKilledPackets() {
	int retransmitPacket = 0;
	for (int n = base; n < base + length_window; n++)
	    if (sender_array[n] != null)
		if (!sender_array[n].pckt_acknowledged && !sender_array[n].is_buffered) {
		    sender_array[n].on_the_way = true;
		    sender_array[n].Pckt_ack = true;
		    sender_array[n].postion_pckt = pckt_height + 5;
		    retransmitPacket++;
		} else if (!sender_array[n].pckt_acknowledged && sender_array[n].is_buffered) {
		    sender_array[n].on_the_way = true;
		    sender_array[n].Pckt_ack = true;
		    sender_array[n].postion_pckt = pckt_height + 5;
		    retransmitPacket++;
		}
	timer_Sleep = true;
	if (srApproachThread == null) {
	    srApproachThread = new Thread(this);
	    srApproachThread.start();
	}
	if (retransmitPacket == 0) {
	    timerThread = null;
	} else
	    commentsBox.append("Timeout occurred for Packet(s). Timer(s) restarted for Packet(s). \n");
}
public void actionPerformed(ActionEvent e) {
	commentsBox.append("in actionevent");
	String cmd = e.getActionCommand();
	if (cmd == "rdt" && next_seq_sum < base + length_window) {
		sender_array[next_seq_sum] = new Packet(true, pckt_height + window_packt_size,next_seq_sum);
		commentsBox.append("Packet " + next_seq_sum + " sent\n");
		commentsBox.append("Timer started for Packet " + next_seq_sum + "\n");
	if (base == next_seq_sum){
	    if (timerThread == null)
		timerThread = new Thread(this);
	    timer_Sleep = true;
	    timerThread.start();
	}
	    repaint();
	    next_seq_sum++;
	    if (next_seq_sum == base + length_window)
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
		srApproachThread = null;
		if (timerThread != null) {
		timer_Flag = true;
		timerThread = null; // added later
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
		if (sender_array[selected].Pckt_ack) {
			commentsBox.append("Packet " + selected + " lost\n");
	} else
		commentsBox.append("Selective Ack of Packet " + selected+ " lost.\n");
	    sender_array[selected].on_the_way = false;
	    kill.setEnabled(false);
	    selected = de_selected;
	    repaint();
	}
	else if (cmd == "rst")
	    reset_app();
}
public boolean mouseDown(Event e, int x, int y) {
	int location, xpos, ypos;
	location = (x - offset_height) / (pckt_width + 7);
	if (location >= pckts_total || location < 0) {
	    selected = de_selected;
	    return false;
	}
	if (sender_array[location] != null) {
	    xpos = offset_height + (pckt_width + 7) * location;
	    ypos = sender_array[location].postion_pckt;
	    if (x >= xpos && x <= xpos + pckt_width && sender_array[location].on_the_way) {
		if ((sender_array[location].Pckt_ack && y >= offset_width + ypos && y <= offset_width + ypos + pckt_height) || ((!sender_array[location].Pckt_ack) && y >= offset_width + clearance_width - ypos && y <= offset_width + clearance_width - ypos + pckt_height)) {
		    if (sender_array[location].Pckt_ack)
			commentsBox.append("Packet " + location + " selected.\n");
	else
		commentsBox.append("Selective Ack " + location+ " selected.\n");
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
	Dimension d = size();
	if ((graphics == null) || (d.width != dimensions.width) || (d.height != dimensions.height)) {
	    dimensions = d;
	    image = createImage(d.width, d.height);
	    graphics = image.getGraphics();
	}
	graphics.setColor(Color.white);
	graphics.fillRect(0, 0, d.width, d.height);
	graphics.setColor(Color.black);
	graphics.draw3DRect(offset_height + base * (pckt_width + 7) - 4,offset_width - 3, (length_window) * (pckt_width + 7) + 1,pckt_height + 6, true);
	graphics.draw3DRect(offset_height + base_receiver * (pckt_width + 7) - 4,offset_width + 222, ((default_receiver_window_size_) * (pckt_width + 7) + 1),pckt_height + 6, true);
	for (int i = 0; i < pckts_total; i++) {
		graphics.setColor(Color.black);
		graphics.drawString("" + i, offset_height + (pckt_width + 7) * i, offset_width - 4);
		graphics.drawString("" + i, offset_height + (pckt_width + 7) * i, offset_width + clearance_width + 30);
	if (sender_array[i] == null) {
		graphics.setColor(Color.black);
		graphics.draw3DRect(offset_height + (pckt_width + 7) * i,offset_width, pckt_width, pckt_height, true);
		graphics.draw3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width, pckt_width, pckt_height, true);
	} else {
	if (sender_array[i].pckt_acknowledged)
	    graphics.setColor(ack_received);
	else
	    graphics.setColor(no_ack_clr);
		graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width, pckt_width, pckt_height, true);
	if (sender_array[i].is_buffered)
	    graphics.setColor(Color.GRAY);
	else
		graphics.setColor(destination_clr);
	if (sender_array[i].destination_reached)
	    graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width, pckt_width, pckt_height,true);
	else {
	    graphics.setColor(Color.black);
	    graphics.draw3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width, pckt_width, pckt_height,true);
	}
	if (sender_array[i].on_the_way) {
	    if (i == selected)
		graphics.setColor(selected_clr);
	    else if (sender_array[i].Pckt_ack)
		graphics.setColor(moving_pckt_clr);
	    else if (sender_array[i].pckt_received)
	    graphics.setColor(moving_ack_clr);
	else
		graphics.setColor(moving_ack_clr);
	if (sender_array[i].Pckt_ack) {
		graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width + sender_array[i].postion_pckt, pckt_width,pckt_height, true);
		graphics.setColor(Color.black);
		graphics.drawString("" + i, offset_height+ (pckt_width + 7) * i, offset_width + sender_array[i].postion_pckt);
	} else {
		graphics.fill3DRect(offset_height + (pckt_width + 7) * i,offset_width + clearance_width - sender_array[i].postion_pckt,pckt_width, pckt_height, true);
	if (sender_array[i].out_of_order) {
	    graphics.setColor(Color.black);
	    graphics.drawString("" + sender_array[i].for_ack,offset_height + (pckt_width + 7) * i, offset_width+ clearance_width- sender_array[i].postion_pckt);
	} else {
	    graphics.setColor(Color.black);
	    graphics.drawString("" + i, offset_height+(pckt_width + 7) * i, offset_width+ clearance_width - sender_array[i].postion_pckt);
		}
	    }
	} 
	} 
	} 
	graphics.setColor(Color.black);
	int newvOffset = offset_width + clearance_width + pckt_height;
	int newHOffset = offset_height;
	graphics.drawString("(S) - Action at Sender (R) - Action at Receiver",newHOffset + 60, newvOffset + 90);
	graphics.drawString("Packet", newHOffset + 15, newvOffset + 60);
	graphics.drawString("Ack Received", newHOffset + 225,newvOffset + 60);
	graphics.drawString("Ack", newHOffset + 170, newvOffset + 60);
	graphics.drawString("Received", newHOffset + 85, newvOffset + 60);
	graphics.drawString("Selected", newHOffset + 335, newvOffset + 60);
	graphics.drawString("Buffered", newHOffset + 415, newvOffset + 60);
	graphics.drawString("base = " + base, offset_height + (pckt_width + 7)* pckts_total + 10, offset_width + 33);
	graphics.drawString("nextseqnum = " + next_seq_sum, offset_height+(pckt_width + 7) * pckts_total + 10, offset_width + 50);
	graphics.setColor(Color.blue);
	graphics.drawString("Sender (Send Window Size = " + length_window + ")", offset_height + (pckt_width + 7) * pckts_total + 10, offset_width + 12);
	graphics.drawString("Receiver (Receiver Window Size = " + default_receiver_window_size_ + ")", offset_height + (pckt_width + 7) * pckts_total + 10, offset_width + clearance_width + 12);
	graphics.setColor(Color.gray);
	graphics.draw3DRect(newHOffset - 10, newvOffset + 42, 475, 25, true);
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
	graphics.setColor(Color.GRAY);
	graphics.fill3DRect(newHOffset + 400, newvOffset + 50, 10, 10, true);
	g.drawImage(image, 0, 0, this);
}

public boolean check_tot_packets(int packno) {
	for (int i = 0; i < packno; i++)
	    if (!sender_array[i].destination_reached)
		return false;
	return true;
}

public void reset_app() {
	for (int i = 0; i < pckts_total; i++)
	    if (sender_array[i] != null)
		sender_array[i] = null;
	
	base = 0;
	base_receiver = 0;
	next_seq_sum = 0;
	selected = de_selected;
	frames_per_sec = default_fps;
	timer_Flag = false;
	timer_Sleep = false;
	srApproachThread = null;
	timerThread = null;
	
	if (stop.getActionCommand() == "startanim"){
		slow.setEnabled(true);
		fast.setEnabled(true);
	    }
	
	start.setEnabled(true);
	kill.setEnabled(false);
	stop.setLabel("Stop Animation");
	stop.setActionCommand("stopanim");
	commentsBox.append("Simulation restarted. Press 'Send New' to start.\n");
		repaint();
	    }   
}