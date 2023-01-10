package main.java.day03;

/**
 * Class calculating priority score for a character.
 */
public class PriorityScore {
    String charsToCheck;

    public PriorityScore(String input){
        charsToCheck = input;
    }

    public int scoreForChar(Character ch) {
        int score = 0;
        if (Character.isLowerCase(ch)){
            score = ((int) ch) - 96;
        } else{
            score = ((int) ch) - 38;
        }
        return score;
    }
    
    public int scoreForString(){
        int totalScore = 0;
        for (int i = 0; i < charsToCheck.length(); i++) {
            totalScore += scoreForChar(charsToCheck.charAt(i));
        }
        return totalScore;
    }
}
