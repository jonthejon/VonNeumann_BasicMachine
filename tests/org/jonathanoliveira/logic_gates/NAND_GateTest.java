package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.logic_gates.NAND_Gate;
import org.junit.Test;

import static org.junit.Assert.*;

public class NAND_GateTest {

    //    after constructing a 2 input NAND gate, set INPUT[true, false]. output must be true
    @Test
    public void check_10_2input_NAND_gate() throws Exception {
        NAND_Gate nand_gate = new NAND_Gate();
        nand_gate.setInputs(new boolean[] {true, false});
        assertTrue(nand_gate.getOutput());
    }

    //    after constructing a 2 input NAND gate, set INPUT[false, false]. output must be true
    @Test
    public void check_00_2input_NAND_gate() throws Exception {
        NAND_Gate nand_gate = new NAND_Gate();
        nand_gate.setInputs(new boolean[] {false, false});
        assertTrue(nand_gate.getOutput());
    }

    //    after constructing a 2 input NAND gate, set INPUT[true, true]. output must be false
    @Test
    public void check_11_2input_NAND_gate() throws Exception {
        NAND_Gate nand_gate = new NAND_Gate();
        nand_gate.setInputs(new boolean[] {true, true});
        assertFalse(nand_gate.getOutput());
    }

    //    after constructing a 4 input NAND gate, set INPUT[false, false, true], but gate supports precisely 4 inputs.
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput_4input_NAND_gate() throws Exception {
        NAND_Gate nand_gate = new NAND_Gate(4);
        nand_gate.setInputs(new boolean[] {false, false, true});
    }

    //    after constructing a 7 input NAND gate, set INPUT[true x7]. output must be false
    @Test
    public void check_1111111_7input_NAND_gate() throws Exception {
        NAND_Gate nand_gate = new NAND_Gate(7);
        nand_gate.setInputs(new boolean[] {true, true, true, true, true, true, true});
        assertFalse(nand_gate.getOutput());
    }

    //    after constructing a 7 input NAND gate, set INPUT[true x 6, false]. output must be true
    @Test
    public void check_1111110_7input_NAND_gate() throws Exception {
        NAND_Gate nand_gate = new NAND_Gate(7);
        nand_gate.setInputs(new boolean[] {true, true, true, true, true, true, false});
        assertTrue(nand_gate.getOutput());
    }

}