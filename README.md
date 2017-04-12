# VonNeumann_BasicMachine
This project is designed to mimic the creation of a Von Neumann machine.

The book "Code: The Hidden Language of Computers", from Charles Petzold, is used as guideline for implementing a working Von Newumann Machine.

Although the behavior of a logic gate can easily be accomplished using a couple of IF statements, the goal of this project is not to develop the most efficient code, but rather to mimic the physical development of a computer starting from the very basic components and wiring them out one by one.

In this project, following the cited book, we are using Telegraph Relays as our most basic component and working up from it. But the project is coded towards interfaces, therefore, allowing a future shift in the use of transistor.

-------------------------------------------------

DETAILS:
This entire project is built upon the implmentation of a class that simulates the behavior of a telegraph relay.
 * For a graphical scheme of a telegraph relay, check out
 * https://www.google.com.br/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjlxKzH1pDTAhWFTZAKHcnCBbcQjRwIBw&url=http%3A%2F%2Fcs.umw.edu%2F~finlayson%2Fclass%2Fspring16%2Fcpsc305%2Flabs%2F02-transistors.html&bvm=bv.152174688,d.Y2I&psig=AFQjCNE9XK95lXV6fjtYxeXoLbgjiSJULw&ust=1491597145245130

All relays are based in boolean (true/false) values that correspond to the existence of voltage.

From the Relay, other components can be created with increasing complexity.

BUFFER:
A Buffer is basically a relay, in which it just replicates the signals sent as input to the relay.
Basically, if the input voltage of a buffer is true, the output value will also be true.
So, in essence, the behavior of a buffer is the following:
  * if INPUT: true, then OUTPUT == VOLTAGE
  * if INPUT: false, then OUTPUT == false

INVERTER
Just like a Buffer, an Inverter is a basic Component.
All inverters are based in boolean (true/false) values that correspond to the existence of voltage.
Basically, if the input voltage of an is true, the output value will be false.
So, in essence, the behavior of an inverter is the following:
 * if INPUT: true, then OUTPUT == false
 * if INPUT: false, then OUTPUT == VOLTAGE

AND (logic gate)
The behavior of an AND gate is the following:
* if (ALL INPUTS): true, then OUTPUT ==  true
* if (AT LEAST 1 INPUT): false, then OUTPUT ==  false

     AND | 0 | 1 |
    --------------
      0  | 0 | 0 |
    --------------
      1  | 0 | 1 |

NAND (logic gate)
The behavior of a NAND gate is the following:
* if (ALL INPUTS): true, then OUTPUT ==  false
* if (AT LEAST 1 INPUT): false, then OUTPUT ==  true

    NAND | 0 | 1 |
    --------------
      0  | 1 | 1 |
    --------------
      1  | 1 | 0 |

OR (logic gate)
The behavior of an OR gate is the following:
* if (ALL INPUTS): false, then OUTPUT ==  false
* if (AT LEAST 1 INPUT): true, then OUTPUT ==  true

      OR | 0 | 1 |
    --------------
      0  | 0 | 1 |
    --------------
      1  | 1 | 1 |

NOR (logic gate)
The behavior of a NOR gate is the following:
* if (ALL INPUTS): false, then OUTPUT ==  true
* if (AT LEAST 1 INPUT): true, then OUTPUT ==  false

     NOR | 0 | 1 |
    --------------
      0  | 1 | 0 |
    --------------
      1  | 0 | 0 |

XOR (logic gate)
The behavior of an XOR gate:
* the output will be true only if EXCLUSIVELY ONE of the inputs is true.

     XOR | 0 | 1 |
    --------------
      0  | 0 | 1 |
    --------------
      1  | 1 | 0 |

-------------------------------------------------

These components can be wired in specific ways in order to perform logic calculations on binary numbers such as additions.
After making our machine learn how to add, it will be ready to calculate just about anything, since everything can be simplified to a combination of multiple additions.