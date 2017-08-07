package org.jonathanoliveira;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.jonathanoliveira.basic_components.BasicComponent;
import org.jonathanoliveira.complex_components.CPU_16bit;
import org.jonathanoliveira.utilities.Converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private CPU_16bit cpu;

    public static void main(String[] args) {

        System.out.printf("Power on.");
        System.out.println("");

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
                computer.run();
                power = false;
                continue;
            }

            if (userInput.toLowerCase().equals("transistors")) {
                System.out.printf("%,d", numOfRelays);
                System.out.println("");
                continue;
            }

            if (userInput.toLowerCase().equals("memory")) {
                int ram = computer.cpu.getRamSize();
                int rom = computer.cpu.getRomSize();
                System.out.printf("%,d bytes", (ram + rom) * 2);
                System.out.println("");
                continue;
            }

            if (userInput.toLowerCase().contains("flash->")) {
                int charInit = userInput.indexOf('>') + 1;
                String filename = userInput.substring(charInit);

                ArrayList<boolean[]> instructions = new ArrayList<>();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./" + filename + ".txt"), 4096);
                    ArrayList<String> raw = new ArrayList<>();
                    bufferedReader.lines().forEach(raw::add);
                    ArrayList<Integer> bits = new ArrayList<>();
                    raw.forEach(string -> {
                        int size = string.length();
                        for (int s = 0; s < size; s++) {
                            String strBit = string.substring(s, s + 1);
                            int bit = Integer.parseInt(strBit);
                            bits.add(bit);
                        }
                    });
                    int[] instr;
                    int counter = 0;
                    for (int i = 0; i < (bits.size() / 16); i++) {
                        instr = new int[16];
                        for (int j = 0; j < 16; j++) {
                            instr[j] = bits.get(counter);
                            counter++;
                        }
                        boolean[] boolInst = Converter.convertToBooleans(instr);
                        instructions.add(boolInst);
                    }
                } catch (Exception e) {
                    System.out.println("Looks like this file doesn't exists.");
                }

                computer.addToROM(instructions);
                continue;
            }

            boolean[] boolBin;
            boolean[] boolAddr;
            try {
                String subString = userInput.substring(0, 4);
                if (!userInput.contains("]=")) throw new IllegalArgumentException();
                if (subString.toUpperCase().equals("RAM[")) {
                    int charInit = userInput.indexOf('[');
                    int charEnd = userInput.indexOf(']');
                    if (charEnd - charInit == 1) throw new IllegalArgumentException();
                    String address = userInput.substring(charInit + 1, charEnd);
                    int decAddress = Integer.parseInt(address);
                    if (decAddress < 0) throw new IllegalArgumentException();
                    String value = userInput.substring(charEnd + 2);
                    if (value.length() == 0) throw new IllegalArgumentException();
                    int[] binValue = new int[value.length()];
                    for (int s = 0; s < value.length(); s++) {
                        String sub = value.substring(s, s+1);
                        int tempNum = Integer.parseInt(sub);
                        if (tempNum != 0 && tempNum != 1) throw new IllegalArgumentException();
                        binValue[s] = tempNum;
                    }

                    Converter converter = new Converter();
                    int[] intAddr = converter.convert_unsigned(decAddress,14);
                    int decValue = converter.convert_signed(binValue);
                    int[] intData = converter.convert_signed(decValue, 16);
                    boolAddr = Converter.convertToBooleans(intAddr);
                    boolBin = Converter.convertToBooleans(intData);
                    computer.addSingleDataToRAM(boolAddr, boolBin);
                    System.out.println("Inserted into RAM[" + decAddress + "]: " + decValue);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
        System.out.printf("");
        System.out.printf("Power off.");
        System.out.printf("");
    }

    private void addToROM(ArrayList<boolean[]> instructions) {
        instructions.forEach(booleans -> this.cpu.addInstruction_test(booleans));
        System.out.println("ROM flashed.");
        this.reset();
        this.cpu.runClock();
    }

    private void addSingleDataToRAM(boolean[] address, boolean[] data) {
        this.cpu.addSingleData(address, data);
        this.cpu.resetRamAddress();
    }

    private void reset() {
        this.cpu.resetClock_test();
    }

    private void run() {
        System.out.println("Computing... ");
        this.cpu.run_test();
        boolean[] regd = this.cpu.getRegister_d().Q();
        Converter converter = new Converter();
        int result = converter.convert_signed(Converter.convertFromBooleans(regd));
        System.out.println("Result: " + result);
    }
}
