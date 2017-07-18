package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class MUX_GateTest {

    @Test
    public void create_16bit_MUX_Gate() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        int channelWidth = muxGate.getNumInputs();
        assertTrue(channelWidth == 16);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_Invalid_MUX_Gate() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(-5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Inputs_MUX_Gate() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(8);
        boolean[] inputsA = new boolean[] {false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false};
        muxGate.setGate(inputsA, inputsB, false);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {false}, new boolean[] {false}, false);
        assertTrue(!muxGate.getOutput()[0]);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {false}, new boolean[] {false}, true);
        assertTrue(!muxGate.getOutput()[0]);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {false}, new boolean[] {true}, false);
        assertTrue(!muxGate.getOutput()[0]);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {false}, new boolean[] {true}, true);
        assertTrue(muxGate.getOutput()[0]);
    }

    @Test
    public void test_5_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {true}, new boolean[] {false}, false);
        assertTrue(muxGate.getOutput()[0]);
    }

    @Test
    public void test_6_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {true}, new boolean[] {false}, true);
        assertTrue(!muxGate.getOutput()[0]);
    }

    @Test
    public void test_7_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {true}, new boolean[] {true}, false);
        assertTrue(muxGate.getOutput()[0]);
    }

    @Test
    public void test_8_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(1);
        muxGate.setGate(new boolean[] {true}, new boolean[] {true}, true);
        assertTrue(muxGate.getOutput()[0]);
    }


    @Test
    public void test_Multi_1_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        muxGate.setGate(inputsA, inputsB, false);
        assertArrayEquals(muxGate.getOutput(), inputsA);
    }

    @Test
    public void test_Multi_2_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        muxGate.setGate(inputsA, inputsB, true);
        assertArrayEquals(muxGate.getOutput(), inputsB);
    }

    @Test
    public void test_Multi_3_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, true, false, false, true, false, false, false, true, true, false, true, false, false};
        muxGate.setGate(inputsA, inputsB, false);
        assertArrayEquals(muxGate.getOutput(), inputsA);
    }

    @Test
    public void test_Multi_4_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] inputsB = new boolean[] {false, false, false, true, false, false, true, false, false, false, true, true, false, true, false, false};
        muxGate.setGate(inputsA, inputsB, true);
        assertArrayEquals(muxGate.getOutput(), inputsB);
    }

    @Test
    public void test_Multi_5_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {true, false, false, true, true, false, false, false, false, true, true, true, false, true, true, false};
        boolean[] inputsB = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        muxGate.setGate(inputsA, inputsB, false);
        assertArrayEquals(muxGate.getOutput(), inputsA);
    }

    @Test
    public void test_Multi_6_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {true, false, false, true, true, false, false, false, false, true, true, true, false, true, true, false};
        boolean[] inputsB = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        muxGate.setGate(inputsA, inputsB, true);
        assertArrayEquals(muxGate.getOutput(), inputsB);
    }

    @Test
    public void test_Multi_7_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
        boolean[] inputsB = new boolean[] {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
        muxGate.setGate(inputsA, inputsB, false);
        assertArrayEquals(muxGate.getOutput(), inputsA);
    }

    @Test
    public void test_Multi_8_Nand2Tetris() throws Exception {
        MUX_Gate muxGate = new MUX_Gate(16);
        boolean[] inputsA = new boolean[] {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
        boolean[] inputsB = new boolean[] {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
        muxGate.setGate(inputsA, inputsB, true);
        assertArrayEquals(muxGate.getOutput(), inputsB);
    }
}