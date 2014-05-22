package GrafoStruct;

import java.util.Vector;

public class Node {

	Vector<Edge> adj;
	String name;
	Boolean visited;
	
	public Node(String nodeName){
		adj = new Vector<Edge>();
		visited = false;
		name = nodeName;
	}
	
	public String getName(){
		return name;
	}
	
	public void addEdge(Edge e){
		adj.add(e);
	}
	
	public void printInfo(){
		System.out.println("The " + getName() + " are conected to\n");
		System.out.println("\tAdjacent titles");
		
		for(Edge e : adj)
			System.out.println("\t\t" + e.getDest().getName() + " - " + e.getWeight() + "km");
	}
}