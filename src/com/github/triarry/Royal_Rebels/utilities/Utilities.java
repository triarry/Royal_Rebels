package com.github.triarry.Royal_Rebels.utilities;

import com.github.triarry.Royal_Rebels.Royal_Rebels;

public class Utilities {
	
	private Royal_Rebels plugin;
	static Utilities instance = new Utilities();
	
    public static Utilities getUtilities() {
        return instance;
    }
  
    public void startUp(Royal_Rebels plug) {
        plugin = plug;
    }
}