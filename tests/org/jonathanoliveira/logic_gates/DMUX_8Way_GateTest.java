package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class DMUX_8Way_GateTest {

    @Test
    public void create_DMUX_8Way_Gate() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        int numChannels = dmux8WayGate.getNumChannels();
        assertTrue(numChannels == 8);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Sel_Size() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false};
        dmux8WayGate.setGate(input, select);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_a == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_b == input);
        assertTrue(!channel_a);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_c == input);
        assertTrue(!channel_b);
        assertTrue(!channel_a);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_d == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_a);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_5_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{true, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_e == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_a);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_6_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{true, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_f == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_a);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_7_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{true, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_g == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_a);
        assertTrue(!channel_h);
    }

    @Test
    public void test_8_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{true, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_h == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_a);
    }

    @Test
    public void test_9_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{false, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_a == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_10_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{false, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_b == input);
        assertTrue(!channel_a);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_11_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{false, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_c == input);
        assertTrue(!channel_b);
        assertTrue(!channel_a);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_12_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{false, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_d == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_a);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_13_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{true, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_e == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_a);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_14_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{true, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_f == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_a);
        assertTrue(!channel_g);
        assertTrue(!channel_h);
    }

    @Test
    public void test_15_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{true, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_g == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_a);
        assertTrue(!channel_h);
    }

    @Test
    public void test_16_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{true, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        boolean channel_e = result[4];
        boolean channel_f = result[5];
        boolean channel_g = result[6];
        boolean channel_h = result[7];
        assertTrue(channel_h == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_a);
    }
}