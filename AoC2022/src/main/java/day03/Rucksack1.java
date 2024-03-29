package main.java.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class checking rucksack compartments for overlap.
 */
public class Rucksack1 {
    BufferedReader br;
    
    public Rucksack1() throws FileNotFoundException{
        br = new BufferedReader(new FileReader("src/main/java/day03/input.txt"));
        
    }


    public void readInput() throws IOException{
        String line;
        int totalScore = 0;
        while ((line = br.readLine()) != null){
            Compartment compartment = new Compartment(line);
            PriorityScore psc = new PriorityScore(compartment.findOverlap());
            totalScore += psc.scoreForString();

        }
        System.out.println(totalScore);
    }

    
    public static void main(String args[]) throws IOException{
        Rucksack1 test = new Rucksack1();
        test.readInput();
    }
}