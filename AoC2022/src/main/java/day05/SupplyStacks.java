package main.java.day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class SupplyStacks {
    //Array of Stacks for part A and for part B.
    LinkedList<Character>[] stackSequence = new LinkedList[9];
    LinkedList<Character>[] stackSequence2 = new LinkedList[9];

    public SupplyStacks(){
        for (int i = 0; i< stackSequence.length;i++){
            stackSequence[i] = new LinkedList<Character>();
            stackSequence2[i] = new LinkedList<Character>();
        }
    }

    /**
     * Method for reading in from file, setting up initial crate stacks, then calling the methods to handle moves.
     * @throws IOException
     */
    public void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day05/input.txt"));
        String line;
        LinkedList<String> strList = new LinkedList<>();
        line = br.readLine();
        
        while ((int) line.charAt(1)!= 49){
            //if character is '1', stop
            strList.addFirst(line);
            line=br.readLine();
        }
        
        while(!(strList.isEmpty())){
            parseLineIntoStack(strList.pop());
        }

        //skip a line

        br.readLine();
        
        while ((line = br.readLine())!= null){
            carryOutInstruction(parseInstruction(line));
            partBInstructions(parseInstruction(line));
        }
        br.close();

        for (int i = 0; i < stackSequence.length; i++){
            System.out.print(Character.toString(stackSequence[i].peek()));
        }
        System.out.println();
        for (int i = 0; i < stackSequence.length; i++){
            System.out.print(Character.toString(stackSequence2[i].peek()));
        }
    }

    /**
     * Method that retrieves characters from line, checks if they are empty (i.e " "), then adds them to their correct initial stack.
     * Part B - repeat for the 2nd array of stacks.
     * @param line
     */
    public void parseLineIntoStack(String line){
        for (int i = 1; i< line.length(); i+=4){
            if (Character.isLetter(line.charAt(i))){
                if (i == 1){
                    stackSequence[0].push(line.charAt(i));
                    stackSequence2[0].push(line.charAt(i));
                }else{
                    
                    int x = (i-1)/4;
                    stackSequence[x].push(line.charAt(i));
                    stackSequence2[x].push(line.charAt(i));
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
        //System.out.println("Pushing " + Integer.toString(instructions[0]) + " crates from " + Integer.toString(instructions[1]) + " into " + Integer.toString(instructions[2]));
        LinkedList from = stackSequence[instructions[1]-1];
        //System.out.println("Top of 'from' = " + from.peek());
        LinkedList to = stackSequence[instructions[2]-1];
        int moves = instructions[0];

        for (int i = 0; i< moves; i++){
            to.push(from.pop());
            
        }
    }

    public void partBInstructions(int[] instructions){
        LinkedList tempList = new LinkedList();
        LinkedList from = stackSequence2[instructions[1]-1];
        LinkedList to = stackSequence2[instructions[2]-1];

        for (int i = 0; i<instructions[0]; i++){
            tempList.addLast(from.pop());

        }
        while (!(tempList.isEmpty())){
            to.push(tempList.removeLast());
        }
    }   


    public static void main (String[] args) throws IOException{
        SupplyStacks test = new SupplyStacks();
        test.readInput();
    }
    
}
