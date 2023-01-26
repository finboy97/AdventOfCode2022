package main.java.day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.LinkedList;
import java.util.regex.Matcher;

public class ReadTerminalInteractions {
    Integer totalSizeOfDirectoriesSmallerThan100k;

    LinkedList<FileSystemNode> directoryStack;
    FileSystemNode currentNode;
    FileSystemNode rootNode;

    public ReadTerminalInteractions(){
        totalSizeOfDirectoriesSmallerThan100k = 0;
        directoryStack = new LinkedList<FileSystemNode>();
        rootNode = new FileSystemNode();
        rootNode.set
    }

    public void readInput(String path) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = new String();

        while ((line = br.readLine())!=null){
            manageLine(line);
        }
        br.close();
    }

    private void manageLine(String input){
        String[] lineInputArray = input.split(" ");
        Pattern pattern1 = Pattern.compile("[0-9]{1,}");
        Matcher mt = pattern1.matcher(lineInputArray[0]);

        if (mt.matches()){
            lineInputArray[0]="int";
        }

        switch(lineInputArray[0]){
            case "$":
                if (lineInputArray[1].equals("cd")){
                    if (lineInputArray[2].equals("..")){
                        System.out.println("Move up 1 level");
                        break;
                    }else{
                        System.out.println("Move down 1 level");
                        break;
                    }
                } else if (lineInputArray[1].equals("ls")){
                    System.out.println("List elements");
                    break;
                } else {
                    System.out.println("Command not found");
                    break;
                }          
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

    public int returnFilesLessThan100k(){
        return totalSizeOfDirectoriesSmallerThan100k;
    }

    public static void main (String[] args) throws IOException{
        ReadTerminalInteractions test = new ReadTerminalInteractions();
        test.readInput("src/main/java/day07/Input.txt");
    }
}
