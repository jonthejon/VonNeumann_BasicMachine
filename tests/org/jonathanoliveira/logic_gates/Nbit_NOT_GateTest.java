package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class Nbit_NOT_GateTest {

    @Test
    public void create_16bit_NOT_Gate() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(16);
        int size = nbit_not_gate.getNumInputs();
        assertTrue(size == 16);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_Negbit_NOT_Gate() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(-3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_1bit_NOT_Gate() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void check_invalid_input_size() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(8);
        boolean[] inputs = new boolean[] {false, false, false, false, false};
        nbit_not_gate.setInputs(inputs);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(16);
        boolean[] inputs = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        nbit_not_gate.setInputs(inputs);
        boolean[] expected = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        assertArrayEquals(nbit_not_gate.getOutput(), expected);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(16);
        boolean[] inputs = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        nbit_not_gate.setInputs(inputs);
        boolean[] expected = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        assertArrayEquals(nbit_not_gate.getOutput(), expected);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(16);
        boolean[] inputs = new boolean[] {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
        nbit_not_gate.setInputs(inputs);
        boolean[] expected = new boolean[] {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
        assertArrayEquals(nbit_not_gate.getOutput(), expected);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(16);
        boolean[] inputs = new boolean[] {false, false, true, true, true, true, false, false, true, true, false, false, false, false, true, true};
        nbit_not_gate.setInputs(inputs);
        boolean[] expected = new boolean[] {true, true, false, false, false, false, true, true, false, false, true, true, true, true, false, false};
        assertArrayEquals(nbit_not_gate.getOutput(), expected);
    }

    @Test
    public void test_5_Nand2Tetris() throws Exception {
        Nbit_NOT_Gate nbit_not_gate = new Nbit_NOT_Gate(16);
        boolean[] inputs = new boolean[] {false, false, false, true, false, false, true, false, false, false, true, true, false, true, false, false};
        nbit_not_gate.setInputs(inputs);
        boolean[] expected = new boolean[] {true, true, true, false, true, true, false, true, true, true, false, false, true, false, true, true};
        assertArrayEquals(nbit_not_gate.getOutput(), expected);
    }
}