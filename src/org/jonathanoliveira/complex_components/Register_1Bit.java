package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.AND_Gate;

/**
 * This is the 1-Bit Register_1Bit.
 * From this class we'll implement all memories inside our computer.
 * D | C | Q
 * 0 | 1 | 0
 * 1 | 1 | 1
 * x | 0 | Q
 */

public class Register_1Bit {

    private boolean data;
    private boolean write;

    private AND_Gate dataAnd;
    private AND_Gate resetAnd;
    private Inverter inverter;
    private R_S_FlipFLop flipFLop;

    public Register_1Bit() {
        this.dataAnd = new AND_Gate();
        this.resetAnd = new AND_Gate();
        this.inverter = new Inverter();
        this.flipFLop = new R_S_FlipFLop();
        wire();
    }

    public boolean Q() {
        return this.flipFLop.Q();
    }

    public void data(boolean data) {
        this.data = data;
        wire();
    }

    public void write(boolean write) {
        this.write = write;
    }

    private void wire() {
        this.inverter.setInput(this.data);
        this.dataAnd.setInputs(new boolean[]{this.data, this.write});
        this.resetAnd.setInputs(new boolean[]{this.inverter.getOutput(), this.write});
        this.flipFLop.inputs(this.dataAnd.getOutput(), this.resetAnd.getOutput());
    }
}
