package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.complex_components.Selector_4_To_1;

import java.util.Arrays;

/**
 * This gate should allow you to choose 1 of 4 channels.
 * |        a         |        b         |        c         |        d         | sel  |       out        |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  00  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  01  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  10  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  11  | 0000000000000000 |
 * | 0001001000110100 | 1001100001110110 | 1010101010101010 | 0101010101010101 |  00  | 0001001000110100 |
 * | 0001001000110100 | 1001100001110110 | 1010101010101010 | 0101010101010101 |  01  | 1001100001110110 |
 * | 0001001000110100 | 1001100001110110 | 1010101010101010 | 0101010101010101 |  10  | 1010101010101010 |
 * | 0001001000110100 | 1001100001110110 | 1010101010101010 | 0101010101010101 |  11  | 0101010101010101 |
 **/

public class MUX_4Way_Gate {

    private Selector_4_To_1 selector;

    private AND_Gate[][] andGates;
    private OR_Gate[][] orGates;

    private boolean[][] inputs;
    private boolean[] select;
    private boolean[] output;

    public MUX_4Way_Gate(int dataWidth) {
        if (dataWidth < 1) throw new IllegalArgumentException();
        this.andGates = new AND_Gate[dataWidth][4];
        this.orGates = new OR_Gate[dataWidth][3];
        for (int i = 0; i < dataWidth; i++) {
            Arrays.fill(this.andGates[i], new AND_Gate());
            Arrays.fill(this.orGates[i], new OR_Gate());
        }
        this.inputs = new boolean[4][dataWidth];
        this.select = new boolean[2];
        this.output = new boolean[dataWidth];
        this.selector = new Selector_4_To_1();
    }

    /**
     * Method that will return the number of inputs that this MUX gate can handle.
     * The number of inputs is the number of channels! Do not confuse with the data width.
     * @return the number of channels that this gate can handle
     * */
    public int getNumChannels() {
        return this.andGates[0].length;
    }

    /**
     * Method that returns the size of the data width of the channels
     * @return the width of bits of the channels of this MUX gate*/
    public int getDataWidth() {
        return this.andGates.length;
    }

    /**
     * Method that is responsible for setting all the inputs and selection mode of this gate
     * @param inputs: the 2D array of inputs of this Gate
     * @param select: the selection array that let's you choose which data channel do you want to listen
     * */
    public void setGate(boolean[][] inputs, boolean[] select) {
        if (inputs.length != getNumChannels() || select.length != this.select.length) throw new IllegalArgumentException();
        for (boolean[] arr : inputs) {
            if (arr.length != getDataWidth()) throw new IllegalArgumentException();
        }
        this.inputs = inputs;
        this.select = select;
        this.wire();
    }

    /**
     * This method is called everytime we need to update the output value.
     * Observe that it is private.
     * @param output: the output value of this gate that we just calculated.
     * */
    private void setOutput(boolean[] output) {
        if (output.length != this.output.length) throw new IllegalArgumentException();
        this.output = output;
    }

    /**
     * Method that just returns the present value of the output of this gate
     * @return the value of the output of this gate
     * */
    public boolean[] getOutput() {
/*        System.out.print("[ ");
        for (boolean value: output){
            System.out.print(value + "  ");
        }
        System.out.print(" ]");*/
        return this.output;
    }

    /**
     * Method responsible for wiring all the underlying gates of this MUX gate and updating the output
     * */
    public void wire() {

        this.selector.setComponent(this.select);
        boolean[] selections = this.selector.getOutput();
        boolean and1Result;
        boolean and2Result;
        boolean and3Result;
        boolean and4Result;
        boolean or1Result;
        boolean or2Result;


        boolean[] output = new boolean[getDataWidth()];
        for (int i = 0; i < getDataWidth(); i++) {
            andGates[i][0].setInputs(new boolean[]{inputs[0][i], selections[0]}); // INPUT A
            and1Result = andGates[i][0].getOutput();
            andGates[i][1].setInputs(new boolean[]{inputs[1][i], selections[1]}); // false
            and2Result = andGates[i][1].getOutput();
            andGates[i][2].setInputs(new boolean[]{inputs[2][i], selections[2]}); // false
            and3Result = andGates[i][2].getOutput();
            andGates[i][3].setInputs(new boolean[]{inputs[3][i], selections[3]}); // false
            and4Result = andGates[i][3].getOutput();
            orGates[i][0].setInputs(new boolean[]{and1Result, and2Result});
            or1Result = orGates[i][0].getOutput();
            orGates[i][1].setInputs(new boolean[]{and3Result, or1Result}); // true
            or2Result = orGates[i][1].getOutput();
            orGates[i][2].setInputs(new boolean[]{and4Result, or2Result}); // true
            output[i] = orGates[i][2].getOutput();
        }
        this.setOutput(output);
    }
}
