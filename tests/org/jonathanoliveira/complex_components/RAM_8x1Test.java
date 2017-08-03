package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.BasicComponent;
import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class RAM_8x1Test {

    @Test (expected = IllegalArgumentException.class)
    public void checkInvalidAddress() throws Exception {
        RAM_8x1 ram = new RAM_8x1();
//        System.out.println(BasicComponent.counter);
        ram.write(true);
        ram.dataIn(true);
        boolean[] address = Converter.convertToBooleans(new int[]{0,0});
        ram.address(address);
    }

    @Test
    public void checkRam() throws Exception {
        RAM_8x1 ram = new RAM_8x1();
        boolean[] addr1 = Converter.convertToBooleans(new int[]{0,0,0});
        boolean[] addr2 = Converter.convertToBooleans(new int[]{0,0,1});
        boolean[] addr3 = Converter.convertToBooleans(new int[]{0,1,0});
        boolean[] addr4 = Converter.convertToBooleans(new int[]{0,1,1});
        boolean[] addr5 = Converter.convertToBooleans(new int[]{1,0,0});
        boolean[] addr6 = Converter.convertToBooleans(new int[]{1,0,1});
        boolean[] addr7 = Converter.convertToBooleans(new int[]{1,1,0});
        boolean[] addr8 = Converter.convertToBooleans(new int[]{1,1,1});
        ram.address(addr1);
        assertTrue(!ram.dataOut());
        ram.address(addr5);
        assertTrue(!ram.dataOut());
        ram.write(true);
        ram.dataIn(true);
        ram.address(addr1);
        ram.address(addr3);
        ram.address(addr5);
        ram.address(addr7);
        ram.write(false);
        ram.address(addr1);
        assertTrue(ram.dataOut());
        ram.address(addr3);
        assertTrue(ram.dataOut());
        ram.address(addr5);
        assertTrue(ram.dataOut());
        ram.address(addr7);
        assertTrue(ram.dataOut());
        ram.address(addr2);
        assertTrue(!ram.dataOut());
        ram.address(addr4);
        assertTrue(!ram.dataOut());
        ram.address(addr6);
        assertTrue(!ram.dataOut());
        ram.address(addr8);
        assertTrue(!ram.dataOut());
        ram.write(true);
        ram.dataIn(false);
        ram.address(addr1);
        ram.address(addr3);
        ram.address(addr5);
        ram.address(addr7);
        ram.write(false);
        ram.address(addr1);
        assertTrue(!ram.dataOut());
        ram.address(addr3);
        assertTrue(!ram.dataOut());
        ram.address(addr5);
        assertTrue(!ram.dataOut());
        ram.write(true);
        ram.dataIn(true);
        ram.address(addr7);
        ram.write(false);
        ram.address(addr5);
        assertTrue(!ram.dataOut());
        ram.address(addr2);
        assertTrue(!ram.dataOut());
        ram.address(addr4);
        assertTrue(!ram.dataOut());
        ram.address(addr6);
        assertTrue(!ram.dataOut());
        ram.address(addr8);
        assertTrue(!ram.dataOut());
        ram.address(addr7);
        assertTrue(ram.dataOut());
    }
}