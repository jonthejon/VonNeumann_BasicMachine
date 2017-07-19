package org.jonathanoliveira.logic_gates;

import org.junit.Test;

import static org.junit.Assert.*;

public class DMUX_GateTest {

    @Test
    public void create_DMUX_Gate() throws Exception {
        DMUX_Gate dmuxGate = new DMUX_Gate();
        int numChannels = dmuxGate.getNumChannels();
        assertTrue(numChannels == 2);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        DMUX_Gate dmuxGate = new DMUX_Gate();
        boolean input = false;
        dmuxGate.setGate(input, false);
        assertTrue(dmuxGate.getOutput()[0] == input);
        assertTrue(!dmuxGate.getOutput()[1]);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        DMUX_Gate dmuxGate = new DMUX_Gate();
        boolean input = false;
        dmuxGate.setGate(input, true);
        assertTrue(dmuxGate.getOutput()[1] == input);
        assertTrue(!dmuxGate.getOutput()[0]);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        DMUX_Gate dmuxGate = new DMUX_Gate();
        boolean input = true;
        dmuxGate.setGate(input, false);
        assertTrue(dmuxGate.getOutput()[0] == input);
        assertTrue(!dmuxGate.getOutput()[1]);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        DMUX_Gate dmuxGate = new DMUX_Gate();
        boolean input = true;
        dmuxGate.setGate(input, true);
        assertTrue(dmuxGate.getOutput()[1] == input);
        assertTrue(!dmuxGate.getOutput()[0]);
    }
}