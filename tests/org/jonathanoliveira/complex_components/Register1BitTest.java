package org.jonathanoliveira.complex_components;

import org.junit.Test;

import static org.junit.Assert.*;

public class Register1BitTest {
    // data = 1 clock=1 Q=1
    @Test
    public void checkData_1_clock_1() throws Exception {
        Register_1Bit reg = new Register_1Bit();
        reg.data(true);
        reg.clock(true);
        assertTrue(reg.Q());
    }

    // data = 0 clock=1 Q=0
    @Test
    public void checkData_0_clock_1() throws Exception {
        Register_1Bit reg = new Register_1Bit();
        reg.data(false);
        reg.clock(true);
        assertTrue(!reg.Q());
    }

    // data = 1 clock=0 Q=Q
    @Test
    public void checkData_n_clock_0() throws Exception {
        Register_1Bit reg = new Register_1Bit();
        reg.data(true);
        reg.clock(true);
        reg.clock(false);
        reg.data(false);
        assertTrue(reg.Q());
        reg.data(true);
        reg.data(false);
        assertTrue(reg.Q());
        reg.data(false);
        reg.clock(true);
        reg.clock(false);
        reg.data(true);
        assertTrue(!reg.Q());
    }
}