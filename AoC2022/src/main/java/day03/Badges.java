package main.java.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * Class for Day 3 - Part B
 */
public class Badges {
    int score;
    
    /**
     * Method for finding which character is repeated in 3 lines. 
     * Uses a counter to track which line is being assessed.
     */
    public void getBadgeScores(){
        try {
            String line;
            HashSet<Character> line1Chars = new HashSet<>();
            HashSet<Character> lines1and2Chars = new HashSet<>();
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/day3/input.txt"));
            
            
            int count = 0;
            while((line = reader.readLine()) != null) {
                if (count == 0){
                    for (int i = 0; i< line.length(); i++){
                        line1Chars.add(line.charAt(i));
                    }
                    count++;
                }else if (count ==1 ){
                    for (int i = 0; i< line.length(); i++){
                        if (line1Chars.contains(line.charAt(i))){
                            lines1and2Chars.add(line.charAt(i));
                        }
                    }
                    count++;
                } else{
                    for (int i = 0; i< line.length(); i++) {
                        if (lines1and2Chars.contains(line.charAt(i))){
                            line1Chars.clear();
                            lines1and2Chars.clear();
                            //System.out.println(Character.toString(line.charAt(i)));
                            addScore(line.charAt(i));
                            break;
                        }                        
                    }
                    count=0;
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

    /**
     * Method for adding scores based on the character returned.
     * Checks if lower or upper case, then gets the ASCII value for that character, and calculates the score accordingly.
     * @param c
     */
    private void addScore(Character c){
        if (Character.isLowerCase(c)){
            score += ((int) c - 96);
        }
        else {
            score += ((int) c-38);
        }
    }
    
    



    public static void main(String[] args) {
        Badges test = new Badges();
        test.getBadgeScores();
    }
}