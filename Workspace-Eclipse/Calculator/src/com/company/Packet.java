package com.company;

/**
 * Created by Sahib Yar on 22/03/2016.
 */
public class Packet
{
    // ID of current Packet
    public int ID;
    // if the current packet is being sent as an acknowledge from receiver
    public boolean Acknowledged;

    // The size of the Packet. I will keep this as 64 Byte or 512 bits, but you can choose your own.
    public static int PacketSize;

    // if the packet has been received by the receiver and the sender has
    // received the acknowledgment of the current packet.
    public boolean transmission_conformed;

    // The size of this array will be equal to PacketSize
    public byte[] data;
    // This boolean is used to know that the current array of data is ready to send,
    // delivered or sent but acknowledge received yet.
    public boolean databuffered;
    public int End_to_End_Delay;
    public int TimeOut;     // for Selective Repeat
    // endregion;

    // region Member Functions
    Packet()
    {
        ID = -1;
        Acknowledged = false;
        transmission_conformed = false;
        databuffered = false;
    }
}