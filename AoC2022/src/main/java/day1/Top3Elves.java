
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Top3Elves {
   
    
    ArrayList<Integer> elfArray; 
    Integer smallestValue;
    Integer smallestIndex;

    public Top3Elves(){
        elfArray = new ArrayList<Integer>(3);
        for (int i = 0; i <3; i++){
            elfArray.add(i);
        }
        this.setMin();
    }

    public void arrayElfCalories(){
        try {
            String line;
            int currentCalories = 0;
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Finba\\Documents\\AdventOfCode2022\\AdventOfCode2022\\AoC2022\\src\\main\\java\\day1\\Input.txt"));
            
            while((line = reader.readLine()) != null) {
                if(line.length() != 0){
                    currentCalories += Integer.parseInt(line);
                    }else {
                    if (currentCalories > smallestValue){
                        elfArray.set(smallestIndex, currentCalories);
                        setMin();
                    }
                    currentCalories = 0;
                }
            }
            reader.close();
            Integer top3Cals = 0;
            for (int i = 0; i< elfArray.size();i++){
                top3Cals += elfArray.get(i); 
            }
            System.out.println(top3Cals.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException IOerror) {
            System.out.println("IO Exception");
        }
    }
    public void setMin(){
        smallestValue=elfArray.get(0);
        smallestIndex = 0;

        if (elfArray.get(1) < smallestValue) {
            smallestValue=elfArray.get(1);
            smallestIndex = 1;
        }
        if (elfArray.get(2) < smallestValue) {
            smallestValue=elfArray.get(2);
            smallestIndex = 2;
        }
    }




    public static void main (String Args[]){
        Top3Elves test = new Top3Elves();
        test.arrayElfCalories();
    }

}


