package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.AND_Gate;
import org.jonathanoliveira.logic_gates.OR_Gate;
import org.jonathanoliveira.logic_gates.XOR_gate;

/**
 * The problem with the Half Adder is that it just calculates a Carry On, but it does not use a previous carry on from another sum into its own. Just observe that the HalfAdder only accepts 2 inputs.
 * We need to create a complete adder that will perform a sum with both the inputs and with a previous carry on from another sum.
 * We can accomplish this by using a couple of HalfAdders and an OR gate.
 * This is how it should work:
 *  inputs A and B will be the inputs of the first HalfAdder.
 *  The sum_out of this will be the input of the second HalfAdder.
 *  The other input of the second HalfAdder will be the carry_on of a previous sum.
 *  Since the carry_on of both of these HalfAdders will never be 1 at the same time, we can input them as a final OR gate.
 *  The sum_out of the second HalfAdder will be sum_out of the FullAdder.
 *  The output of the OR gate will be the carry_out of the FullAdder.
 *
 *  Here is the table of the Full Adder:
 *
 *     inA | inB | CarIn | SumOut | CarOut |
 *    --------------------------------------
 *      0  |  0  |   0   |   0    |    0   |
 *    --------------------------------------
 *      0  |  1  |   0   |   1    |    0   |
 *    --------------------------------------
 *      1  |  0  |   0   |   1    |    0   |
 *    --------------------------------------
 *      1  |  1  |   0   |   0    |    1   |
 *    --------------------------------------
 *      0  |  0  |   1   |   1    |    0   |
 *    --------------------------------------
 *      0  |  1  |   1   |   0    |    1   |
 *    --------------------------------------
 *      1  |  0  |   1   |   0    |    1   |
 *    --------------------------------------
 *      1  |  1  |   1   |   1    |    1   |
 *
 */

public class FullAdder {

    // this is the output of the sum, made by the second Half Adder gate
    private boolean sum_out;
    // this is the carry value of the sum, output of the OR gate
    private boolean carry_out;
    // private HalfAdder. The first Adder of this Full Adder
    private HalfAdder first_adder;
    // private HalfAdder. The second Adder of this Full Adder
    private HalfAdder second_adder;
    // private OR gate that is the final part of this Full Adder
    private OR_Gate or_gate;
    private boolean inCarry;
    private boolean inA;
    private boolean inB;

    // nor-arg constructor that will initialize the Half Adders and the OR gate
    FullAdder() {
        // initiates the first Half Adder
        first_adder = new HalfAdder();
        // initiates the second Half Adder
        second_adder = new HalfAdder();
        // initiates the 2-input OR gate
        or_gate = new OR_Gate();
    }

    // method that sets the inputs of the HalfAdders with the inputs and the carry_in.
    void setInputs(boolean inCarry, boolean inA, boolean inB) {
        this.inCarry = inCarry;
        this.inA = inA;
        this.inB = inB;
        this.wire();
    }

    // method that returns the sum output
    boolean getSumOut() {
        return this.sum_out;
    }

    // method that returns the carry out
    boolean getCarryOut() {
        return this.carry_out;
    }

    public void wire() {
        // set the inputs of the first HalfAdder
        first_adder.setInputs(inA, inB);
        // set the inputs of the second HalfAdder with the carry_in and the sum_out of the first adder
        second_adder.setInputs(inCarry, first_adder.getSumOut());
        // update the sum output with the second adder sum_out
        sum_out = second_adder.getSumOut();
        // set the inputs of the OR gate with the carry_out of both adders
        or_gate.setInputs(new boolean[] {first_adder.getCarryOut(), second_adder.getCarryOut()});
        // update the carry out with the OR output
        carry_out = or_gate.getOutput();
    }

}
