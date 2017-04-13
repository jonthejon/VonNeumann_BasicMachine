package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.logic_gates.NOR_Gate;
import org.junit.Test;

import static org.junit.Assert.*;

public class NOR_GateTest {

    //    after constructing a 2 input NOR gate, set INPUT[true, false]. output must be false
    @Test
    public void check_10_2input_NOR_gate() throws Exception {
        NOR_Gate nor_gate = new NOR_Gate();
        nor_gate.setInputs(new boolean[] {true, false});
        assertFalse(nor_gate.getOutput());
    }

    //    after constructing a 2 input NOR gate, set INPUT[false, false]. output must be true
    @Test
    public void check_00_2input_NOR_gate() throws Exception {
        NOR_Gate nor_gate = new NOR_Gate();
        nor_gate.setInputs(new boolean[] {false, false});
        assertTrue(nor_gate.getOutput());
    }

    //    after constructing a 4 input NOR gate, set INPUT[false, false, true], but gate supports precisely 4 inputs.
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput_4input_NOR_gate() throws Exception {
        NOR_Gate nor_gate = new NOR_Gate(4);
        nor_gate.setInputs(new boolean[] {false, false, true});
    }

    //    after constructing a 7 input NOR gate, set INPUT[false x7]. output must be true
    @Test
    public void check_0000000_7input_NOR_gate() throws Exception {
        NOR_Gate nor_gate = new NOR_Gate(7);
        nor_gate.setInputs(new boolean[] {false, false, false, false, false, false, false});
        assertTrue(nor_gate.getOutput());
    }

    //    after constructing a 7 input NOR gate, set INPUT[false x 6, true]. output must be false
    @Test
    public void check_0000001_7input_NOR_gate() throws Exception {
        NOR_Gate nor_gate = new NOR_Gate(7);
        nor_gate.setInputs(new boolean[] {false, false, false, false, false, false, true});
        assertFalse(nor_gate.getOutput());
    }

}