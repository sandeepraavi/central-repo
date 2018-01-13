package com.company;

import com.sun.org.apache.bcel.internal.generic.FALOAD;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;

public class GBN
{
    public static int windowSize;
    public static Vector<Packet> ReceiverArray = new Vector<>();
    public static Vector<Packet> SenderArray = new Vector<>();

    public static Integer Transmission_Delay;
    public static Integer End_to_End_delay;    //Propagation Delay
    public static Integer TimeOut;
    public static Integer number_of_packets_emitted_per_minute;
    public static Float Packet_Loss_Probability;

    public static HashMap<Integer, Packet> Slidingwindow = new HashMap<>(windowSize);

    public static Vector<Integer> Acknowledged = new Vector<>();
    public static Vector<Integer> Received = new Vector<>();
    public static Vector<Integer> Time_Outed = new Vector<>();

    public static boolean GoBackN = true;
    public static String input_message = "There are many variations of passages of Lorem " +
            "Ipsum available, but the majority have suffered alteration in some form, by " +
            "injected humour, or randomised words which don't look even slightly believable." +
            " If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't" +
            " anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators" +
            " on the Internet tend to repeat predefined chunks as necessary, making this" +
            " the first true generator on the Internet. It uses a dictionary of over 200 Latin words," +
            " combined with a handful of model sentence structures, to generate Lorem Ipsum which " +
            "looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, " +
            "injected humour, or non-characteristic words etc.";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Integer user_input_variable;
        float input_value;
        //Data to be send
        byte[] fileBytes = input_message.getBytes();
        System.out.println("Input_message size: " + input_message.length());

        Integer count = 0;
        do {
            if (count > 0)
                System.out.println("Error...!!! Window Size must be greater than 1" +
                        "\nOr else it will act as a stop and wait but less than 11.\nPlease enter again.");
            ++count;
            // Getting the Window Size from the User.
            System.out.print("Enter the Window Size: ");
            user_input_variable = sc.nextInt();
        } while (user_input_variable <= 1 || user_input_variable > 10);

        //sets the window size for the windows
        windowSize = user_input_variable;

        count = 0;
        do {
            if (count > 0)
                System.out.println("Error...!!! TimeOut must be between 1000 to 30000 milliseconds." +
                        "\nPlease enter again.");
            ++count;
            // Getting the TimeOut from the User.
            System.out.print("Enter TimeOut: ");
            user_input_variable = sc.nextInt();
        } while (user_input_variable < 1000 || user_input_variable > 30000);
        //Setting the TimeOut
        TimeOut = user_input_variable;

        count = 0;
        do {
            if (count > 0)
                System.out.println("Error...!!! The Packet loss probability must be between 0 to 1." +
                        "\nPlease enter again.");
            ++count;
            // Getting the TimeOut from the User.
            System.out.print("Enter Packet loss Probability: ");
            input_value = (float) sc.nextDouble();
        } while (input_value < 0 || input_value > 1);

        Packet_Loss_Probability = input_value;

        count = 0;
        do {
            if (count > 0)
                System.out.println("Error...!!! Number of packets emitted per minute must be between 1 to 120." +
                        "\nPlease enter again.");
            ++count;
            // Getting the Number of packets emitted per minute form sender from the User.
            System.out.print("Enter Number of packets emitted per minute:\n" +
                    "The number of packets the upper layer tries to send per minute: ");
            user_input_variable = sc.nextInt();
        } while (user_input_variable < 1 || user_input_variable > 120);

        //Setting the TimeOut
        number_of_packets_emitted_per_minute = user_input_variable;

        /*
        *   Loading the data into Packet, here the transmission delay will occurred
        *   Transmission delay is the amount of time required to push all the packet's
        *   bits into the wire. In other words, this is the delay caused by the data-rate
        *   of the link.
        */
        Transmission_Delay = number_of_packets_emitted_per_minute / 60;

        count = 0;
        do {
            if (count > 0)
                System.out.println("Error...!!! End to End to delay must be between 1000 to 20000 milliseconds." +
                        "\nPlease enter again.\n");
            ++count;
            // Getting the Window Size from the User.
            System.out.print("Enter the End to End Delay:\n" +
                    "Time a packet takes from one station to the other station: ");
            user_input_variable = sc.nextInt();
        } while (user_input_variable < 1000 || user_input_variable > 20000);

        //Time a packet takes from one station to the other.
        End_to_End_delay = user_input_variable - Transmission_Delay;

        count = 0;
        do {
            if (count > 0)
                System.out.println("Error...!!! Please enter correct choice.");
            ++count;
            // Getting the Window Size from the User.
            System.out.print("Select the Protocol:\n" +
                    "Press 1 for GoBackN\nPress 2 for Selective Repeat: ");
            user_input_variable = sc.nextInt();
        } while (user_input_variable < 1 || user_input_variable > 2);

        //Time a packet takes from one station to the other.
        if (user_input_variable == 1)
            GoBackN = true;
        else
            GoBackN = false;

