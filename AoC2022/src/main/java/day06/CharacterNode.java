package main.java.day06;

import java.util.Objects;

public class CharacterNode {
    Character thisChar;
    CharacterNode next;

    public CharacterNode(char ch){
        thisChar = ch;
        next = null;
    }

    public CharacterNode(char ch, CharacterNode nextNode){
        thisChar = ch;
        next = nextNode;
    }

    public Character getChar(){
        return thisChar;
    }

    public CharacterNode getNext(){
        return next;
    }

    public void setNext(CharacterNode nextNode){
        this.next = nextNode;
    }

    /**
     * Check if 'next' is equal to null. 
     * If yes, then return false (i.e. it does not have next).
     * @return
     */
    public boolean hasNext(){
        return !(Objects.equals(null, next));
    }

}
