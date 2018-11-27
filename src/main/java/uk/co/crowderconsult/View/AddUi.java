package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Model.area.AreaType;

import javax.swing.*;

/**
 * @author daniel.shamaeli
 */
public class AddUi {

    private JFrame frame;
    private JTextField id;
    private JTextField name;
    private JRadioButton isActive;
    private JComboBox comboBox;
    private JButton saveButton;
    private JButton cancelButton;
    private ButtonGroup status;


    public AddUi() {
        initialise();
    }


    public void initialise() {
        frame = new JFrame("Add a New Area");
        frame.setBounds(100, 100, 400, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(50, 25, 40, 20);
        frame.getContentPane().add(lblId);

        id = new JTextField();
        id.setBounds(100, 25, 100, 20);
        frame.getContentPane().add(id);
        id.setColumns(10);


        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(50, 50, 40, 20);
        frame.getContentPane().add(lblName);

        name = new JTextField();
        name.setBounds(100, 50, 100, 20);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel activation = new JLabel("STATUS");
        activation.setBounds(50, 75, 100, 20);
        frame.getContentPane().add(activation);

        isActive = new JRadioButton("Active");
        isActive.setBounds(150, 75, 100, 20);
        frame.getContentPane().add(isActive);

        JRadioButton notActive = new JRadioButton("Inactive");
        notActive.setBounds(250, 75, 100, 20);
        frame.getContentPane().add(notActive);

        status = new ButtonGroup();
        status.add(isActive);
        status.add(notActive);

        JLabel lblOccupation = new JLabel("Area Type");
        lblOccupation.setBounds(50, 100, 100, 20);
        frame.getContentPane().add(lblOccupation);


        comboBox = new JComboBox(AreaType.values());
        comboBox.setBounds(150, 100, 150, 20);
        frame.getContentPane().add(comboBox);

        saveButton = new JButton("Save");

        saveButton.setBounds(50, 150, 100, 25);
        frame.getContentPane().add(saveButton);

        cancelButton = new JButton("Cancel");

        cancelButton.setBounds(200, 150, 100, 25);
        frame.getContentPane().add(cancelButton);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getName() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JRadioButton getIsActive() {
        return isActive;
    }

    public void setIsActive(JRadioButton isActive) {
        this.isActive = isActive;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public ButtonGroup getStatus() {
        return status;
    }

    public void setStatus(ButtonGroup status) {
        this.status = status;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}

