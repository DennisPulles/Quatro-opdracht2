package Codecademy.JunitTests;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumericRangeToolsTest {
    @Test
    public void testIsValidPercentageReturnsTrue(){
        //arrange
        int percentage = 50;
        //act
        Boolean result = NumericRangeTools.isValidPercentage(percentage);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseBelowZero(){
        //arrange
        int percentage = -1;
        //act
        Boolean result = NumericRangeTools.isValidPercentage(percentage);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseAboveOneHundred(){
        //arrange
        int percentage = 101;
        //act
        Boolean result = NumericRangeTools.isValidPercentage(percentage);
        //assert
        assertEquals(true, result);
    }
}
