
/**
* The class Math contains methods for performing basic mathematical functions.
*
* @author Jaakko Heinsuo
*/
package fi.tuni.tamk.tiko.heinsuo.util;
public class Math {
    /**
    * Returns a random int value between the given parameters. 
    *
    * Method calls java.lang.Math.random method which returns a value [0,1[.
    * That value is the multiplied with (range between min and max) + 1.
    * After that, the value is converted to int and added to the min value.
    * The value is now between the given parameters.
    * The value is returned.
    * 
    * @param min is the minimum value of the random number.
    * @param max is the maximum value of the random number.
    * @return a random int value between the given parameters.
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}