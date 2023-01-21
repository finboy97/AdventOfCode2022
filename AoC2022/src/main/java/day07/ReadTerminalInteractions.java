package main.java.day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class ReadTerminalInteractions {
    

    public void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day07/Input.txt"));
        String line = new String();

        while ((line = br.readLine())!=null){
            manageLine(line);
        }
    }

    private void manageLine(String input){
        String elementOne = input.split(" ")[0];
        
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher mt = pattern.matcher(elementOne);
        if (mt.matches()){
            elementOne="int";
        }

        switch(elementOne){
            case "$":
                System.out.println("Command");
                break;
            case "dir":
                System.out.println("Directory");
                break;
            case "int":
                System.out.println("File");
                break;
            default:
                System.out.println("Unrecognised");

        }
    }

    public static void main (String[] args) throws IOException{
        ReadTerminalInteractions test = new ReadTerminalInteractions();
        test.readInput();
    }
}
