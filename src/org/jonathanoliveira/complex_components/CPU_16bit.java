package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.MUX_Gate;
import org.jonathanoliveira.utilities.Converter;

/**
 * This will be our computer.
 * It will have a ALU, a ROM containing all program instructions and a RAM containing all data.
 */

public class CPU_16bit {

    private Counter_Nbit counter;
    private RAM_16Kx16 ROM;
    private RAM_16Kx16 RAM;
    private MUX_Gate mux_ROM;
    private MUX_Gate mux_reg_a;
    private MUX_Gate mux_reg_d;
    private MUX_Gate mux_RAM;
    private MUX_Gate mux_M_A;
    private Register_Nbit register_a;
    Register_Nbit register_d;
    private ALU_16bit ALU;
    private Inverter inv_reg_a;
    private int bitSize;
    private int numOfInstructions;

    private boolean[] dummy;

    public CPU_16bit() {
        this.counter = new Counter_Nbit(14);
        this.ROM = new RAM_16Kx16();
        this.RAM = new RAM_16Kx16();
        this.mux_ROM = new MUX_Gate(16);
        this.mux_M_A = new MUX_Gate(16);
        this.mux_reg_a = new MUX_Gate(1);
        this.mux_reg_d = new MUX_Gate(1);
        this.mux_RAM = new MUX_Gate(1);
        this.register_a = new Register_Nbit(16);
        this.register_d = new Register_Nbit(16);
        this.inv_reg_a = new Inverter();
        this.ALU = new ALU_16bit();
        this.bitSize = 16;
        this.numOfInstructions = 0;
        this.dummy = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    public Register_Nbit getRegister_d() {
        return register_d;
    }

    public int getBitSize() {
        return this.bitSize;
    }

    public int getRamSize() {
        return this.RAM.getStorage();
    }

    public int getRomSize() {
        return this.ROM.getStorage();
    }

    public void addInstruction_test(boolean[] instruction) {
        if (instruction.length != getBitSize()) throw new IllegalArgumentException();
        this.ROM.write(true);
        this.ROM.dataIn(instruction);
        this.ROM.address(this.counter.getOutput());
        this.ROM.write(false);
        incClock_test();
        numOfInstructions++;
    }

    public void addData_test(boolean[] data) {
        if (data.length != getBitSize()) throw new IllegalArgumentException();
        this.RAM.write(true);
        this.RAM.dataIn(data);
        this.RAM.address(this.counter.getOutput());
        this.RAM.write(false);
        incClock_test();
    }

    public void addSingleData(boolean[] address, boolean[] data) {
        if (data.length != getBitSize()) throw new IllegalArgumentException();
        this.RAM.write(true);
        this.RAM.dataIn(data);
        this.RAM.address(address);
        this.RAM.write(false);
    }

    public void resetClock_test() {
        counter.setFunction(Converter.convertToBooleans(new int[]{0,0,1}));
    }

    public void incClock_test() {
        counter.setFunction(Converter.convertToBooleans(new int[]{0,1,0}));
    }

    public boolean[] fetchInstruction_test() {
        this.ROM.address(this.counter.getOutput());
        incClock_test();
        return this.ROM.dataOut();
    }

    public boolean[] fetchData_test() {
        this.RAM.address(this.counter.getOutput());
        incClock_test();
        return this.RAM.dataOut();
    }

    public void run_test() {
        int control = 0;
        while (control < numOfInstructions) {
            control++;
//            getting the instruction from the ROM
            boolean[] instruction = fetchInstruction_test();

//            decomposing the instruction in case we have a C instruction
            boolean type = instruction[0];
            boolean ALUrest = instruction[3];
            boolean[] ALUControl = new boolean[]{instruction[4], instruction[5], instruction[6], instruction[7], instruction[8], instruction[9]};
            boolean[] destBits = new boolean[]{instruction[10], instruction[11], instruction[12]};
            boolean[] jumpBits = new boolean[]{instruction[13], instruction[14], instruction[15]};

//            sending the type bit into an inverter
            inv_reg_a.setInput(type);

//            the first mux gate must choose between the CPU output or the ROM output
            mux_ROM.setGate(ALU.getOutput(), instruction, inv_reg_a.getOutput()); // CORRECT!

//            if the type is 0, then we will use the inverter value instead of the destination value
            mux_reg_a.setGate(new boolean[]{inv_reg_a.getOutput()}, new boolean[]{destBits[0]}, type);

//            using the output value of the mux gate so we can choose between the destbit or the inverter
            register_a.write(mux_reg_a.getOutput()[0]); // CORRECT!
//            setting the data of the register A (but this will only be saved if we have a true write value)
            register_a.data(instruction);
//            just getting the register A output so we can perform some calculations on it
            boolean[] register_a_data = register_a.Q();

//            System.out.println("REGISTER A");
//            for (boolean bool : register_a_data) {
//                System.out.print("" + bool + " ");
//            }
//            System.out.println("");

//            starting a new variable to store the address that will be used to access the RAM
            boolean[] address = new boolean[14];
//            populating the address variable with the proper bits of the register A
            for (int i = 0; i < register_a_data.length; i++) {
                if (i <= 1) continue;
                address[i - 2] = register_a_data[i];
            }
//            this mux will define if we'll read or write to the RAM. If type A, RAM.write(false) and we'll just read. If type C, the destination bits will be used to define the RAM.write()
            mux_RAM.setGate(new boolean[]{type}, new boolean[]{destBits[2]}, type);
//            setting the RAM.write() according to the output of the previous mux gate
            RAM.write(mux_RAM.getOutput()[0]);
//            setting the address of the RAM, given by the register A
            RAM.address(address);

            boolean[] ramOut = RAM.dataOut();
//            System.out.println("REGISTER M");
//            for (boolean bool : ramOut) {
//                System.out.print("" + bool + " ");
//            }
//            System.out.println("");

//            this mux will let us choose to send into the ALU the contents of the A register or the M register.
//            If instruction A, register A will be sent to the ALU. If instruction C, register M will be sent
            mux_M_A.setGate(register_a_data, ramOut, type);
//            setting the inputs and function of the ALU.
//            If instruction A, the ALU will go crazy, but nothing will be saved.
//            If instruction C, the ALU will compute using registers D and M
            ALU.setInputs(register_d.Q(), mux_M_A.getOutput(), ALUControl);


//            this mux will define if we'll write to the register D. If type A, D.write(false). If type C, the destination bits will be used to define the D.write()
            mux_reg_d.setGate(new boolean[]{type}, new boolean[]{destBits[1]}, type);
//            setting the write mode computed by the previous Mux gate
            register_d.write(mux_reg_d.getOutput()[0]);
//            setting the data of the Register D with the ALU output. (this will only be saved if the write mode is set to true)
            register_d.data(ALU.getOutput());

            boolean[] dOut = register_d.Q();
//            System.out.println("REGISTER D");
//            for (boolean bool : dOut) {
//                System.out.print("" + bool + " ");
//            }
//            System.out.println("");

//            setting the data of the RAM (this will only be saved if the write is set to true)
            RAM.dataIn(ALU.getOutput());
//            setting the address of the RAM, given by the register A
            RAM.address(address);
//            for (boolean bit : data) {
//                System.out.print("" + bit + " ");
//            }
//            System.out.println("");

//            System.out.println("");
//            System.out.println("");
        }
    }

}
