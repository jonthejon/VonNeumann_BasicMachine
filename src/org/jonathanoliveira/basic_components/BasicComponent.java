package org.jonathanoliveira.basic_components;

/*
* This is the Superclass of all basic components.
* In our case, they are Relays and Inverters.
* Each one of them will have some kind of peculiar behavior that should be addressed on
* their own subclasses.
* */

abstract class BasicComponent implements Configurable {

    private boolean input;
    //    the default value of voltage is true, unless else defined by a Logic gate.
    private boolean voltage = true;
    boolean output;

    @Override
    public void setVoltage(boolean voltage) {
        this.voltage = voltage;
    }

    @Override
    public boolean getVoltage() {
        return this.voltage;
    }

    @Override
    public void setInput(boolean input) {
        this.input = input;
    }

    @Override
    public boolean getInput() {
        return this.input;
    }

    @Override
    public boolean getOutput() {
        setOutput();
        return this.output;
    }

//    this method implements the behavior of a particular component
//    this is how we are defining how a particular component should be wired
    abstract void setOutput();

}
