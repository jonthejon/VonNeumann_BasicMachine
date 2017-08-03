package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.BasicComponent;
import org.junit.Test;

import static org.junit.Assert.*;

public class Register1BitTest {
    // data = 1 write=1 Q=1
    @Test
    public void checkData_1_clock_1() throws Exception {
        Register_1Bit reg = new Register_1Bit();
//        System.out.println(BasicComponent.counter);
        reg.write(true);
        reg.data(true);
        assertTrue(reg.Q());
    }

    // data = 0 write=1 Q=0
    @Test
    public void checkData_0_clock_1() throws Exception {
        Register_1Bit reg = new Register_1Bit();
        reg.write(true);
        reg.data(false);
        assertTrue(!reg.Q());
    }

    // data = 1 write=0 Q=Q
    @Test
    public void checkData_n_clock_0() throws Exception {
        Register_1Bit reg = new Register_1Bit();
        reg.write(true);
        reg.data(true);
        reg.write(false);
        reg.data(false);
        assertTrue(reg.Q());
        reg.data(true);
        reg.data(false);
        assertTrue(reg.Q());
        reg.write(true);
        reg.data(false);
        reg.write(false);
        reg.data(true);
        assertTrue(!reg.Q());
    }
}