package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class RAM_4Kx16Test {
    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidAddress() throws Exception {
        RAM_4Kx16 ram = new RAM_4Kx16();
        boolean[] dataIn1 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        ram.write(true);
        ram.dataIn(dataIn1);
        boolean[] address = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0});
        ram.address(address);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidDataIn() throws Exception {
        RAM_4Kx16 ram = new RAM_4Kx16();
        boolean[] dataIn1 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        ram.write(true);
        ram.dataIn(dataIn1);
    }

    @Test
    public void checkRam() throws Exception {
        RAM_4Kx16 ram = new RAM_4Kx16();
        boolean[] dataIn1 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        boolean[] dataIn2 = Converter.convertToBooleans(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0});
        boolean[] dataIn3 = Converter.convertToBooleans(new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1});
        boolean[] dataIn4 = Converter.convertToBooleans(new int[]{0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1});
        boolean[] dataIn5 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] addr1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] addr2 = Converter.convertToBooleans(new int[]{0,0,1,0,0,1,0,1,0,0,1,0});
        boolean[] addr3 = Converter.convertToBooleans(new int[]{0,1,0,0,1,0,1,0,0,1,0,0});
        boolean[] addr4 = Converter.convertToBooleans(new int[]{0,1,1,0,1,1,1,1,0,1,1,0});
        boolean[] addr5 = Converter.convertToBooleans(new int[]{1,0,0,1,0,0,0,0,1,0,0,1});
        boolean[] addr6 = Converter.convertToBooleans(new int[]{1,0,1,1,0,1,0,1,1,0,1,1});
        boolean[] addr7 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,0,1,1,0,1});
        boolean[] addr8 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1});
        ram.address(addr1);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr5);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.write(true);
        ram.dataIn(dataIn1);
        ram.address(addr1);
        ram.address(addr3);
        ram.address(addr5);
        ram.address(addr7);
        ram.write(false);
        ram.address(addr1);
        assertArrayEquals(dataIn1, ram.dataOut());
        ram.address(addr3);
        assertArrayEquals(dataIn1, ram.dataOut());
        ram.address(addr5);
        assertArrayEquals(dataIn1, ram.dataOut());
        ram.address(addr7);
        assertArrayEquals(dataIn1, ram.dataOut());
        ram.address(addr2);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr4);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr6);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr8);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.write(true);
        ram.dataIn(dataIn2);
        ram.address(addr1);
        ram.address(addr3);
        ram.address(addr5);
        ram.address(addr7);
        ram.write(false);
        ram.address(addr1);
        assertArrayEquals(dataIn2, ram.dataOut());
        ram.address(addr3);
        assertArrayEquals(dataIn2, ram.dataOut());
        ram.address(addr5);
        assertArrayEquals(dataIn2, ram.dataOut());
        ram.write(true);
        ram.dataIn(dataIn3);
        ram.address(addr7);
        ram.write(false);
        ram.address(addr5);
        assertArrayEquals(dataIn2, ram.dataOut());
        ram.address(addr2);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr4);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr6);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr8);
        assertArrayEquals(dataIn5, ram.dataOut());
        ram.address(addr7);
        assertArrayEquals(dataIn3, ram.dataOut());
    }
}