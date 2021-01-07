package Java.Logic;

public class Validator {
    

    static boolean percentageValidator(int number){
        //any number lower than zero is invalid
        //any number higher than one hundred is invalid

        if(number >= 0 && number <= 100){
            return true; 
        }

        return false;
    }

    static boolean gradeValidator(int number){
        //any number lower than one is invalid
        //any number higher than ten is invalid

        if(number >= 1 && number <= 10){
            return true; 
        }

        return false;
    }


    static boolean emailValidator(String email) {
        //Explain of the regex key
        //^	The beginning of a line
        //[] A group of
        //\\ disables in line code like \n
        //w-_.+ any letter or number and dash, underscore, dot and plus only once
        //* zero or more after this
        //() as a capturing group
        //$	The end of a line
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        // return outcome determined whether email matches the regex key
        return email.matches(regex);
    }
}