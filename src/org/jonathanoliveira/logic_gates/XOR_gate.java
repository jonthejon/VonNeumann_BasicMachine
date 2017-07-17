package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.utilities.Binary;

import java.util.Arrays;

/**
 * The XOR gate is a more complex gate than the other ones created.
 * In order to create it, we must use other gates instead of just relays.
 * Here is the desired behavior of an XOR gate: the output will be true only if EXCLUSIVELY ONE of the inputs is true.
 *
 *     XOR | 0 | 1 |
 *    --------------
 *      0  | 0 | 1 |
 *    --------------
 *      1  | 1 | 0 |
 *
 * This behavior will be achieved after sending the same input to an OR gate and a NAND gate and then sending the result into an AND gate, like so:
 *
 *     A In | B In | OR Out | NAND Out | AND = XOR |
 *    ----------------------------------------------
 *       0  |  0   |    0   |     1    |     0     |
 *    ----------------------------------------------
 *       0  |  1   |    1   |     1    |     1     |
 *    ----------------------------------------------
 *       1  |  0   |    1   |     1    |     1     |
 *    ----------------------------------------------
 *       1  |  1   |    1   |     0    |     0     |
 *
 */

public class XOR_gate {

//    field to hold the inputs of this gate
    private boolean[] inputs;
    // field to hold the output of this gate
    private boolean output;
    // OR gate that is a component of this XOR gate
    private OR_Gate or_gate;
    // NAND gate that is a component of this XOR gate
    private NAND_Gate nand_gate;
    // AND gate that is a component of this XOR gate
    private AND_Gate and_gate;

    // no-arg constructor that initiate all necessary 2-input gates
    public XOR_gate() {
        // initiate the 2-input OR gate
        or_gate = new OR_Gate();
        // initiate the 2-input NAND gate
        nand_gate = new NAND_Gate();
        // initiate the 2-input AND gate
        and_gate = new AND_Gate();

//        creating the inputs array with the proper size of inputs
        this.inputs = new boolean[getNumInputs()];
//        initiating the inputs array with default values
        Arrays.fill(this.inputs, Binary.NO_VOLTAGE.getValue());
//        calling the wire method so we can set the output of this gate
        this.wire();
    }

    public int getNumInputs() {
        // returns the number of inputs of any one of these gates.
        return or_gate.getNumInputs();
    }

    public void setInputs(boolean[] inputs) {
// check to see if the number of inputs is different then the accepted number (2)
        if (inputs.length != getNumInputs()) {
            // if there is an invalid number of components, an exception must be thrown
            throw new IllegalArgumentException();
        } else {
//            setting the new values if inputs
            this.inputs = inputs;
//            calling wire method so the output of this gate can be recalculated after the new inputs have been set
            this.wire();
        }
    }

    public boolean[] getInputs() {
        return this.inputs;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    public boolean getOutput() {
        // returns the value of the output
        return this.output;
    }

    public void wire() {
        // boolean array that will hold the outputs of the OR and NAND gate
        boolean[] andGateInputs = new boolean[2];
        // set the inputs of the OR gate
        or_gate.setInputs(getInputs());
        // save the output of the OR gate
        andGateInputs[0] = or_gate.getOutput();
        // set the inputs of the NAND gate
        nand_gate.setInputs(getInputs());
        // save the output of the NAND gate
        andGateInputs[1] = nand_gate.getOutput();
        // set the inputs of the AND gate
        and_gate.setInputs(andGateInputs);
        // set the XOR output equals to the output of the AND gate
        this.output = and_gate.getOutput();
    }
}
