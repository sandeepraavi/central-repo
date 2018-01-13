package ucmo.cs.networking.project;
class GBNPacket {

	boolean on_the_way; 
	boolean destination_reached; 
	boolean pckt_acknowledged; 
	boolean pckt_ack;
	boolean pckt_selected; 
	boolean pckt_received; 
	boolean out_of_order;
	int pckt_position; 
	int ack_for; 
	boolean is_buffered;
	
	GBNPacket(boolean onway, int packetpos, int nextseq) {
		on_the_way = onway;
		pckt_selected = false;
		destination_reached = false;
		pckt_acknowledged = false;
		pckt_ack = true;
		pckt_received = false;
		out_of_order = false;
		pckt_position = packetpos;
		ack_for = nextseq;
		is_buffered = false;

	}
	GBNPacket() {
		on_the_way = false;
		pckt_selected = false;
		destination_reached = false;
		pckt_acknowledged = false;
		pckt_ack = true;
		pckt_received = false;
		out_of_order = false;
		pckt_position = 0;
		ack_for = 0;
		is_buffered = false;
	}


}