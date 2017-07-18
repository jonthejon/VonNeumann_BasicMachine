package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.basic_components.Inverter;

import java.util.Arrays;

/**
 * This gate should allow you to choose 1 of 8 channels.
 *
 * |        a         |        b         |        c         |        d         |        e         |        f         |        g         |        h         |  sel  |       out        |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  000  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  001  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  010  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  011  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  100  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  101  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  110  | 0000000000000000 |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 | 0000000000000000 |  111  | 0000000000000000 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  000  | 0001001000110100 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  001  | 0010001101000101 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  010  | 0011010001010110 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  011  | 0100010101100111 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  100  | 0101011001111000 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  101  | 0110011110001001 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  110  | 0111100010011010 |
 * | 0001001000110100 | 0010001101000101 | 0011010001010110 | 0100010101100111 | 0101011001111000 | 0110011110001001 | 0111100010011010 | 1000100110101011 |  111  | 1000100110101011 |
 */

public class MUX_8Way_Gate {

    private XOR_gate selXOR = new XOR_gate();
    private AND_Gate selAND_1 = new AND_Gate();
    private AND_Gate selAND_2 = new AND_Gate();
    private AND_Gate selAND_3 = new AND_Gate();
    private AND_Gate selAND_4 = new AND_Gate();
    private Inverter selInverter_1 = new Inverter();
    private Inverter selInverter_2 = new Inverter();

    private AND_Gate[][] andGates;
    private OR_Gate[][] orGates;

    private boolean[][] inputs;
    private boolean[] select;
    private boolean[] output;

    public MUX_8Way_Gate(int dataWidth) {
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
        selXOR.setInputs(new boolean[]{select[1], select[0]});
        selAND_1.setInputs(new boolean[]{select[0], selXOR.getOutput()});
        selAND_2.setInputs(new boolean[]{select[1], selXOR.getOutput()});
        selAND_3.setInputs(new boolean[]{select[1], select[0]});
        selInverter_1.setInput(selAND_3.getOutput());
        selInverter_2.setInput(selXOR.getOutput());
        selAND_4.setInputs(new boolean[]{selInverter_1.getOutput(), selInverter_2.getOutput()});

        boolean OaSel = selAND_4.getOutput();
        boolean ObSel = selAND_2.getOutput();
        boolean OcSel = selAND_1.getOutput();
        boolean OdSel = selAND_3.getOutput();

        boolean and1Result;
        boolean and2Result;
        boolean and3Result;
        boolean and4Result;
        boolean or1Result;
        boolean or2Result;


        boolean[] output = new boolean[getDataWidth()];
        for (int i = 0; i < getDataWidth(); i++) {
            andGates[i][0].setInputs(new boolean[]{inputs[0][i], OaSel}); // INPUT A
            and1Result = andGates[i][0].getOutput();
            andGates[i][1].setInputs(new boolean[]{inputs[1][i], ObSel}); // false
            and2Result = andGates[i][1].getOutput();
            andGates[i][2].setInputs(new boolean[]{inputs[2][i], OcSel}); // false
            and3Result = andGates[i][2].getOutput();
            andGates[i][3].setInputs(new boolean[]{inputs[3][i], OdSel}); // false
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
