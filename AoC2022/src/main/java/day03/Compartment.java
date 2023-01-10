package main.java.day03;

import java.util.HashSet;

public class Compartment {
    public HashSet<Character> compartment1;    
    public String compartment2;

    public Compartment(String input){
        int midchar = Math.round((float) input.length()/2);
        String str1 = input.substring(0,midchar);
        compartment1 = new HashSet<Character>();
        for (int i = 0; i < str1.length(); i++){
            compartment1.add(str1.charAt(i));
        }
        compartment2 = input.substring(midchar);
    }

    public String findOverlap(){
        String wrongCompartment = "";
        HashSet<Character> checked = new HashSet<Character>();
        
        for (int i = 0; i < compartment2.length(); i++){
            if (checked.contains(compartment2.charAt(i))){
                continue;
            }
            if (compartment1.contains(compartment2.charAt(i))){
                wrongCompartment.concat(Character.toString(compartment2.charAt(i)));
            }
            checked.add(compartment2.charAt(i));
        }
        return wrongCompartment;
    }

}
