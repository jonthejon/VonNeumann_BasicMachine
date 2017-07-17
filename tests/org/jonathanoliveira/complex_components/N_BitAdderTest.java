package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class N_BitAdderTest {
/*

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

// 4) fix the adder so it results only binary numbers with the same length as its inputs (fix the proper tests)
// 5) refactor the adder for problematic results (fix the proper tests)

    // ------------ calculations with signed binary numbers ------------

*/
/*
    // test the sum of signed decimals numbers after conversion into signed binary and back
    @Test
    public void check_sum_9_neg10() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert_signed(9,8));
        boolean[] inB = converter.convertToBooleans(converter.convert_signed(-10,8));
        N_BitAdder adder = new N_BitAdder(inA.length);
        adder.setInputs(inA, inB, true);
        int dec_result = converter.convert_signed(converter.convertFromBooleans(adder.getResult()));
        assertEquals(-1, dec_result);
    }

    // test the sum of signed decimals numbers after conversion into signed binary and back
    @Test (expected = IllegalArgumentException.class)
    public void check_sum_neg120_neg110() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert_signed(-120,8));
        boolean[] inB = converter.convertToBooleans(converter.convert_signed(-110,8));
        N_BitAdder adder = new N_BitAdder(inA.length);
        adder.setInputs(inA, inB, true);
        int dec_result = converter.convert_signed(converter.convertFromBooleans(adder.getResult()));
        assertEquals(-230, dec_result);
    }

    // test the sum of signed decimals numbers after conversion into signed binary and back
    @Test
    public void check_sum_neg100_110() throws Exception {
        Converter converter = new Converter();
        boolean[] inA = converter.convertToBooleans(converter.convert_signed(-100,8));
        boolean[] inB = converter.convertToBooleans(converter.convert_signed(110,8));
        N_BitAdder adder = new N_BitAdder(inA.length);
        adder.setInputs(inA, inB, true);
        int dec_result = converter.convert_signed(converter.convertFromBooleans(adder.getResult()));
        assertEquals(10, dec_result);
    }
*//*


*/

}

