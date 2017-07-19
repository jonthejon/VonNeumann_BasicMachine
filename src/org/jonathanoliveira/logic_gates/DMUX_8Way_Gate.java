package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.complex_components.Selector_8_To_1;

/**
 * DMux 8way lets you select what channel you want the single data input to appear.
 * you must define 3 select bits that will represent one of the 8 different output channels
 | in  |  sel  |  a  |  b  |  c  |  d  |  e  |  f  |  g  |  h  |
 |  0  |  000  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  001  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  010  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  011  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  100  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  101  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  110  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  0  |  111  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  1  |  000  |  1  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  1  |  001  |  0  |  1  |  0  |  0  |  0  |  0  |  0  |  0  |
 |  1  |  010  |  0  |  0  |  1  |  0  |  0  |  0  |  0  |  0  |
 |  1  |  011  |  0  |  0  |  0  |  1  |  0  |  0  |  0  |  0  |
 |  1  |  100  |  0  |  0  |  0  |  0  |  1  |  0  |  0  |  0  |
 |  1  |  101  |  0  |  0  |  0  |  0  |  0  |  1  |  0  |  0  |
 |  1  |  110  |  0  |  0  |  0  |  0  |  0  |  0  |  1  |  0  |
 |  1  |  111  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  1  |
 */

public class DMUX_8Way_Gate {

    private Selector_8_To_1 selector;

    //    defining the fields that will hold the inputs, the selection and the output of this gate
    private boolean input;
    private boolean[] select;
    private boolean[] output;
    // AND gate that is a component of this DMUX gate
//    private AND_Gate[] and_gates;
    private AND_Gate and_gate_a;
    private AND_Gate and_gate_b;
    private AND_Gate and_gate_c;
    private AND_Gate and_gate_d;
    private AND_Gate and_gate_e;
    private AND_Gate and_gate_f;
    private AND_Gate and_gate_g;
    private AND_Gate and_gate_h;

    /*    *
         * This is the constructor of the DMUX gate. This gate can only take 1 bit data input and handle only 2 output channels
         * */
    public DMUX_8Way_Gate() {
//        initiating the output array with the proper size
        this.output = new boolean[8];
//        initiating the select array with the proper size
        this.select = new boolean[3];
//        initiating the AND Gates array with the proper size
//        this.and_gates = new AND_Gate[4];
//        filling the AND gate array with new fresh AND Gates
//        Arrays.fill(this.and_gates, new AND_Gate());
        this.and_gate_a = new AND_Gate();
        this.and_gate_b = new AND_Gate();
        this.and_gate_c = new AND_Gate();
        this.and_gate_d = new AND_Gate();
        this.and_gate_e = new AND_Gate();
        this.and_gate_f = new AND_Gate();
        this.and_gate_g = new AND_Gate();
        this.and_gate_h = new AND_Gate();
        this.selector = new Selector_8_To_1();
//        calling the wire method so we can set the output of this gate
        this.wire();
    }

    /*    *
         * Method that will return the number of channels that this DMUX gate can output.
         * @return the number of channels of this DMUX gate
         * */
    public int getNumChannels() {
        // returns the number of inputs of any one of the output length.
        return output.length;
    }

    /*    *
         * Method that is responsible for setting all the inputs and selection mode of this gate
         * @param input: the first data input for this gate
         * @param select: the selection mode that let's you choose which data channel do you want to listen
         * */
    public void setGate(boolean input, boolean[] select) {
        if (select.length != this.select.length) throw new IllegalArgumentException();
//        setting the IVs with the proper values
        this.input = input;
        this.select = select;
//        calling wire() method so we can recalculate the output of this Gate
        this.wire();
    }

    /*    *
         * This method is called everytime we need to update the output value.
         * Observe that it is private.
         * @param output: the output value of this gate that we just calculated.
         * */
    private void setOutput(boolean[] output) {
//        checking to see if the size of the output array is valid
        if (output.length != this.getNumChannels()) throw new IllegalArgumentException();
        this.output = output;
    }

    /*    *
         * Method that just returns the present value of the output of this gate
         * @return the value of the output of this gate
         * */
    public boolean[] getOutput() {
        // returns the value of the output
        return this.output;
    }

    /*    *
         * Method responsible for wiring all the underlying gates of this DMUX gate and updating the output
         * */
    public void wire() {

        boolean and1Result;
        boolean and2Result;
        boolean and3Result;
        boolean and4Result;
        boolean and5Result;
        boolean and6Result;
        boolean and7Result;
        boolean and8Result;

//        initiates a new output array to store momentarily the output result of this DMUX gate
        boolean[] output = new boolean[this.getNumChannels()];
        this.selector.setComponent(this.select);
        boolean[] selections = this.selector.getOutput();
        this.and_gate_a.setInputs(new boolean[]{selections[0], this.input});
        this.and_gate_b.setInputs(new boolean[]{selections[1], this.input});
        this.and_gate_c.setInputs(new boolean[]{selections[2], this.input});
        this.and_gate_d.setInputs(new boolean[]{selections[3], this.input});
        this.and_gate_e.setInputs(new boolean[]{selections[4], this.input});
        this.and_gate_f.setInputs(new boolean[]{selections[5], this.input});
        this.and_gate_g.setInputs(new boolean[]{selections[6], this.input});
        this.and_gate_h.setInputs(new boolean[]{selections[7], this.input});

        and1Result = this.and_gate_a.getOutput();
        and2Result = this.and_gate_b.getOutput();
        and3Result = this.and_gate_c.getOutput();
        and4Result = this.and_gate_d.getOutput();
        and5Result = this.and_gate_e.getOutput();
        and6Result = this.and_gate_f.getOutput();
        and7Result = this.and_gate_g.getOutput();
        and8Result = this.and_gate_h.getOutput();
//        setting the output values of the gate with the proper result of the AND gates
        output[0] = and1Result;
        output[1] = and2Result;
        output[2] = and3Result;
        output[3] = and4Result;
        output[4] = and5Result;
        output[5] = and6Result;
        output[6] = and7Result;
        output[7] = and8Result;
//        setting the output of this MUX gate to be the result of the OR gates
        this.setOutput(output);
    }
}
