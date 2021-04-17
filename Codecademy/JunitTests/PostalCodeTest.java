package Codecademy.JunitTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PostalCodeTest {
    @Test
    public void nullPointerExceptionPostalCode (){
         //arrange
         ValitdatePostalCode x = new ValitdatePostalCode();

         //act
        String valid = x.formatPostalCode(null);
 
         //assert
         assertEquals("NullPointerException", valid);
    }
    @Test
    public void notEnoughNumbers (){
        //arrange
        ValitdatePostalCode y = new ValitdatePostalCode();

        //act
       String valid = y.formatPostalCode("123AB");

        //assert
        assertEquals("IllegalArgumentException", valid);
   }
   @Test
   public void good (){
     //arrange
     ValitdatePostalCode z = new ValitdatePostalCode();

     //act
    String valid = z.formatPostalCode("1234ab");

     //assert
     assertEquals("1234 AB", valid);
}
@Test
public void differentInput (){
     //arrange
     ValitdatePostalCode a = new ValitdatePostalCode();

     //act
    String valid = a.formatPostalCode("Kaas");

     //assert
     assertEquals("IllegalArgumentException", valid);
}

}
