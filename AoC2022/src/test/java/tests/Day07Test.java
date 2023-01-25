package test.java.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import main.java.day07.ReadTerminalInteractions;

public class Day07Test {
    

    @Test
    public void fileSystemHasSize95437() throws IOException{
        ReadTerminalInteractions test = new ReadTerminalInteractions();
        test.readInput("src/main/java/day07/Day07TestData.txt");
        int testOutput = test.returnFilesLessThan100k();
        assertEquals(95437,testOutput);

    }
}
