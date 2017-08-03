package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Counter16BitTest {

    @Test (expected = IllegalArgumentException.class)
    public void checkInvalidFunction() throws Exception {
        Counter_Nbit counter = new Counter_Nbit(3);
        boolean[] func = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] input = Converter.convertToBooleans(new int[]{0,1,0});
        counter.setCounter(input, func);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkInvalidInput() throws Exception {
        Counter_Nbit counter = new Counter_Nbit(3);
        boolean[] func = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] input = Converter.convertToBooleans(new int[]{0,1});
        counter.setCounter(input, func);
    }

    @Test
    public void checkIncrement() throws Exception {
        Counter_Nbit counter = new Counter_Nbit(3);
        boolean[] func = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] input = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] exp1 = Converter.convertToBooleans(new int[]{0,0,1});
        boolean[] exp2 = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] exp3 = Converter.convertToBooleans(new int[]{0,1,1});
        boolean[] exp4 = Converter.convertToBooleans(new int[]{1,0,0});
        boolean[] exp5 = Converter.convertToBooleans(new int[]{1,0,1});
        boolean[] exp6 = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] exp7 = Converter.convertToBooleans(new int[]{1,1,1});
        boolean[] exp8 = Converter.convertToBooleans(new int[]{0,0,0});
        assertArrayEquals(exp8, counter.getOutput());
        counter.setCounter(input, func);
        assertArrayEquals(exp1, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp2, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp3, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp4, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp5, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp6, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp7, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp8, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp1, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp2, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp3, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,0,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp3, counter.getOutput());
        assertArrayEquals(exp3, counter.getOutput());
        assertArrayEquals(exp3, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,1,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp4, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp5, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp6, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp7, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp8, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp1, counter.getOutput());
    }

    @Test
    public void checkLoad() throws Exception {
        Counter_Nbit counter = new Counter_Nbit(3);
        boolean[] func = Converter.convertToBooleans(new int[]{1,0,0});
        boolean[] input = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] exp1 = Converter.convertToBooleans(new int[]{0,0,1});
        boolean[] exp2 = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] exp3 = Converter.convertToBooleans(new int[]{0,1,1});
        boolean[] exp4 = Converter.convertToBooleans(new int[]{1,0,0});
        boolean[] exp5 = Converter.convertToBooleans(new int[]{1,0,1});
        boolean[] exp6 = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] exp7 = Converter.convertToBooleans(new int[]{1,1,1});
        boolean[] exp8 = Converter.convertToBooleans(new int[]{0,0,0});
        assertArrayEquals(exp8, counter.getOutput());
        counter.setCounter(input, func);
        assertArrayEquals(exp6, counter.getOutput());
        assertArrayEquals(exp6, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,0,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp6, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,1,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp7, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp8, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp1, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,0,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp1, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{1,0,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp6, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,0,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp6, counter.getOutput());
        func = Converter.convertToBooleans(new int[]{0,1,0});
        counter.setCounter(input, func);
        assertArrayEquals(exp7, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp8, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp1, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp2, counter.getOutput());
        counter.setFunction(func);
        assertArrayEquals(exp3, counter.getOutput());
    }

    @Test
    public void checkReset() throws Exception {
        Counter_Nbit counter = new Counter_Nbit(3);
        boolean[] load = Converter.convertToBooleans(new int[]{1,0,0});
        boolean[] inc = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] reset = Converter.convertToBooleans(new int[]{0,0,1});
        boolean[] stall = Converter.convertToBooleans(new int[]{0,0,0});
        boolean[] input = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] exp1 = Converter.convertToBooleans(new int[]{0,0,1});
        boolean[] exp2 = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] exp3 = Converter.convertToBooleans(new int[]{0,1,1});
        boolean[] exp4 = Converter.convertToBooleans(new int[]{1,0,0});
        boolean[] exp5 = Converter.convertToBooleans(new int[]{1,0,1});
        boolean[] exp6 = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] exp7 = Converter.convertToBooleans(new int[]{1,1,1});
        boolean[] exp8 = Converter.convertToBooleans(new int[]{0,0,0});
        assertArrayEquals(exp8, counter.getOutput());
        counter.setCounter(input, load);
        assertArrayEquals(exp6, counter.getOutput());
        assertArrayEquals(exp6, counter.getOutput());
        counter.setCounter(input, reset);
        assertArrayEquals(exp8, counter.getOutput());
        counter.setCounter(input, inc);
        assertArrayEquals(exp1, counter.getOutput());
        counter.setFunction(inc);
        assertArrayEquals(exp2, counter.getOutput());
        counter.setFunction(inc);
        assertArrayEquals(exp3, counter.getOutput());
        counter.setCounter(input, stall);
        assertArrayEquals(exp3, counter.getOutput());
        counter.setCounter(input, load);
        assertArrayEquals(exp6, counter.getOutput());
        counter.setCounter(input, inc);
        assertArrayEquals(exp7, counter.getOutput());
        counter.setCounter(input, reset);
        assertArrayEquals(exp8, counter.getOutput());
        counter.setCounter(input, inc);
        assertArrayEquals(exp1, counter.getOutput());
        counter.setFunction(inc);
        assertArrayEquals(exp2, counter.getOutput());
        counter.setCounter(input, stall);
        assertArrayEquals(exp2, counter.getOutput());
    }
}