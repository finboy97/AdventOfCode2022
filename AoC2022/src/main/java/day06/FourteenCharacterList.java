package main.java.day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Extension of the FourCharacterList class. Changed to acommodate 14 character long message objects.
 */
public class FourteenCharacterList extends FourCharacterList {

    /**
     * Override of the inherited 'isFull', changed for a longer string.
     */
    @Override
    public boolean isFull() {
        return size==14;
    }

    /**
     * Wrapper class for an appropriate name.
     * @return
     */
    public boolean isMessageStart(){
        return isPacketStart();
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day06/Input.txt"));
        String messageInput;
        String line = br.readLine();
        messageInput = line;
        
        FourteenCharacterList thisList = new FourteenCharacterList();
        for (int i=0;i<messageInput.length(); i++){
            thisList.addChar(messageInput.charAt(i));
            if (thisList.isFull()){
                if (thisList.isMessageStart()){
                    System.out.print(Integer.toString(thisList.startNumber()));
                    break;

                }
            }
        }
        br.close();
    }    
}
