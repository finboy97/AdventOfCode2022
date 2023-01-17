package main.java.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Rucksack {

    String repeats = new String();

    Integer score = 0; 

    public void readLines(){
        try {
            String line;
            
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/day3/input.txt"));
            
            
            
            while((line = reader.readLine()) != null) {
                HashSet<Character> pocket1Chars = new HashSet<>();
                HashSet<Character> duplicates = new HashSet<>();
                int lineLength = line.length();
                String pocket1 = line.substring(0, (lineLength/2));
                for (int i = 0; i< pocket1.length(); i++){
                    pocket1Chars.add(pocket1.charAt(i));
                }
                String pocket2 = line.substring(lineLength/2);

                for (int i = 0; i<pocket2.length(); i++){
                    if (pocket1Chars.contains(pocket2.charAt(i))){
                        if (duplicates.contains(pocket2.charAt(i))){
                            continue;
                        } else {
                            duplicates.add(pocket2.charAt(i));
                            repeats = repeats + pocket2.charAt(i);
                            if (Character.isLowerCase(pocket2.charAt(i))){
                                score += ( (int) pocket2.charAt(i) )-96;
                            }
                            else {
                                score += (int) pocket2.charAt(i)-38;
                            }
                        }
                        
                    }
                }
                
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException IOerror) {
            System.out.println("IO Exception");
        }
    System.out.println(Integer.toString(score));
     
}

    public static void main (String [] args){
         
        Rucksack test = new Rucksack();
        test.readLines();
    }
}