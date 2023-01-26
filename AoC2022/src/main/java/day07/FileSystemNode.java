package main.java.day07;

import java.util.HashMap;

public class FileSystemNode {
    //type 0 - dir.
    //type 1 - file.
    private Integer type;
    private String name;
    private Integer size;
    private FileSystemNode parent;
    private HashMap<String, FileSystemNode> children;


    public FileSystemNode(FileSystemNode parentNode, String newNodeName, int newNodeSize, Integer newNodeType){
        this.setParent(parentNode);
        this.setName(newNodeName);
        this.setSize(newNodeSize);
        this.setType(newNodeType);
    }

    /**
     * Method for increasing the size of a node.
     * Used for when moving down the tree to increase the size of the parent.
     * @param numberToAdd The number that needs adding to the current node size.
     */
    public void addSize(int numberToAdd){
        this.size += numberToAdd;
    }

    public void setSize(int newNodeSize) {
        this.size = newNodeSize;
    }

    public int getSize(){
        return size;
    }

    public void setName(String newNodeName) {

    }

    public String getName(){
        return name;
    }

    public FileSystemNode getParent(){
        return parent;
    }

    public void setParent(FileSystemNode parentNode){
        this.parent = parentNode;
    }
    


    public HashMap<String, FileSystemNode> getChildren(){
        return children;
    }

    public void setType(Integer newType){
        this.type = newType;
    }
    public int getType(){
        
        return type;
    }
}
