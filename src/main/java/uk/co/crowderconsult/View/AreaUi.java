package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Model.area.Area;

import javax.swing.*;
import java.awt.*;

public class AreaUi {
    private JFrame frame = new JFrame("Area Repository");
    private JLabel numberOfResults = new JLabel();
    private JTextArea status = new JTextArea();
    private JComboBox<String> comboBox = new JComboBox<>();
    private JComboBox<String> secondComboBox = new JComboBox<>();
    private JComboBox<String> areaComboBox = new JComboBox<>();
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");

    public void createAndShowUi() {
        frame.setSize(520, 800);
        numberOfResults.setBounds(50, 75, 200, 20);
        comboBox.setBounds(50, 50, 200, 20);
        areaComboBox.setBounds(300, 50, 150, 20);
        secondComboBox.setBounds(300, 50, 150, 20);
        editButton.setBounds(50, 520, 80, 20);
        deleteButton.setBounds(150, 520, 80, 20);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areaComboBox.setRenderer(getRenderer());
        secondComboBox.setRenderer(getRenderer());

        JScrollPane scroll = new JScrollPane(status);
        scroll.setBounds(50, 100, 400, 400);

        frame.add(comboBox);
        frame.add(numberOfResults);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(scroll);
        frame.setVisible(true);
    }

    private DefaultListCellRenderer getRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String display = "";
                if (value instanceof Area) {
                    display = "Area: " + ((Area) value).getAreaId();
                }
                return super.getListCellRendererComponent(list, display, index, isSelected, cellHasFocus);
            }
        };
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(JLabel numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public JTextArea getStatus() {
        return status;
    }

    public void setStatus(JTextArea status) {
        this.status = status;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public JComboBox<String> getAreaComboBox() {
        return areaComboBox;
    }

    public void setAreaComboBox(JComboBox<String> areaComboBox) {
        this.areaComboBox = areaComboBox;
    }

    public JComboBox<String> getSecondComboBox() {
        return secondComboBox;
    }

    public void setSecondComboBox(JComboBox<String> secondComboBox) {
        this.secondComboBox = secondComboBox;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
}

