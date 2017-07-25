package org.jonathanoliveira.logic_gates;

/*
* All gates are made of components, no matter how many.
* A NOR gate must be able to receive a certain number of inputs and come out with the proper output.
*
* So, in essence, the behavior of a NOR gate is the following:
* if (ALL INPUTS): false, then OUTPUT ==  true
* if (AT LEAST 1 INPUT): true, then OUTPUT ==  false
*
*     NOR | 0 | 1 |
*    --------------
*      0  | 1 | 0 |
*    --------------
*      1  | 0 | 0 |
*
* */

import org.jonathanoliveira.utilities.Welder;

public class NOR_Gate extends BasicLogicGate {

    public NOR_Gate() {
        // sending to the constructor the proper component (inverter) type that we want to use in an AND gate
        super(ComponentType.INVERTER);
    }

    public NOR_Gate(int numInputs) {
        // sending the superclass constructor the component type that we want (inverter) and the number of buffers we want
        super(ComponentType.INVERTER, numInputs);
    }

    @Override
    public void wire() {
//        calling the Welder method that handles linear wiring of simple gates
        Welder.linearWiring(this);
    }
}
