package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class Register_16BitTest {

    @Test
    public void checkData1_clock_1() throws Exception {
        Register_16Bit reg = new Register_16Bit();
        reg.write(true);
        reg.data(Converter.convertToBooleans(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}));
        boolean[] exp = Converter.convertToBooleans(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0});
        assertArrayEquals(exp, reg.Q());
        reg.data(Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        boolean[] exp2 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        assertArrayEquals(exp2, reg.Q());
    }

    @Test
    public void checkData_n_clock_0() throws Exception {
        Register_16Bit reg = new Register_16Bit();
        boolean[] exp = Converter.convertToBooleans(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0});
        boolean[] exp2 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        reg.write(true);
        reg.data(exp);
        assertArrayEquals(exp, reg.Q());
        reg.write(false);
        assertArrayEquals(exp, reg.Q());
        reg.data(exp2);
        assertArrayEquals(exp, reg.Q());
        reg.data(exp);
        reg.data(exp2);
        assertArrayEquals(exp, reg.Q());
        reg.write(true);
        reg.data(exp2);
        reg.write(false);
        reg.data(exp);
        assertArrayEquals(exp2, reg.Q());
    }
}