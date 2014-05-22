package GrafoStruct;

public class Edge {

	
	private Node dest;
	private double weight;
	
	public Edge(Node d, double w){
		dest=d;
		weight =w;
	}
	
	public Node getDest(){
		return dest;
	}
	public double getWeight(){
		return weight;
	}
}


