package main.java.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Rucksack {


    public void readLines(){
        try {
            String line;
            
            BufferedReader reader = new BufferedReader(new FileReader("/home/finbar/Documents/advent_of_code_2022/AdventOfCode2022/AoC2022/src/main/java/day3/test.txt"));
            
            while((line = reader.readLine()) != null) {
                int lineLength = line.length();
                String pocket1 = line.substring(0, (lineLength/2));
                String pocket2 = line.substring(lineLength/2);
                if(line.length() != 0){
                    System.out.println(pocket1);
                    System.out.println(pocket2);
                    
                }else {
                    
                }
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException IOerror) {
            System.out.println("IO Exception");
        }
        
     
}

    public static void main (String [] args){
         
        Rucksack test = new Rucksack();
        test.readLines();
    }
}