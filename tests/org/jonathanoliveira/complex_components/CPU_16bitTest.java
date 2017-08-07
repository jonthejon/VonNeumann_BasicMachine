package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CPU_16bitTest {

    CPU_16bit cpu;

    @Before
    public void setUp() throws Exception {
        this.cpu = new CPU_16bit();
    }

    @Test
    public void testROM() throws Exception {
//        CPU_16bit cpu = new CPU_16bit();
        boolean[] inst1 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        boolean[] inst2 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0});
        boolean[] inst3 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0});
        boolean[] inst4 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0});
        boolean[] inst5 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0});
//        cpu.incClock_test();
        cpu.addInstruction_test(inst1);
        cpu.addInstruction_test(inst2);
        cpu.addInstruction_test(inst3);
        cpu.addInstruction_test(inst4);
        cpu.addInstruction_test(inst5);
        cpu.resetClock_test();
        cpu.runClock();
        cpu.incClock_test();
        assertArrayEquals(inst1, cpu.fetchInstruction_test());
        assertArrayEquals(inst2, cpu.fetchInstruction_test());
        assertArrayEquals(inst3, cpu.fetchInstruction_test());
        assertArrayEquals(inst4, cpu.fetchInstruction_test());
        assertArrayEquals(inst5, cpu.fetchInstruction_test());
    }

    @Test
    public void testRAM() throws Exception {
//        CPU_16bit cpu = new CPU_16bit();
        boolean[] data1 = Converter.convertToBooleans(new int[]{0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1});
        boolean[] data2 = Converter.convertToBooleans(new int[]{1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0});
        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
//        cpu.incClock_test();
        cpu.addData_test(data1);
        cpu.addData_test(data2);
        cpu.addData_test(data3);
        cpu.addData_test(data4);
        cpu.addData_test(data5);
        cpu.resetClock_test();
        cpu.runClock();
        cpu.incClock_test();
        assertArrayEquals(data1, cpu.fetchData_test());
        assertArrayEquals(data2, cpu.fetchData_test());
        assertArrayEquals(data3, cpu.fetchData_test());
        assertArrayEquals(data4, cpu.fetchData_test());
        assertArrayEquals(data5, cpu.fetchData_test());
    }

    @Test
    public void testROM_RAM() throws Exception {
//        CPU_16bit cpu = new CPU_16bit();
        boolean[] address1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] address2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        boolean[] address3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
        boolean[] address4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] address5 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0});
        cpu.incClock_test();
        cpu.addInstruction_test(address1);
        cpu.addInstruction_test(address2);
        cpu.addInstruction_test(address3);
        cpu.addInstruction_test(address4);
        cpu.addInstruction_test(address5);
        cpu.resetClock_test();
        cpu.runClock();
        boolean[] data1 = Converter.convertToBooleans(new int[]{0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1});
        boolean[] data2 = Converter.convertToBooleans(new int[]{1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0});
        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
        cpu.incClock_test();
        cpu.addData_test(data1);
        cpu.addData_test(data2);
        cpu.addData_test(data3);
        cpu.addData_test(data4);
        cpu.addData_test(data5);
        cpu.resetClock_test();
        cpu.runClock();
        cpu.run_test();
    }

    @Test
    public void testBasicFunctionality() throws Exception {
//        CPU_16bit cpu = new CPU_16bit();
//        regM = RAM[0] >>>> OK!!
        boolean[] instructionA_1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
//        regD = regM >>>> OK!!
        boolean[] instructionC_1 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});
//        regM = RAM[1] >>>> OK!!
        boolean[] instructionA_2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
//        regD = regD + RegM >>>> OK!!
        boolean[] instructionC_2 = Converter.convertToBooleans(new int[]{1,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0});
//        setting address RAM[2] for output >>>> OK!!
        boolean[] instructionA_3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
//        RAM[2] = regD >>>> ?
        boolean[] instructionC_3 = Converter.convertToBooleans(new int[]{1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0});
//        regM = RAM[2] >>>>
        boolean[] instructionA_4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
//        regD = regM >>>>
        boolean[] instructionC_4 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});

//        boolean[] address1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
//        boolean[] address2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
//        boolean[] address3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
//        boolean[] address4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
//        boolean[] address5 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0});
        cpu.addInstruction_test(instructionA_1);
        cpu.addInstruction_test(instructionC_1);
        cpu.addInstruction_test(instructionA_2);
        cpu.addInstruction_test(instructionC_2);
        cpu.addInstruction_test(instructionA_3);
        cpu.addInstruction_test(instructionC_3);
        cpu.addInstruction_test(instructionA_4);
        cpu.addInstruction_test(instructionC_4);
