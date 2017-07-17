package org.jonathanoliveira.logic_gates;

/*
* All gates are made of components, no matter how many.
* A NAND gate must be able to receive a certain number of inputs and come out with the proper output.
*
* So, in essence, the behavior of a NAND gate is the following:
* if (ALL INPUTS): true, then OUTPUT ==  false
* if (AT LEAST 1 INPUT): false, then OUTPUT ==  true
*
*    NAND | 0 | 1 |
*    --------------
*      0  | 1 | 1 |
*    --------------
*      1  | 1 | 0 |
*
* */

import org.jonathanoliveira.utilities.Welder;

class NAND_Gate extends BasicLogicGate {

    NAND_Gate() {
        // sending to the constructor the proper component (inverter) type that we want to use in an NAND gate
        super(ComponentType.INVERTER);
    }

    NAND_Gate(int numInputs) {
        // sending the superclass constructor the component type that we want (inverter) and the number of buffers we want
        super(ComponentType.INVERTER, numInputs);
    }

    @Override
    public void wire() {
//        calling the Welder method that handles parallel wiring of simple gates
        Welder.parallelWiring(this);
    }
}
