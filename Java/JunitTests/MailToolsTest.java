import org.junit.Test;

import static org.junit.Assert.*;
public class MailToolsTest {

    @Test
    public void validateMailAddressReturnsFalseNoAt(){
        //arrange
        String mailAddress = "mailmail.com";
        //act
        Boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoMailbox(){
        //arrange
        String mailAddress = "@mail.com";
        //act
        Boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoSubdomainTLDDelimiter(){
        //arrange
        String mailAddress = "mail@mail.k.com";
        //act
        Boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoSubdomain(){
        //arrange
        String mailAddress = "mail@.com";
        //act
        Boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoTLD(){
        //arrange
        String mailAddress = "mail@mail.";
        //act
        Boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }

    public void validateMailAddressReturnsTrue(){
        //arrange
        String mailAddress = "mail@mail.com";
        //act
        Boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(true, result);
    }

}
