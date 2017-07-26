package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.DMUX_8Way_Gate;
import org.jonathanoliveira.logic_gates.MUX_8Way_Gate;

/**
 * Ram chip.
 * This chip stores 8 different 1bit values
 */

public class RAM_8x1 {

    private int bitSize;
    private int numRegisters;
    private boolean dataIn;
    private boolean dataOut;
    private boolean write;
    private boolean[] address;

    private Register_1Bit[] registers;
    private DMUX_8Way_Gate dmux;
    private MUX_8Way_Gate mux;

    public RAM_8x1() {
        this.bitSize = 1;
        this.numRegisters = 8;
        this.address = new boolean[3];
        this.registers = new Register_1Bit[numRegisters];
        for (int i = 0; i < numRegisters; i++) {
            this.registers[i] = new Register_1Bit();
        }
        this.dmux = new DMUX_8Way_Gate(1);
        this.mux = new MUX_8Way_Gate(bitSize);
    }

    public boolean dataOut() {
        return dataOut;
    }

    public void dataIn(boolean dataIn) {
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
        this.dmux.setGate(this.write, this.address);
        boolean[][] muxInput = new boolean[numRegisters][bitSize];
        for (int r = 0; r < numRegisters; r++) {
            this.registers[r].write(this.dmux.getOutput()[r][0]);
            this.registers[r].data(dataIn);
            muxInput[r][0] = this.registers[r].Q();
        }
        this.mux.setGate(muxInput, this.address);
        this.dataOut = this.mux.getOutput()[0];
    }
}
