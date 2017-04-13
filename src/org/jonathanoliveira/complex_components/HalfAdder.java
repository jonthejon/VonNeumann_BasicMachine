package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.AND_Gate;
import org.jonathanoliveira.logic_gates.XOR_gate;

/**
 * When make an addition operation using binary numbers, there aren't many different results you must handle:
 *
 * 0 + 0 = 0
 * 0 + 1 = 1
 * 1 + 0 = 1
 * 1 + 1 = 0, carry the 1
 *
 * We can rewrite this additions in a table with 2-bit size with leading zeros:
 *
 *      +  |  0 |  1 |
 *    ----------------
 *      0  | 00 | 01 |
 *    ----------------
 *      1  | 01 | 10 |
 *
 * We can divide this table into to complementary tables like so:
 *
 *     sum | 0 | 1 |        car | 0 | 1 |
 *    --------------       --------------
 *      0  | 0 | 1 |         0  | 0 | 0 |
 *    --------------       --------------
 *      1  | 1 | 0 |         1  | 0 | 1 |
 *
 * Finally we can observe that these tables are exactly like the XOR and AND gates.
 * This means that we can replicate the sum of binary numbers using these gates.
 */

class HalfAdder {

    // this is the output of the sum, made by the XOR gate
    private boolean sum_out;
    // this is the carry value of the sum, output of the AND gate
    private boolean carry_out;
    // private XOR gate that is part of this Half-Adder
    private XOR_gate xor_gate;
    // private AND gate that is part of this Half-Adder
    private AND_Gate and_gate;

    // nor-arg constructor that will initialize the gates
    HalfAdder() {
        // initiates the 2-input XOR gate
        xor_gate = new XOR_gate();
        // initiates the 2-input AND gate
        and_gate = new AND_Gate();
    }

    // method that sets the inputs of the the half adder. They will always be two.
    void setInputs(boolean inA, boolean inB) {
        // create a boolean array and initiate it with the adder inputs
        boolean[] inputs = new boolean[] {inA, inB};
        // set the inputs of the XOR gates
        xor_gate.setInputs(inputs);
        // update the sum output with the XOR output
        sum_out = xor_gate.getOutput();
        // set the inputs of the AND gates
        and_gate.setInputs(inputs);
        // update the carry out with the AND output
        carry_out = and_gate.getOutput();
    }

    // method that returns the sum output
    boolean getSumOut() {
        return this.sum_out;
    }

    // method that returns the carry out
    boolean getCarryOut() {
        return this.carry_out;
    }

}
