package org.jonathanoliveira.logic_gates;

import org.jonathanoliveira.basic_components.Relay;
import org.jonathanoliveira.basic_components.Configurable;
import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.utilities.Binary;

import java.util.Arrays;

/**
 * This is the superclass for all Logic Gates.
 * In here you'll find all the common behavior of the logic gates.
 */

public abstract class BasicLogicGate implements Inputable {

    // private field to hold the components that make up this gate
    // Configurable array with the size set by the constructor
    public Configurable[] components;
//    private field to hold the inputs values of this logic gate
    private boolean[] inputs;
    // private field to hold the output of this gate
    private boolean output;

//    this enum holds all the possible types of basic components (relays) used to create logic gates
    enum ComponentType { RELAY, INVERTER }

    // constructor (default is a 2 input OR gate)
    // this constructor has a component type argument in order to correctly create the proper logic gate.
    BasicLogicGate(ComponentType componentType) {
        //    initiate the field array to fit 2 relays
        components = new Configurable[2];
//        setting the inputs array to have the same number of inputs of this gate
        this.inputs = new boolean[getNumInputs()];
//        filling the input arrays initially to have all false inputs
        Arrays.fill(this.inputs, Binary.NO_VOLTAGE.getValue());

        // switch statement to handle the proper component selected
        switch (componentType) {
            // gate must be constructed using relays, instead of inverters.
            case RELAY:
                //    create first relay and set it to position 0
                components[0] = new Relay();
                //    create second relay and set it to position 1
                components[1] = new Relay();
                break;

            // gate must be constructed using inverters, instead of relays.
            case INVERTER:
                //    create first inverter and set it to position 0
                components[0] = new Inverter();
                //    create second inverter and set it to position 1
                components[1] = new Inverter();
                break;

        }
//        calling the wire method so it can preset this gate with the initial values of the inputs
        this.wire();
    }

    // constructor (3 and over input AND gate)
    // receives an int that tells how many UnitComponents that it must have.
    BasicLogicGate(ComponentType componentType, int numInputs) {
        //  check to see if the number of components if bigger than 2. If true, proceed.
        if (numInputs > 2) {
            //    initiate the field array
            components = new Configurable[numInputs];

//        setting the inputs array to have the same number of inputs of this gate
            this.inputs = new boolean[getNumInputs()];
//        filling the input arrays initially to have all false inputs
            Arrays.fill(this.inputs, Binary.NO_VOLTAGE.getValue());

            //    loop for the number of requested relays
            for (int i = 0; i < numInputs; i++) {
                // initiate a new relay and put the relay inside the array
                // switch statement to handle the proper component selected
                switch (componentType) {
                    // gate must be constructed using relays, instead of inverters.
                    case RELAY:
                        components[i] = new Relay();
                        break;
                    // gate must be constructed using inverters, instead of relays.
                    case INVERTER:
                        components[i] = new Inverter();
                        break;
                }
            }
        // if there is an invalid number of components, an exception must be thrown
        } else {
            throw new IllegalArgumentException();
        }
//        calling the wire method so it can preset this gate with the initial values of the inputs
        this.wire();
    }

    // method that returns the number of inputs necessary to operate this gate
    @Override
    public int getNumInputs() {
    //    return the size of the array, since every relay has an input
        return components.length;
    }

    // method that receives an array of inputs and set the relays with the proper values
    public void setInputs(boolean[] inputs) {
        // check to see if the number of inputs is different then the supported
        // if not, throw an exception
        if (inputs.length != getNumInputs()) throw new IllegalArgumentException();

//        setting the input values with the given values
        this.inputs = inputs;
        // after checking, call a method (array of inputs) that will wire all components with inputs and voltages in order to produce the gate behavior
        this.wire();
        /*setAndWireComponents(inputs);*/
    }

    @Override
    public boolean[] getInputs() {
        return this.inputs;
    }

    // returns the value of the output
    @Override
    public boolean getOutput() {
        return this.output;
    }

    // sets the value of the output. Can only be called from within this class.
    @Override
    public void setOutput(boolean output) {
        this.output = output;
    }

}
