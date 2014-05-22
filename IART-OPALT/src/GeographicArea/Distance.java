package GeographicArea;

import GrafoStruct.Edge;

public class Distance extends Edge{

	public Distance(Lote lote, double distance) {
		super(lote, distance);
	}
	
	public double getDistance(){
		return this.getWeight();
	}

}
