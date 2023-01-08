package main.java.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for Day 4 - Part 1. 
 * processInput handles reading in lines.
 * calculateInput handles splitting line into integers for start and end of ranges, then checking for overlap. 
 */
public class Assignment {

    Integer numberEncapsulated=0;
    Integer numberOfOverlaps=0;

    public void processInput(){
        try {
            String line = new String();
            //BufferedReader reader = new BufferedReader(new FileReader("/home/finbar/Documents/advent_of_code_2022/AdventOfCode2022/AoC2022/src/main/java/day4/test.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Finba\\Documents\\AdventOfCode2022\\AdventOfCode2022\\AoC2022\\src\\main\\java\\day4\\input.txt"));
            
            

            while((line = reader.readLine()) != null) {
                calcluateTotalEncapsulated(line);
                calculateOverlaps(line);

            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException IOerror) {
            System.out.println("IO Exception");
        }
        System.out.println("The number of pairs with an encapsulated assignment is " + Integer.toString(numberEncapsulated));
        System.out.println("The number of pairs with a partial overlap is " + Integer.toString(numberOfOverlaps));
    }

    /**
     * Method splits line up and stores integers for pairs 1 and 2 in an array.
     * If either both beginnings or both ends are the same, there must be an encapsulation.
     * Else, if the first value is bigger than the partners first, and the last value smaller, there is an encapsulation.
     * @param line
     */
    public void calcluateTotalEncapsulated(String line){
        String[] splitPairs = line.split(",");
        int[] rangePairs = new int[4];
        rangePairs[0] = Integer.parseInt( splitPairs[0].split("-")[0]);
        rangePairs[1] = Integer.parseInt( splitPairs[0].split("-")[1]);
        rangePairs[2] = Integer.parseInt( splitPairs[1].split("-")[0]);
        rangePairs[3] = Integer.parseInt( splitPairs[1].split("-")[1]);

        //System.out.println("The first number is:".concat(Integer.toString(rangePairs[0])));
        //System.out.println("The last number is:".concat(Integer.toString(rangePairs[3])));

        if (rangePairs[0]==rangePairs[2] || rangePairs[1]==rangePairs[3]){
            numberEncapsulated++;
        }else if ((rangePairs[0]>rangePairs[2]) && (rangePairs[1]< rangePairs[3])){
            numberEncapsulated++;
        }else if ((rangePairs[0]<rangePairs[2]) && (rangePairs[3]< rangePairs[1])){
            numberEncapsulated++;
        }
    }

    public void calculateOverlaps(String str){
        String[] splitPairs = str.split(",");
        int[] rangePairs = new int[4];
        rangePairs[0] = Integer.parseInt( splitPairs[0].split("-")[0]);
        rangePairs[1] = Integer.parseInt( splitPairs[0].split("-")[1]);
        rangePairs[2] = Integer.parseInt( splitPairs[1].split("-")[0]);
        rangePairs[3] = Integer.parseInt( splitPairs[1].split("-")[1]);

        if (!(rangePairs[1]<rangePairs[2] || rangePairs[3]<rangePairs[0])){
            numberOfOverlaps++;
        }
    }


    public static void main (String [] args){
        Assignment test = new Assignment();
        test.processInput();
    }
    
}
