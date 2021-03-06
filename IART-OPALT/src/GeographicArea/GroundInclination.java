package GeographicArea;

import java.util.Random;

public enum GroundInclination{
	
	STEEP("Steep",1),
	SLOPE("Slope",2),
	FLAT("Flat",3);
	
	private String name;
	private int value;
	
	private static final Random rand = new Random(System.currentTimeMillis());
	
	private GroundInclination(String str, int v){
		name = str;
		value = v;
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
	
	public int getValue(){
		return value;
	}
	
	public static GroundInclination getRandomGroundInclination(){
		
		GroundInclination[] _temp = {STEEP,SLOPE,FLAT};
		
		return _temp[rand.nextInt(_temp.length)];
	}
	
	public static GroundInclination getRandomGroundInclination(GroundInclination gi){
		
		GroundInclination[] _temp = {STEEP,SLOPE,FLAT};
		
		int _temp_int = 1000;
		
		while(!(gi.getValue()-1 <= _temp_int && _temp_int <= gi.getValue()+1 && _temp_int > 0))
			_temp_int = rand.nextInt(_temp.length);
		
		return _temp[_temp_int];
	}
}