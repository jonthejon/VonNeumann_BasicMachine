package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.basic_components.Inverter;

import java.util.Arrays;

/**
 * Mux lets you select what channel you want the output to mimic.
 * If the select input is 0, the A channel is output.
 * If the select input is 1, the B channel is output.
 * |   a   |   b   |  sel  |  out  |
 * |   0   |   0   |   0   |   0   |
 * |   0   |   0   |   1   |   0   |
 * |   0   |   1   |   0   |   0   |
 * |   0   |   1   |   1   |   1   |
 * |   1   |   0   |   0   |   1   |
 * |   1   |   0   |   1   |   0   |
 * |   1   |   1   |   0   |   1   |
 * |   1   |   1   |   1   |   1   |
 */

public class MUX_Gate {

//    defining the fields that will hold the inputs, the selection and the output of this gate
    private boolean[] inputA;
    private boolean[] inputB;
    private boolean select;
    private boolean[] output;
    // OR gate that is a component of this MUX gate
    private OR_Gate[] or_gates;
    // AND gate that is a component of this MUX gate
    private AND_Gate[] and_gates_B;
    // AND gate that is a component of this MUX gate
    private AND_Gate[] and_gates_A;
    // Inverter component that is a component of this MUX gate
    private Inverter inverter;

    /**
     * This is the constructor of the MUX gate. you can create one with any amount of data width that you wish.
     * @param dataWidth: the width of the channels that you what (the size of the inputs)
     * */
    public MUX_Gate(int dataWidth) {
//        checking to see if we are not trying to create a MUX gate with an invalid size
        if (dataWidth < 1) throw new IllegalArgumentException();
//        initiating the inputs and output arrays with the proper size
        this.inputA = new boolean[dataWidth];
        this.inputB = new boolean[dataWidth];
        this.output = new boolean[dataWidth];
//        initiating the gates arrays with the proper sizes
        this.or_gates = new OR_Gate[dataWidth];
        this.and_gates_A = new AND_Gate[dataWidth];
        this.and_gates_B = new AND_Gate[dataWidth];
//        filling the arrays with fresh gates
        Arrays.fill(this.or_gates, new OR_Gate());
        Arrays.fill(this.and_gates_A, new AND_Gate());
        Arrays.fill(this.and_gates_B, new AND_Gate());
        // initiate the second 2-input inverter
        inverter = new Inverter();
//        calling the wire method so we can set the output of this gate
        this.wire();
    }

    /**
     * Method that will return the number of inputs that this MUX gate can handle.
     * The number of inputs is not the number of channels! We are always choosing between 2 channels in this gate.
     * The number of components is the width of the channels.
     * @return the width of bits of the channels of this MUX gate
     * */
    public int getNumInputs() {
        // returns the number of inputs of any one of these gates.
        return and_gates_A.length;
    }

    /**
     * Method that is responsible for setting all the inputs and selection mode of this gate
     * @param inputA: the first data input for this gate
     * @param inputB: the second data input for this gate
     * @param select: the selection mode that let's you choose which data channel do you want to listen
     * */
    public void setGate(boolean[] inputA, boolean[] inputB, boolean select) {
//        checking to see if the size of the inputs is valid
        if (inputA.length != inputB.length || inputA.length != this.getNumInputs()) throw new IllegalArgumentException();
//        setting the IVs with the proper values
        this.inputA = inputA;
        this.inputB = inputB;
        this.select = select;
//        calling wire() method so we can recalculate the output of this Gate
        this.wire();
    }

    /**
     * This method is called everytime we need to update the output value.
     * Observe that it is private.
     * @param output: the output value of this gate that we just calculated.
     * */
    private void setOutput(boolean[] output) {
//        checking to see if the size of the output array is valid
        if (output.length != this.getNumInputs()) throw new IllegalArgumentException();
        this.output = output;
    }

    /**
     * Method that just returns the present value of the output of this gate
     * @return the value of the output of this gate
     * */
    public boolean[] getOutput() {
        // returns the value of the output
        return this.output;
    }

    /**
     * Method responsible for wiring all the underlying gates of this MUX gate and updating the output
     * */
    public void wire() {
//        initiates a new output array to store momentarily the output result of this MUX gate
        boolean[] output = new boolean[this.getNumInputs()];
//        sending the select signal into the inverter
        this.inverter.setInput(this.select);
//        looping through all the inputs values
        for (int i = 0; i < getNumInputs(); i++) {
//        setting the inputs for the first AND Gate to be the data of channel A and the output of the inverter
            this.and_gates_A[i].setInputs(new boolean[]{this.inputA[i], this.inverter.getOutput()});
//        setting the inputs for the second AND Gate to be the data of channel B and the select value
            this.and_gates_B[i].setInputs(new boolean[]{this.inputB[i], this.select});
//        setting the inputs of the OR gate to be the outputs of the 2 AND gates
            this.or_gates[i].setInputs(new boolean[]{this.and_gates_A[i].getOutput(), this.and_gates_B[i].getOutput()});
//            setting the result of the OR gate to the proper bit of the output array
            output[i] = this.or_gates[i].getOutput();
        }
//        setting the output of this MUX gate to be the result of the OR gates
        this.setOutput(output);
    }
}
