package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.logic_gates.NOR_Gate;

/**
 * Implements a classic R-S fLip-fLop.
 *  S | R | Q | !Q
 *  1 | 0 | 1 | 0
 *  0 | 1 | 0 | 1
 *  0 | 0 | Q | !Q
 *  1 | 1 | NOT ALLOWED
 */

public class R_S_FlipFLop {

    private boolean set;
    private boolean reset;
    private boolean Q;
    private boolean Qbar;

    private NOR_Gate setNor;
    private NOR_Gate resetNor;

    public R_S_FlipFLop() {
        setNor = new NOR_Gate();
        resetNor = new NOR_Gate();
        setNor.setInputs(new boolean[]{set, false});
        resetNor.setInputs(new boolean[]{reset, setNor.getOutput()});
        setNor.setInputs(new boolean[]{set, resetNor.getOutput()});
        resetNor.setInputs(new boolean[]{reset, setNor.getOutput()});
        Q = resetNor.getOutput();
        Qbar = setNor.getOutput();
    }

    public void set(boolean set) {
        if (set && reset) throw new IllegalArgumentException();
        this.set = set;
        wire();
    }

    public void reset(boolean reset) {
        if (set && reset) throw new IllegalArgumentException();
        this.reset = reset;
        wire();
    }

    public boolean Q() {
        return Q;
    }

    public boolean Qbar() {
        return Qbar;
    }

    private void wire() {
        setNor.setInputs(new boolean[]{set, resetNor.getOutput()});
        resetNor.setInputs(new boolean[]{reset, setNor.getOutput()});
        setNor.setInputs(new boolean[]{set, resetNor.getOutput()});
        resetNor.setInputs(new boolean[]{reset, setNor.getOutput()});
        Q = resetNor.getOutput();
        Qbar = setNor.getOutput();
    }
}
