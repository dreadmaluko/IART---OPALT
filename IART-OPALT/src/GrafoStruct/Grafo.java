package GrafoStruct;

import java.util.Vector;

public class Grafo {

	protected Vector<Node> vertexSet;
	
	public Grafo(){
		vertexSet = new Vector<Node>();
	}

	public int getNumVertex(){
		return vertexSet.size();
	}
}
