package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.basic_components.Inverter;
import org.jonathanoliveira.logic_gates.MUX_Gate;
import org.jonathanoliveira.logic_gates.Nbit_AND_Gate;
import org.jonathanoliveira.utilities.Binary;
import org.jonathanoliveira.utilities.Converter;

import java.util.Scanner;

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
    private Nbit_AND_Gate controllerAND;
    private CounterController controller;


    Converter converter = new Converter();

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
        this.controllerAND = new Nbit_AND_Gate(3);
        this.controller = new CounterController();
        this.ALU = new ALU_16bit();
        this.bitSize = 16;
        this.numOfInstructions = 0;
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
        incClock_test();
        boolean[] clock = this.counter.getOutput();
        this.ROM.address(clock);
        this.ROM.write(false);
        this.counter.wire();
//        System.out.println(converter.convert_unsigned(Converter.convertFromBooleans(clock)));
//        runClock();
        numOfInstructions++;
    }

    public void addData_test(boolean[] data) {
        if (data.length != getBitSize()) throw new IllegalArgumentException();
        this.RAM.write(true);
        this.RAM.dataIn(data);
        incClock_test();
        boolean[] clock = this.counter.getOutput();
        this.RAM.address(clock);
        this.RAM.write(false);
//        System.out.println(converter.convert_unsigned(Converter.convertFromBooleans(clock)));
//        counter.getOutput();
    }

    public void addSingleData(boolean[] address, boolean[] data) {
        if (data.length != getBitSize()) throw new IllegalArgumentException();
        this.RAM.write(true);
        this.RAM.dataIn(data);
        this.RAM.address(address);
        this.RAM.write(false);
    }

    public void resetRamAddress() {
        this.RAM.address(Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public void resetClock_test() {
//        System.out.println("Reset called.");
//        counter.setFunction(Converter.convertToBooleans(new int[]{1,0,0}));
        counter.setFunction(Converter.convertToBooleans(new int[]{0,0,1}));
        this.counter.wire();
//        counter.setInput(Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }

    public void incClock_test() {
        this.counter.setFunction(Converter.convertToBooleans(new int[]{0,1,0}));
    }

    public boolean[] fetchInstruction_test() {
//        System.out.println("instruction called.");
        boolean[] clock = this.counter.getOutput();
//        incClock_test();
//        System.out.println("Clock");
//        for (boolean bool : clock) {
//            int conv = bool ? 1 : 0;
//            System.out.print("" + conv + " ");
//        }
//        System.out.println("");
        this.ROM.address(clock);
        return this.ROM.dataOut();
    }

    public boolean[] fetchData_test() {
//        incClock_test();
//        System.out.println("fetch test called.");
        boolean[] clock = this.counter.getOutput();
//        System.out.println("Clock");
//        for (boolean bool : clock) {
//            int conv = bool ? 1 : 0;
//            System.out.print("" + conv + " ");
//        }
//        System.out.println("");
        this.RAM.address(clock);
        return this.RAM.dataOut();
    }

    public void runClock() {
//        System.out.println("Run called.");
//        boolean[] clock = this.counter.getOutput();
//        System.out.println("RUN CLOCK");
//        for (boolean bool : clock) {
//            int conv = bool ? 1 : 0;
//            System.out.print("" + conv + " ");
//        }
//        System.out.println("");
        counter.getOutput();
        incClock_test();
    }

    public void run_test() {
//        RAM.address();
        incClock_test();
        int control = 0;
//        Scanner reader = new Scanner(System.in);
//        String userInput = "";
        int numInstruc = 0;
        while (numInstruc < numOfInstructions + 2) {
//        while (!userInput.toLowerCase().equals("off")) {
//        while (control < numOfInstructions) {
//            userInput = reader.nextLine();
//            System.out.println("Instruction " + control);
            control++;
//            getting the instruction from the ROM
            boolean[] instruction = fetchInstruction_test();
            numInstruc = converter.convert_unsigned(Converter.convertFromBooleans(counter.getOutput()));
//            System.out.println(numInstruc);

            for (boolean bool : counter.getOutput()) {
                int conv = bool ? 1 : 0;
                System.out.print("" + conv + " ");
            }
            System.out.println("");

//            decomposing the instruction in case we have a C instruction
            boolean type = instruction[0];
            boolean ALUrest = instruction[3];
            boolean[] ALUControl = new boolean[]{instruction[4], instruction[5], instruction[6], instruction[7], instruction[8], instruction[9]};
            boolean[] destBits = new boolean[]{instruction[10], instruction[11], instruction[12]};
            boolean[] jumpBits = new boolean[]{instruction[13], instruction[14], instruction[15]};

//            System.out.println("RAM JUMP BITS");
//            for (boolean bool : jumpBits) {
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");

//            System.out.print(type);
//            if (type) {
//                for (boolean bool : jumpBits) System.out.print("" + bool + " ");
//                System.out.println("");
//            }

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
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");

//            starting a new variable to store the address that will be used to access the RAM
            boolean[] address = new boolean[14];
//            populating the address variable with the proper bits of the register A
            for (int i = 0; i < register_a_data.length; i++) {
                if (i <= 1) continue;
                address[i - 2] = register_a_data[i];
            }


//            counter.setInput(address);
            boolean typeCopy = type;
            controllerAND.setInputs(jumpBits, new boolean[]{typeCopy, typeCopy, typeCopy});
//            controller.setInputs(controllerAND.getOutput(), ALU.getZr(), ALU.getNg());
//            boolean[] counterFunc = new boolean[]{controller.isOutL(), controller.isOutI(), Binary.NO_VOLTAGE.getValue()};
//            for (boolean bool : counterFunc) System.out.print("" + bool + " ");
//            System.out.println("");
//            counter.setFunction(counterFunc);


//            this mux will define if we'll read or write to the RAM. If type A, RAM.write(false) and we'll just read. If type C, the destination bits will be used to define the RAM.write()
            mux_RAM.setGate(new boolean[]{type}, new boolean[]{destBits[2]}, type);
////            setting the RAM.write() according to the output of the previous mux gate
//            RAM.write(mux_RAM.getOutput()[0]);
//            System.out.println("RAM Write? " + mux_RAM.getOutput()[0]);
//            setting the address of the RAM, given by the register A
//            RAM.address(address);
//            RAM.write(mux_RAM.getOutput()[0]);

            boolean[] ramOut = RAM.dataOut();
//            System.out.println("REGISTER M");
//            for (boolean bool : ramOut) {
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");

//            this mux will let us choose to send into the ALU the contents of the A register or the M register.
//            If instruction A, register A will be sent to the ALU. If instruction C, register M will be sent
            mux_M_A.setGate(register_a_data, ramOut, type);
//            setting the inputs and function of the ALU.
//            If instruction A, the ALU will go crazy, but nothing will be saved.
//            If instruction C, the ALU will compute using registers D and M
//            System.out.println("ALU Y");
//            for (boolean bool : mux_M_A.getOutput()) {
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");
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
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");

//            System.out.println("calculated jump bits");
//            for (boolean bool : controllerAND.getOutput()) {
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");
            controller.setInputs(controllerAND.getOutput(), ALU.getZr(), ALU.getNg());
            boolean[] counterFunc = new boolean[]{controller.isOutL(), controller.isOutI(), Binary.NO_VOLTAGE.getValue()};
//            System.out.println("Clock Function");
//            for (boolean bool : counterFunc) {
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");
            counter.setFunction(counterFunc);
            counter.setInput(address);

//            setting the data of the RAM (this will only be saved if the write is set to true)
            RAM.dataIn(ALU.getOutput());
//            setting the RAM.write() according to the output of the previous mux gate
//            System.out.println("ALU output: ");
//            for (boolean bool : ALU.getOutput()) {
//                int conv = bool ? 1 : 0;
//                System.out.print("" + conv + " ");
//            }
//            System.out.println("");
            RAM.write(mux_RAM.getOutput()[0]);
//            System.out.println("RAM Write? " + mux_RAM.getOutput()[0]);
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
