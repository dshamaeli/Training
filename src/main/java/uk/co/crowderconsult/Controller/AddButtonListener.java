package uk.co.crowderconsult.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String commmand = e.getActionCommand();
        if (commmand.equals("OK")) {
            System.out.println("OK button selected");
        } else if (commmand.equals("Submit")) {
            System.out.println("Submit button selected");
        } else {
            System.out.println("Cancel button selected");
        }
    }
}
