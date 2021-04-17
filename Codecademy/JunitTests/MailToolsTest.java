package Codecademy.JunitTests;
import org.junit.Test;

import Codecademy.Logic.Validator;

import static org.junit.Assert.*;
public class MailToolsTest {
    
    @Test
    public void validateMailAddressReturnsFalseNoAt(){
        //arrange
        Validator validator = new Validator();
        String mailAddress = "mailmail.com";
        //act
        Boolean result = validator.emailValidator(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoMailbox(){
        //arrange
        Validator validator = new Validator();
        String mailAddress = "@mail.com";
        //act
        Boolean result = validator.emailValidator(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsTrueNoSubdomainTLDDelimiter(){
        //arrange
        Validator validator = new Validator();
        String mailAddress = "mail@mail.k.com";
        //act
        Boolean result = validator.emailValidator(mailAddress);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoSubdomain(){
        //arrange
        Validator validator = new Validator();
        String mailAddress = "mail@.com";
        //act
        Boolean result = validator.emailValidator(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoTLD(){
        //arrange
        Validator validator = new Validator();
        String mailAddress = "mail@mail.";
        //act
        Boolean result = validator.emailValidator(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsTrue(){
        //arrange
        Validator validator = new Validator();
        String mailAddress = "mail@mail.com";
        //act
        Boolean result = validator.emailValidator(mailAddress);
        //assert
        assertEquals(true, result);
    }

}
