package lllllllll.yatm.core;

public enum Resource {
	LEAD("lead");
	
	
    public final String name;
    public final boolean hasOre;
    public final boolean hasRaw;
    
    Resource(String name)
    {
    	this.name = name;
    	this.hasOre = true;
    	this.hasRaw = true;
    }
    
}
