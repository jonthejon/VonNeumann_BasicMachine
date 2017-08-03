package org.jonathanoliveira.basic_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.utilities.Binary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InverterTest {

    private Inverter inverter;

    @Before
    public void setUp() throws Exception {
        inverter = new Inverter();

    }

    @Test
//    CHECK TO SEE IF THE INVERTER INPUT STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void inputHasVoltage() throws Exception {
        inverter.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = inverter.getInput();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE INVERTER INPUT STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void inputHasNoVoltage() throws Exception {
        inverter.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = inverter.getInput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECKS IF INVERTER HAS true OUTPUT AFTER INPUT IS SET TO false AND VOLTAGE HAS BEEN SET TO true
    public void outputHasVoltage() throws Exception {
        inverter.setVoltage(Binary.VOLTAGE.getValue());
        inverter.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = inverter.getOutput();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECKS IF INVERTER HAS false OUTPUT AFTER INPUT IS SET TO true, NO MATTER THE VOLTAGE
    public void outputHasNoVoltage_NoControlVoltage() throws Exception {
        inverter.setVoltage(Binary.VOLTAGE.getValue());
        inverter.setInput(Binary.VOLTAGE.getValue());
        boolean hasVoltage = inverter.getOutput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECKS IF INVERTER HAS false OUTPUT AFTER INPUT IS SET TO false BUT VOLTAGE HAS BEEN SET TO false
    public void outputHasNoVoltage_NoInputVoltage() throws Exception {
        inverter.setVoltage(Binary.NO_VOLTAGE.getValue());
        inverter.setInput(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = inverter.getOutput();
        assertFalse(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY VOLTAGE STORES IT`S OWN VALUE CORRECTLY WHEN SET TO true
    public void controlHasVoltage() throws Exception {
        inverter.setVoltage(Binary.VOLTAGE.getValue());
        boolean hasVoltage = inverter.getVoltage();
        assertTrue(hasVoltage);
    }

    @Test
//    CHECK TO SEE IF THE RELAY VOLTAGE STORES IT`S OWN VALUE CORRECTLY WHEN SET TO false
    public void controlHasNoVoltage() throws Exception {
        inverter.setVoltage(Binary.NO_VOLTAGE.getValue());
        boolean hasVoltage = inverter.getVoltage();
        assertFalse(hasVoltage);
    }
}