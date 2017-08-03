package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.BasicComponent;
import org.junit.Test;

import static org.junit.Assert.*;

public class FullAdderTest {

    // after constructing a Full-Adder, set carry_in = false, inA = false, inB = false.
    // Result expected is: Sum = false, Carry = false
    @Test
    public void check_000_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(false,false, false);
        boolean[] expected = new boolean[] {false, false};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = false, inA = false, inB = true.
    // Result expected is: Sum = true, Carry = false
    @Test
    public void check_001_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(false,false, true);
        boolean[] expected = new boolean[] {true, false};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = false, inA = true, inB = false.
    // Result expected is: Sum = true, Carry = false
    @Test
    public void check_010_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(false,true, false);
        boolean[] expected = new boolean[] {true, false};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = false, inA = true, inB = true.
    // Result expected is: Sum = false, Carry = true
    @Test
    public void check_011_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(false,true, true);
        boolean[] expected = new boolean[] {false, true};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = true, inA = false, inB = false.
    // Result expected is: Sum = true, Carry = false
    @Test
    public void check_100_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(true,false, false);
        boolean[] expected = new boolean[] {true, false};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = true, inA = false, inB = true.
    // Result expected is: Sum = false, Carry = true
    @Test
    public void check_101_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(true,false, true);
        boolean[] expected = new boolean[] {false, true};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = true, inA = true, inB = false.
    // Result expected is: Sum = false, Carry = true
    @Test
    public void check_110_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(true,true, false);
        boolean[] expected = new boolean[] {false, true};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

    // after constructing a Full-Adder, set carry_in = true, inA = true, inB = true.
    // Result expected is: Sum = true, Carry = true
    @Test
    public void check_111_input_FullAdder() throws Exception {
        FullAdder fullAdder = new FullAdder();
        fullAdder.setInputs(true,true, true);
        boolean[] expected = new boolean[] {true, true};
        boolean[] results = new boolean[] {fullAdder.getSumOut(), fullAdder.getCarryOut()};
        assertArrayEquals(expected, results);
    }

}