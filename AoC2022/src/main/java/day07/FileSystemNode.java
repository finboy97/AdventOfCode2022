package main.java.day07;

import java.util.HashMap;

public class FileSystemNode {
    //type 0 - dir.
    //type 1 - file.
    Integer type;
    String name;
    Integer size;
    FileSystemNode parent;
    HashMap<String, FileSystemNode> children;
    

    public FileSystemNode getParent(){
        return parent;
    }

    public HashMap<String, FileSystemNode> getChildren(){
        return children;
    }

    public int getType(){
        
        return type;
    }
}
