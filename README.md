# VonNeumann_BasicMachine

This project is in Execution Phase with new functionalities being added over time. The latest functionality implemented on this Von Neumann machine is:

     adds any two positive integer numbers together
     
---
PROJECT OVERVIEW

This project is designed to mimic the physical fabrication process of the simplest possible digital computer, using relays, that follows the Von Neumann architecture. A computer that uses the Von Neumann architecture can be defined as any computer in which the program instructions, as well as its data, are kept in the same memory array (RAM).

The book "Code: The Hidden Language of Computers", from Charles Petzold, is used as guideline for implementing a working Von Newumann Machine.

Although the behavior of a logic gate can easily be accomplished using a couple of IF statements, the goal of this project is not to develop the most efficient code, but rather to mimic the physical development of a computer starting from the very basic components and wiring them out one by one.

In this project we'll use Telegraph Relays as our most basic component and build up all of our components from it.

---
This entire project is built upon the implementation of a class that simulates the behavior of a telegraph relay.
- For a graphical scheme of a telegraph relay, check out: https://www.google.com.br/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjlxKzH1pDTAhWFTZAKHcnCBbcQjRwIBw&url=http%3A%2F%2Fcs.umw.edu%2F~finlayson%2Fclass%2Fspring16%2Fcpsc305%2Flabs%2F02-transistors.html&bvm=bv.152174688,d.Y2I&psig=AFQjCNE9XK95lXV6fjtYxeXoLbgjiSJULw&ust=1491597145245130

All relays are based in boolean (true/false) values that correspond to the existence of voltage in the wires of the relays. True = voltage. False = no voltage.

---
We have basically two ways of wiring a Relay. Each way will make the final component behave differently: as a data buffer or as a data inverter.

BUFFER:  
A Buffer is basically a common relay, in which it just replicates the signals sent as input to the output.
So, if the input voltage of a buffer is true, the output voltage will also be true.
The behavior of a buffer can be described as:

- INPUT == true, then OUTPUT == VOLTAGE == true
- INPUT == false, then OUTPUT == NO VOLTAGE == false

INVERTER:  
The Inverter has the oposite behavior of a Buffer.
If the input voltage of an inverter is true, the output voltage will be false.
The behavior of an inverter can be described as:

- INPUT == true, then OUTPUT == NO VOLTAGE == false
- INPUT == false, then OUTPUT == VOLTAGE == true

---
We can wire together in different ways two or more of the relays mentioned above. Each kind of wiring (combination of relays) will produce a unique result based on the input voltages if the underlying relays. These bundled relays are commonly called Logic Gates, since the results presented by them mimic logic operations over their input voltages.

AND GATE:  
The behavior of an AND gate is the following:
- (ALL INPUTS) == true, then OUTPUT ==  true
- (AT LEAST 1 INPUT) == false, then OUTPUT ==  false

NAND GATE:  
The NAND gate has the oposite behavior of the AND gate:
- (ALL INPUTS) == true, then OUTPUT ==  false
- (AT LEAST 1 INPUT) == false, then OUTPUT ==  true

OR GATE:  
The behavior of an OR gate is the following:
- (ALL INPUTS) == false, then OUTPUT ==  false
- (AT LEAST 1 INPUT) == true, then OUTPUT ==  true

NOR GATE:  
The NOR gate has the oposite behavior of the OR gate:
- (ALL INPUTS) == false, then OUTPUT ==  true
- (AT LEAST 1 INPUT) == true, then OUTPUT ==  false

XOR GATE:  
The XOR gate behaves just as the OR gate, but with a catch: the output will be true only if exactly one of the inputs is true:
- (ALL INPUTS) == true, then OUTPUT ==  false
- (ALL INPUTS) == false, then OUTPUT ==  false
- (AT PRECISELY 1 INPUT) == true, then OUTPUT ==  true

---
Logic gates can also be wired one to another in many different ways. The wiring of logic gates and basic relays to each other can produce an array of components of ever-increasing complexity. Such components can be used to perform mathematical computations with binary numbers that, in a way, are at the core of every modern computer.
