package GeographicArea;

enum GroundInclination{
	
	STEEP("Steep"),
	FLAT("Flat"),
	SLOPE("Slope");
	
	String name;
	
	private GroundInclination(String str){
		name = str;
	}
	
	public static GroundInclination getInclination(String str){
		
		if(str.equals("Steep"))
			return GroundInclination.STEEP;
		else
			if(str.equals("Flat"))
				return GroundInclination.FLAT;
			else
				if(str.equals("Slope"))
					return GroundInclination.SLOPE;
		
		return null;
	}
	
	public void printInfo(){
		System.out.println("\tGround inclination: " + name);
	}
}