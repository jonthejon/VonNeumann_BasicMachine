package org.jonathanoliveira.logic_gates;

/**
 * This Interface will define the contract of all logic gates used in this project.
 *
 * This Interface should be useful in case later we want to construct more complex
 * structures that are composed of different logic gates.
 *
 * All gates should have getter method for its output. Also they should have a method
 * that shows how many inputs it receives and a method that actually handles
 * the inputs sent to it.
 */

public interface Inputable {

//    returns the number of inputs this logic gate has
    int getNumInputs();

//    handles the inputs sent to this logic gate
    void setInputs(boolean[] inputs);

//    getter method to check the output of the component
    boolean getOutput();

}
