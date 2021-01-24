import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DateTest {
    @Test
    public void testDateOutOfRangeFebInLeapYear(){
        //arrange
        ValidateDate x = new ValidateDate();

        //act
       boolean valid = x.validateDate(30, 2, 2020);

        //assert
        assertEquals(false, valid);
    }
    @Test
    public void testDateInRangeNov(){
        //arrange
        ValidateDate y = new ValidateDate();

        //act
       boolean valid = y.validateDate(23, 11, 2020);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateInRangeFebInLeapYear(){
        //arrange
        ValidateDate z = new ValidateDate();

        //act
       boolean valid = z.validateDate(12, 2, 2020);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateOutOfRangeApr(){
        //arrange
        ValidateDate a = new ValidateDate();

        //act
       boolean valid = a.validateDate(31, 4, 2002);

        //assert
        assertEquals(false, valid);
    }
}
