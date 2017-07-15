package org.jonathanoliveira.basic_components;

import org.jonathanoliveira.utilities.Binary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RelayTest {

    private Relay relay;

    @Before
    public void setUp() throws Exception {
        relay = new Relay();
    }

    @Test
//    CHECK TO SEE IF THE RELAY INPUT STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void inputHasVoltage() throws Exception {
        relay.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = relay.getInput();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY INPUT STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void inputHasNoVoltage() throws Exception {
        relay.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = relay.getInput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECKS IF RELAY HAS true OUTPUT AFTER INPUT AND VOLTAGE HAS BEEN SET TO true
    public void outputHasVoltage() throws Exception {
        relay.setVoltage(Binary.VOLTAGE.getValue());
        relay.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = relay.getOutput();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECKS IF RELAY HAS false OUTPUT AFTER INPUT IS SET TO true BUT VOLTAGE HAS BEEN SET TO false
    public void outputHasNoVoltage_NoControlVoltage() throws Exception {
        relay.setVoltage(Binary.NO_VOLTAGE.getValue());
        relay.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = relay.getOutput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECKS IF RELAY HAS false OUTPUT AFTER INPUT IS SET TO false BUT VOLTAGE HAS BEEN SET TO true
    public void outputHasNoVoltage_NoInputVoltage() throws Exception {
        relay.setVoltage(Binary.VOLTAGE.getValue());
        relay.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = relay.getOutput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY VOLTAGE STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void controlHasVoltage() throws Exception {
        relay.setVoltage(Binary.VOLTAGE.getValue());
        boolean hasVoltage = relay.getVoltage();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY VOLTAGE STORES IT`S OWN VALUE CORRECTLY WHEN SET TO false
    public void controlHasNoVoltage() throws Exception {
        relay.setVoltage(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = relay.getVoltage();
        assertFalse(hasVoltage);
    }

}