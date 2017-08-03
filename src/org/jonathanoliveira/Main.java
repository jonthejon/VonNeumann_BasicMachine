package org.jonathanoliveira;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.jonathanoliveira.basic_components.BasicComponent;
import org.jonathanoliveira.complex_components.CPU_16bit;
import org.jonathanoliveira.utilities.Converter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private CPU_16bit cpu;

    public static void main(String[] args) {

        Main computer = new Main();
        computer.cpu = new CPU_16bit();

        int numOfRelays = BasicComponent.counter;

        boolean power = true;
        Scanner reader = new Scanner(System.in);

        while (power) {
            String userInput = reader.nextLine();
            if (userInput.toLowerCase().equals("off")) {
                power = false;
                continue;
            }

            if (userInput.toLowerCase().equals("run")) {
                computer.setUp();
                power = false;
                continue;
            }

            if (userInput.toLowerCase().equals("relays")) {
                System.out.printf("Number of relays: %,d", numOfRelays);
                System.out.println("");
                System.out.println("");
                continue;
            }


            boolean[] boolBin = new boolean[16];
            boolean[] boolAddr = new boolean[14];
            try {
                String subString = userInput.substring(0, 4);
                if (!userInput.contains("]=")) throw new IllegalArgumentException();
//                System.out.println("step1");
                if (subString.equals("RAM[")) {
                    int charInit = userInput.indexOf('[');
                    int charEnd = userInput.indexOf(']');
                    if (charEnd - charInit == 1) throw new IllegalArgumentException();
//                    System.out.println("step2");
                    String address = userInput.substring(charInit + 1, charEnd);
                    int decAddress = Integer.parseInt(address);
                    if (decAddress < 0) throw new IllegalArgumentException();
//                    System.out.println(decAddress);
//                    System.out.println("step3");
                    String value = userInput.substring(charEnd + 2);
//                    System.out.println("step4");
                    if (value.length() == 0) throw new IllegalArgumentException();
                    int[] binValue = new int[value.length()];
                    for (int s = 0; s < value.length(); s++) {
                        String sub = value.substring(s, s+1);
                        int tempNum = Integer.parseInt(sub);
                        if (tempNum != 0 && tempNum != 1) throw new IllegalArgumentException();
                        binValue[s] = tempNum;
//                        System.out.println(sub);
                    }


//                    System.out.println("VALUE: ");
//                    for (int bool : binValue) {
//                        System.out.print("" + bool + " ");
//                    }
//                    System.out.println("");


//                    System.out.println("step5");
//                    int decValue = Integer.parseInt(value);
//                    System.out.println("step6");
//                    System.out.println(decValue);


                    Converter converter = new Converter();
                    int[] intAddr = converter.convert_unsigned(decAddress,14);
                    int decValue = converter.convert_signed(binValue);
                    int[] intData = converter.convert_signed(decValue, 16);
                    boolAddr = Converter.convertToBooleans(intAddr);
                    boolBin = Converter.convertToBooleans(intData);
                    System.out.println("Inserting into RAM[" + decAddress + "]: " + decValue);
                    System.out.println("");
                    computer.addSingleDataToRAM(boolAddr, boolBin);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }


//            System.out.println("ADDRESS: ");
//            for (boolean bool : boolAddr) {
//                System.out.print("" + bool + " ");
//            }
//            System.out.println("");
//
//            System.out.println("DATA: ");
//            for (boolean bool : boolBin) {
//                System.out.print("" + bool + " ");
//            }
//            System.out.println("");

        }
    }

    private void setUp() {

//        this.cpu = new CPU_16bit();

        ArrayList<boolean[]> instructions = new ArrayList<>();
        ArrayList<boolean[]> data = new ArrayList<>();

        System.out.println("Computing RAM[0] + RAM[1]");

//        regM = RAM[0]
        boolean[] instructionA_1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
//        regD = regM
        boolean[] instructionC_1 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});
//        regM = RAM[1]
        boolean[] instructionA_2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
//        regD = regD + RegM
        boolean[] instructionC_2 = Converter.convertToBooleans(new int[]{1,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0});
//        setting address RAM[2] for output
        boolean[] instructionA_3 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
//        RAM[2] = regD
        boolean[] instructionC_3 = Converter.convertToBooleans(new int[]{1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0});
//        regM = RAM[2]
        boolean[] instructionA_4 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0});
//        regD = regM
        boolean[] instructionC_4 = Converter.convertToBooleans(new int[]{1,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0});

        instructions.add(instructionA_1);
        instructions.add(instructionC_1);
        instructions.add(instructionA_2);
        instructions.add(instructionC_2);
        instructions.add(instructionA_3);
        instructions.add(instructionC_3);
        instructions.add(instructionA_4);
        instructions.add(instructionC_4);

//        boolean[] data1 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1});
//        int data1Res = Converter.convert(Converter.convertFromBooleans(data1));
//        System.out.println("Inserting into RAM[0]: " + data1Res);
//        boolean[] data2 = Converter.convertToBooleans(new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1});
//        int data2Res = Converter.convert(Converter.convertFromBooleans(data2));
//        System.out.println("Inserting into RAM[1]: " + data2Res);

//        data.add(data1);
//        data.add(data2);

        this.addToROM(instructions);
//        computer.addToRAM(data);

        this.run();
    }

    private void addToROM(ArrayList<boolean[]> instructions) {
        instructions.forEach(booleans -> this.cpu.addInstruction_test(booleans));
        this.reset();
    }

    private void addToRAM(ArrayList<boolean[]> data) {
        data.forEach(booleans -> this.cpu.addData_test(booleans));
        this.reset();
    }

    private void addSingleDataToRAM(boolean[] address, boolean[] data) {
        this.cpu.addSingleData(address, data);
    }

    private void reset() {
        this.cpu.resetClock_test();
    }

    private void run() {
        System.out.print("Computing... ");
        this.cpu.run_test();
        boolean[] regd = this.cpu.getRegister_d().Q();
        Converter converter = new Converter();
//        int result = Converter.convert(Converter.convertFromBooleans(regd));
        int result = converter.convert_signed(Converter.convertFromBooleans(regd));
        System.out.println("Result: " + result);
    }
}
