package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.logic_gates.AND_Gate;
import org.junit.Test;

import static org.junit.Assert.*;

public class AND_GateTest {

    //    after constructing a 2 input AND gate, all 2 relays will exist
    @Test
    public void create_2input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate();
        int numInputs = and_gate.getNumInputs();
        assertTrue(numInputs == 2);
    }

    //    after constructing a 5 input AND gate, all 5 relays will exist
    @Test
    public void create_5input_AND_gate() throws Exception {
        int numRelays = 5;
        AND_Gate and_gate = new AND_Gate(numRelays);
        int numInputs = and_gate.getNumInputs();
        assertTrue(numInputs == numRelays);
    }

    //    after constructing a -3 input AND gate, and IllegalArgumentException will be thrown
    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_AND_gate() throws Exception {
        int numRelays = -5;
        new AND_Gate(numRelays);
    }

    //    after constructing a 2 input AND gate, set INPUT[true, true]. output must be true
    @Test
    public void check_11_2input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate();
        and_gate.setInputs(new boolean[] {true, true});
        assertTrue(and_gate.getOutput());
    }

    //    after constructing a 2 input AND gate, set INPUT[true, false]. output must be false
    @Test
    public void check_10_2input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate();
        and_gate.setInputs(new boolean[] {true, false});
        assertFalse(and_gate.getOutput());
    }

    //    after constructing a 2 input AND gate, set INPUT[false, false]. output must be false
    @Test
    public void check_00_2input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate();
        and_gate.setInputs(new boolean[] {false, false});
        assertFalse(and_gate.getOutput());
    }

    //    after constructing a 2 input AND gate, set INPUT[false, false, true], but gate only supports 2 inputs.
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput_2input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate();
        and_gate.setInputs(new boolean[] {false, false, true});
    }

    //    after constructing a 4 input AND gate, set INPUT[false, false, true], but gate supports precisely 4 inputs.
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput_4input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate(4);
        and_gate.setInputs(new boolean[] {false, false, true});
    }

    //    after constructing a 7 input AND gate, set INPUT[true x7]. output must be true
    @Test
    public void check_1111111_7input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate(7);
        and_gate.setInputs(new boolean[] {true, true, true, true, true, true, true});
        assertTrue(and_gate.getOutput());
    }

    //    after constructing a 7 input AND gate, set INPUT[true x 6, false]. output must be false
    @Test
    public void check_11111110_7input_AND_gate() throws Exception {
        AND_Gate and_gate = new AND_Gate(7);
        and_gate.setInputs(new boolean[] {true, true, true, true, true, true, false});
        assertFalse(and_gate.getOutput());
    }
}