package main.java.day05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class SupplyStacks {
    LinkedList<Character>[] stackSequence = new LinkedList[9];

    public SupplyStacks(){
        for (int i = 0; i< stackSequence.length;i++){
            stackSequence[i] = new LinkedList<Character>();
        }
    }

    public void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day05/input.txt"));
        String line;

        while ((line = br.readLine())!= null || ((int) line.charAt(0) != 91)){
            parseLineIntoStack(line);
            if (line.length()==0){

                break;
            }           
        }
        while ((line = br.readLine())!= null){
            carryOutInstruction(parseInstruction(line));
        }
        br.close();
        for (int i = 0; i < stackSequence.length; i++){
            System.out.print(Character.toString(stackSequence[i].peek()));
        }
    }

    public void parseLineIntoStack(String line){
        for (int i = 1; i< line.length(); i+=4){
            if (Character.isLetter(line.charAt(i))){
                if (i == 1){
                    stackSequence[0].push(line.charAt(i));
                }else{
                    
                    int x = (i-1)/4;
                    stackSequence[x].push(line.charAt(i));
                }
            }
        }
    }

    /**
     * Method for parsing an instruction line.
     * @param line
     */
    public int[] parseInstruction(String line){
        String[] lineComponents = line.split(" ");
        int amount = Integer.parseInt(lineComponents[1]);
        int from = Integer.parseInt(lineComponents[3]);
        int to = Integer.parseInt(lineComponents[5]);
        int[] instructions = {amount, from, to};
        return instructions;
    }

    /**
     * Method which handles carrying out an instruction line for crates.
     * 
     * @param instructions - Size 3 array of int's. First value is the number of moves, 2nd value is 'from', 3rd value is 'to'.
     */
    public void carryOutInstruction(int[] instructions){
        System.out.println("Pushing " + Integer.toString(instructions[0]) + "crates from" + Integer.toString(instructions[1]) + " into " + Integer.toString(instructions[2]));
        LinkedList from = stackSequence[instructions[1]];
        LinkedList to = stackSequence[instructions[2]];
        int moves = instructions[0];

        for (int i = 0; i< moves; i++){
            to.push(from.pop());
        }

    }



    public static void main (String[] args) throws IOException{
        SupplyStacks test = new SupplyStacks();
        test.readInput();
    }
    
}
