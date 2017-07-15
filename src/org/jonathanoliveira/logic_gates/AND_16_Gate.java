package org.jonathanoliveira.logic_gates;

/** This gate works the same way as a normal AND gate but takes 2 groups of 16 bits of input and output a 16 bit group
 * |        a         |        b         |       out        |
 * | 0000000000000000 | 0000000000000000 | 0000000000000000 |
 * | 0000000000000000 | 1111111111111111 | 0000000000000000 |
 * | 1111111111111111 | 1111111111111111 | 1111111111111111 |
 * | 1010101010101010 | 0101010101010101 | 0000000000000000 |
 * | 0011110011000011 | 0000111111110000 | 0000110011000000 |
 * | 0001001000110100 | 1001100001110110 | 0001000000110100 |
 */

public class AND_16_Gate implements Inputable {



    @Override
    public int getNumInputs() {
        return 0;
    }

    @Override
    public void setInputs(boolean[] inputs) {

    }

    @Override
    public boolean getOutput() {
        return false;
    }
}
