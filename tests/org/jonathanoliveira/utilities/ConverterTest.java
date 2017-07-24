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
        int dec_num = converter.convert_unsigned(bin_num);
        assertEquals(150, dec_num);
    }

    // testing the conversion of decimal 150 to decimal 10010110
    @Test
    public void dec_150_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(150);
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
        int dec_num = converter.convert_unsigned(bin_num);
        assertEquals(29, dec_num);
    }

    // testing the conversion of decimal 29 to decimal 11101
    @Test
    public void dec_29_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(29);
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
        int dec_num = converter.convert_unsigned(bin_num);
        assertEquals(5, dec_num);
    }

    // testing the conversion of binary 00101 to decimal 5
    @Test
    public void bin_00101_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {0,0,1,0,1};
        int dec_num = converter.convert_unsigned(bin_num);
        assertEquals(5, dec_num);
    }

    // testing the conversion of decimal 5 to binary 101
    @Test
    public void dec_5_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(5);
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

    // testing the attempt to convert_unsigned a negative decimal
    @Test (expected = IllegalArgumentException.class)
    public void dec_Invalid_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] dec_num = converter.convert_unsigned(-5);
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

    // -----------------------------------------

    // testing the attempt to convert_unsigned a decimal number with not sufficient binary digits
    // decimal 8 is 1000 in binary, but we are requesting an 3-digit number
    @Test (expected = IllegalArgumentException.class)
    public void dec_InvalidBitSize_8_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(8,3);
    }

    // testing the attempt to convert_unsigned a decimal number with not sufficient binary digits
    // decimal 256 is 100000000 in binary, but we are requesting an 8-digit number
    @Test (expected = IllegalArgumentException.class)
    public void dec_InvalidBitSize_256_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(256,8);
    }

    // testing the conversion of decimal 150 to binary 10010110
    // 150 needs at least 8 bits to be represented in binary, so this test should pass
    @Test
    public void dec_150_to_binary_8_bitsize() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(150,8);
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

    // testing the conversion of decimal 150 to binary 000010010110
    // 150 needs at least 8 bits to be represented in binary and we are requesting a 12-bit binary number, so this test should pass
    @Test
    public void dec_150_to_binary_12_bitsize() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_unsigned(150,12);
        int[] expected = new int[] {0,0,0,0,1,0,0,1,0,1,1,0};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
        assertEquals(expected[3], bin_num[3]);
        assertEquals(expected[4], bin_num[4]);
        assertEquals(expected[5], bin_num[5]);
        assertEquals(expected[6], bin_num[6]);
        assertEquals(expected[7], bin_num[7]);
        assertEquals(expected[8], bin_num[8]);
        assertEquals(expected[9], bin_num[9]);
        assertEquals(expected[10], bin_num[10]);
        assertEquals(expected[11], bin_num[11]);
    }

    // -----------------------------------------

    // testing the attempt to convert_signed a decimal number with not sufficient binary digits
    // the range of a 8-bit signed binary number is -128 to 127.
    // So converting 130 to an 8-bit binary should throw an exception.
    @Test (expected = IllegalArgumentException.class)
    public void dec_Sign_InvalidBitSize_130_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_signed(130,8);
    }

    // testing the attempt to convert_signed a decimal number with not sufficient binary digits
    // the range of a 16-bit signed binary number is -32768 to 32767.
    // So converting -33000 to a 16-bit binary should throw an exception.
    @Test (expected = IllegalArgumentException.class)
    public void dec_Sign_InvalidBitSize_33000_to_binary() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_signed(33000,16);
    }

    // testing the conversion of decimal 3 to an 8-bit signed binary (00000011)
    @Test
    public void dec_3_to_SignedBin_8_bitsize() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_signed(3,8);
        int[] expected = new int[] {0,0,0,0,0,0,1,1};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
        assertEquals(expected[3], bin_num[3]);
        assertEquals(expected[4], bin_num[4]);
        assertEquals(expected[5], bin_num[5]);
        assertEquals(expected[6], bin_num[6]);
        assertEquals(expected[7], bin_num[7]);
    }

    // testing the conversion of decimal -125 to an 8-bit signed binary (10000011)
    @Test
    public void dec_neg125_to_SignedBin_8_bitsize() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_signed(-125,8);
        int[] expected = new int[] {1,0,0,0,0,0,1,1};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
        assertEquals(expected[3], bin_num[3]);
        assertEquals(expected[4], bin_num[4]);
        assertEquals(expected[5], bin_num[5]);
        assertEquals(expected[6], bin_num[6]);
        assertEquals(expected[7], bin_num[7]);
    }

    // testing the conversion of decimal -2 to an 8-bit signed binary (11111110)
    @Test
    public void dec_neg2_to_SignedBin_8_bitsize() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = converter.convert_signed(-2,8);
        int[] expected = new int[] {1,1,1,1,1,1,1,0};
        assertEquals(expected[0], bin_num[0]);
        assertEquals(expected[1], bin_num[1]);
        assertEquals(expected[2], bin_num[2]);
        assertEquals(expected[3], bin_num[3]);
        assertEquals(expected[4], bin_num[4]);
        assertEquals(expected[5], bin_num[5]);
        assertEquals(expected[6], bin_num[6]);
        assertEquals(expected[7], bin_num[7]);
    }

    // testing the conversion of signed binary 11111110 to decimal -2
    @Test
    public void signedBin_11111110_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {1,1,1,1,1,1,1,0};
        int dec_num = converter.convert_signed(bin_num);
        assertEquals(-2, dec_num);
    }

    // testing the conversion of signed binary 10000000 to decimal -128
    @Test
    public void signedBin_10000000_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {1,0,0,0,0,0,0,0};
        int dec_num = converter.convert_signed(bin_num);
        assertEquals(-128, dec_num);
    }

    // testing the conversion of signed binary 01111100 to decimal 124
    @Test
    public void signedBin_01111100_to_decimal() throws Exception {
        Converter converter = new Converter();
        int[] bin_num = new int[] {0,1,1,1,1,1,0,0};
        int dec_num = converter.convert_signed(bin_num);
        assertEquals(124, dec_num);
    }

}