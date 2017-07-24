package org.jonathanoliveira.complex_components;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This component will perform the complete addition of any number of bits we need.
 * It will accomplish this by wiring in series the necessary Full Adders and one Half Adder.
 * Each Adder will be responsible for 1 bit of the binary number.
 * The first bit will be sent to the Half Adder
 * The sum_out of the first adder will be saved as a partial result of the total sum and
 * the carry_out will be set as the carry_in for the second adder.
 * The total output of this n bit adder will be all the outputs of the inner full adders.
 * The N-bit adder may result in an overflow that will be represented by the carryout of the last adder
 */

public class N_BitAdder {

    private HalfAdder halfAdder;
    private FullAdder[] fullAdderArr;
    private boolean[] inputA;
    private boolean[] inputB;
    private boolean[] output;
    private boolean carry_out;

    public N_BitAdder(int numOfBits) {
        if (numOfBits < 2) throw new IllegalArgumentException();
        this.halfAdder = new HalfAdder();
        this.fullAdderArr = new FullAdder[numOfBits - 1];
        Arrays.fill(this.fullAdderArr, new FullAdder());
        this.output = new boolean[numOfBits];
    }

    public int getBitSize() {
        return this.output.length;
    }

    public void setInputs(boolean[] inputA, boolean[] inputB) {
        if (inputA.length != inputB.length || inputA.length != getBitSize()) {
            throw new IllegalArgumentException();
        }
        this.inputA = inputA;
        this.inputB = inputB;
        this.wire();
    }

    private void setOutput(boolean[] output, boolean carry_out) {
        if (output.length != this.output.length) throw new IllegalArgumentException();
        this.output = output;
        this.carry_out = carry_out;
    }

    public boolean[] getOutput() {
        return this.output;
    }

    public boolean getCarryOut() {
        return this.carry_out;
    }

    public void wire() {
        boolean[] prevOut = new boolean[this.getBitSize()];
        int bit = this.output.length - 1;
        boolean currCarry = false;
        this.halfAdder.setInputs(inputA[bit], inputB[bit]);
        prevOut[bit] = this.halfAdder.getSumOut();
        currCarry = this.halfAdder.getCarryOut();
        bit--;
        for (FullAdder adder: this.fullAdderArr) {
            adder.setInputs(currCarry, inputA[bit], inputB[bit]);
            prevOut[bit] = adder.getSumOut();
            currCarry = adder.getCarryOut();
            bit--;
        }
        this.setOutput(prevOut, currCarry);
    }

    /*

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
*/
}
