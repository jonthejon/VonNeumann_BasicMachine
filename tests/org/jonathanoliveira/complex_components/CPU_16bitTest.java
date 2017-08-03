package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CPU_16bitTest {


    @Test
    public void testROM() throws Exception {
        CPU_16bit cpu = new CPU_16bit();
        boolean[] inst1 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        boolean[] inst2 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0});
        boolean[] inst3 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0});
        boolean[] inst4 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0});
        boolean[] inst5 = Converter.convertToBooleans(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0});
        cpu.addInstruction_test(inst1);
        cpu.addInstruction_test(inst2);
        cpu.addInstruction_test(inst3);
        cpu.addInstruction_test(inst4);
        cpu.addInstruction_test(inst5);
        cpu.resetClock_test();
        assertArrayEquals(inst1, cpu.fetchInstruction_test());
        assertArrayEquals(inst2, cpu.fetchInstruction_test());
        assertArrayEquals(inst3, cpu.fetchInstruction_test());
        assertArrayEquals(inst4, cpu.fetchInstruction_test());
        assertArrayEquals(inst5, cpu.fetchInstruction_test());
    }

    @Test
    public void testRAM() throws Exception {
        CPU_16bit cpu = new CPU_16bit();
        boolean[] data1 = Converter.convertToBooleans(new int[]{0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1});
        boolean[] data2 = Converter.convertToBooleans(new int[]{1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0});
        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
        cpu.addData_test(data1);
        cpu.addData_test(data2);
        cpu.addData_test(data3);
        cpu.addData_test(data4);
        cpu.addData_test(data5);
        cpu.resetClock_test();
        assertArrayEquals(data1, cpu.fetchData_test());
        assertArrayEquals(data2, cpu.fetchData_test());
        assertArrayEquals(data3, cpu.fetchData_test());
        assertArrayEquals(data4, cpu.fetchData_test());
        assertArrayEquals(data5, cpu.fetchData_test());
    }

    @Test
    public void testROM_RAM() throws Exception {
        CPU_16bit cpu = new CPU_16bit();
        boolean[] address1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        boolean[] address2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        boolean[] address3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
        boolean[] address4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1});
        boolean[] address5 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0});
        cpu.addInstruction_test(address1);
        cpu.addInstruction_test(address2);
        cpu.addInstruction_test(address3);
        cpu.addInstruction_test(address4);
        cpu.addInstruction_test(address5);
        cpu.resetClock_test();
        boolean[] data1 = Converter.convertToBooleans(new int[]{0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1});
        boolean[] data2 = Converter.convertToBooleans(new int[]{1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0});
        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
        cpu.addData_test(data1);
        cpu.addData_test(data2);
        cpu.addData_test(data3);
        cpu.addData_test(data4);
        cpu.addData_test(data5);
        cpu.resetClock_test();
        cpu.run_test();
    }

    @Test
    public void testBasicFunctionality() throws Exception {
        CPU_16bit cpu = new CPU_16bit();
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
        boolean[] data1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1});
        boolean[] data2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
//        boolean[] data3 = Converter.convertToBooleans(new int[]{1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0});
//        boolean[] data4 = Converter.convertToBooleans(new int[]{1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0});
//        boolean[] data5 = Converter.convertToBooleans(new int[]{0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,0});
        cpu.addData_test(data1);
        cpu.addData_test(data2);
//        cpu.addData_test(data3);
//        cpu.addData_test(data4);
//        cpu.addData_test(data5);
        cpu.resetClock_test();
        cpu.run_test();
        boolean[] regD = cpu.register_d.Q();
        boolean[] exp = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0});
        assertArrayEquals(exp, regD);
    }
}