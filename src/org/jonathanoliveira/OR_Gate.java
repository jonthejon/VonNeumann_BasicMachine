package org.jonathanoliveira;

/*
* All gates are made of components, no matter how many.
* An OR gate must be able to receive a certain number of inputs and come out with the proper output.
*
* So, in essence, the behavior of an OR gate is the following:
* if (ALL INPUTS): false, then OUTPUT ==  false
* if (AT LEAST 1 INPUT): true, then OUTPUT ==  true
* */

class OR_Gate extends LogicGate {

    OR_Gate() {
        //        Todo: send to the superclass constructor an Enum option
        super();
    }

    OR_Gate(int numInputs) {
        //        Todo: send to the superclass constructor an Enum option
        super(numInputs);
    }

    // private method that wires all components with inputs and voltages in order to produce an OR gate behavior
    @Override
    void setAndWireComponents(boolean[] inputs) {

        // initiate a boolean variable to hold the proper voltage value and set it to false (false will be the default output of the OR gate)
        boolean relay_voltage = false;
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
