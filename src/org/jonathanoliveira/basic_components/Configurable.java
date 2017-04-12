package org.jonathanoliveira.basic_components;

/**
 * This Interface will define the contract of all single unit components used in
 * a particular logical gate.
 *
 * It will allow us to use different kinds of components in the construction
 * of logic gates.
 *
 * This Interface will also be useful in case later when we want to implement a computer using
 * vacuum tubes or transistors instead of relays.
 *
 * All components should have getter and setter methods for your 3 basic information
 * holders (voltage, input and output) in order for the logical gates to connect them
 * in all possible ways.
 */
public interface Configurable {

//    getter and setter methods for the Voltage of the component
//    voltage may be data in some configurations of components
    void setVoltage(boolean voltage);
    boolean getVoltage();

//    getter and setter methods for the input of the component
    void setInput(boolean input);
    boolean getInput();

//    getter method to check the output of the component
    boolean getOutput();

}
