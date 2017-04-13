package org.jonathanoliveira.utilities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class responsible for converting numbers from the decimal system to binary system and vice-versa.
 */

public class Converter {

    // binary to decimal method
    public int convert(int[] binary_number) {
        // int variable that will store the decimal number
        int decimal_number = 0;
        // loop to calculate each bit of the binary number
        for (int i = 0; i < binary_number.length; i++) {
            // adds to the decimal number the result of the binary conversion
            decimal_number += (binary_number[i] * powerOfTwo(binary_number.length - 1 - i));
        }
        // returns the calculated decimal number
        return decimal_number;
    }

    // decimal to binary method
    public int[] convert(int decimal_number) {
        // verify if the decimal number is not a negative number.
        // this is because for now our adder will only handle positive numbers.
        if (decimal_number < 0) throw new IllegalArgumentException();

        // number that will specify the bit size of the binary number
        int bit_size = 0;
        // loop until we define the size of the binary number
        while (true) {
            if (decimal_number >= powerOfTwo(bit_size)) {
                bit_size++;
            } else break;
        }
        // initialize an array with the calculated size
        int[] binary = new int[bit_size];
        // int variable to hold the remainders of the divisions used in the calculation
        int remainders = decimal_number;
        // loop to populate the binary array
        for (int i = 0; i < binary.length; i++) {
            // defines the divisor we will use
            int divisor = powerOfTwo(binary.length - 1 - i);
            // sets the selected bit to either 1 or 0, depending of this division
            binary[i] = remainders / divisor;
            // reset the remainder variable so we can continue our calculations with the next bits
            remainders = remainders % divisor;
        }
        // returns the final array of bits
        return binary;
    }

    // method power of 2 calculator
    int powerOfTwo(int power) {
        return (int) Math.pow(2, power);
    }

    // binary to boolean conversion method
    // this method will be used as an interface between our arrays that represent binary numbers to our arrays of booleans in which the logic gates work on
    public boolean[] convertToBooleans(int[] binary) {
        // initiate the boolean array with the same size of the binary array that will be sent as a result
        boolean[] bool_result = new boolean[binary.length];
        // loop inside the binary array
        for (int i = 0; i < binary.length; i++) {
            // set the boolean to true or false, depending on the bit, 1 or 0
            bool_result[i] = (binary[i] == 1);
        }
        return bool_result;
    }

    // boolean to binary conversion method
    // this method will be used as an interface between our arrays that represent binary numbers to our arrays of booleans in which the logic gates work on
    public int[] convertFromBooleans(boolean[] booleans) {
        // initiate the int array with the same size of the boolean array that will be sent as a result
        int[] binary = new int[booleans.length];
        // loop inside the boolean array
        for (int i = 0; i < booleans.length; i++) {
            // set the boolean to true or false, depending on the bit, 1 or 0
            binary[i] = booleans[i] ? 1 : 0;
        }
        return binary;
    }


}
