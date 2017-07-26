package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class MUX_8Way_GateTest {
    @Test(expected = IllegalArgumentException.class)
    public void invalid_Negative_Data_Width() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(-3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Data_Width() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(4);
        boolean[][] inputs = new boolean[8][mux8WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false};
        boolean[] input_d = new boolean[] {false, false, false, false};
        boolean[] input_e = new boolean[] {false, false, false, false};
        boolean[] input_f = new boolean[] {false, false, false, false};
        boolean[] input_g = new boolean[] {false, false, false, false};
        boolean[] input_h = new boolean[] {false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        inputs[4] = input_e;
        inputs[5] = input_f;
        inputs[6] = input_g;
        inputs[7] = input_h;
        boolean[] select = new boolean[] {false, false, false};
        mux8WayGate.setGate(inputs, select);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Num_Inputs() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(4);
        boolean[][] inputs = new boolean[3][mux8WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        boolean[] select = new boolean[] {false, false, false};
        mux8WayGate.setGate(inputs, select);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Select() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(4);
        boolean[][] inputs = new boolean[8][mux8WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false};
        boolean[] input_d = new boolean[] {false, false, false, false};
        boolean[] input_e = new boolean[] {false, false, false, false};
        boolean[] input_f = new boolean[] {false, false, false, false};
        boolean[] input_g = new boolean[] {false, false, false, false};
        boolean[] input_h = new boolean[] {false, false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        inputs[4] = input_e;
        inputs[5] = input_f;
        inputs[6] = input_g;
        inputs[7] = input_h;
        boolean[] select = new boolean[] {false, false};
        mux8WayGate.setGate(inputs, select);
    }

    @Test
    public void test_1_To_8_Nand2Tetris() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(16);
        boolean[][] inputs = new boolean[8][mux8WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_d = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_e = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_f = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_g = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_h = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        inputs[4] = input_e;
        inputs[5] = input_f;
        inputs[6] = input_g;
        inputs[7] = input_h;
        boolean[] select = new boolean[] {false, false, false};
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_a);
        select[0] = false;
        select[1] = false;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_b);
        select[0] = false;
        select[1] = true;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_c);
        select[0] = false;
        select[1] = true;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_d);
        select[0] = true;
        select[1] = false;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_e);
        select[0] = true;
        select[1] = false;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_f);
        select[0] = true;
        select[1] = true;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_g);
        select[0] = true;
        select[1] = true;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_h);
    }

    @Test
    public void test_9_To_16_Nand2Tetris() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(16);
        boolean[][] inputs = new boolean[8][mux8WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {true, false, false, true, false, false, true, false, false, true, false, true, true, false, false, true};
        boolean[] input_b = new boolean[] {false, true, true, false, false, false, true, true, true, false, true, false, true, true, false, false};
        boolean[] input_c = new boolean[] {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
        boolean[] input_d = new boolean[] {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
        boolean[] input_e = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, true, true, true, false, true};
        boolean[] input_f = new boolean[] {false, false, true, true, false, false, true, false, false, true, false, true, false, false, true, false};
        boolean[] input_g = new boolean[] {true, false, false, false, false, false, false, false, false, true, false, false, false, false, true, true};
        boolean[] input_h = new boolean[] {true, false, true, false, false, false, true, false, true, false, false, true, true, true, true, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        inputs[4] = input_e;
        inputs[5] = input_f;
        inputs[6] = input_g;
        inputs[7] = input_h;
        boolean[] select = new boolean[] {false, false, false};
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_a);
        select[0] = false;
        select[1] = false;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_b);
        select[0] = false;
        select[1] = true;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_c);
        select[0] = false;
        select[1] = true;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_d);
        select[0] = true;
        select[1] = false;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_e);
        select[0] = true;
        select[1] = false;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_f);
        select[0] = true;
        select[1] = true;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_g);
        select[0] = true;
        select[1] = true;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_h);
    }

    @Test
    public void test_DataWidth_1_Nand2Tetris() throws Exception {
        MUX_8Way_Gate mux8WayGate = new MUX_8Way_Gate(1);
        boolean[][] inputs = new boolean[8][mux8WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {true};
        boolean[] input_b = new boolean[] {false};
        boolean[] input_c = new boolean[] {true};
        boolean[] input_d = new boolean[] {false};
        boolean[] input_e = new boolean[] {false};
        boolean[] input_f = new boolean[] {false};
        boolean[] input_g = new boolean[] {true};
        boolean[] input_h = new boolean[] {true};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        inputs[4] = input_e;
        inputs[5] = input_f;
        inputs[6] = input_g;
        inputs[7] = input_h;
        boolean[] select = new boolean[] {false, false, false};
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_a);
        select[0] = false;
        select[1] = false;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_b);
        select[0] = false;
        select[1] = true;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_c);
        select[0] = false;
        select[1] = true;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_d);
        select[0] = true;
        select[1] = false;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_e);
        select[0] = true;
        select[1] = false;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_f);
        select[0] = true;
        select[1] = true;
        select[2] = false;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_g);
        select[0] = true;
        select[1] = true;
        select[2] = true;
        mux8WayGate.setGate(inputs, select);
        assertArrayEquals(mux8WayGate.getOutput(), input_h);
    }
}