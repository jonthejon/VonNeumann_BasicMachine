package org.jonathanoliveira.complex_components;

/**
 * This class will be the counter for all accessing the RAM and controlling the ALU.
 * It will have a 16bit number input and a 3bit function input that will control the outcome of this counter.
 * L = load -> will load a particular number into the counter
 * I = increment -> will increment the number stored inside the counter with 1
 * R = reset -> will set the counter to 0
 * L | I | R | res
 * 1 | 0 | 0 | load the counter with in[16]
 * 0 | 0 | 1 | reset the counter to 0000...
 * 0 | 1 | 0 | increment the counter with 1 (if 1111... -> 0000...)
 * 0 | 0 | 0 | nothing happens, the output of the counter maintains the same
 * ** notice that the function inputs must be set to 1 only one at a time
 */
public class Counter_16Bit {

    private boolean[] input;
    private boolean[] output;
    private boolean[] function;

//    private Register_Nbit
}
