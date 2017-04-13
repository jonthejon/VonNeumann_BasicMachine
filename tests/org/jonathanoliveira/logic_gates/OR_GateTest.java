package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.logic_gates.OR_Gate;
import org.junit.Test;

import static org.junit.Assert.*;


public class OR_GateTest {

    //    after constructing a 2 input OR gate, all 2 relays will exist
    @Test
    public void create_2input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate();
        int numInputs = or_gate.getNumInputs();
        assertTrue(numInputs == 2);
    }

    //    after constructing a 5 input OR gate, all 5 relays will exist
    @Test
    public void create_5input_OR_gate() throws Exception {
        int numRelays = 5;
        OR_Gate or_gate = new OR_Gate(numRelays);
        int numInputs = or_gate.getNumInputs();
        assertTrue(numInputs == numRelays);
    }

    //    after constructing a -3 input OR gate, and IllegalArgumentException will be thrown
    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_OR_gate() throws Exception {
        int numRelays = -5;
        new OR_Gate(numRelays);
    }

    //    after constructing a 2 input OR gate, set INPUT[true, true]. output must be true
    @Test
    public void check_11_2input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate();
        or_gate.setInputs(new boolean[] {true, true});
        assertTrue(or_gate.getOutput());
    }

    //    after constructing a 2 input OR gate, set INPUT[true, false]. output must be true
    @Test
    public void check_10_2input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate();
        or_gate.setInputs(new boolean[] {true, false});
        assertTrue(or_gate.getOutput());
    }

    //    after constructing a 2 input OR gate, set INPUT[false, false]. output must be false
    @Test
    public void check_00_2input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate();
        or_gate.setInputs(new boolean[] {false, false});
        assertFalse(or_gate.getOutput());
    }

    //    after constructing a 2 input OR gate, set INPUT[false, false, true], but gate only supports 2 inputs.
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput_2input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate();
        or_gate.setInputs(new boolean[] {false, false, true});
    }

    //    after constructing a 4 input OR gate, set INPUT[false, false, true], but gate supports precisely 4 inputs.
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput_4input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate(4);
        or_gate.setInputs(new boolean[] {false, false, true});
    }

    //    after constructing a 7 input OR gate, set INPUT[false x7]. output must be false
    @Test
    public void check_0000000_7input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate(7);
        or_gate.setInputs(new boolean[] {false, false, false, false, false, false, false});
        assertFalse(or_gate.getOutput());
    }

    //    after constructing a 7 input OR gate, set INPUT[false x 6, true]. output must be true
    @Test
    public void check_0000001_7input_OR_gate() throws Exception {
        OR_Gate or_gate = new OR_Gate(7);
        or_gate.setInputs(new boolean[] {false, false, false, false, false, false, true});
        assertTrue(or_gate.getOutput());
    }

}