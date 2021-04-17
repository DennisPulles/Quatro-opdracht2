package Codecademy.JunitTests;
import org.junit.Test;

import Codecademy.Logic.Validator;

import static org.junit.Assert.*;
public class SignatoryNameTest {
    
    @Test
    public void validateNameReturnsTrueSimpleName(){
        //arrange
        Validator validator = new Validator();
        String name = "Jan";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateNameReturnsFalseContainsNumber(){
        //arrange
        Validator validator = new Validator();
        String name = "Jan123";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateNameReturnsTrueContainsDash(){
        //arrange
        Validator validator = new Validator();
        String name = "Jan-peterse";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateNameReturnsTrueContainsComma(){
        //arrange
        Validator validator = new Validator();
        String name = "Martin Luther King, jr";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateNameReturnsTrueContainsApostrophe(){
        //arrange
        Validator validator = new Validator();
        String name = "Mathias D'ame";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }
}
