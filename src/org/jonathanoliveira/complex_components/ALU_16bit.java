package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.*;

/**
 * This class will be the ALU_16bit of the computer.
 * I'm using the ALU_16bit architecture of the Nand2Tetris course.
 |zx |nx |zy |ny | f |no |       |zr |ng |def
 | 1 | 0 | 1 | 0 | 1 | 0 | >>>>> | 1 | 0 |[0]
 | 1 | 1 | 1 | 1 | 1 | 1 | >>>>> | 0 | 0 |[1]
 | 1 | 1 | 1 | 0 | 1 | 0 | >>>>> | 0 | 1 |[-1]
 | 0 | 0 | 1 | 1 | 0 | 0 | >>>>> | 0 | 0 |[x]
 | 1 | 1 | 0 | 0 | 0 | 0 | >>>>> | 0 | 0 |[y]
 | 0 | 0 | 1 | 1 | 0 | 1 | >>>>> | 0 | 1 |[!x]
 | 1 | 1 | 0 | 0 | 0 | 1 | >>>>> | 0 | 1 |[!y]
 | 0 | 0 | 1 | 1 | 1 | 1 | >>>>> | 0 | 1 |[-x]
 | 1 | 1 | 0 | 0 | 1 | 1 | >>>>> | 0 | 1 |[-y]
 | 0 | 1 | 1 | 1 | 1 | 1 | >>>>> | 0 | 0 |[x+1]
 | 1 | 1 | 0 | 1 | 1 | 1 | >>>>> | 0 | 0 |[y+1]
 | 0 | 0 | 1 | 1 | 1 | 0 | >>>>> | 0 | 0 |[x-1]
 | 1 | 1 | 0 | 0 | 1 | 0 | >>>>> | 0 | 0 |[y-1]
 | 0 | 0 | 0 | 0 | 1 | 0 | >>>>> | 0 | 0 |[x+y]
 | 0 | 1 | 0 | 0 | 1 | 1 | >>>>> | 0 | 0 |[x-y]
 | 0 | 0 | 0 | 1 | 1 | 1 | >>>>> | 0 | 1 |[y-x]
 | 0 | 0 | 0 | 0 | 0 | 0 | >>>>> | 0 | 0 |[x&y]
 | 0 | 1 | 0 | 1 | 0 | 1 | >>>>> | 0 | 0 |[x|y]
 */

public class ALU_16bit {

    private int numOfBits;
    private int numFuncBits;

    private boolean[] x;
    private Nbit_NOT_Gate not1X;
    private Nbit_NOT_Gate not2X;
    private Nbit_AND_Gate andX;
    private MUX_4Way_Gate chooseX;

    private boolean[] y;
    private Nbit_NOT_Gate not1Y;
    private Nbit_NOT_Gate not2Y;
    private Nbit_AND_Gate andY;
    private MUX_4Way_Gate chooseY;

    private N_BitAdder adder;
    private Nbit_AND_Gate aluAnd;
    private MUX_Gate sumAndMux;

    private Nbit_NOT_Gate negOutput;
    private MUX_Gate outNegMux;

    private OR_Gate zrOrGate;
    private Inverter zrInv;
    private AND_Gate ngAndGate;

    private boolean[] function;
    private boolean[] output;
    private boolean zr;
    private boolean ng;

    public ALU_16bit() {
        this.numOfBits = 16;
        this.numFuncBits = 6;

        this.x = new boolean[this.numOfBits];
        this.not1X = new Nbit_NOT_Gate(this.numOfBits);
        this.not2X = new Nbit_NOT_Gate(this.numOfBits);
        this.andX = new Nbit_AND_Gate(this.numOfBits);
        this.chooseX = new MUX_4Way_Gate(this.numOfBits);

        this.y = new boolean[this.numOfBits];
        this.not1Y = new Nbit_NOT_Gate(this.numOfBits);
        this.not2Y = new Nbit_NOT_Gate(this.numOfBits);
        this.andY = new Nbit_AND_Gate(this.numOfBits);
        this.chooseY = new MUX_4Way_Gate(this.numOfBits);

        this.adder = new N_BitAdder(this.numOfBits);
        this.aluAnd = new Nbit_AND_Gate(this.numOfBits);
        this.sumAndMux = new MUX_Gate(this.numOfBits);

        this.negOutput = new Nbit_NOT_Gate(this.numOfBits);
        this.outNegMux = new MUX_Gate(this.numOfBits);

        this.zrOrGate = new OR_Gate(this.numOfBits);
        this.zrInv = new Inverter();
        this.ngAndGate = new AND_Gate();

        this.function = new boolean[this.numFuncBits];
        this.output = new boolean[this.numOfBits];
    }

    public int getBitSize() {
        return this.numOfBits;
    }

    public void setInputs(boolean[] x, boolean[] y, boolean[] function) {
        if (x.length != getBitSize() || x.length != y.length || function.length != this.numFuncBits) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
        this.function = function;
        this.wire();
    }

    public boolean[] getInputX() {
        return this.x;
    }

    public boolean[] getInputY() {
        return this.y;
    }

    public boolean getZr() {
        return this.zr;
    }

    public boolean getNg() {
        return this.ng;
    }

    public boolean[] getOutput() {
        return this.output;
    }

    public void wire() {

        this.not1X.setInputs(this.x);
        this.andX.setInputs(this.x, this.not1X.getOutput());
        this.not2X.setInputs(this.andX.getOutput());
        boolean[][] xMuxIn = new boolean[4][16];
        xMuxIn[0] = this.x;
        xMuxIn[1] = this.not1X.getOutput();
        xMuxIn[2] = this.andX.getOutput();
        xMuxIn[3] = this.not2X.getOutput();
        this.chooseX.setGate(xMuxIn, new boolean[]{this.function[0], this.function[1]});

        this.not1Y.setInputs(this.y);
        this.andY.setInputs(this.y, this.not1Y.getOutput());
        this.not2Y.setInputs(this.andY.getOutput());
        boolean[][] yMuxIn = new boolean[4][16];
        yMuxIn[0] = this.y;
        yMuxIn[1] = this.not1Y.getOutput();
        yMuxIn[2] = this.andY.getOutput();
        yMuxIn[3] = this.not2Y.getOutput();
        this.chooseY.setGate(yMuxIn, new boolean[]{this.function[2], this.function[3]});

        this.x = this.chooseX.getOutput();
        this.y = this.chooseY.getOutput();

        this.adder.setInputs(this.x, this.y);
        this.aluAnd.setInputs(this.x, this.y);
        this.sumAndMux.setGate(this.aluAnd.getOutput(), this.adder.getOutput(), this.function[4]);

        this.negOutput.setInputs(this.sumAndMux.getOutput());
        this.outNegMux.setGate(this.sumAndMux.getOutput(), this.negOutput.getOutput(), this.function[5]);

        this.output = this.outNegMux.getOutput();

        this.zrOrGate.setInputs(this.output);
        this.zrInv.setInput(this.zrOrGate.getOutput());
        this.zr = this.zrInv.getOutput();

        this.ngAndGate.setInputs(new boolean[]{this.output[0], true});
        this.ng = this.ngAndGate.getOutput();
    }
}
