package main.java.day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * Class for processing CharacterNode objects into a linked list and identifying if the characters are all unique.
 */
public class FourCharacterList {
    CharacterNode first;
    CharacterNode last;
    Integer size;
    Integer lastCharacter;

    /**
     * Constructor.
     */
    public FourCharacterList(){
        first = null;
        last = null;
        size = 0;
        lastCharacter=0;
    }

    /**
     * Method checking if the linked list is empty.
     * @return
     */
    public boolean isEmpty(){
        return (first == null);
    }

    /**
     * Method checks if the Linked List is the maximum size.
     * @return boolean.
     */
    public boolean isFull(){
        return (size==4);
    }

    /**
     * Method which adds a character into the linkedlist.
     * The method checks if the list is full, then calls the 'isPacketStart' method.
     * @param ch
     */
    public void addChar(Character ch){
        if (this.isEmpty()){
            first = new CharacterNode(ch);
            last = first;   
            size++;
            lastCharacter++;
        } else if (!this.isFull()){
            CharacterNode newNode = new CharacterNode(ch);
            last.setNext(newNode);
            last = newNode;
            size++;
            lastCharacter++;
        }else {
            CharacterNode newNode = new CharacterNode(ch);
            last.setNext(newNode);
            last = newNode;
            first = first.getNext();
            lastCharacter++;
        }
        
        if (this.isFull()){
            if (this.isPacketStart()){
                System.out.println("The final character is number " + Integer.toString(lastCharacter) + ", " + Character.toString(last.getChar()));
            }
        }
        
    }

    /**
     * Method which checks the 4 characters in the linked list, sees if there are repeats, then returns a boolean depending on the result.
     */
    public boolean isPacketStart(){
        HashSet<Character> currentChars = new HashSet<Character>();
        CharacterNode currentNode = first;
        boolean isStart = true;
                
        while (currentNode != null){
            if (currentChars.contains(currentNode.getChar())){
                isStart = false;
                break;
            }   
            currentChars.add(currentNode.getChar());
            currentNode=currentNode.getNext();
        }
        return isStart;
    }

    /**
     * Returns the number of the final character identified in the packet start sequence.
     * @return
     */
    public int startNumber(){
        return lastCharacter;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day06/Input.txt"));
        String messageInput;
        String line = br.readLine();
        messageInput = line;
        
        FourCharacterList thisList = new FourCharacterList();
        for (int i=0;i<messageInput.length(); i++){
            thisList.addChar(messageInput.charAt(i));
            if (thisList.isFull()){
                if (thisList.isPacketStart()){
                    System.out.print(Integer.toString(thisList.startNumber()));
                    break;

                }
            }
        }
        br.close();
    }
}
