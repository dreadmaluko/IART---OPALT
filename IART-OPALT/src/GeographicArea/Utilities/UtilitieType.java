package GeographicArea.Utilities;

public class UtilitieType {
	
	private String name;
	private int index;
	private static int numberOfUtilities = 0;
	
	private int groundQuality;
	private int groundInclination;
	private int loteCost;
	
	public UtilitieType(String _name, int gq, int gi, int _loteCost){
		name = _name;
		index = numberOfUtilities;
		
		groundQuality = gq;
		groundInclination = gi;
		
		loteCost = _loteCost;
		
		numberOfUtilities++;
	}
	
	public void printInfo(){
		System.out.println("\tUrilitie type: " + name);
		System.out.println("\t\tGround Quality Target: " + groundQuality);
		System.out.println("\t\tGround Inclination Target: " + groundInclination);
	}
	
	public int getIndex(){
		return index;
	}
	
	public String getName(){
		return name;
	}
	
	public int getGroundQuality(){
		return groundQuality;
	}
	
	public int getLoteCost(){
		return loteCost;
	}
	
	public int getGroundInclination(){
		return groundInclination;
	}
	
	public static int getNumberOfUtilities(){
		return numberOfUtilities;
	}
}
