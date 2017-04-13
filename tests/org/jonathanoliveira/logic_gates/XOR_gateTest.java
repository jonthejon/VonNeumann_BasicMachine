package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;


public class XOR_gateTest {

    //    after constructing a 2 input XOR gate, error will occur if setting more than 2 inputs
    @Test (expected = IllegalArgumentException.class)
    public void set_InvalidBiggerInput_XOR_gate() throws Exception {
        XOR_gate xor_gate = new XOR_gate();
        xor_gate.setInputs(new boolean[] {true, true, true});
    }

    //    after constructing a 2 input XOR gate, error will occur if setting less than 2 inputs
    @Test (expected = IllegalArgumentException.class)
    public void set_InvalidSmallerInput_XOR_gate() throws Exception {
        XOR_gate xor_gate = new XOR_gate();
        xor_gate.setInputs(new boolean[] {true});
    }

    //    after constructing a 2 input XOR gate, set INPUT[false, false]. output must be false
    @Test
    public void check_00_input_XOR_gate() throws Exception {
        XOR_gate xor_gate = new XOR_gate();
        xor_gate.setInputs(new boolean[] {false, false});
        assertFalse(xor_gate.getOutput());
    }

    //    after constructing a 2 input XOR gate, set INPUT[true, false]. output must be true
    @Test
    public void check_10_input_XOR_gate() throws Exception {
        XOR_gate xor_gate = new XOR_gate();
        xor_gate.setInputs(new boolean[] {true, false});
        assertTrue(xor_gate.getOutput());
    }

    //    after constructing a 2 input XOR gate, set INPUT[true, true]. output must be false
    @Test
    public void check_11_input_XOR_gate() throws Exception {
        XOR_gate xor_gate = new XOR_gate();
        xor_gate.setInputs(new boolean[] {true, true});
        assertFalse(xor_gate.getOutput());
    }

    //    after constructing a 2 input XOR gate, set INPUT[false, true]. output must be false
    @Test
    public void check_01_input_XOR_gate() throws Exception {
        XOR_gate xor_gate = new XOR_gate();
        xor_gate.setInputs(new boolean[] {false, true});
        assertTrue(xor_gate.getOutput());
    }

}