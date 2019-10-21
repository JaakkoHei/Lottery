/**
* The class Console contains a method for reading integers from the user.
*
* @author Jaakko Heinsuo
*/
package fi.tuni.tamk.tiko.heinsuo.util;

import java.util.Scanner;

public class Console {
    /**
    * Method askes numbers from the user that are between the given values 
    *
    * Method has a while loop that repeats until a valid user input is given.
    * In this loop the user is asked to give a number between the given values.
    * Method tries to convert the users input into an integer, if it fails a message is printed and the loop continued.
    * If the conversion is successful then the value is compared to to the parameters, if this fails a message is printed and the loop continued.
    * If both checks are passed the value is returned and the loop not continued.
    * 
    * @param min is the minimum value that the user can input.
    * @param max is the maximum value that the user can input.
    * @param errorMessageNonNumeric is the error message when the input is non numeric.
    * @param errorMessageNonMinAndMax is the error message when the input is outside the specified values.
    * @return is the user given number.
    */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean repeat = true;
        while(repeat) {
            repeat = false;
            try {
                num = Integer.parseInt(input.nextLine());
                if(num < min || num > max) {
                    repeat = true;
                    System.out.println(errorMessageNonMinAndMax);
                }
            } catch(NumberFormatException e) {
                repeat = true;
                System.out.println(errorMessageNonNumeric);
            }
        }
        return num;
    }
}