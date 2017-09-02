# A Von Neumann machine

IN THE CURRENT IMPLEMENTATION, THIS COMPUTER HAS A 65K RAM, BUILT WITH OVER 10 MILLION TRANSISTORS (INSTANCES OF THE TRANSISTOR CLASS).

How does a computer really works?
This project tries to answer this question that I always had since I started programming.

This is a virtual computer coded in Java. The goal of this project is to mimic the hurdles of physically assembling a computer, transistor by transistor.
In order to achieve this goal, I developed a Java class that behaves the same way as a physical transistor and to simulate the assemblage, I restricted myself to create the entire computer with only combining several of this transistors classes together. This implies that:
     1) all the components of this virtual computer are combinations of the transistor class (I'm not allowed to create any code functionalities, only combine transistors)
     2) the only primitive types that I used in this project are booleans: no ints, floats, etc... (this is to simulate the fact that in a real computer implementation, you're limited to binary values delimited by electricity voltages).
     3) I'm not allowed to use any kind of code branching like IF or FOR that will enhance the functionality of the underlying component.

### Prerequisites

Make sure you have a Java Virtual Machine up and running on your machine if you want to run this software.

[JAVA](https://java.com/en/download/) - download the latest Java, in case you don't have it.

### Developing

If you want to help or if you're just in the mood to doodle around with the code, I suggest downloading the IntelliJ IDEA. It's an IDE from the guys at JetBrains and in my humble opinion, the best Java IDE in the market.

[INTELLIJ](https://www.jetbrains.com/idea/) - download the IntelliJ IDEA here.

### Programming for the computer

Since I have not yet created a compiler, all programs must be written in Binary format (using 1 or 0). A program is just a set of instructions that can be loaded into the computer's ROM and executed.
The underlying CPU is a 16bit processor, therefore all instructions are 16bit wide.
The CPU architecture is very similar to the CPU used in the Nand2Tetris course. This means that you can use the instructions architecture displayed on the course.

[NAND2TETRIS](http://nand2tetris.org/course.php) - The Nand2Tetris course
[NAND2TETRIS - Machine Language](http://nand2tetris.org/04.php) - This section of the course explains the underlying machine language used in the CPU.

Here is an example of a program that adds two different numbers that are stored in RAM-0 and RAM-1, and stores the result at RAM-2:

```
0000000000000000  // Loads the number stored inside RAM-0 into the ALU a-input
1110110000010000  // Saves the ALU's a-input into the D-register of the CPU
0000000000000001  // Loads the number stored inside RAM-1 into the ALU a-input
1110000010010000  // Saves the ALU's sum of the a-input and the D-register into the D-register
0000000000000010  // Selects the RAM-2 memory address for saving the sum result
1110001100001000  // Saves the D-register value into the select RAM memory address
```

## Running the computer

In the following steps, we will load and run the program described above

     1) save the program into a txt file (add_r0_r1.txt, for example) inside the computer folder
     2) on the command line, run the Main class
          You will see 'Power on.' appear in the next line
          Optionally, you can inspect the Memory size of this computer by typing 'memory'
          Optionally, you can inspect the number of transistors used for the assembly of this computer typing 'transistors'
          ```
          >>> memory
          65,536 bytes
          >>> transistors
          10,440,911
          ```
     3) load into RAM-0 and RAM-1 (in binary format) the numbers that you wish to add
          ```
          >>> ram[0]=0110
          Inserted into RAM[0]: 6
          >>> ram[0]=0110
          Inserted into RAM[1]: 13
          ```
     4) flash the program you created into the ROM (when writing the program name, omit the extension)
          ```
          >>> flash->add_r0_r1
          ROM flashed.
          ```
     5) run the program with the 'run' command.
          The computer will start the computation delimited by the instructions in your program and output the result
          ```
          >>> run
          Computing...
          Result: 19
          ```

## Libraries

No external libraries have been used in this project.

## Acknowledgments

* The CPU architecture is loosely based on the architecture presented in the [Nand2Tetris](http://nand2tetris.org/course.php) course. 
* A lot of the ideas were taken from this awesome book by Charles Petzold [Code](https://www.amazon.ca/Code-Language-Computer-Hardware-Software/dp/0735611319)
