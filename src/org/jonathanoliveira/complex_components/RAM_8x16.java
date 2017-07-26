package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.DMUX_8Way_Gate;
import org.jonathanoliveira.logic_gates.MUX_8Way_Gate;

/**
 * Ram chip.
 * This chip stores 8 different 16bit values
 */
public class RAM_8x16 {

    private int numRams;
    private boolean[] dataIn;
    private boolean[] dataOut;
    private boolean write;
    private boolean[] address;

    private RAM_8x1[] rams;

    public RAM_8x16() {
        this.numRams = 16;
        this.address = new boolean[3];
        this.rams = new RAM_8x1[numRams];
        for (int i = 0; i < numRams; i++) {
            this.rams[i] = new RAM_8x1();
        }
        this.dataIn = new boolean[numRams];
        this.dataOut = new boolean[numRams];
    }

    public boolean[] dataOut() {
        return dataOut;
    }

    public void dataIn(boolean[] dataIn) {
        if (dataIn.length != numRams) throw new IllegalArgumentException();
        this.dataIn = dataIn;
    }

    public void write(boolean write) {
        this.write = write;
    }

    public void address(boolean[] address) {
        if (address.length != this.address.length) throw new IllegalArgumentException();
        this.address = address;
        wire();
    }

    private void wire() {
        boolean[] output = new boolean[numRams];
        for (int r = 0; r < numRams; r++) {
            this.rams[r].write(this.write);
            this.rams[r].dataIn(this.dataIn[r]);
            this.rams[r].address(this.address);
            output[r] = this.rams[r].dataOut();
        }
        this.dataOut = output;
    }
}
