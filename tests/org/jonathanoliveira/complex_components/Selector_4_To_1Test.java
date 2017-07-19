package org.jonathanoliveira.complex_components;

import org.junit.Test;

import static org.junit.Assert.*;

public class Selector_4_To_1Test {

    @Test
    public void create_Valid_Selector() throws Exception {
        Selector_4_To_1 selector4To1 = new Selector_4_To_1();
        int num_channels = selector4To1.getNumChannels();
        assertTrue(num_channels == 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_Selection_Size() throws Exception {
        Selector_4_To_1 selector4To1 = new Selector_4_To_1();
        boolean[] select = new boolean[]{false};
        selector4To1.setComponent(select);
    }

    @Test
    public void test_1_Nand2Tetris() throws Exception {
        Selector_4_To_1 selector4To1 = new Selector_4_To_1();
        boolean[] select = new boolean[]{false, false};
        boolean[] expected = new boolean[]{true, false, false, false};
        selector4To1.setComponent(select);
        boolean[] result = selector4To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_2_Nand2Tetris() throws Exception {
        Selector_4_To_1 selector4To1 = new Selector_4_To_1();
        boolean[] select = new boolean[]{false, true};
        boolean[] expected = new boolean[]{false, true, false, false};
        selector4To1.setComponent(select);
        boolean[] result = selector4To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_3_Nand2Tetris() throws Exception {
        Selector_4_To_1 selector4To1 = new Selector_4_To_1();
        boolean[] select = new boolean[]{true, false};
        boolean[] expected = new boolean[]{false, false, true, false};
        selector4To1.setComponent(select);
        boolean[] result = selector4To1.getOutput();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_4_Nand2Tetris() throws Exception {
        Selector_4_To_1 selector4To1 = new Selector_4_To_1();
        boolean[] select = new boolean[]{true, true};
        boolean[] expected = new boolean[]{false, false, false, true};
        selector4To1.setComponent(select);
        boolean[] result = selector4To1.getOutput();
        assertArrayEquals(expected, result);
    }
}