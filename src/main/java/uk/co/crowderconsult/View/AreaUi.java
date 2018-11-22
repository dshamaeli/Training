package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Controller.testController;
import uk.co.crowderconsult.Model.area.Area;

import javax.swing.*;
import java.awt.*;

public class AreaUi {
    private JFrame frame = new JFrame("Area Repository");
    private JLabel numberOfResults = new JLabel();
    private JTextArea status = new JTextArea();
    ;
    private JComboBox<String> comboBox = new JComboBox<>();
    private JComboBox<String> areaComboBox = new JComboBox<>();


    public void createAndShowUi() {
        frame.setSize(600, 600);
        numberOfResults.setBounds(50, 75, 200, 20);
        comboBox.setBounds(50, 50, 200, 20);
        areaComboBox.setBounds(300, 50, 150, 20);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areaComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String display = "";
                if (value instanceof Area) {
                    display = "Area: " + ((Area) value).getAreaId();
                }
                return super.getListCellRendererComponent(list, display, index, isSelected, cellHasFocus);
            }
        });

        JScrollPane scroll = new JScrollPane(status);
        scroll.setBounds(50, 100, 500, 400);

        frame.add(comboBox);
        frame.add(numberOfResults);
        frame.add(scroll);
        frame.setVisible(true);
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

    public static class test extends JFrame {
        //    private String message;

        test(String message) {
            //        this.message = message;
            JTextField text = new JTextField();
            text.setBounds(75, 100, 250, 40);

            JButton button = new JButton("Find IP");
            button.setBounds(130, 200, 100, 40);

            JLabel label = new JLabel();
            label.setBounds(75, 300, 250, 40);

            add(text);
            add(button);
            add(label);

            setSize(400, 500);
            setLayout(null);
            setVisible(true);

            button.addActionListener(new testController(text, label));
        }

        public static void main(String[] args) {
            new test("yahoo");
        }
    }
}

