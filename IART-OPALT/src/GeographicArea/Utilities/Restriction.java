package GeographicArea.Utilities;

public class Restriction {
	
	private UtilitieType u1;
	private UtilitieType u2;
	private RestrictionType restrictionType;
	
	public Restriction(UtilitieType _u1, UtilitieType _u2, RestrictionType _restrictionType){
		
		u1=_u1;
		u2=_u2;
		restrictionType=_restrictionType;
	}
	
	public UtilitieType getFirstUtilitie(){
		return u1;
	}
	public UtilitieType getSecondUtilitie(){
		return u2;
	}
	public RestrictionType getRestrictionType(){
		return restrictionType;
	}
	

}