        // Now we have to load the packet into sender array
        Packet.PacketSize = 64;
        for (Integer i = 0; i <= fileBytes.length / Packet.PacketSize; i++)
        {
            Packet packet = new Packet();
            packet.ID = i + 1;
            packet.End_to_End_Delay = End_to_End_delay;
            packet.TimeOut = TimeOut;

            Integer from = i * Packet.PacketSize;
            Integer to = from + Packet.PacketSize;
            if (to <= fileBytes.length)
                packet.data = Arrays.copyOfRange(fileBytes, from, to);
            else
                packet.data = Arrays.copyOfRange(fileBytes, from, fileBytes.length - 1);

            SenderArray.add(i, packet);
        }

        if (!GoBackN)
        {
            long startTime = System.nanoTime();
            Integer iterator = 0;
            Integer last_Received = -1;
            Boolean packet_received = false;
            boolean last_packet = false;

            System.out.println("\n\t***************SELECTIVE REPEAT***************\n");
            do {
                if (last_Received == -1)    // no Packet received yet.
                {
                    if (Slidingwindow.size() < windowSize)
                    {
                        if (Math.random() > Packet_Loss_Probability)
                            System.out.println("Sending Packet no. " + slide_forward(last_Received));
                        else {
                            Iterator i = SenderArray.iterator();
                            boolean status = false;
                            int ii = 0;
                            while (i.hasNext() && !status)
                            {
                                Packet p = (Packet) i.next();
                                status = !p.databuffered;
                                ++ii;
                            }
                            System.out.println("Packet no. " + ii + " is lost.");
                        }
                    }
                } else {  /* do nothing */ }

                if (last_Received >= 0 && packet_received)
                {
                    TreeMap<Integer, Packet> map = new TreeMap<>(Slidingwindow);
                    int max_key = map.floorKey(SenderArray.size() + 5);
                    do {
                        if (Math.random() > Packet_Loss_Probability)
                        {
                            int o = slide_forward(last_Received);
                            if (o >= 0 && !last_packet)
                            {
                                if (o == SenderArray.size())
                                    last_packet = true;
                                System.out.println("Sending Packet no. " + o);
                            } else {  /* Do nothing */ }
                        } else {
                            Iterator i = SenderArray.iterator();
                            boolean status = false;
                            int ii = 0;
                            while (i.hasNext() && !status) {
                                Packet p = (Packet) i.next();
                                if (!p.databuffered)
                                    status = true;
                                ++ii;
                            }
                            if (!last_packet)
                                System.out.println("Packet no. " + ii + " is lost.");
                        }
                    }while(Slidingwindow.size() < windowSize &&
                            max_key < SenderArray.size());
                    packet_received = false;
                } else {  /* do nothing */ }
                if (Time_Outed.size() > 0)
                {
                    Iterator i = Time_Outed.iterator();
                    while (i.hasNext())
                    {
                        Integer o = (Integer)i.next();
                        System.out.println("Packet no. " + o + " is timed out.");
                        System.out.println("Sending Packet no. " + o);
                    }
                    Time_Outed.clear();
                } else {   /* do nothing.*/ }

                acknowledge();
                Receive();

                if (Acknowledged.size() > 0) {
                    Iterator i = Acknowledged.iterator();
                    while (i.hasNext()) {
                        Integer p = (Integer) i.next();
                        System.out.println("Packet no. " + p + " is Acknowledged.");
                    }
                    Acknowledged.clear();
                } else { /* Do nothing */ }

                if (Received.size() > 0) {
                    Iterator i = Received.iterator();
                    while (i.hasNext()) {
                        iterator += Packet.PacketSize;
                        Integer p = (Integer) i.next();
                        Slidingwindow.remove(p);
                        System.out.println("Packet no. " + p + " is Received.");
                        ReceiverArray.add(SenderArray.get(p-1));
                        last_Received = p;
                        packet_received = true;
                    }
                    Received.clear();
                } else { /* Do nothing */ }
            } while (iterator < fileBytes.length);
            long stopTime = System.nanoTime();
            System.out.println("Execution Time = " +  ((stopTime - startTime)/1000000) + " milliseconds." );
        }
        else
        {
            long startTime = System.nanoTime();
            Integer iterator = 0;
            Integer last_Received = -1;
            Boolean packet_received = false;
            int timer = TimeOut;
            boolean last_packet = false;

            System.out.println("\n\t***************GO BACK N***************\n");
            do
            {
                if (last_Received == -1)    // no Packet received yet.
                {
                    if (Slidingwindow.size() < windowSize)
                    {
                        if (Math.random() > Packet_Loss_Probability)
                            System.out.println("Sending Packet no. " + slide_forward(last_Received));
                        else
                        {
                            Iterator i = SenderArray.iterator();
                            boolean status = false;
                            int ii = 0;
                            while (i.hasNext() && !status)
                            {
                                Packet p = (Packet) i.next();
                                status = !p.databuffered;
                                ++ii;
                            }
                            System.out.println("Packet no. " + ii + " is lost.");
                        }
                    }
                }
                else
                {  /* do nothing */ }

                if (last_Received >= 0 && packet_received)
                {
                    TreeMap<Integer, Packet> map = new TreeMap<>(Slidingwindow);
                    int max_key = map.floorKey(SenderArray.size() + 5);
                    do {
                        if (Math.random() > Packet_Loss_Probability) {
                            int o = slide_forward(last_Received);
                            if (o >= 0 && !last_packet) {
                                if (o == SenderArray.size())
                                    last_packet = true;
                                System.out.println("Sending Packet no. " + o);
                            } else {  /* Do nothing */ }
                        } else {
                            Iterator i = SenderArray.iterator();
                            boolean status = false;
                            int ii = 0;
                            while (i.hasNext() && !status) {
                                Packet p = (Packet) i.next();
                                status = !p.databuffered;
                                ++ii;
                            }
                            if (!last_packet)
                                System.out.println("Packet no. " + ii + " is lost.");
                        }
                    }while(Slidingwindow.size() < windowSize &&
                            max_key < SenderArray.size());
                    timer = TimeOut;
                    packet_received = false;
                }
                else
                {  /* do nothing */ }
                if (timer <= 0)
                {
                    System.out.println("Timeout Occurred....\nResending all the Packets in the " +
                            "Sliding Window.");

                    Iterator i = Slidingwindow.entrySet().iterator();
                    while (i.hasNext())
                    {
                        Map.Entry pair = (Map.Entry) i.next();
                        System.out.println("Sending Packet no. " + pair.getKey());
                    }
                    timer = TimeOut;
                }
                else
                {   /* do nothing.*/  }

                acknowledge();
                Receive();

                if (Acknowledged.size() > 0)
                {
                    Iterator i = Acknowledged.iterator();
                    while (i.hasNext())
                    {
                        Integer p = (Integer) i.next();
                        System.out.println("Packet no. " + p + " is Acknowledged.");
                    }
                    Acknowledged.clear();
                }
                else{ /* Do nothing */  }

                if (Received.size() > 0)
                {
                    Iterator i = Received.iterator();
                    while (i.hasNext())
                    {
                        iterator += Packet.PacketSize;
                        Integer p = (Integer) i.next();
                        Slidingwindow.remove(p);
                        System.out.println("Packet no. " + p + " is Received.");
                        ReceiverArray.add(SenderArray.get(p-1));
                        last_Received = p;
                        packet_received = true;
                    }
                    Received.clear();
                }
                else{ /* Do nothing */ }
                --timer;
            }while(iterator < fileBytes.length);
            long stopTime = System.nanoTime();
            System.out.println("Execution Time = " +  ((stopTime - startTime)/1000000) + " milliseconds." );
        }

    }

    public static void acknowledge()
    {
        try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        for(Map.Entry<Integer, Packet> entry: Slidingwindow.entrySet())
        {
            if (!entry.getValue().Acknowledged)       // if not yet Acknowledged
            {
                --entry.getValue().End_to_End_Delay;
                if (!GoBackN)
                    --entry.getValue().TimeOut;

                if (entry.getValue().End_to_End_Delay == 0)
                {
                    Acknowledged.add(entry.getKey());
                    entry.getValue().Acknowledged = true;
                    entry.getValue().End_to_End_Delay = End_to_End_delay;
                }
                else if (!GoBackN && entry.getValue().TimeOut == 0)
                {
                    Time_Outed.add(entry.getKey());
                    entry.getValue().TimeOut = TimeOut;
                }
            }
        }
    }

    public static void Receive()
    {
        try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        for(Map.Entry<Integer, Packet> entry: Slidingwindow.entrySet())
        {
            if (entry.getValue().Acknowledged)       // if Acknowledged
            {
                --entry.getValue().End_to_End_Delay;
                if (!GoBackN)   // if it is Selective Repeat
                    --entry.getValue().TimeOut;

                if (entry.getValue().End_to_End_Delay == 0)
                {
                    Received.add(entry.getKey());
                    entry.getValue().transmission_conformed = true;
                }
                else if (!GoBackN && entry.getValue().TimeOut == 0)
                {
                    Time_Outed.add(entry.getKey());
                    entry.getValue().TimeOut = TimeOut;
                }
            }
        }
    }

    public static int slide_forward(int last_Received)
    {
        if (last_Received >= 0)
            Slidingwindow.remove(last_Received);

        TreeMap<Integer, Packet> map = new TreeMap<>(Slidingwindow);
        int size;
        if (Slidingwindow.size()> 1)
            size = map.floorKey(SenderArray.size() + 5) - map.firstKey();
        else
            size = Slidingwindow.size();

        if (size < windowSize)
        {
            Iterator i = SenderArray.iterator();
            boolean status = false;
            int ii = 0;
            while (i.hasNext() && !status)
            {
                Packet p = (Packet) i.next();
                status = !p.databuffered;
                ++ii;
            }

            try
            {
                Thread.sleep(Transmission_Delay * 100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Packet p;
            p = SenderArray.get(ii-1);
            p.databuffered = true;
            Slidingwindow.put(p.ID, p);
            return p.ID;
        }
        else
            System.out.println("\nError....\nSomething went wrong in sliding the window forward.");
        return -1;
    }
}