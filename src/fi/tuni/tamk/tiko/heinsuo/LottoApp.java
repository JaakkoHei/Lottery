/**
* The class LottoApp has methods that simulate a lottery with user given numbers.
*
* @author Jaakko Heinsuo
*/
package fi.tuni.tamk.tiko.heinsuo;

import fi.tuni.tamk.tiko.heinsuo.util.Console;
import fi.tuni.tamk.tiko.heinsuo.util.Arrays;
import fi.tuni.tamk.tiko.heinsuo.util.Math;
import java.util.*;

public class LottoApp {
    static int numberCount = 7;
    // The count of numbers used in the lottery.
    static int [] numbers = new int[numberCount];
    // Int array for the numbers
    static int min = 1;
    static int max = 40;
    // Minimum and maximum values for user given numbers.
    static String errorMessageNonNumeric = "Error: Please give an integer number.";
    static String errorMessageNonMinAndMax = "Error: Please give an unique number between [" + min + ", " + max + "]";
    static String errorMessageNotUnique = "Error: Not an unique number";
    // Error messages for different error situations.
    static int weeks = 6241;
    // Weeks are set to 6241, because its just over 120 years(a lifetime).

    /**
    * Runs the lottery simulation 
    *
    * Method checks is "args" array is viable, if not asks the user for input.
    * Asks if user wants weekly lottery results. Runs lottery until user wins during a lifetime.
    * 
    * @param args is the possible user input for lottery numbers.
    */
    public static void main(String [] args) {
        boolean startUpInput = false;
        // Boolean value to follow if the command line arguments are viable.
        if(args.length == numberCount) {
            startUpInput = true;
            try { // Argument values are checked for integers, unique number and if they are are between parameters.
                int [] tempNumbers = Arrays.toIntArray(args);
                for(int i = 0; i < numberCount && startUpInput; i++) {
                    if(tempNumbers[i] < min || tempNumbers[i] > max) {
                        startUpInput = false;
                    }
                    if(Arrays.contains(tempNumbers[i], numbers)) {
                        startUpInput = false;
                    } else {
                        numbers[i] = tempNumbers[i];
                    }
                }
            } catch(NumberFormatException e) {
                startUpInput = false;
                System.out.println();
            }
        }
        if(!startUpInput) { // If command line arguments aren't viable, they are asked from the user.
            System.out.println("Command line input doesn't exist or failed.");
            for(int i = 0; i < numberCount; i++) { 
                System.out.println("Please give an unique number between [" + min + ", " + max + "]");
                int number = Console.readInt(min, max, errorMessageNonNumeric, errorMessageNonMinAndMax);
                // Checked for integers and if they are between parameters.
                if(Arrays.contains(number, numbers)) { // Checked for unique numbers.
                    System.out.println(errorMessageNotUnique);
                    i--; // Loops if check fails.
                } else {
                    numbers[i] = number; // Added if passed checks.
                }    
            }
        } 
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to see the lotto results for each week? (y = for yes)");
        char lottoPrint = input.nextLine().charAt(0);
        while(weeks > 6240) { // Repeats if winning takes more than 120 years(a lifetime).
            weeks = 0;
            int [] records = new int [numberCount]; // Array used to hold weeks taken to get correct number(s).
            int record = 0; // Index for records.
            int [] lotto; // Randomized lottery numbers are reset.
            boolean repeat = true;
            while(repeat) {
                lotto = calculateLotto(); // Randomized lottery numbers.
                if(lottoPrint == 'y') { // Earlier user was asked if they want to see lottery weekly results.
                    printLottery(numbers, "User  ");
                    printLottery(lotto, "Random");
                }
                if(Arrays.containsSameValues(numbers, lotto) > record) { // Check for new milestone.
                    records[record] = weeks / 52;
                    record++;
                }
                if(Arrays.containsSameValues(numbers, lotto) == numberCount) { // Check for win.
                    repeat = false;
                }
                weeks++;
            }
            for(int i = 0; i < numberCount; i++) { // Printing milestone records.
                System.out.println("You got " + (i + 1) +  " right! It took " + records[i] + " years");
            }
            System.out.println("You won!");
            if(weeks > 6240) {
                System.out.println("Although it took more than a lifetime, let's try it again.");
            }
        }    
    }
    /**
    * Method calculates random numbers between specified values for the lottery. 
    *
    * First an "lotto" array is created for the randomized lottery numbers.
    * Then an "lottoNumbers" array is created for the possible lottery numbers.
    * The possible numbers are added to the array with a for loop.
    * A random number is generated with the Math.getRandom between the specified numbers.
    * The random number is added to the "lotto" array and removed from the "lottonumbers"
    * with the Arrays.removeIndex.
    * 
    * @return is an int array containing the randomized lottery numbers.
    */
    private static int[] calculateLotto() {
        int [] lotto = new int[numberCount];
        int [] lottoNumbers = new int[max];
        for(int i = 0; i < max; i++) {
            lottoNumbers[i] = min + i;
        }
        for(int i = 0; i < numberCount; i++) {
            int randomNumber = Math.getRandom(0, (lottoNumbers.length - 1));
            lotto[i] = lottoNumbers[randomNumber];
            lottoNumbers = Arrays.removeIndex(lottoNumbers, randomNumber);
        }
        return lotto;
    }
    /**
    * Prints lottery numbers 
    *
    * Method uses Arrays.sort and Arrays.prefixSortedIntArray to modify given array
    * into the wanted format. Then the name and content of the array is printed in 
    * a more readable format.
    * 
    * @param array is the given lottery numbers.
    * @param name is the name for the lottery numbers.
    */
    public static void printLottery(int [] array, String name) {
        int [] sortedArray = Arrays.sort(array);;
        String [] prefixedArray = Arrays.prefixSortedIntArray(sortedArray);
        System.out.println();
        System.out.print(name + " lotto: [");
        for(int i = 0; i < array.length; i++) {
            System.out.print(prefixedArray[i]);
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
