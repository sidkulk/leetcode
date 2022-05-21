package mediumSolutions.zigZagConversion;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("SIDDHARTH", 3));
        /**
         * S ->   H ->  H -->
         * I -> D -> A -> T -->
         * D ->   R -->
         */

        // above is the format in with the string SIDDHARTH is to be printed row wise
        // INPUT --> SIDDHARTH
        // OUTPUT --> SHHIDATDR
    }

    public static String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        // initialize all string builders:
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        // define variables
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        // Traverse zig zag:
        while (index < n) {

            // go down
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }

            // go up (start from 2ns last index)
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(arr[index++]);
            }
        }

        // now combine all the string builders:
        StringBuilder sb = sbs[0]; // start from the 0th stringbuilder array index
        for (int i = 1; i < numRows; i++) {
            sb.append(sbs[i].toString());
        }

        return sb.toString();
    }
}
