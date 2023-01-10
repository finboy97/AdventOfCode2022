package main.java.day02;

/**
 * Class for calculating score for a single round of Rock Paper Scissors.
 */
public class RPSRound {
    Character oppMove;
    Character playerMove;
    char roundArray[];

    RPSRound(String round){
        roundArray = round.toUpperCase().toCharArray();
        oppMove = roundArray[0];
        playerMove = roundArray[2];
    }

    /**
     * Method which combines both the score for type of move, and the result of the round.
     * @return total score. 
     */
    public int calculateScore(){
        int score = 0;
        score += getTypeScore();
        score += getResultScore();
        System.out.println(Integer.toString(score));
        return score;

    }

    /**
     * Method for score based on the type of move chosen.
     * Compares ASCII value of the move - 88 for X, 89 for Y, 90 for Z.
     * @return
     */
    public int getTypeScore(){
        if ((int) (roundArray[2])==88){
            return 1;
        }else if ((int) (roundArray[2])==89){
            return 2;
        }else {
            return 3;
        }
    }

    /**
     * Calculate differences between ASCII values for player and opponent move. 
     * E.g. opp chooses A, player chooses Z: 90-65 = 25.
     * Difference of 23 means loss.
     * Difference of 21 or 24 means draw.
     * Else, its a win. 
     * @return
     */
    public int getResultScore(){
        int charDiff = (Character.getNumericValue(roundArray[2]) - Character.getNumericValue(roundArray[0]));
        if (charDiff==23){
            return 3;
        }else if(charDiff % 3 ==0){
            return 6;
        }else {
            return 0;
        }
    }

}
