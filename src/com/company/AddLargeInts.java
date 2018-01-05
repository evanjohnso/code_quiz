package com.company;

import java.util.ArrayList;

public abstract class AddLargeInts {
    public static void addLargeInts(String a, String b) {
            int lenDiff = a.length() - b.length();
            if (lenDiff == 0) {
                addEqualStrings(a, b);
                return;
            }
            int net = Math.abs(lenDiff);

            String zeros = "";
            System.out.println(lenDiff);
            System.out.println(net);
            while (net > 0) {
                zeros = zeros.concat("0");
                net--;
            }

            String netted = "";
            if (lenDiff > 0) {
                netted = zeros.concat(b);
                // pad b by lenDiff of zeros
            } else if (lenDiff < 0) {
                netted = zeros.concat(a);
                // pad a by lenDiff of zeros
            }
            System.out.println("a: " + netted);
            addEqualStrings(a, b);
        }

        private static ArrayList addEqualStrings(String a, String b) {
            ArrayList output = new ArrayList();
            int numLength = a.length() -1;
            int carryOne = 0;
            for (int i = numLength; i >= 0; i--) {
                int a1 = Character.getNumericValue(a.charAt(i));
                int b1 = Character.getNumericValue(b.charAt(i));
                int sum = a1 + b1 + carryOne;
                if (sum >= 10) {
                    carryOne = 1;
                    int remainder = sum - 10;
                    output.add(0, remainder);
                } else {
                    carryOne = 0;
                    output.add(0, sum);
                }
            }
            if (carryOne == 1) {
                output.add(0, 1);
            }
            System.out.println(output);
            return output;
        }

}

