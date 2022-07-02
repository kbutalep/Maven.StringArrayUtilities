package com.zipcodewilmington;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[(array.length - 1)];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[(array.length - 2)];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String newString : array) {
            if (newString.contains(value)) ;
            return true;
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
      String[] reversedS = new String[array.length];
      int index = 0;
      for (int i = array.length -1; i >= 0; i--){
          reversedS[index] = array[i];
          index++;
      }
       return reversedS;
    }

//Alternate code for reference
    //List<String> list = Arrays.asList(array);
    //Collections.reverse(list);
    //String[] reversedArray = new String[list.size()];
    //reversedArray = list.toArray(array);
    //return reversedArray;


    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int len = array.length - 1;
        for (int i = 0; i <= array.length / 2; i++) {
            if (array[i] != array[len]) {
                return false;
            } else {
                len -= 1;
            }
        }
        return true;
    }


    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String[] alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
        String arrayString = Arrays.toString(array).toLowerCase();
        for (int i = 0; i <= alphabet.length - 1; i++) {
            if (!arrayString.contains(alphabet[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numOfOccurs = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                numOfOccurs++;
            }
        }
        return numOfOccurs;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] newRemovedArray = new String[array.length - getNumberOfOccurrences(array, valueToRemove)];
        int index = 0;
        for (String part : array) {
        if(!part.equals(valueToRemove)){
        newRemovedArray[index] = part;
        index++;
        }
        } return newRemovedArray;
    }


    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        ArrayList<String> newArrayNoDupes = new ArrayList<>(Arrays.asList(array));
        for (int i = 1; i < newArrayNoDupes.size(); i++) {
            if(newArrayNoDupes.get(i) == newArrayNoDupes.get(i-1)) {
                newArrayNoDupes.remove(i);
                i--;
            }
        }
        int newlistsize = newArrayNoDupes.size();
        String[] finalArray = newArrayNoDupes.toArray(new String[0]);
        return finalArray;
    }


    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        ArrayList removed = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array.length) {
                String next = array[i];
                while (array[i].equals(array[i + 1])) {
                    next += array[i];
                    i++;
                    if (i + 1 == array.length) {
                        break;
                    }

                }
                removed.add(next);
            } else {
                removed.add(array[i]);
            }
        }
        String[] combined = new String[removed.size()];
        removed.toArray(combined);
        return combined;
    }
}
