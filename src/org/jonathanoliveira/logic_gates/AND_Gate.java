package org.jonathanoliveira.logic_gates;

/*
* All gates are made of components, no matter how many.
* An AND gate must be able to receive a certain number of inputs and come out with the proper output.
*
* So, in essence, the behavior of an AND gate is the following:
* if (ALL INPUTS): true, then OUTPUT ==  true
* if (AT LEAST 1 INPUT): false, then OUTPUT ==  false
*
*     AND | 0 | 1 |
*    --------------
*      0  | 0 | 0 |
*    --------------
*      1  | 0 | 1 |
*
* */

import org.jonathanoliveira.utilities.Welder;

public class AND_Gate extends BasicLogicGate {

    public AND_Gate() {
        // sending to the constructor the proper component type that we want to use in an AND gate
        super(ComponentType.RELAY);
    }

    public AND_Gate(int numInputs) {
        // sending the superclass constructor the component type that we want (buffer) and the number of buffers we want
        super(ComponentType.RELAY, numInputs);
    }

    @Override
    public void wire() {
//        calling the Welder method that handles linear wiring of simple gates
        Welder.linearWiring(this);
    }
}
