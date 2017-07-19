package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.AND_Gate;
import org.jonathanoliveira.logic_gates.XOR_gate;

/**
 * This component will receive 2 input bits and output 4 different channels with only one of them set to 1
 *
 */
public class Selector_4_To_1 {

//    necessary gates to define a 4-1 selector
    private XOR_gate selXOR;
    private AND_Gate selAND_1;
    private AND_Gate selAND_2;
    private AND_Gate selAND_3;
    private AND_Gate selAND_4;
    private Inverter selInverter_1;
    private Inverter selInverter_2;
//    the inputs and output of this selector
    private boolean[] output;
    private boolean[] inputs;

    public Selector_4_To_1() {
        selXOR = new XOR_gate();
        selAND_1 = new AND_Gate();
        selAND_2 = new AND_Gate();
        selAND_3 = new AND_Gate();
        selAND_4 = new AND_Gate();
        selInverter_1 = new Inverter();
        selInverter_2 = new Inverter();
        this.output = new boolean[4];
        this.inputs = new boolean[2];
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
        selXOR.setInputs(new boolean[]{this.inputs[1], this.inputs[0]});
        selAND_1.setInputs(new boolean[]{this.inputs[0], selXOR.getOutput()});
        selAND_2.setInputs(new boolean[]{this.inputs[1], selXOR.getOutput()});
        selAND_3.setInputs(new boolean[]{this.inputs[1], this.inputs[0]});
        selInverter_1.setInput(selAND_3.getOutput());
        selInverter_2.setInput(selXOR.getOutput());
        selAND_4.setInputs(new boolean[]{selInverter_1.getOutput(), selInverter_2.getOutput()});

        boolean OaSel = selAND_4.getOutput();
        boolean ObSel = selAND_2.getOutput();
        boolean OcSel = selAND_1.getOutput();
        boolean OdSel = selAND_3.getOutput();

        boolean[] output = new boolean[this.getNumChannels()];
        output[0] = OaSel;
        output[1] = ObSel;
        output[2] = OcSel;
        output[3] = OdSel;
        this.setOutput(output);
    }
}
