package org.jonathanoliveira.basic_components;

import org.jonathanoliveira.utilities.Welder;

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
    public void wire() {
//        calling the proper Welder method to handle the wiring of this component
        Welder.wireInverter(this);
    }
}
