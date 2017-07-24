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
}
