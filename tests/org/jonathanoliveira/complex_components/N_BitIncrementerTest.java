package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class N_BitIncrementerTest {
    // test to see if the constructor properly works
    @Test
    public void create_n_bitInc() throws Exception {
        N_BitIncrementer incrementer = new N_BitIncrementer(8);
        int size = incrementer.getBitSize();
        assertEquals(8,size);
    }

    // error will occur if trying to create a N-bit adder with an illegal size
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidCreation() throws Exception {
        N_BitIncrementer incrementer = new N_BitIncrementer(-3);
    }

    // error will occur if trying to input a number with a different bit size
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput() throws Exception {
        N_BitIncrementer incrementer = new N_BitIncrementer(4);
        incrementer.setInput(new boolean[]{true,true,true});
    }

    // test the sum of decimals numbers after conversion into binary and back
    @Test
    public void check_inc_20() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert_unsigned(20));
        N_BitIncrementer incrementer = new N_BitIncrementer(5);
        incrementer.setInput(inA);
        int dec_result = converter.convert_unsigned(converter.convertFromBooleans(incrementer.getOutput()));
        assertEquals(21, dec_result);
    }

    // test the sum of decimals numbers after conversion into binary and back
    @Test
    public void check_inc_0() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert_unsigned(0, 5));
        N_BitIncrementer incrementer = new N_BitIncrementer(5);
        incrementer.setInput(inA);
        int dec_result = converter.convert_unsigned(converter.convertFromBooleans(incrementer.getOutput()));
        assertEquals(1, dec_result);
    }

    // test the sum of decimals numbers after conversion into binary and back
    @Test
    public void check_inc_overload() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert_unsigned(7,3));
        N_BitIncrementer incrementer = new N_BitIncrementer(3);
        incrementer.setInput(inA);
        int dec_result = converter.convert_unsigned(converter.convertFromBooleans(incrementer.getOutput()));
        assertEquals(0, dec_result);
    }

}