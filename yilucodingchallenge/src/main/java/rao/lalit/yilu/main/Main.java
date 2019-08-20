package rao.lalit.yilu.main;

import rao.lalit.yilu.challenge.ChallengeSet;

public class Main {

    public static void main(String[] args) {
        char c = ChallengeSet.nonRepeatedCharacterCheck("lalit");
        System.out.println(String.format("String %s contains a repeating character %c", 
            "lalit", c));
        
        boolean isRotation = ChallengeSet.checkRotation("lalit", "itlal");
        System.out.println(String.format("is %s rotation of %s? %s", "itlal", "lalit", isRotation));    
    }
    
}
