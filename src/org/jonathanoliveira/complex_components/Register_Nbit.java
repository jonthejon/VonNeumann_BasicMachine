package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.AND_Gate;

import java.util.Arrays;

/**
 * This is the 16-Bit Register_1Bit.
 * built using the 1-bit register.
 * So the truth table of the 1-bit register maintains but with 16bits
 */

public class Register_Nbit {

    private int bitSize;
    private boolean[] data;
    private boolean write;
    private boolean[] Q;

    private Register_1Bit[] registers;

    public Register_Nbit(int bitSize) {
        this.bitSize = bitSize;
        registers = new Register_1Bit[bitSize];
        for (int i = 0; i < bitSize; i++) {
            registers[i] = new Register_1Bit();
        }
        data = new boolean[bitSize];
        Q = new boolean[bitSize];
        wire();
    }

    public boolean[] Q() {
        return Q;
    }

    public void data(boolean[] data) {
        if (data.length != bitSize) throw new IllegalArgumentException();
        this.data = data;
        wire();
    }

    public void write(boolean write) {
        this.write = write;
    }

    private void wire() {
        for (int bit = 0; bit < bitSize; bit++) {
            registers[bit].write(this.write);
            registers[bit].data(data[bit]);
            registers[bit].write(write);
            Q[bit] = registers[bit].Q();
        }
    }
}
