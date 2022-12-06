package main.java.day2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Class for calculating score from the input. 
 */
public class RPSScore2 {
    BufferedReader br;
    String line;
    Integer totalScore;

    public RPSScore2() throws FileNotFoundException{
        br = new BufferedReader(new FileReader("C:\\Users\\Finba\\Documents\\AdventOfCode2022\\AdventOfCode2022\\AoC2022\\src\\main\\java\\day2\\input.txt"));
        line = "blah";
        totalScore = 0;
    }

    /**
     * Reads in lines of input, generates a score and adds them up.
     * @return
     * @throws IOException
     */
    public int getScore() throws IOException{
        RPSChooseMove move = new RPSChooseMove();
        while ((line = br.readLine()) != null){
            String newMove = move.chooseMove(line);
            System.out.println(newMove);
            RPSRound newRound = new RPSRound(newMove);
            totalScore += newRound.calculateScore();
        }
        return totalScore; 
    }
    
    public static void main (String args[]) throws IOException{
        RPSScore2 test = new RPSScore2();
        System.out.println(Integer.toString(test.getScore()));
    }

}