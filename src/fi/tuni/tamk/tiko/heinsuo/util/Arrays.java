/**
* The class Arrays contains methods that modify or compare arrays.
*
* @author Jaakko Heinsuo
*/
package fi.tuni.tamk.tiko.heinsuo.util;

public class Arrays {
    /**
    * Returns given string array as a int array. 
    *
    * Creates new empty int array and copies and converts the content of the given string array.
    * Converted int array is then returned.
    * 
    * @param array is the given string array to be converted to int.
    * @return is converted int array.
    */
    public static int [] toIntArray(String [] array) {
        int [] intArray = new int [array.length];
        for(int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }
    /**
    * Method compares given int value to given int array and returns a boolean depending on the results.
    *
    * The values of the given array are compared to the given value.
    * If the value is found, boolean true is returned. Otherwise boolean false is returned.
    * 
    * @param array is the given int array.
    * @param value is the given int value that is compared to the arrays values.
    * @return is either true or false.
    */
    public static boolean contains(int value, int [] array) {
        for(int i = 0; i < array.length; i++) {
            if(value == array[i]) {
                return true;
            }
        }
        return false;
    }
    /**
    * Method compares two int arrays and counts the amount of same values between them. 
    *
    * Given arrays are compared value by value, if the values are same, int same is increased by 1.
    * After all the values have been compared, the counter int same is returned.
    *
    * @param array1 is the first given int array.
    * @param array2 is the second given int array.
    * @return is the number of same values between the two arrays.
    */
    public static int containsSameValues(int [] array1, int [] array2) {
        int same = 0;
        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) {
                    same++;
                }
            }
        }
        return same;
    }
    /**
    * Method removes a specified index from the given array and the returns the modified array. 
    *
    * A copy of the given array is created which is smaller by 1.
    * The content of the original array is then copied on to the created one.
    * During the copying the specified index is skipped.
    *
    * @param original is the given int array.
    * @param index is the index that is to be removed from the given array.
    * @return Is the modified array.
    */
    public static int [] removeIndex(int [] original, int index) {
        int [] copy = new int [original.length - 1];
        int j = 0;
        for(int i = 0; i < original.length; i++) {
            if(i != index) {
                copy[j] = original[i];
                j++;
            }
        }
        return copy;
    }
    /**
    * Method sorts the contents of the given int array from smallest to biggest and returns the modified array. 
    *
    * Method uses to for loops to modify the array.
    * First loop goes through the array from the start.
    * Second loop goes through the array from the current index of the first loop.
    * In the second loop the values of the array are compared and the index of the smallest one is saved.
    * In the first loop the smallest index is moved to the current first loop index with the help of a temp int.
    *
    * @param array is the given int array.
    * @return Is the sorted array.
    */
    public static int [] sort(int [] array) {
        for (int i = 0; i < array.length - 1; i++) { 
            int smallestPos = i; 
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallestPos]) {
                    smallestPos = j; 
                }
            }
            int temp = array[smallestPos]; 
            array[smallestPos] = array[i]; 
            array[i] = temp; 
        }
        return array;
    }
    /**
    * Method adds a prefix of 0s to the arrays values according the the largest number. 
    *
    * Method creates a string array that is the length of the given array.
    * Then the method counts the numbers on the last value of the array and saves this value.
    * Then into the arrays values are added 0s so that all values are the same length in numbers.
    *
    * @param array is the given int array sorted from smallest to largest.
    * @return Is the modified array.
    */
    public static String [] prefixSortedIntArray(int [] array) {
        String [] prefixedArray = new String [array.length];
        int prefixCount = ("" + array[array.length - 1]).length();  
        for(int i = 0; i < array.length; i++) {
            String temp = "" + array[i];
            while(temp.length() < prefixCount) {
                temp = "0" + temp;
            }
            prefixedArray[i] = temp;
        }
        return prefixedArray;
    }
}