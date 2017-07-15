package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.utilities.Binary;

/**
 * This class will be responsible for performing the wiring of the basic components
 * in a parallel way. This means that all logic gates that have a parallel configuration
 * of their basic components will extend it.
 * In our case, this means that OR_gate and NAND_Gate will extend this class.
 */

class ParallelWired extends BasicLogicGate {

    ParallelWired(ComponentType componentType) {
        super(componentType);
    }

    ParallelWired(ComponentType componentType, int numInputs) {
        super(componentType, numInputs);
    }

    // method that wires all components with inputs and voltages in order to produce an OR gate behavior
    @Override
    void setAndWireComponents(boolean[] inputs) {
        // initiate a boolean variable to hold the proper voltage value and set it to false (false will be the default output of the OR gate)
        boolean relay_voltage = Binary.NO_VOLTAGE.getValue();
        // make a loop through all components of this gate
        for (int i = 0; i < getNumInputs(); i++) {
            // set relay input with input value
            components[i].setInput(inputs[i]);
            // check to see if relay_voltage is false. If not, the result of the relay is already true and we can skip this step.
            if (!relay_voltage) {
                // set relay_voltage to the output of the relay
                relay_voltage = components[i].getOutput();
            }
        }
        // after all wiring, set the OR gate output value to proper voltage value
        setOutput(relay_voltage);
    }
}
