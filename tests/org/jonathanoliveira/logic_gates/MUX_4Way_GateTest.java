package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class MUX_4Way_GateTest {

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Negative_Data_Width() throws Exception {
        MUX_4Way_Gate mux4WayGate = new MUX_4Way_Gate(-3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Data_Width() throws Exception {
        MUX_4Way_Gate mux4WayGate = new MUX_4Way_Gate(4);
        boolean[][] inputs = new boolean[4][mux4WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false};
        boolean[] input_d = new boolean[] {false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        boolean[] select = new boolean[] {false, false};
        mux4WayGate.setGate(inputs, select);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Num_Inputs() throws Exception {
        MUX_4Way_Gate mux4WayGate = new MUX_4Way_Gate(4);
        boolean[][] inputs = new boolean[3][mux4WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        boolean[] select = new boolean[] {false, false};
        mux4WayGate.setGate(inputs, select);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Select() throws Exception {
        MUX_4Way_Gate mux4WayGate = new MUX_4Way_Gate(4);
        boolean[][] inputs = new boolean[4][mux4WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false};
        boolean[] input_d = new boolean[] {false, false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        boolean[] select = new boolean[] {false};
        mux4WayGate.setGate(inputs, select);
    }

    @Test
    public void test_1_To_4_Nand2Tetris() throws Exception {
        MUX_4Way_Gate mux4WayGate = new MUX_4Way_Gate(16);
        boolean[][] inputs = new boolean[4][mux4WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_b = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_c = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] input_d = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        boolean[] select = new boolean[] {false, false};
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(mux4WayGate.getOutput(), input_a);
        select[0] = false;
        select[1] = true;
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(mux4WayGate.getOutput(), input_b);
        select[0] = true;
        select[1] = false;
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(mux4WayGate.getOutput(), input_c);
        select[0] = true;
        select[1] = true;
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(mux4WayGate.getOutput(), input_d);
    }

    @Test
    public void test_5_To_8_Nand2Tetris() throws Exception {
        MUX_4Way_Gate mux4WayGate = new MUX_4Way_Gate(16);
        boolean[][] inputs = new boolean[4][mux4WayGate.getDataWidth()];
        boolean[] input_a = new boolean[] {true, false, false, true, false, false, true, false, false, true, false, true, true, false, false, true};
        boolean[] input_b = new boolean[] {false, true, true, false, false, false, true, true, true, false, true, false, true, true, false, false};
        boolean[] input_c = new boolean[] {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
        boolean[] input_d = new boolean[] {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
        inputs[0] = input_a;
        inputs[1] = input_b;
        inputs[2] = input_c;
        inputs[3] = input_d;
        boolean[] select = new boolean[] {false, false};
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(input_a, mux4WayGate.getOutput());
        select[0] = false;
        select[1] = true;
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(input_b, mux4WayGate.getOutput());
        select[0] = true;
        select[1] = false;
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(input_c, mux4WayGate.getOutput());
        select[0] = true;
        select[1] = true;
        mux4WayGate.setGate(inputs, select);
        assertArrayEquals(input_d, mux4WayGate.getOutput());
    }
}