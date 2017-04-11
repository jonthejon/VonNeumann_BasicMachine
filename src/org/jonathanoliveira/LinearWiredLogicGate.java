package org.jonathanoliveira;

/**
 * This class will be responsible for performing the wiring of the basic components
 * in a linear way. This means that all logic gates that have a linear configuration
 * of their basic components will extend it.
 * In our case, this means that AND_gate and NOR_gate will extend this class.
 */

abstract class LinearWiredLogicGate extends LogicGate {

    LinearWiredLogicGate (ComponentType componentType) {
        super(componentType);
    }

    LinearWiredLogicGate (ComponentType componentType, int numInputs) {
        super(componentType, numInputs);
    }

    // private method that wires all components with inputs and voltages in order to produce a linear configuration of the gate
    @Override
    void setAndWireComponents(boolean[] inputs) {
        // initiate a boolean variable to hold the proper voltage value and set it to true
        boolean relay_voltage = Binary.VOLTAGE.getValue();
        // make a loop through all components of this gate
        for (int i = 0; i < getNumInputs(); i++) {
            // set relay input with input value
            components[i].setInput(inputs[i]);
            // set relay voltage with proper value
            components[i].setVoltage(relay_voltage);
            // set proper voltage value to output of the relay
            relay_voltage = components[i].getOutput();
        }
        // after all wiring, set the AND gate output value to proper voltage value
        setOutput(relay_voltage);
    }
}
