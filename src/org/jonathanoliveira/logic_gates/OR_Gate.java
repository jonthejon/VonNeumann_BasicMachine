package org.jonathanoliveira.logic_gates;

/*
* All gates are made of components, no matter how many.
* An OR gate must be able to receive a certain number of inputs and come out with the proper output.
*
* So, in essence, the behavior of an OR gate is the following:
* if (ALL INPUTS): false, then OUTPUT ==  false
* if (AT LEAST 1 INPUT): true, then OUTPUT ==  true
*
*      OR | 0 | 1 |
*    --------------
*      0  | 0 | 1 |
*    --------------
*      1  | 1 | 1 |
*
* */

import org.jonathanoliveira.utilities.Welder;

public class OR_Gate extends BasicLogicGate {

    public OR_Gate() {
        // sending to the constructor the proper component type that we want to use in an AND gate
        super(ComponentType.RELAY);
    }

    public OR_Gate(int numInputs) {
        // sending the superclass constructor the component type that we want (buffer) and the number of buffers we want
        super(ComponentType.RELAY, numInputs);
    }

    @Override
    public void wire() {
//        calling the Welder method that handles parallel wiring of simple gates
        Welder.parallelWiring(this);
    }
}
