package org.jonathanoliveira.complex_components;

import org.jonathanoliveira.utilities.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class CounterControllerTest {

    @Test
    public void mainTest() throws Exception {
        CounterController controller = new CounterController();

        boolean[] jumpBits = Converter.convertToBooleans(new int[]{0,0,0});
        boolean aluZ = false;
        boolean aluN = false;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(!controller.isOutL() && controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{0,0,1});
        aluZ = false;
        aluN = false;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{0,1,0});
        aluZ = true;
        aluN = false;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{0,1,1});
        aluZ = true;
        aluN = false;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{1,0,0});
        aluZ = true;
        aluN = true;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{1,0,1});
        aluZ = false;
        aluN = false;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{1,1,0});
        aluZ = false;
        aluN = true;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{1,1,1});
        aluZ = false;
        aluN = true;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{1,1,1});
        aluZ = true;
        aluN = true;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

        jumpBits = Converter.convertToBooleans(new int[]{1,1,1});
        aluZ = false;
        aluN = false;
        controller.setInputs(jumpBits, aluZ, aluN);
        assertTrue(controller.isOutL() && !controller.isOutI());

    }


}