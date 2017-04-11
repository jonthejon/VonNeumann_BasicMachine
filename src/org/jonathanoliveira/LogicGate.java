package org.jonathanoliveira;

/**
 * This is the superclass for all Logic Gates.
 * In here you'll find all the common behavior of the logic gates.
 * In our case, they will be AND, OR, NAND and NOR.
 */

abstract class LogicGate implements Inputable {

    // private field to hold the components that make up this gate
    // Configurable array with the size set by the constructor
    Configurable[] components;
    // private field to hold the output of this gate
    boolean output;

//    this enum holds all the possible types of basic components (relays) used to create logic gates
    enum ComponentType { BUFFER, INVERTER }

    // constructor (default is a 2 input OR gate)
    // this constructor has a component type argument in order to correctly create the proper logic gate.
    LogicGate(ComponentType componentType) {
        //    initiate the field array to fit 2 relays
        components = new Configurable[2];
        // switch statement to handle the proper component selected
        switch (componentType) {
            // gate must be constructed using buffers, instead of inverters.
            case BUFFER:
                //    create first relay and set it to position 0
                components[0] = new Buffer();
                //    create second relay and set it to position 1
                components[1] = new Buffer();
                break;

            // gate must be constructed using buffers, instead of inverters.
            case INVERTER:
                //    create first relay and set it to position 0
                components[0] = new Inverter();
                //    create second relay and set it to position 1
                components[1] = new Inverter();
                break;

        }
    }

    // constructor (3 and over input AND gate)
    // receives an int that tells how many UnitComponents (relays, in our case) that it must have.
    LogicGate(ComponentType componentType, int numInputs) {
        //  check to see if the number of components if bigger than 2. If true, proceed.
        if (numInputs > 2) {
            //    initiate the field array
            components = new Configurable[numInputs];
            //    loop for the number of requested relays
            for (int i = 0; i < numInputs; i++) {
                //      initiate a new relay and put the relay inside the array
                // switch statement to handle the proper component selected
                switch (componentType) {
                    // gate must be constructed using buffers, instead of inverters.
                    case BUFFER:
                        components[i] = new Buffer();
                        break;
                    // gate must be constructed using buffers, instead of inverters.
                    case INVERTER:
                        components[i] = new Inverter();
                        break;
                }
            }
        // if there is an invalid number of components, an exception must be thrown
        } else {
            throw new IllegalArgumentException();
        }
    }

    // method that returns the number of inputs necessary to operate this gate
    @Override
    public int getNumInputs() {
    //    return the size of the array, since every relay has an input
        return components.length;
    }

    // method that receives an array of inputs and set the relays with the proper values
    @Override
    public void setInputs(boolean[] inputs) {
        // check to see if the number of inputs is different then the supported
        // if not, throw an exception
        if (inputs.length != getNumInputs()) throw new IllegalArgumentException();

        // after checking, call a method (array of inputs) that will wire all components with inputs and voltages in order to produce an AND gate behavior
        setAndWireComponents(inputs);
    }

    // returns the value of the output
    @Override
    public boolean getOutput() {
        return this.output;
    }

    // sets the value of the output. Can only be called from within this class.
    void setOutput(boolean output) {
        this.output = output;
    }

    // method that wires all components with inputs and voltages in order to produce an AND gate behavior
    // each different logic gate will have a unique implementation of this method
    abstract void setAndWireComponents(boolean[] inputs);

}
