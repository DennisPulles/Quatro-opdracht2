package Codecademy.JunitTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Codecademy.Logic.Validator;

public class DateTest {
    @Test
    public void testDateOutOfRangeFebInLeapYear(){
        //arrange
        Validator validator= new Validator();

        //act
       boolean valid = validator.validateDate(30, 2, 2020);

        //assert
        assertEquals(false, valid);
    }
    @Test
    public void testDateInRangeNov(){
        //arrange
        Validator validator= new Validator();

        //act
       boolean valid = validator.validateDate(23, 11, 2020);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateInRangeFebInLeapYear(){
        //arrange
        Validator validator= new Validator();

        //act
       boolean valid = validator.validateDate(12, 2, 2020);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateOutOfRangeApr(){
        //arrange
        Validator validator= new Validator();

        //act
       boolean valid = validator.validateDate(31, 4, 2002);

        //assert
        assertEquals(false, valid);
    }
}
