package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.AND_Gate;
import org.jonathanoliveira.logic_gates.XOR_gate;

/**
 * This component will receive 3 input bits and output 8 different channels with only one of them set to 1
 */
public class Selector_8_To_1 {
    //    necessary gates to define a 8-1 selector
    private XOR_gate selXOR;
    private AND_Gate selAND_1;
    private AND_Gate selAND_2;
    private AND_Gate selAND_3;
    private AND_Gate selAND_4;
    private AND_Gate selAND_5;
    private AND_Gate selAND_6;
    private AND_Gate selAND_7;
    private AND_Gate selAND_8;
    private AND_Gate selAND_9;
    private AND_Gate selAND_10;
    private AND_Gate selAND_11;
    private AND_Gate selAND_12;
    private Inverter selInverter_1;
    private Inverter selInverter_2;
    private Inverter selInverter_3;
    //    the inputs and output of this selector
    private boolean[] output;
    private boolean[] inputs;

    public Selector_8_To_1() {
        this.selXOR = new XOR_gate();
        this.selAND_1 = new AND_Gate();
        this.selAND_2 = new AND_Gate();
        this.selAND_3 = new AND_Gate();
        this.selAND_4 = new AND_Gate();
        this.selAND_5 = new AND_Gate();
        this.selAND_6 = new AND_Gate();
        this.selAND_7 = new AND_Gate();
        this.selAND_8 = new AND_Gate();
        this.selAND_9 = new AND_Gate();
        this.selAND_10 = new AND_Gate();
        this.selAND_11 = new AND_Gate();
        this.selAND_12 = new AND_Gate();
        this.selInverter_1 = new Inverter();
        this.selInverter_2 = new Inverter();
        this.selInverter_3 = new Inverter();

        this.output = new boolean[8];
        this.inputs = new boolean[3];
    }

    /**
     * The number of inputs is the number of channels! Do not confuse with the data width.
     * @return the number of channels that this gate can handle
     * */
    public int getNumChannels() {
        return this.output.length;
    }

    /**
     * Method that is responsible for setting all the inputs and selection mode of this gate
     * @param inputs: the 2D array of inputs of this Gate
     * */
    public void setComponent(boolean[] inputs) {
        if (inputs.length != this.inputs.length) throw new IllegalArgumentException();
        this.inputs = inputs;
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
        return this.output;
    }

    /**
     * Method responsible for wiring all the underlying gates of this MUX gate and updating the output
     * */
    public void wire() {
        selXOR.setInputs(new boolean[]{this.inputs[1], this.inputs[2]});// false
        selAND_1.setInputs(new boolean[]{this.inputs[2], selXOR.getOutput()});// false
        selAND_2.setInputs(new boolean[]{this.inputs[1], selXOR.getOutput()});// false
        selAND_3.setInputs(new boolean[]{this.inputs[1], this.inputs[2]});// true
        selInverter_1.setInput(selAND_3.getOutput());// false
        selInverter_2.setInput(selXOR.getOutput());// true
        selAND_4.setInputs(new boolean[]{selInverter_1.getOutput(), selInverter_2.getOutput()});// false

        boolean OaSel = selAND_4.getOutput();// false
        boolean ObSel = selAND_1.getOutput();// false
        boolean OcSel = selAND_2.getOutput();// false
        boolean OdSel = selAND_3.getOutput();// true

        selInverter_3.setInput(this.inputs[0]);// false
        selAND_5.setInputs(new boolean[]{OaSel, selInverter_3.getOutput()});// false
        selAND_6.setInputs(new boolean[]{ObSel, selInverter_3.getOutput()});// false
        selAND_7.setInputs(new boolean[]{OcSel, selInverter_3.getOutput()});// false
        selAND_8.setInputs(new boolean[]{OdSel, selInverter_3.getOutput()});// false
        selAND_9.setInputs(new boolean[]{OaSel, this.inputs[0]});// false
        selAND_10.setInputs(new boolean[]{ObSel, this.inputs[0]});// true
        selAND_11.setInputs(new boolean[]{OcSel, this.inputs[0]});// false
        selAND_12.setInputs(new boolean[]{OdSel, this.inputs[0]});// true

        boolean OAASel = selAND_5.getOutput();// false
        boolean OBBSel = selAND_6.getOutput();// false
        boolean OCCSel = selAND_7.getOutput();// false
        boolean ODDSel = selAND_8.getOutput();// false
        boolean OEESel = selAND_9.getOutput();// false
        boolean OFFSel = selAND_10.getOutput();// false
        boolean OGGSel = selAND_11.getOutput();// false
        boolean OHHSel = selAND_12.getOutput();// true

        boolean[] output = new boolean[this.getNumChannels()];
        output[0] = OAASel;
        output[1] = OBBSel;
        output[2] = OCCSel;
        output[3] = ODDSel;
        output[4] = OEESel;
        output[5] = OFFSel;
        output[6] = OGGSel;
        output[7] = OHHSel;
        this.setOutput(output);
    }
}
