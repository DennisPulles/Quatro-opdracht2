package Java.Logic;

public class Validator {
    

    public boolean percentageValidator(int number){
        if(number >= 0 && number <= 100){
            return true; 
        }

        return false;
    }

    public boolean gradeValidator(int number){
        if(number >= 1 && number <= 10){
            return true; 
        }

        return false;
    }


    public boolean emailValidator(String email) {
        //Explain of the regex key

        //^	The beginning of a line
        //[] A group of
        //\\ disables in line code like \n
        //w-_.+ any letter or number and dash, underscore, dot and plus only once
        //* zero or more after this
        //() as a capturing group
        //$	The end of a line
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}