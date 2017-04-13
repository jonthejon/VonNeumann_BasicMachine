package org.jonathanoliveira.utilities;

import org.jonathanoliveira.complex_components.N_BitAdder;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConverterTest {

    // testing the conversion of binary 10010110 to decimal 150
    @Test
    public void bin_10010110_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {1,0,0,1,0,1,1,0};
        int dec_num = converter.convert(bin_num);
        assertEquals(150, dec_num);
    }

    // testing the conversion of decimal 150 to decimal 10010110
    @Test
    public void dec_150_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert(150);
        int[] expected = new int[] {1,0,0,1,0,1,1,0};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
        assertEquals(expected[3], bin_num[3]);
        assertEquals(expected[4], bin_num[4]);
        assertEquals(expected[5], bin_num[5]);
        assertEquals(expected[6], bin_num[6]);
        assertEquals(expected[7], bin_num[7]);
    }

    // testing the conversion of binary 11101 to decimal 29
    @Test
    public void bin_11101_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {1,1,1,0,1};
        int dec_num = converter.convert(bin_num);
        assertEquals(29, dec_num);
    }

    // testing the conversion of decimal 29 to decimal 11101
    @Test
    public void dec_29_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert(29);
        int[] expected = new int[] {1,1,1,0,1};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
        assertEquals(expected[3], bin_num[3]);
        assertEquals(expected[4], bin_num[4]);
    }

    // testing the conversion of binary 101 to decimal 5
    @Test
    public void bin_101_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {1,0,1};
        int dec_num = converter.convert(bin_num);
        assertEquals(5, dec_num);
    }

    // testing the conversion of binary 00101 to decimal 5
    @Test
    public void bin_00101_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {0,0,1,0,1};
        int dec_num = converter.convert(bin_num);
        assertEquals(5, dec_num);
    }

    // testing the conversion of decimal 5 to binary 101
    @Test
    public void dec_5_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert(5);
        int[] expected = new int[] {1,0,1};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
    }

    @Test
    public void powerof2() throws Exception {
        Converter converter = new Converter();
        int result = converter.powerOfTwo(5);
        assertEquals(32,result);
    }

    // testing the attempt to convert a negative decimal
    @Test (expected = IllegalArgumentException.class)
    public void dec_Invalid_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] dec_num = converter.convert(-5);
    }

    // testing the conversion of binary 101 to booleans
    @Test
    public void bin_101_to_booleans() throws Exception {
        Converter converter = new Converter();
        boolean[] bool_arr = converter.convertToBooleans(new int[] {1,0,1});
        boolean[] expected = new boolean[] {true,false,true};
        assertEquals(expected[0], bool_arr[0]);
        assertEquals(expected[1], bool_arr[1]);
        assertEquals(expected[2], bool_arr[2]);
    }

    // testing the conversion of binary 10010110 to booleans
    @Test
    public void bin_10010110_to_booleans() throws Exception {
        Converter converter = new Converter();
        boolean[] bool_arr = converter.convertToBooleans(new int[] {1,0,0,1,0,1,1,0});
        boolean[] expected = new boolean[] {true,false,false,true,false,true,true,false};
        assertEquals(expected[0], bool_arr[0]);
        assertEquals(expected[1], bool_arr[1]);
        assertEquals(expected[2], bool_arr[2]);
        assertEquals(expected[3], bool_arr[3]);
        assertEquals(expected[4], bool_arr[4]);
        assertEquals(expected[5], bool_arr[5]);
        assertEquals(expected[6], bool_arr[6]);
        assertEquals(expected[7], bool_arr[7]);
    }
}