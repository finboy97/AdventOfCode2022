package test.java.tests;
    import static org.junit.Assert.assertEquals;
    import org.junit.Test;

    import main.java.day06.FourCharacterList;
public class Day06Test {

   
    @Test
    public void fourCharacterListReturnsCorrectStartCharacter() throws AssertionError{
        FourCharacterList testList = new FourCharacterList();
        String testInput = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
        int packetStartNo = 0;
        int expectedValue = 7;
        for (int i=0;i<testInput.length(); i++){
            testList.addChar(testInput.charAt(i));
            if (testList.isPacketStart()){
                packetStartNo = testList.startNumber();
                break;
            }
        }
        assertEquals(expectedValue, packetStartNo);
    }
}
