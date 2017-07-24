package org.jonathanoliveira.complex_components;

import java.util.Arrays;

/**
 * This component will receive a N-Bit number and output the same number added with 1.
 * In the case that it overloads to the maximum number that it can handle, it will output 0.
 *
 * in[10101] -> out[10110]
 * in[1111] -> out[0000]
 */

public class N_BitIncrementer {

    private HalfAdder[] halfAdderArr;
    private boolean[] input;
    private boolean[] output;

    public N_BitIncrementer(int numOfBits) {
        if (numOfBits < 2) throw new IllegalArgumentException();
        this.halfAdderArr = new HalfAdder[numOfBits];
        Arrays.fill(this.halfAdderArr, new HalfAdder());
        this.output = new boolean[numOfBits];
    }

    public int getBitSize() {
        return this.output.length;
    }

    public void setInput(boolean[] inputA) {
        if (inputA.length != getBitSize()) throw new IllegalArgumentException();
        this.input = inputA;
        this.wire();
    }

    private void setOutput(boolean[] output) {
        if (output.length != this.output.length) throw new IllegalArgumentException();
        this.output = output;
    }

    public boolean[] getOutput() {
        return this.output;
    }

    public void wire() {
        boolean[] prevOut = new boolean[this.getBitSize()];
        int bit = this.output.length - 1;
        boolean currCarry;
        this.halfAdderArr[0].setInputs(input[bit], true);
        prevOut[bit] = this.halfAdderArr[0].getSumOut();
        currCarry = this.halfAdderArr[0].getCarryOut();
        bit--;
        for (int i = 1; i < this.halfAdderArr.length; i++) {
            this.halfAdderArr[i].setInputs(input[bit], currCarry);
            prevOut[bit] = this.halfAdderArr[i].getSumOut();
            currCarry = this.halfAdderArr[i].getCarryOut();
            bit--;
        }
        this.setOutput(prevOut);
    }
}
