package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class DMUX_8Way_GateTest {

    @Test
    public void create_DMUX_8Way_Gate() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
        int numChannels = dmux8WayGate.getNumChannels();
        assertTrue(numChannels == 8);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Sel_Size() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{false};
        dmux8WayGate.setGate(input, select);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{false, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_a == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{false, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_b == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{false, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_c == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{false, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_d == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{true, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_e == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{true, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_f == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{true, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_g == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = false;
        boolean[] input = new boolean[]{false};
        boolean[] select = new boolean[]{true, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_h == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{false, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_a == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{false, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_b == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{false, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_c == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{false, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_d == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{true, false, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_e == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{true, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_f == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{true, true, false};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_g == input[0]);
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
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(1);
//        boolean input = true;
        boolean[] input = new boolean[]{true};
        boolean[] select = new boolean[]{true, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean channel_a = result[0][0];
        boolean channel_b = result[1][0];
        boolean channel_c = result[2][0];
        boolean channel_d = result[3][0];
        boolean channel_e = result[4][0];
        boolean channel_f = result[5][0];
        boolean channel_g = result[6][0];
        boolean channel_h = result[7][0];
        assertTrue(channel_h == input[0]);
        assertTrue(!channel_b);
        assertTrue(!channel_c);
        assertTrue(!channel_d);
        assertTrue(!channel_e);
        assertTrue(!channel_f);
        assertTrue(!channel_g);
        assertTrue(!channel_a);
    }

    @Test
    public void test_4_DataWidth() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(4);
//        boolean input = true;
        boolean[] input = new boolean[]{true, true, true, true};
        boolean[] others = new boolean[]{false, false, false, false};
        boolean[] select = new boolean[]{true, true, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean[] channel_a = result[0];
        boolean[] channel_b = result[1];
        boolean[] channel_c = result[2];
        boolean[] channel_d = result[3];
        boolean[] channel_e = result[4];
        boolean[] channel_f = result[5];
        boolean[] channel_g = result[6];
        boolean[] channel_h = result[7];
        assertArrayEquals(input, channel_h);
        assertArrayEquals(others,channel_b);
        assertArrayEquals(others,channel_c);
        assertArrayEquals(others,channel_d);
        assertArrayEquals(others,channel_e);
        assertArrayEquals(others,channel_f);
        assertArrayEquals(others,channel_g);
        assertArrayEquals(others,channel_a);
    }

    @Test
    public void test_16_DataWidth1() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(16);
        boolean[] input = Converter.convertToBooleans(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0});
        boolean[] others = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] select = new boolean[]{false, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean[] channel_a = result[0];
        boolean[] channel_b = result[1];
        boolean[] channel_c = result[2];
        boolean[] channel_d = result[3];
        boolean[] channel_e = result[4];
        boolean[] channel_f = result[5];
        boolean[] channel_g = result[6];
        boolean[] channel_h = result[7];
        assertArrayEquals(others, channel_h);
        assertArrayEquals(input,channel_b);
        assertArrayEquals(others,channel_c);
        assertArrayEquals(others,channel_d);
        assertArrayEquals(others,channel_e);
        assertArrayEquals(others,channel_f);
        assertArrayEquals(others,channel_g);
        assertArrayEquals(others,channel_a);
    }

    @Test
    public void test_16_DataWidth2() throws Exception {
        DMUX_8Way_Gate dmux8WayGate = new DMUX_8Way_Gate(16);
        boolean[] input = Converter.convertToBooleans(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0});
        boolean[] others = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] select = new boolean[]{true, false, true};
        dmux8WayGate.setGate(input, select);
        boolean[][] result = dmux8WayGate.getOutput();
        boolean[] channel_a = result[0];
        boolean[] channel_b = result[1];
        boolean[] channel_c = result[2];
        boolean[] channel_d = result[3];
        boolean[] channel_e = result[4];
        boolean[] channel_f = result[5];
        boolean[] channel_g = result[6];
        boolean[] channel_h = result[7];
        assertArrayEquals(others, channel_h);
        assertArrayEquals(others,channel_b);
        assertArrayEquals(others,channel_c);
        assertArrayEquals(others,channel_d);
        assertArrayEquals(others,channel_e);
        assertArrayEquals(input,channel_f);
        assertArrayEquals(others,channel_g);
        assertArrayEquals(others,channel_a);
    }
}