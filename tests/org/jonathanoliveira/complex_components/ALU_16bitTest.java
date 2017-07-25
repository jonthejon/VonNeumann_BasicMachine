package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ALU_16bitTest {

    @Test(expected = IllegalArgumentException.class)
    public void check_invalidInput() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1});
        boolean[] function = Converter.convertToBooleans(new int[]{1,0});
        alu.setInputs(x,y, function);
    }

    @Test(expected = IllegalArgumentException.class)
    public void check_invalidFunction() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1});
        alu.setInputs(x,y,function);
    }

    @Test
    public void check_X_00() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,0,0,0});
        alu.setInputs(x,y, function);
        assertArrayEquals(x,alu.getInputX());
    }

    @Test
    public void check_X_01() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,1,0,0,0,0});
        boolean[] notx = Converter.convertToBooleans(new int[]{0,1,1,1,0,1,1,1,0,0,0,1,0,0,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(notx, alu.getInputX());
    }

    @Test
    public void check_X_10() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,0,0,0,0,0});
        boolean[] zero = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(zero, alu.getInputX());
    }

    @Test
    public void check_X_11() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,0,0,0,0});
        boolean[] ones = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(ones, alu.getInputX());
    }

    @Test
    public void check_Y_00() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,0,0,0});
        alu.setInputs(x, y,function);
        assertArrayEquals(y,alu.getInputY());
    }

    @Test
    public void check_Y_01() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,1,0,1,0,0});
        boolean[] noty = Converter.convertToBooleans(new int[]{0,1,1,1,0,1,1,1,0,0,0,1,0,0,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(noty, alu.getInputY());
    }

    @Test
    public void check_Y_10() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,0,1,0,0,0});
        boolean[] zero = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(zero, alu.getInputY());
    }

    @Test
    public void check_Y_11() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,1,1,0,0});
        boolean[] ones = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(ones, alu.getInputY());
    }

    @Test
    public void checkANDFunc() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,1,0,1,1,1,0,0,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,1,0,0,0,0,0,0,1,0,1,1,0,0});
        boolean[] res = Converter.convertToBooleans(new int[]{1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,0,0,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkSUMFunc() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,1,0,1,1,1,0,0,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,1,0,0,0,0,0,0,1,0,1,1,0,0});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,1,1,0,1,1,0,0,0,1,0,0,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,0,1,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkOutputNeg() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,1,0,1,1,1,0,0,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,1,0,0,0,0,0,0,1,0,1,1,0,0});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,1,0,0,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkOutputNeg2() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{1,0,0,0,1,0,1,0,1,1,1,0,0,1,0,0});
        boolean[] y = Converter.convertToBooleans(new int[]{1,0,0,1,0,0,0,0,0,0,1,0,1,1,0,0});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,1,1,0,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_1() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,0,1,0,1,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_2() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,1,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_3() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,1,0,1,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkNand2Tetris_4() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,1,1,0,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_5() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,0,0,0,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_6() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,1,1,0,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkNand2Tetris_7() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,0,0,0,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkNand2Tetris_8() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,1,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkNand2Tetris_9() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,0,0,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkNand2Tetris_10() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,1,1,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_11() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,0,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_12() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,1,1,1,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_13() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
        boolean[] function = Converter.convertToBooleans(new int[]{1,1,0,0,1,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_14() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,0,1,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_15() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,1,0,0,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_16() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,1,1,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(alu.isNg());
    }

    @Test
    public void checkNand2Tetris_17() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        boolean[] function = Converter.convertToBooleans(new int[]{0,0,0,0,0,0});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }

    @Test
    public void checkNand2Tetris_18() throws Exception {
        ALU_16bit alu = new ALU_16bit();
        boolean[] x = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1});
        boolean[] y = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] res = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1});
        boolean[] function = Converter.convertToBooleans(new int[]{0,1,0,1,0,1});
        alu.setInputs(x,y,function);
        assertArrayEquals(res, alu.getOutput());
        assertTrue(!alu.isZr());
        assertTrue(!alu.isNg());
    }
}