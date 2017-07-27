package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.DMUX_8Way_Gate;
import org.jonathanoliveira.logic_gates.MUX_8Way_Gate;

/**
 * Ram chip.
 * This chip stores 4096 different 16bit values
 */
public class RAM_4Kx16 {

    private int bitSize;
    private int numRams;
    private boolean[] dataIn;
    private boolean[] dataOut;
    private boolean write;
    private boolean[] address;

    private RAM_512x16[] rams;
    private DMUX_8Way_Gate dmux;
    private MUX_8Way_Gate mux;

    public RAM_4Kx16() {
        this.bitSize = 16;
        this.numRams = 8;
        this.address = new boolean[12];
        this.rams = new RAM_512x16[numRams];
        for (int i = 0; i < numRams; i++) {
            this.rams[i] = new RAM_512x16();
        }
        this.dataIn = new boolean[bitSize];
        this.dataOut = new boolean[bitSize];
        this.dmux = new DMUX_8Way_Gate(1);
        this.mux = new MUX_8Way_Gate(bitSize);
    }

    public boolean[] dataOut() {
        return dataOut;
    }

    public void dataIn(boolean[] dataIn) {
        if (dataIn.length != bitSize) throw new IllegalArgumentException();
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
        boolean[] highAddress = new boolean[]{address[0], address[1], address[2]};
        boolean[] lowAddress = new boolean[]{address[3], address[4], address[5], address[6], address[7], address[8], address[9], address[10], address[11]};
        this.dmux.setGate(new boolean[]{this.write}, highAddress);
        boolean[][] muxInput = new boolean[numRams][bitSize];
        for (int r = 0; r < numRams; r++) {
            this.rams[r].write(this.dmux.getOutput()[r][0]);
            this.rams[r].dataIn(dataIn);
            this.rams[r].address(lowAddress);
            muxInput[r] = this.rams[r].dataOut();
        }
        this.mux.setGate(muxInput, highAddress);
        this.dataOut = this.mux.getOutput();
    }
}
