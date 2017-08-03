package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.AND_Gate;
import org.jonathanoliveira.logic_gates.MUX_8Way_Gate;
import org.jonathanoliveira.utilities.Binary;

/**
 * This component will control how the program counter will behave given the inputs of the instructions and the output of the ALU
 */

public class CounterController {

    private boolean outL;
    private boolean outI;
    private boolean[] jumpBits;
    private boolean aluZ;
    private boolean aluN;

    private MUX_8Way_Gate mux;
    private AND_Gate andChan2;
    private AND_Gate andChan3;
    private AND_Gate andChan4;
    private Inverter invChan5;
    private Inverter invChan6;
    private Inverter invChan7;
    private Inverter invALUz;
    private Inverter invALUn;
    private Inverter invL;

    public CounterController() {
        this.jumpBits = new boolean[3];
        this.mux = new MUX_8Way_Gate(1);
        this.andChan2 = new AND_Gate(3);
        this.andChan3 = new AND_Gate(3);
        this.andChan4 = new AND_Gate();
        this.invChan5 = new Inverter();
        this.invChan6 = new Inverter();
        this.invChan7 = new Inverter();
        this.invALUz = new Inverter();
        this.invALUn = new Inverter();
        this.invL = new Inverter();
        wire();
    }

    public void setInputs(boolean[] jumpBits, boolean aluZ, boolean aluN) {
        if (jumpBits.length != this.jumpBits.length) throw new IllegalArgumentException();
        this.jumpBits = jumpBits;
        this.aluZ = aluZ;
        this.aluN = aluN;
        wire();
    }

    public boolean isOutL() {
//        System.out.println("L: " + outL);
        return outL;
    }

    public boolean isOutI() {
//        System.out.println("I: " + outI);
        return outI;
    }

    private void wire() {

        invALUz.setInput(aluZ);
        invALUn.setInput(aluN);

        // channel 8
        boolean[] c8 = new boolean[]{Binary.VOLTAGE.getValue()};

        // channel 1
        boolean[] c1 = new boolean[]{Binary.NO_VOLTAGE.getValue()};

        // channel 2
        andChan2.setInputs(new boolean[]{invALUz.getOutput(), invALUn.getOutput(), c8[0]});
        boolean[] c2 = new boolean[]{andChan2.getOutput()};

        // channel 3
        andChan3.setInputs(new boolean[]{aluZ, invALUn.getOutput(), c8[0]});
        boolean[] c3 = new boolean[]{andChan3.getOutput()};

        // channel 4
        andChan4.setInputs(new boolean[]{invALUn.getOutput(), c8[0]});
        boolean[] c4 = new boolean[]{andChan4.getOutput()};

//        System.out.println("c4: " + c4[0]);
        // channel 5
        invChan5.setInput(c4[0]);
        boolean[] c5 = new boolean[]{invChan5.getOutput()};
//        System.out.println("c5: " + c5[0]);

        // channel 6
        invChan6.setInput(c3[0]);
        boolean[] c6 = new boolean[]{invChan6.getOutput()};

        // channel 7
        invChan7.setInput(c2[0]);
        boolean[] c7 = new boolean[]{invChan7.getOutput()};


        boolean[][] muxIn = new boolean[8][1];
        muxIn[0] = c1;
        muxIn[1] = c2;
        muxIn[2] = c3;
        muxIn[3] = c4;
        muxIn[4] = c5;
        muxIn[5] = c6;
        muxIn[6] = c7;
        muxIn[7] = c8;
        mux.setGate(muxIn, jumpBits);

        invL.setInput(mux.getOutput()[0]);

//        System.out.println("L: " + outL);
        outL = mux.getOutput()[0];
        outI = invL.getOutput();
    }
}
