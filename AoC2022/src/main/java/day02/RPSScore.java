package main.java.day02;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Class for calculating score from the input. 
 */
public class RPSScore {
    BufferedReader br;
    String line;
    Integer totalScore;

    public RPSScore() throws FileNotFoundException{
        br = new BufferedReader(new FileReader("src/main/java/day02/input.txt"));
        line = "blah";
        totalScore = 0;
    }

    /**
     * Reads in lines of input, generates a score and adds them up.
     * @return
     * @throws IOException
     */
    public int getScore() throws IOException{
        while ((line = br.readLine()) != null){
            RPSRound newRound = new RPSRound(line);
            totalScore += newRound.calculateScore();
        }
        return totalScore; 
    }
    
    public static void main (String args[]) throws IOException{
        RPSScore test = new RPSScore();
        System.out.println(Integer.toString(test.getScore()));
    }

}