package org.jonathanoliveira.utilities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class responsible for converting numbers from the decimal system to binary system and vice-versa.
 */

public class Converter {

    // todo: (2) refactor the name of this method to make it clear that it handles only unsigned binary numbers
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

    // todo: (3) define overloaded convert() method that converts signed binary numbers to decimal numbers. Takes an int[] binary number
    // it may take positive and negative binary numbers
    /*
    * invert all bits, add 1 (to find the respective positive integer)
    * invert the decimal
    * */

    // todo: (2) refactor the name of this method to make it clear that it handles only unsigned binary numbers
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

    public int[] convert(int decimal_number, int bit_size) {
        // verify if the decimal number is not a negative number.
        // this is because for now our adder will only handle positive numbers.
        if (decimal_number < 0 || bit_size <= 0 || decimal_number >= powerOfTwo(bit_size)) throw new IllegalArgumentException();

        // initialize an array with the calculated size
        int[] binary = new int[bit_size];
        // int variable to hold the remainders of the divisions used in the calculation
        int remainders = decimal_number;
        // loop to populate the binary array
        for (int i = 0; i < binary.length; i++) {
            // defines the divisor we will use
            // 0100
            //7
            int divisor = powerOfTwo(binary.length - 1 - i);
            // sets the selected bit to either 1 or 0, depending of this division
            binary[i] = remainders / divisor;
            // reset the remainder variable so we can continue our calculations with the next bits
            remainders = remainders % divisor;
        }
        // returns the final array of bits
        return binary;
    }

    // todo: (1) define overloaded convert() method that will take an int decimal and an int bit-size

    // todo: (3) define overloaded convert() method that converts decimal numbers to signed binary numbers. Takes an int decimal number and an int bit_size.
    // it may take positive and negative integers

    public int[] convert_signed(int decimal_number, int bit_size) {

        int lower_bound = powerOfTwo(bit_size-1) * (-1);
//        int upper_bound = powerOfTwo(bit_size-1) * -1;
        int upper_bound = lower_bound * (-1) - 1;
        if (bit_size <= 0 || decimal_number > upper_bound || decimal_number < lower_bound) throw new IllegalArgumentException();
        int[] inverted_binary;
        if (decimal_number >= 0) {
            return convert(decimal_number,bit_size);
        } else {
            inverted_binary = convert(decimal_number*(-1),bit_size);
        }
        for (int i = 0; i<inverted_binary.length ; i++) {
            inverted_binary[i] = (inverted_binary[i] == 1) ? 0 : 1;
        }
        return add_1(inverted_binary);

    }

    private int[] add_1(int[] binary) {
        int carry = 1;
        for (int i = binary.length - 1; i>=0 ; i--) {
            binary[i] = ((binary[i] + carry) == 1) ? 1 : 0;
            carry = ((binary[i] + carry) == 2) ? 1 : 0;
        }
        return binary;
    }


    /*
    * what is -2 in a 3-bit signed binary?
    * get the +2 in binary, invert all bits and add 1
    * */

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
