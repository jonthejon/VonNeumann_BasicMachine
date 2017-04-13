package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class N_BitAdderTest {

    // test to see if the constructor properly works
    @Test
    public void create_n_bitAdder() throws Exception {
        N_BitAdder adder = new N_BitAdder(8);
        int size = adder.getBitSize();
        assertEquals(8,size);
    }

    // error will occur if trying to input a number with a different bit size
    @Test (expected = IllegalArgumentException.class)
    public void check_invalidInput() throws Exception {
        N_BitAdder adder = new N_BitAdder(4);
        adder.setInputs(new boolean[]{false, true}, new boolean[]{true,true,true});
    }

    // test the sum of decimals numbers after conversion into binary and back
    @Test
    public void check_sum_20_24() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert(20));
        boolean[] inB = converter.convertToBooleans(converter.convert(24));
        N_BitAdder adder = new N_BitAdder(5);
        adder.setInputs(inA, inB);
        int dec_result = converter.convert(converter.convertFromBooleans(adder.getResult()));
        assertEquals(44, dec_result);
    }

    // test the sum of decimals numbers after conversion into binary and back
    @Test
    public void check_sum_16_19() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert(16));
        boolean[] inB = converter.convertToBooleans(converter.convert(19));
        N_BitAdder adder = new N_BitAdder(5);
        adder.setInputs(inA, inB);
        int dec_result = converter.convert(converter.convertFromBooleans(adder.getResult()));
        assertEquals(35, dec_result);
    }

    // test the sum of decimals numbers after conversion into binary and back
    @Test
    public void check_sum_9_10() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert(9));
        boolean[] inB = converter.convertToBooleans(converter.convert(10));
        N_BitAdder adder = new N_BitAdder(4);
        adder.setInputs(inA, inB);
        int dec_result = converter.convert(converter.convertFromBooleans(adder.getResult()));
        assertEquals(19, dec_result);
    }
}