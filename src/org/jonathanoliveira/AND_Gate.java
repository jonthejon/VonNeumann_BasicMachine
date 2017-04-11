package org.jonathanoliveira;

/*
* All gates are made of components, no matter how many.
* An AND gate must be able to receive a certain number of inputs and come out with the proper output.
*
* So, in essence, the behavior of an AND gate is the following:
* if (ALL INPUTS): true, then OUTPUT ==  true
* if (AT LEAST 1 INPUT): false, then OUTPUT ==  false
* */

class AND_Gate extends LogicGate {

    AND_Gate() {
//        Todo: send to the superclass constructor an Enum option
        super();
    }

    AND_Gate(int numInputs) {
        //        Todo: send to the superclass constructor an Enum option
        super(numInputs);
    }

    // private method that wires all components with inputs and voltages in order to produce an AND gate behavior
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
