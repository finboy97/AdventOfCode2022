package main.java.day01;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class CaloryCount { 

    public void biggestCalorieElf(){
            try {
                String line;
                Integer  maxCalorie = 0;
                int currentCalories = 0;
                BufferedReader reader = new BufferedReader(new FileReader("src/main/java/day01/Input.txt"));
                
                while((line = reader.readLine()) != null) {
                    if(line.length() != 0){
                        currentCalories += Integer.parseInt(line);
                        if (currentCalories > maxCalorie) {
                            maxCalorie = currentCalories;
                        }
                    }else {
                        currentCalories = 0;
                    }
                }
                reader.close();
                System.out.print(maxCalorie.toString());
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException IOerror) {
                System.out.println("IO Exception");
            }
            
         
    }

    public static void main (String Args[]){
        CaloryCount  test = new CaloryCount();
        test.biggestCalorieElf();
    }
}