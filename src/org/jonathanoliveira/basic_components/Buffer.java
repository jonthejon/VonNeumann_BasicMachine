package org.jonathanoliveira.basic_components;

import org.jonathanoliveira.utilities.Binary;

/**
 * All relays are based in boolean (true/false) values that correspond to the existence of voltage.
 * A Buffer is basically a relay, in which it just replicates the signals sent as input to the relay.
 * Basically, if the input voltage of a buffer is true, the output value will also be true.
 *
 * So, in essence, the behavior of a buffer is the following:
 * if INPUT: true, then OUTPUT == VOLTAGE
 * if INPUT: false, then OUTPUT == false
 *
 * important to notice that getOutput() must be called only after the input and the voltage
 *      has been properly set.
 *
 * For a graphical scheme of a telegraph relay, check out
 * https://www.google.com.br/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjlxKzH1pDTAhWFTZAKHcnCBbcQjRwIBw&url=http%3A%2F%2Fcs.umw.edu%2F~finlayson%2Fclass%2Fspring16%2Fcpsc305%2Flabs%2F02-transistors.html&bvm=bv.152174688,d.Y2I&psig=AFQjCNE9XK95lXV6fjtYxeXoLbgjiSJULw&ust=1491597145245130
 */

public class Buffer extends BasicComponent {

    @Override
    void setOutput() {
//      IF input is true, then output must be equal to voltage
        if (getInput()) {
            this.output = getVoltage();
//      IF input is false, then output must have no voltage
        } else {
            this.output = Binary.NO_VOLTAGE.getValue();
        }
    }

}
