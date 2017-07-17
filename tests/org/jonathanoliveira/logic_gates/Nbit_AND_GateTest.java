package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class Nbit_AND_GateTest {

    @Test
    public void create_8bit_AND_Gate() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(8);
        int numInputs = nbitAndGate.getNumInputs();
        assertTrue(numInputs == 8);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_Nbit_AND_Gate() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(-3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_Dif_Size_Inputs() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(6);
        boolean[] inputsA = new boolean[] {false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, false};
        nbitAndGate.setInputs(inputsA, inputsB);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_Dif_Size_Inputs_To_Gate() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, false, false, false, false, false};
        nbitAndGate.setInputs(inputsA, inputsB);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        nbitAndGate.setInputs(inputsA, inputsB);
        boolean[] expected = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        assertArrayEquals(nbitAndGate.getOutput(), expected);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        nbitAndGate.setInputs(inputsA, inputsB);
        boolean[] expected = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        assertArrayEquals(nbitAndGate.getOutput(), expected);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        boolean[] inputsB = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        nbitAndGate.setInputs(inputsA, inputsB);
        boolean[] expected = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        assertArrayEquals(nbitAndGate.getOutput(), expected);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
        boolean[] inputsB = new boolean[] {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
        nbitAndGate.setInputs(inputsA, inputsB);
        boolean[] expected = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        assertArrayEquals(nbitAndGate.getOutput(), expected);
    }

    @Test
    public void test_5_Nand2Tetris() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, true, true, true, true, false, false, true, true, false, false, false, false, true, true};
        boolean[] inputsB = new boolean[] {false, false, false, false, true, true, true, true, true, true, true, true, false, false, false, false};
        nbitAndGate.setInputs(inputsA, inputsB);
        boolean[] expected = new boolean[] {false, false, false, false, true, true, false, false, true, true, false, false, false, false, false, false};
        assertArrayEquals(nbitAndGate.getOutput(), expected);
    }

    @Test
    public void test_6_Nand2Tetris() throws Exception {
        Nbit_AND_Gate nbitAndGate = new Nbit_AND_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, true, false, false, true, false, false, false, true, true, false, true, false, false};
        boolean[] inputsB = new boolean[] {true, false, false, true, true, false, false, false, false, true, true, true, false, true, true, false};
        nbitAndGate.setInputs(inputsA, inputsB);
        boolean[] expected = new boolean[] {false, false, false, true, false, false, false, false, false, false, true, true, false, true, false, false};
        assertArrayEquals(nbitAndGate.getOutput(), expected);
    }
}