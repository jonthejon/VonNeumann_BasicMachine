package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.MUX_Gate;
import org.jonathanoliveira.logic_gates.Nbit_AND_Gate;
import org.jonathanoliveira.logic_gates.Nbit_NOT_Gate;

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
public class Counter_Nbit {

    private int bitSize;
    private boolean L;
    private boolean I;
    private boolean R;
    private boolean[] input;
    private boolean[] output;

    private Nbit_NOT_Gate inverter;
    private Nbit_AND_Gate andGate;

    private Register_Nbit register;
    private N_BitIncrementer incrementer;
    private MUX_Gate incMux;

    public Counter_Nbit(int bitSize) {
        this.bitSize = bitSize;
        this.output = new boolean[bitSize];
        this.input = new boolean[bitSize];
        this.register = new Register_Nbit(bitSize);
        this.incrementer = new N_BitIncrementer(bitSize);
        this.incMux = new MUX_Gate(bitSize);
        this.inverter = new Nbit_NOT_Gate(bitSize);
        this.andGate = new Nbit_AND_Gate(bitSize);
//        this.L = false;
//        this.I = true;
//        this.R = false;
    }

    public boolean[] getOutput() {
//        wire();
        return output;
    }

    public void setCounter(boolean[] input, boolean[] function) {
//        int testFunc = 0;
//        for (boolean bool : function) {
//            if (bool) testFunc++;
//        }
//        if (testFunc > 1 || input.length != bitSize || function.length != 3) throw new IllegalArgumentException();
        this.input = input;
        setFunction(function);
//        this.L = function[0];
//        this.I = function[1];
//        this.R = function[2];
    }

    public void setFunction(boolean[] function) {
        int testFunc = 0;
        for (boolean bool : function) {
            if (bool) testFunc++;
        }
        if (testFunc > 1 || input.length != bitSize || function.length != 3) throw new IllegalArgumentException();
        this.L = function[0];
        this.I = function[1];
        this.R = function[2];
        wire();
    }

    private void wire() {

        this.inverter.setInputs(this.input);
        this.andGate.setInputs(this.input, this.inverter.getOutput());

        this.register.write(this.R);
        this.register.data(this.andGate.getOutput());

        this.register.write(this.L);
        this.register.data(this.input);

        this.incrementer.setInput(this.register.Q());
        this.incMux.setGate(this.register.Q(), this.incrementer.getOutput(), this.I);
        this.register.write(this.I);
        this.register.data(this.incMux.getOutput());
        this.output = this.incMux.getOutput();
    }
}
