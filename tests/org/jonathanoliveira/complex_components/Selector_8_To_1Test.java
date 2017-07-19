package org.jonathanoliveira.complex_components;

import org.junit.Test;

import static org.junit.Assert.*;


public class Selector_8_To_1Test {
    @Test
    public void create_Valid_Selector() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        int num_channels = selector8To1.getNumChannels();
        assertTrue(num_channels == 8);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Selection_Size() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{false, false, false, false};
        selector8To1.setComponent(select);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{false, false, false};
        boolean[] expected = new boolean[]{true, false, false, false, false, false, false, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{false, false, true};
        boolean[] expected = new boolean[]{false, true, false, false, false, false, false, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{false, true, false};
        boolean[] expected = new boolean[]{false, false, true, false, false, false, false, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{false, true, true};
        boolean[] expected = new boolean[]{false, false, false, true, false, false, false, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_5_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{true, false, false};
        boolean[] expected = new boolean[]{false, false, false, false, true, false, false, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_6_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{true, false, true};
        boolean[] expected = new boolean[]{false, false, false, false, false, true, false, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_7_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{true, true, false};
        boolean[] expected = new boolean[]{false, false, false, false, false, false, true, false};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_8_Nand2Tetris() throws Exception {
        Selector_8_To_1 selector8To1 = new Selector_8_To_1();
        boolean[] select = new boolean[]{true, true, true};
        boolean[] expected = new boolean[]{false, false, false, false, false, false, false, true};
        selector8To1.setComponent(select);
        boolean[] result = selector8To1.getOutput();
        assertArrayEquals(expected, result);
    }
}