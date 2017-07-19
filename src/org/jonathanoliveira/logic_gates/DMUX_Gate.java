package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.basic_components.Inverter;

import java.util.Arrays;

/**
 * DMux lets you select what channel you want the single data input to appear.
 * If the select input is 0, the A channel will receive the data.
 * If the select input is 1, the B channel will receive the data.
 * |  in   |  sel  |   a   |   b   |
 * |   0   |   0   |   0   |   0   |
 * |   0   |   1   |   0   |   0   |
 * |   1   |   0   |   1   |   0   |
 * |   1   |   1   |   0   |   1   |
 */
public class DMUX_Gate {

    //    defining the fields that will hold the inputs, the selection and the output of this gate
    private boolean input;
    private boolean select;
    private boolean[] output;
    // AND gate that is a component of this DMUX gate
    private AND_Gate and_gate_B;
    // AND gate that is a component of this DMUX gate
    private AND_Gate and_gate_A;
    // Inverter component that is a component of this MUX gate
    private Inverter inverter;

    /**
     * This is the constructor of the DMUX gate. This gate can only take 1 bit data input and handle only 2 output channels
     * */
    public DMUX_Gate() {
//        initiating the output array with the proper size
        this.output = new boolean[2];
//        initiating the gates that composes this DMUX
        this.and_gate_A = new AND_Gate();
        this.and_gate_B = new AND_Gate();
        // initiate the second 2-input inverter
        this.inverter = new Inverter();
//        calling the wire method so we can set the output of this gate
        this.wire();
    }

    /**
     * Method that will return the number of channels that this DMUX gate can output.
     * @return the number of channels of this DMUX gate
     * */
    public int getNumChannels() {
        // returns the number of inputs of any one of the output length.
        return output.length;
    }

    /**
     * Method that is responsible for setting all the inputs and selection mode of this gate
     * @param input: the first data input for this gate
     * @param select: the selection mode that let's you choose which data channel do you want to listen
     * */
    public void setGate(boolean input, boolean select) {
//        setting the IVs with the proper values
        this.input = input;
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
        if (output.length != this.getNumChannels()) throw new IllegalArgumentException();
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
     * Method responsible for wiring all the underlying gates of this DMUX gate and updating the output
     * */
    public void wire() {
//        initiates a new output array to store momentarily the output result of this DMUX gate
        boolean[] output = new boolean[this.getNumChannels()];
//        sending the select signal into the inverter
        this.inverter.setInput(this.select);
//        setting the inputs for the first AND Gate to be the data and the output of the inverter
        this.and_gate_A.setInputs(new boolean[]{this.inverter.getOutput(), this.input});
//        setting the inputs for the second AND Gate to be the data and the select value
        this.and_gate_B.setInputs(new boolean[]{this.select, this.input});
//        setting the output values of the gate with the proper result of the AND gates
        output[0] = this.and_gate_A.getOutput();
        output[1] = this.and_gate_B.getOutput();
//        setting the output of this MUX gate to be the result of the OR gates
        this.setOutput(output);
    }
}
