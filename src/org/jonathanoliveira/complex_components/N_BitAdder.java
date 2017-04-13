package org.jonathanoliveira.complex_components;

import java.util.ArrayList;

/**
 * This component will perform the complete addition of any number of bits we need.
 * It will accomplish this by wiring in series the necessary Full Adders.
 * Each Full Adder will be responsible for 1 bit of the binary number.
 * The carry_in of the first adder will set to zero, since the first two bits to be summed will never have a carry = 1
 * The sum_out of the first adder will be saved as a partial result of the total sum and
 * the carry_out will be set as the carry_in for the second adder.
 * The total output of this n bit adder will be all the outputs of the inner full adders + the carry_out of the last adder.
 */

public class N_BitAdder {

    // Full adders that each correspond to a bit
    private FullAdder[] adders;
    // result array that will be initialized after the inputs of the adder
    boolean[] sum_result;

    // constructor that takes an int to define how many bits this adder will handle
    public N_BitAdder(int num_of_bits) {
        // initialize the adders array with the proper size
        adders = new FullAdder[num_of_bits];
        // create all necessary adders
        for (int i = 0; i < adders.length; i++) {
            adders[i] = new FullAdder();
        }
    }

    // method that returns how many bits does this adder handles
    int getBitSize() {
        return adders.length;
    }

    // method that receives the inputs
    void setInputs(boolean[] inputA, boolean[] inputB) {
        // checking to see if the input sizes are valid
        if (inputA.length != inputB.length || inputA.length != getBitSize() || inputB.length != getBitSize()) {
            throw new IllegalArgumentException();
        } else {
            // call method to set and wire all adders
            setAndWireAdders(inputA, inputB);
        }
    }

    private void setAndWireAdders(boolean[] inputA, boolean[] inputB) {
        // create an Arraylist to dinamically store the sum result on the go
        ArrayList<Boolean> resultArr = new ArrayList<>();
        // create the variable that will hold the carry_on value of the inner adders
        // we will initialize it as false because the first adder will not have a carry_in
        boolean carry_in = false;
        // loop in all adders so we can set each one of them
        // but dont forget to do it in reverse, since that's how an addition works
        for (int i = adders.length - 1; i >= 0; i--) {
            // set the inputs for the adder
            adders[i].setInputs(carry_in, inputA[i], inputB[i]);
            // store the inner adder sum_out into the result arraylist
            resultArr.add(0,adders[i].getSumOut());
            // update the carry_in value for the next adder
            carry_in = adders[i].getCarryOut();
        }
        // if the last adder has a true carry_out, we must add it to our result arraylist
        if (adders[0].getCarryOut()) resultArr.add(0,adders[0].getCarryOut());
        // initialize our result array with the same size of our arraylist
        sum_result = new boolean[resultArr.size()];
        // loop inside the arraylist to populate the result array
        for (int i = 0; i < resultArr.size(); i++) {
            sum_result[i] = resultArr.get(i);
        }
    }

    // method that simply returns the sum result
    boolean[] getResult() {
        return this.sum_result;
    }
}
