package GeographicArea;

enum GroundType{
	POOR("Poor"),
	REASONABLE("Reasonable"),
	RICH("Rich");
	
	private String name;
	
	private GroundType(String str){
		name = str;
	}
	
	public static GroundType getType(String str){
		
		if(str.equals("Poor"))
			return GroundType.POOR;
		else
			if(str.equals("Reasonable"))
				return GroundType.REASONABLE;
			else
				if(str.equals("Rich"))
					return GroundType.RICH;
		
		return null;
	}
	
	public void printInfo(){
		System.out.println("\tGround type: " + name);
	}
}