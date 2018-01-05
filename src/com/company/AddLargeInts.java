package com.company;

import java.util.ArrayList;

public abstract class AddLargeInts {
    public static String addLargeInts(String a, String b) {
            int lengthDiff = a.length() - b.length();
            if (lengthDiff == 0) { return addEqualStrings(a, b); }


            // if nums are diff lengths, prepend the smaller num
            // with xtra 0's to avoid indexOutOfBounds exception
            String xtraZeros = makeZeros(Math.abs(lengthDiff));
            if (lengthDiff > 0) { return addEqualStrings(a, xtraZeros.concat(b)); }
            else                { return addEqualStrings(xtraZeros.concat(a), b); }
        }

        private static String addEqualStrings(String a, String b) {
            ArrayList output = new ArrayList();
            int numLength = a.length() - 1;
            int carryTens = 0;
            // Begin at the ones digit of the epic int
            for (int i = numLength; i >= 0; i--) {
                // add the single digit ints plus carryover from previous addition
                int int1 = Character.getNumericValue(a.charAt(i));
                int int2 = Character.getNumericValue(b.charAt(i));
                int sum = int1 + int2 + carryTens;
                // if sum is double digits, save ones place to array, and
                // carry the tens place over to next round
                if (sum >= 10) {
                    carryTens = 1;
                    int onesPlace = sum - 10;
                    output = addToFront(output, onesPlace);
                } else {
                    carryTens = 0;
                    output = addToFront(output, sum);
                }
            }
            // after full loop, if one last tens to carry over,
            // add it to front of array
            if (carryTens == 1) {
                output = addToFront(output, 1);
            }
            // join array of string digits to output a sum in string form
            return String.join("", output);
        }
        private static ArrayList addToFront(ArrayList array, int element) {
            // add ints to array in string form in order to use String.join() later
            array.add(0, String.valueOf(element));
            return array;
        }

        private static String makeZeros(int num) {
            String zeros = "";
            while (num > 0) {
                zeros = zeros.concat("0");
                num--;
            }
            return zeros;
        }
}

