package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class AreaUi extends JPanel {
    private JFrame frame;
    private JLabel header = new JLabel("You choose: ", JLabel.CENTER);
    private JFormattedTextField status;
    private JPanel controlPanel;

    private JButton okButton;
    private JButton submitButton;
    private JButton cancelButton;

    private JComboBox<String> comboBox = new JComboBox<>();


    public void createAndShowUi() {
//        String[] functions = {"All AREAS", "ACTIVE AREAS", "AREA'S METERS"};

        okButton = new JButton("OK");
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonListener());
        submitButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

//        header = new JLabel("You choose: ", JLabel.CENTER);
        status = new JFormattedTextField("");

        frame = new JFrame("Area Repository");
        frame.setSize(100, 600);
        frame.setLayout(new GridLayout(10, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        frame.add(comboBox);
        frame.add(header);
        frame.add(controlPanel);
        frame.add(controlPanel);

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        frame.add(status);
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getHeader() {
        return header;
    }

    public void setHeader(JLabel header) {
        this.header = header;
    }

    public JFormattedTextField getStatus() {
        return status;
    }

    public void setStatus(JFormattedTextField status) {
        this.status = status;
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(JPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

}

