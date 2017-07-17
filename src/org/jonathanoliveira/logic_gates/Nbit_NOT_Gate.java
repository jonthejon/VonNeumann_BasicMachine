package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.basic_components.Inverter;

import java.util.Arrays;

/** This gate is a simple inverter that can take more the one input
 * |        in        |       out        |
 * | 0000000000000000 | 1111111111111111 |
 * | 1111111111111111 | 0000000000000000 |
 * | 1010101010101010 | 0101010101010101 |
 * | 0011110011000011 | 1100001100111100 |
 * | 0001001000110100 | 1110110111001011 |
 */

public class Nbit_NOT_Gate {

//    array of AND gates that comprises this Nbit_AND_Gate
    private Inverter[] inverters;
//    the inputs array
    private boolean[] inputs;
//    the output array of this gate. This gate outputs many bits at once.
    private boolean[] output;

    /**
     * This is the constructor of this gate.
     * @param numOfBits: the number of bits that this gate can handle at a time
     * */
    public Nbit_NOT_Gate(int numOfBits) {
//        checking to see if the user is trying to construct a gate with an invalid number of bits
        if (numOfBits <= 1) throw new IllegalArgumentException();
//        initiating the array that will hold all the underlying inverters of this gate
        this.inverters = new Inverter[numOfBits];
//        filling the AND gates array with new AND gates
        Arrays.fill(this.inverters, new Inverter());
//        initiating the inputs and output arrays to the correct size given the number of bits asked by the user
//        the initial value of all of this arrays will be filled with false
        this.inputs = new boolean[numOfBits];
        this.output = new boolean[numOfBits];
//        calling the wire() method so we can set the proper initial output of this gate
        this.wire();
    }

    /**
     * This method just returns the number of bits that this gate can handle
     * @return number of bits that this gate can handle
     * */
    public int getNumInputs() {
//        the size of inputs is the same size of the number of bits handled
        return inputs.length;
    }

    /**
     * This method sets the inputs arrays and then calculate the proper output given the inputs
     * @param inputs: the array of inputs for this gate
     * */
    public void setInputs(boolean[] inputs) {
//        checking to see if the length of the inputs have the proper size
        if (inputs.length != this.getNumInputs()) throw new IllegalArgumentException();
//        setting the inputs with the new inputs given as parameters
        this.inputs = inputs;
//        calling the wire() method so this gate can recalculate its output value
        this.wire();
    }

    /**
     * This method return the inputs arrays that are set in this gate
     * @return a 2D array with the first row being the inputA and the second row the inputB
     * */
    public boolean[] getInputs() {
//        just returning the array that holds the inputs values
        return this.inputs;
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
//            setting the inputs of the underlying inverter. This automatically calculates the output of this component.
            inverters[i].setInput(this.inputs[i]);
//            inserting into our new output array the value calculated by this particular gate
            output[i] = inverters[i].getOutput();
        }
//        setting the output of this gate with the calculated output of the calculations
        this.setOutput(output);
    }

}
