package Codecademy.JunitTests;
import org.junit.Test;

import Codecademy.Logic.Validator;

import static org.junit.Assert.*;

public class NumericRangeToolsTest {
    @Test
    public void testIsValidPercentageReturnsTrue(){
        //arrange
        Validator validator = new Validator();
        int percentage = 50;
        //act
        Boolean result = validator.percentageValidator(percentage);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseBelowZero(){
        //arrange
        Validator validator = new Validator();
        int percentage = -1;
        //act
        Boolean result = validator.percentageValidator(percentage);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseAboveOneHundred(){
        //arrange
        Validator validator = new Validator();
        int percentage = 101;
        //act
        Boolean result = validator.percentageValidator(percentage);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidGradeReturnsTrue(){
        //arrange
        Validator validator = new Validator();
        int grade = 5;
        //act
        Boolean result = validator.gradeValidator(grade);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidGradeReturnsFalseBelowZero(){
        //arrange
        Validator validator = new Validator();
        int grade = -1;
        //act
        Boolean result = validator.gradeValidator(grade);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidGradeReturnsFalseAboveTen(){
        //arrange
        Validator validator = new Validator();
        int grade = 11;
        //act
        Boolean result = validator.gradeValidator(grade);
        //assert
        assertEquals(false, result);
    }
}
