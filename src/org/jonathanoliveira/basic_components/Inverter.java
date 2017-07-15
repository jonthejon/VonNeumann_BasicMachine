package org.jonathanoliveira.basic_components;

import org.jonathanoliveira.utilities.Binary;

/**
 * Just like a Relay, an Inverter is a basic Component.
 * All inverters are based in boolean (true/false) values that correspond to the existence of voltage.
 * Basically, if the input voltage of an is true, the output value will be false.
 *
 * So, in essence, the behavior of an inverter is the following:
 * if INPUT: true, then OUTPUT == false
 * if INPUT: false, then OUTPUT == VOLTAGE
 *
 * important to notice that getOutput() must be called only after the input and the voltage
 *      has been properly set.
 */

public class Inverter extends BasicComponent {

    @Override
    void setOutput() {
//      IF input is true, then output must have no voltage
        if (getInput()) {
            this.output = Binary.NO_VOLTAGE.getValue();
//      IF input is false, then output must be equal to voltage
        } else {
            this.output = getVoltage();
        }
    }
}