//        cpu.addInstruction_test(address3);
//        cpu.addInstruction_test(address4);
//        cpu.addInstruction_test(address5);
        cpu.resetClock_test();
        cpu.runClock();
        boolean[] data1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1});
        boolean[] data2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
//        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
//        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
//        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
        cpu.incClock_test();
        cpu.addData_test(data1);
        cpu.addData_test(data2);
//        cpu.addData_test(data3);
//        cpu.addData_test(data4);
//        cpu.addData_test(data5);
        cpu.resetClock_test();
        cpu.runClock();
        cpu.run_test();
        boolean[] regD = cpu.register_d.Q();
        boolean[] exp = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0});
        assertArrayEquals(exp, regD);
    }

//    @Test
//    public void testMultiplication() throws Exception {
////        @0
//        boolean[] instruction_1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
////        D=M
//        boolean[] instruction_2 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});
////        @=??
//        boolean[] instruction_3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
////        D;JEQ
//        boolean[] instruction_4 = Converter.convertToBooleans(new int[]{1,1,1,0,0,0,1,1,0,0,0,0,0,0,1,0});
////        @0
//        boolean[] instruction_5 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
////        @0
//        boolean[] instruction_6 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
////        @0
//        boolean[] instruction_7 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
////        @0
//        boolean[] instruction_8 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
////        @5
//        boolean[] instruction_9 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1});
////        D=M
//        boolean[] instruction_10 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});
////        boolean[] instructionC_3 = Converter.convertToBooleans(new int[]{1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0});
////        boolean[] instructionA_4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
////        boolean[] instructionC_4 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});
//
////        cpu.incClock_test();
////        boolean[] address1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
////        boolean[] address2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
////        boolean[] address3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
////        boolean[] address4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
////        boolean[] address5 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0});
//        cpu.addInstruction_test(instructionA_1);
//        cpu.addInstruction_test(instructionC_1);
//        cpu.addInstruction_test(instructionA_2);
//        cpu.addInstruction_test(instructionC_2);
//        cpu.addInstruction_test(instructionA_3);
//        cpu.addInstruction_test(instructionC_3);
//        cpu.addInstruction_test(instructionA_4);
//        cpu.addInstruction_test(instructionC_4);
////        cpu.addInstruction_test(address3);
////        cpu.addInstruction_test(address4);
////        cpu.addInstruction_test(address5);
//        cpu.resetClock_test();
//        cpu.runClock();
//        boolean[] data1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
//        boolean[] data2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
////        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
////        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
////        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
//        cpu.incClock_test();
//        cpu.addData_test(data1);
//        cpu.addData_test(data2);
////        cpu.addData_test(data3);
////        cpu.addData_test(data4);
////        cpu.addData_test(data5);
//        cpu.resetClock_test();
//        cpu.runClock();
//        cpu.run_test();
//        boolean[] regD = cpu.register_d.Q();
//        boolean[] exp = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0});
//        assertArrayEquals(exp, regD);
//    }

//    @Test
//    public void reader() throws Exception {
////        Converter converter = new Converter();
//        String filename = "add_R0_R1";
//        BufferedReader reader = new BufferedReader(new FileReader("./" + filename + ".txt"), 4096);
//        ArrayList<String> raw = new ArrayList<>();
//        reader.lines().forEach(line -> raw.add(line));
//        ArrayList<Integer> bits = new ArrayList<>();
//        raw.forEach(string -> {
//            int size = string.length();
//            for (int s = 0; s < size; s++) {
//                String strBit = string.substring(s, s+1);
//                int bit = Integer.parseInt(strBit);
//                bits.add(bit);
//            }
//        });
//        boolean[][] instructions = new boolean[bits.size()/16][16];
//        int[] instr;
//        int counter = 0;
//        for (int i = 0; i < instructions.length; i++) {
//            instr = new int[16];
//            for (int j = 0; j < 16; j++) {
//                instr[j] = bits.get(counter);
//                counter++;
//            }
//            boolean[] boolInst = Converter.convertToBooleans(instr);
//            instructions[i] = boolInst;
//        }
//
//        for (boolean[] booleans : instructions) {
//            for (boolean bool : booleans) {
//                System.out.print("" + bool + " ");
//            }
//            System.out.println("");
//            System.out.println("");
//        }
//    }
}