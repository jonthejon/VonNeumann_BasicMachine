package org.jonathanoliveira.basic_components;

/*
* This is the Superclass of all basic components.
* In our case, they are Relays and Inverters.
* Each one of them will have some kind of peculiar behavior that should be addressed on
* their own subclasses.
* */

import org.jonathanoliveira.utilities.Binary;

public abstract class BasicComponent implements Configurable {

    public static int counter;

    private boolean input = Binary.VOLTAGE.getValue();
    private boolean voltage = Binary.VOLTAGE.getValue();
    private boolean output;

    BasicComponent() {
        counter++;
        wire();
    }

    @Override
    public void setVoltage(boolean voltage) {
        this.voltage = voltage;
        this.wire();
    }

    @Override
    public boolean getVoltage() {
        return this.voltage;
    }

    @Override
    public void setInput(boolean input) {
        this.input = input;
        this.wire();
    }

    @Override
    public boolean getInput() {
        return this.input;
    }

    @Override
    public boolean getOutput() {
        return this.output;
    }

    @Override
    public void setOutput(boolean output) {
        this.output = output;
    }

}
