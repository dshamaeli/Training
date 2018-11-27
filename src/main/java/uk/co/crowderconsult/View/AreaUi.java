package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.meter.Meter;

import javax.swing.*;
import java.awt.*;

public class AreaUi {
    private JFrame frame = new JFrame("Area Repository");
    private JLabel numberOfResults = new JLabel();
    private DefaultListModel<Area> areaModel = new DefaultListModel<>();
    private DefaultListModel<Meter> meterModel = new DefaultListModel<>();
    private JList<Area> viewAreaList = new JList<>();
    private JList<Meter> viewMeterList = new JList<>();
    private JComboBox<String> comboBox = new JComboBox<>();
    private JComboBox<String> areaComboBox = new JComboBox<>();
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private JButton addButton = new JButton("Add");
    private JScrollPane scroll = new JScrollPane();

    public void createAndShowUi() {
        frame.setSize(400, 600);
        numberOfResults.setBounds(50, 75, 200, 20);
        comboBox.setBounds(50, 50, 200, 20);
        areaComboBox.setBounds(300, 50, 150, 20);

        addButton.setBounds(50, 520, 80, 20);
        editButton.setBounds(150, 520, 80, 20);
        deleteButton.setBounds(250, 520, 80, 20);
        scroll.setBounds(50, 100, 300, 400);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areaComboBox.setRenderer(getRenderer());
        viewAreaList.setCellRenderer(new AreaRenderer());
        viewMeterList.setCellRenderer(new MeterRenderer());

        frame.add(comboBox);
        frame.add(numberOfResults);
        frame.add(addButton);
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

    public DefaultListModel<Area> getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(DefaultListModel<Area> areaModel) {
        this.areaModel = areaModel;
    }

    public DefaultListModel<Meter> getMeterModel() {
        return meterModel;
    }

    public void setMeterModel(DefaultListModel<Meter> meterModel) {
        this.meterModel = meterModel;
    }

    public JList<Area> getViewAreaList() {
        return viewAreaList;
    }

    public void setViewAreaList(JList<Area> viewAreaList) {
        this.viewAreaList = viewAreaList;
    }

    public JList<Meter> getViewMeterList() {
        return viewMeterList;
    }

    public void setViewMeterList(JList<Meter> viewMeterList) {
        this.viewMeterList = viewMeterList;
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

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
}

