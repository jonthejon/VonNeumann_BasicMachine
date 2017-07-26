package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.AND_Gate;

/**
 * This is the 1-Bit Register_1Bit.
 * From this class we'll implement all memories inside our computer.
 */

public class Register_1Bit {

    private boolean data;
    private boolean clock;

    private AND_Gate dataAnd;
    private AND_Gate resetAnd;
    private Inverter inverter;
    private R_S_FlipFLop flipFLop;

    public Register_1Bit() {
        dataAnd = new AND_Gate();
        resetAnd = new AND_Gate();
        inverter = new Inverter();
        flipFLop = new R_S_FlipFLop();
        wire();
    }

    public boolean Q() {
        return flipFLop.Q();
    }

    public void data(boolean data) {
        this.data = data;
        wire();
    }

    public void clock(boolean clock) {
        this.clock = clock;
        wire();
    }

    private void wire() {
        inverter.setInput(data);
        dataAnd.setInputs(new boolean[]{data, clock});
        resetAnd.setInputs(new boolean[]{inverter.getOutput(), clock});
        flipFLop.set(dataAnd.getOutput());
        flipFLop.reset(resetAnd.getOutput());
    }
}
