package org.jonathanoliveira.utilities;

import org.jonathanoliveira.basic_components.BasicComponent;
import org.jonathanoliveira.logic_gates.BasicLogicGate;

/**
 * This utility class will be used to handle all the possible wiring of the components.
 * For example, some methods will handle a linear wiring, others will handle a parallel wiring.
 */

public class Welder {

    /**
     * This method will handle the wiring of a basic relay.
     * For the wiring of a inverter, se other methods of this class
     * @param component: the underlying relay that called this class for wiring.
     * */
    public static void wireRelay(BasicComponent component) {
//      IF input is true, then output must be equal to voltage
        if (component.getInput()) {
            component.setOutput(component.getVoltage());
//      IF input is false, then output must have no voltage
        } else {
            component.setOutput(Binary.NO_VOLTAGE.getValue());
        }
    }


    /**
     * This method will handle the wiring of a basic inverter.
     * For the wiring of a Relay, se other methods of this class
     * @param component: the underlying inverter that called this class for wiring.
     * */
    public static void wireInverter(BasicComponent component) {
//      IF input is true, then output must have no voltage
        if (component.getInput()) {
            component.setOutput(Binary.NO_VOLTAGE.getValue());
//      IF input is false, then output must be equal to voltage
        } else {
            component.setOutput(component.getVoltage());
        }
    }


    /**
     * This method will wire all the components of a logic gate with a linear architecture.
     * @param gate: the logic gate that will have it's components wired
     * */
    public static void linearWiring(BasicLogicGate gate) {
        // initiate a boolean variable to hold the proper voltage value and set it to true
        boolean relay_voltage = Binary.VOLTAGE.getValue();
        // make a loop through all components of this gate
        for (int i = 0; i < gate.getNumInputs(); i++) {
            // set component input with input value
            gate.components[i].setInput(gate.getInputs()[i]);
            // set component voltage with proper value
            gate.components[i].setVoltage(relay_voltage);
            // set proper voltage value to output of the relay
            relay_voltage = gate.components[i].getOutput();
        }
        // after all wiring, set the AND gate output value to proper voltage value
        gate.setOutput(relay_voltage);
    }

    /**
     * This method will wire all the components of a logic gate with a parallel architecture.
     * @param gate: the logic gate that will have it's components wired
     * */
    public static void parallelWiring(BasicLogicGate gate) {
        // initiate a boolean variable to hold the proper voltage value and set it to false (false will be the default output of the OR gate)
        boolean relay_voltage = Binary.NO_VOLTAGE.getValue();
        // make a loop through all components of this gate
        for (int i = 0; i < gate.getNumInputs(); i++) {
            // set relay input with input value
            gate.components[i].setInput(gate.getInputs()[i]);
            // check to see if relay_voltage is false. If not, the result of the relay is already true and we can skip this step.
            if (!relay_voltage) {
                // set relay_voltage to the output of the relay
                relay_voltage = gate.components[i].getOutput();
            }
        }
        // after all wiring, set the OR gate output value to proper voltage value
        gate.setOutput(relay_voltage);
    }

}
