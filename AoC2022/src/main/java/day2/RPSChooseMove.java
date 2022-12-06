package main.java.day2;

public class RPSChooseMove {
    Character oppMove;
    Character desiredOutcome;
    char roundArray[];

    public RPSChooseMove(){
        
    }

    public String chooseMove(String round){
        roundArray = round.toUpperCase().toCharArray();
        oppMove = roundArray[0];
        desiredOutcome = roundArray[2];

        String move;
        if ((int) desiredOutcome==88){
            if ((int) oppMove==65){
                move = "A Z";
            } else if((int) oppMove==66){
                move = "B X";
            }else {
                move = "C Y";
            }
        }else if ((int) desiredOutcome==89){
            if ((int) oppMove==65){
                move = "A X";
            } else if((int) oppMove==66){
                move = "B Y";
            }else {
                move = "C Z";
            }
        }else {
            if ((int) oppMove==65){
                move = "A Y";
            } else if((int) oppMove==66){
                move = "B Z";
            }else {
                move = "C X";
            }
        }

        return move;

    }


}
