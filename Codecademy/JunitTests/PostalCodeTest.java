package Codecademy.JunitTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Codecademy.Logic.Validator;

public class PostalCodeTest {
    @Test
    public void nullPointerExceptionPostalCode (){
         //arrange
         Validator validator = new Validator();

         //act
        String valid = validator.formatPostalCode(null);
 
         //assert
         assertEquals("NullPointerException", valid);
    }
    @Test
    public void notEnoughNumbers (){
        //arrange
        Validator validator = new Validator();

        //act
       String valid = validator.formatPostalCode("123AB");

        //assert
        assertEquals("IllegalArgumentException", valid);
   }
   @Test
   public void good (){
     //arrange
     Validator validator = new Validator();

     //act
    String valid = validator.formatPostalCode("1234ab");

     //assert
     assertEquals("1234 AB", valid);
}
@Test
public void differentInput (){
     //arrange
     Validator validator = new Validator();

     //act
    String valid = validator.formatPostalCode("Kaas");

     //assert
     assertEquals("IllegalArgumentException", valid);
}

}
