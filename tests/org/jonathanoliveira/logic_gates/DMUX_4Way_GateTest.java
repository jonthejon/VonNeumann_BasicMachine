package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class DMUX_4Way_GateTest {
/*
    @Test
    public void create_DMUX_4Way_Gate() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        int numChannels = dmux4WayGate.getNumChannels();
        assertTrue(numChannels == 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Sel_Size() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false};
        dmux4WayGate.setGate(input, select);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false, false};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_a == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{false, true};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_b == input);
        assertTrue(!channel_a);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{true, false};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_c == input);
        assertTrue(!channel_b);
        assertTrue(!channel_a);
        assertTrue(!channel_d);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = false;
        boolean[] select = new boolean[]{true, true};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_d == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_a);
    }

    @Test
    public void test_5_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{false, false};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_a == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
    }

    @Test
    public void test_6_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{false, true};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_b == input);
        assertTrue(!channel_a);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
    }

    @Test
    public void test_7_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{true, false};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_c == input);
        assertTrue(!channel_b);
        assertTrue(!channel_a);
        assertTrue(!channel_d);
    }

    @Test
    public void test_8_Nand2Tetris() throws Exception {
        DMUX_4Way_Gate dmux4WayGate = new DMUX_4Way_Gate();
        boolean input = true;
        boolean[] select = new boolean[]{true, true};
        dmux4WayGate.setGate(input, select);
        boolean[] result = dmux4WayGate.getOutput();
        boolean channel_a = result[0];
        boolean channel_b = result[1];
        boolean channel_c = result[2];
        boolean channel_d = result[3];
        assertTrue(channel_d == input);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_a);
    }*/
}