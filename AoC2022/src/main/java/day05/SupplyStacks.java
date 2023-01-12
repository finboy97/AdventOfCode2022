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
            parseLineIntoStack(line);
            //System.out.println(line);
            //System.out.println(line.charAt(1));
        }
        System.out.println(stackSequence.length);
        for (int i = 0; i< stackSequence.length; i++){
            System.out.print(Character.toString(stackSequence[i].pop()));
        }        
        br.close();
    }

    public void parseLineIntoStack(String line){
        for (int i = 1; i< line.length(); i+=4){
            if (Character.isLetter(line.charAt(i))){
                if (i == 1){
                    System.out.println("Stack 0: Value "+ Character.toString(line.charAt(i)));
                    stackSequence[0].push(line.charAt(i));
                }else{
                    
                    int x = (i-1)/4;
                    stackSequence[x].push(line.charAt(i));
                }
            }
        }
    }

    public static void main (String[] args) throws IOException{
        SupplyStacks test = new SupplyStacks();
        test.readInput();
    }
    
}
