package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.BasicComponent;
import org.jonathanoliveira.logic_gates.XOR_gate;
import org.junit.Test;

import static org.junit.Assert.*;

public class HalfAdderTest {

    //    after constructing a Half-Adder, set INPUT[false, false]. Sum = false, Carry = false
    @Test
    public void check_00_input_HalfAdder() throws Exception {
        HalfAdder halfAdder = new HalfAdder();
        halfAdder.setInputs(false, false);
        boolean[] expected = new boolean[] {false, false};
        boolean[] results = new boolean[] {halfAdder.getSumOut(), halfAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    //    after constructing a Half-Adder, set INPUT[true, false]. Sum = true, Carry = false
    @Test
    public void check_10_input_HalfAdder() throws Exception {
        HalfAdder halfAdder = new HalfAdder();
        halfAdder.setInputs(true, false);
        boolean[] expected = new boolean[] {true, false};
        boolean[] results = new boolean[] {halfAdder.getSumOut(), halfAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    //    after constructing a Half-Adder, set INPUT[false, true]. Sum = true, Carry = false
    @Test
    public void check_01_input_HalfAdder() throws Exception {
        HalfAdder halfAdder = new HalfAdder();
        halfAdder.setInputs(false, true);
        boolean[] expected = new boolean[] {true, false};
        boolean[] results = new boolean[] {halfAdder.getSumOut(), halfAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    //    after constructing a Half-Adder, set INPUT[true, true]. Sum = false, Carry = true
    @Test
    public void check_11_input_HalfAdder() throws Exception {
        HalfAdder halfAdder = new HalfAdder();
        halfAdder.setInputs(true, true);
        boolean[] expected = new boolean[] {false, true};
        boolean[] results = new boolean[] {halfAdder.getSumOut(), halfAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

}