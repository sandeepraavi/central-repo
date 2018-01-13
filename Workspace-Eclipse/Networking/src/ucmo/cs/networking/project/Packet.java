package ucmo.cs.networking.project;
class Packet {
    
    boolean on_the_way; 
boolean destination_reached;
boolean pckt_acknowledged;
boolean Pckt_ack; 
boolean pckt_selected; 
boolean pckt_received; 
boolean out_of_order;
int postion_pckt;
int for_ack; 
    boolean is_buffered;
    Packet(boolean onway, int Packetpos, int nextseq) {
    	on_the_way = onway;
    	pckt_selected = false;
    	destination_reached = false;
    	pckt_acknowledged = false;
    	Pckt_ack = true;
    	pckt_received = false;
    	out_of_order = false;
    	postion_pckt = Packetpos;
    	for_ack = nextseq;
    	is_buffered = false;
    	
        }
    Packet() {
	on_the_way = false;
	pckt_selected = false;
	destination_reached = false;
	pckt_acknowledged = false;
	Pckt_ack = true;
	pckt_received = false;
	out_of_order = false;
	postion_pckt = 0;
	for_ack = 0;
	is_buffered = false;
    }
}