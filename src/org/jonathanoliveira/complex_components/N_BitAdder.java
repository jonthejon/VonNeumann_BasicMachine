package org.jonathanoliveira.complex_components;

/**
 * This component will perform the complete addition of any number of bits we need.
 * It will accomplish this by wiring in series the necessary Full Adders.
 * Each Full Adder will be responsible for 1 bit of the binary number.
 * The carry_in of the first adder will set to zero, since the first two bits to be summed will never have a carry = 1
 * The sum_out of the first adder will be saved as a partial result of the total sum and
 * the carry_out will be set as the carry_in for the second adder.
 * The total output of this n bit adder will be all the outputs of the inner full adders + the carry_out of the last adder.
 */

public class N_BitAdder {



}
