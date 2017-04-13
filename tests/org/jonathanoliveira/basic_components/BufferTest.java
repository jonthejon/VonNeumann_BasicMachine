package org.jonathanoliveira.basic_components;

import org.jonathanoliveira.basic_components.Buffer;
import org.jonathanoliveira.utilities.Binary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BufferTest {

    private Buffer buffer;

    @Before
    public void setUp() throws Exception {
        buffer = new Buffer();
    }

    @Test
//    CHECK TO SEE IF THE RELAY INPUT STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void inputHasVoltage() throws Exception {
        buffer.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = buffer.getInput();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY INPUT STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void inputHasNoVoltage() throws Exception {
        buffer.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = buffer.getInput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECKS IF RELAY HAS true OUTPUT AFTER INPUT AND VOLTAGE HAS BEEN SET TO true
    public void outputHasVoltage() throws Exception {
        buffer.setVoltage(Binary.VOLTAGE.getValue());
        buffer.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = buffer.getOutput();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECKS IF RELAY HAS false OUTPUT AFTER INPUT IS SET TO true BUT VOLTAGE HAS BEEN SET TO false
    public void outputHasNoVoltage_NoControlVoltage() throws Exception {
        buffer.setVoltage(Binary.NO_VOLTAGE.getValue());
        buffer.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = buffer.getOutput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECKS IF RELAY HAS false OUTPUT AFTER INPUT IS SET TO false BUT VOLTAGE HAS BEEN SET TO true
    public void outputHasNoVoltage_NoInputVoltage() throws Exception {
        buffer.setVoltage(Binary.VOLTAGE.getValue());
        buffer.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = buffer.getOutput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY VOLTAGE STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void controlHasVoltage() throws Exception {
        buffer.setVoltage(Binary.VOLTAGE.getValue());
        boolean hasVoltage = buffer.getVoltage();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY VOLTAGE STORES IT`S OWN VALUE CORRECTLY WHEN SET TO false
    public void controlHasNoVoltage() throws Exception {
        buffer.setVoltage(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = buffer.getVoltage();
        assertFalse(hasVoltage);
    }

}