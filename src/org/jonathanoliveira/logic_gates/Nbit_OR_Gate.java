package org.jonathanoliveira.logic_gates;

import java.util.Arrays;

/** This gate works the same way as a normal AND gate but takes 2 groups of 16 bits of input and output a 16 bit group
 * |        a         |        b         |       out        |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 |
 * | 0000000000000000 | 1111111111111111 | 1111111111111111 |
 * | 1111111111111111 | 1111111111111111 | 1111111111111111 |
 * | 1010101010101010 | 0101010101010101 | 1111111111111111 |
 * | 0011110011000011 | 0000111111110000 | 0011111111110011 |
 * | 0001001000110100 | 1001100001110110 | 1001101001110110 |
 */

public class Nbit_OR_Gate {

//    array of OR gates that comprises this Nbit_OR_Gate
    private OR_Gate[] or_gates;
//    the first inputs array
    private boolean[] inputsA;
//    the second inputs array
    private boolean[] inputsB;
//    the output array of this gate. This gate outputs many bits at once.
    private boolean[] output;

    /**
     * This is the constructor of this gate.
     * @param numOfBits: the number of bits that this gate can handle at a time
     * */
    public Nbit_OR_Gate(int numOfBits) {
//        checking to see if the user is trying to construct a gate with an invalid number of relays
        if (numOfBits <= 1) throw new IllegalArgumentException();
//        initiating the array that will hold all the underlying OR gates of this gate
        this.or_gates = new OR_Gate[numOfBits];
//        filling the OR gates array with new OR gates
        Arrays.fill(this.or_gates, new OR_Gate());
//        initiating the inputsA, inputsB and output arrays to the correct size given the number of bits asked by the user
//        the initial value of all of this arrays will be filled with false
        this.inputsA = new boolean[numOfBits];
        this.inputsB = new boolean[numOfBits];
        this.output = new boolean[numOfBits];
//        calling the wire() method so we can set the proper initial output of this gate
        this.wire();
    }

    /**
     * This method just returns the number of bits that this gate can handle
     * @return number of bits that this gate can handle
     * */
    public int getNumInputs() {
//        the size of inputsA is the same size of the number of bits handled
        return inputsA.length;
    }

    /**
     * This method sets the inputs arrays and then calculate the proper output given the inputs
     * @param inputsA: the first array of inputs for this gate
     * @param inputsB:L the second array of inputs for this gate
     * */
    public void setInputs(boolean[] inputsA, boolean[] inputsB) {
//        checking to see if the length of the inputs have the proper size
        if (inputsA.length != inputsB.length || inputsA.length != this.getNumInputs()) throw new IllegalArgumentException();
//        setting the inputs with the new inputs given as parameters
        this.inputsA = inputsA;
        this.inputsB = inputsB;
//        calling the wire() method so this gate can recalculate its output value
        this.wire();
    }

    /**
     * This method return the inputs arrays that are set in this gate
     * @return a 2D array with the first row being the inputA and the second row the inputB
     * */
    public boolean[][] getInputs() {
//        initiate the 2D array with the proper size
        boolean[][] inputs = new boolean[2][getNumInputs()];
//        looping until we go through all the inputs values
        for (int i = 0; i < getNumInputs(); i++) {
//            setting the inputA value into the 2D array
            inputs[0][i] = this.inputsA[i];
//            setting the inputB value into the 2D array
            inputs[1][i] = this.inputsB[i];
        }
//        returning the filled 2D array
        return inputs;
    }

    /**
     * Method that just returns the output array that was calculated.
     * @return output array with the ouput calculated for this gate.
     * */
    public boolean[] getOutput() {
        return this.output;
    }

    /**
     * Method that sets the output of this gate. This method can only be called from inside this class to ensure that inputs are up to date
     * @param output: the output array that has just been calculated after the new inputs have been set
     * */
    private void setOutput(boolean[] output) {
//        checking to see if the given output array fits inside the output array of this gate
        if (output.length != this.output.length) throw new IllegalArgumentException();
//        setting the output array
        this.output = output;
    }

    /**
     * Method that wires all inner components and calculates the proper output array.
     * This method should be called every time we need to recalculate the output for this gate.
     * */
    public void wire() {
//        initialize a new fresh output array to be filled with the new values to be calculated
        boolean[] output = new boolean[getNumInputs()];
//        looping through all the inputs of this gate
        for (int i = 0; i < getNumInputs(); i++) {
//            setting the inputs of the underlying AND gate. This automatically calculates the output of this particular gate.
//            for each gate, we are giving one input of the inputsA and another of the inputsB
            or_gates[i].setInputs(new boolean[] {inputsA[i], inputsB[i]});
//            inserting into our new output array the value calculated by this particular gate
            output[i] = or_gates[i].getOutput();
        }
//        setting the output of this gate with the calculated output of the calculations
        this.setOutput(output);
    }
}
