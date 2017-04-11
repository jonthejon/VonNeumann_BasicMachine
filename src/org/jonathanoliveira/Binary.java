package org.jonathanoliveira;

/**
 * This Enum will hold the only two possible values for any voltage in the machine.
 * true for 1
 * false for 0
 *
 * For now, this may seem like an overkill, but later we may want to develop a machine that handles
 * different values of voltages.
 */

public enum Binary {

    VOLTAGE(true), NO_VOLTAGE(false);

    private boolean boolVoltage;

    Binary(boolean boolVoltage) {
        this.boolVoltage = boolVoltage;
    }

    public boolean getValue() {
        return boolVoltage;
    }
}
