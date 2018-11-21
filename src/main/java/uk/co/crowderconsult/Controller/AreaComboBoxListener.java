package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaJdbcTemplate;
import uk.co.crowderconsult.Model.utility.Database;
import uk.co.crowderconsult.View.AreaUi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AreaComboBoxListener implements ActionListener {
    private JTextArea status;
    private JLabel numberOfRows;
    private AreaUi view;

    AreaComboBoxListener(AreaUi areaUi) {
        this.status = areaUi.getStatus();
        this.numberOfRows = areaUi.getNumberOfResults();
        this.view = areaUi;
    }

    private List<Area> getAllAreas() {
        AreaJdbcTemplate areaDb = new AreaJdbcTemplate();
        areaDb.setDataSource(Database.getDataSource());
        List<Area> areaList = areaDb.getAllAreas();
        return areaList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selected = comboBox.getSelectedItem();
        if (selected.equals("All AREAS")) {
            status.setText("");
            List<Area> areaList = getAllAreas();
            numberOfRows.setText("Number of Areas: " + areaList.size());
            areaList.stream().forEach(area -> status.setText(status.getText() + "\n" + area.toString()));
        } else if (selected.equals("ACTIVE AREAS")) {
            status.setText("");
            AreaJdbcTemplate areaDb = new AreaJdbcTemplate();
            areaDb.setDataSource(Database.getDataSource());
            List<Area> areaList = areaDb.getActiveAreas();
            numberOfRows.setText("Number of Active Areas: " + areaList.size());
            areaList.stream().forEach(area -> status.setText(status.getText() + "\n" + area.toString()));
        } else if (selected.equals("AREA'S METERS")) {
            status.setText("");
            List<Area> areaList = getAllAreas();

            JComboBox areaComboBox = view.getAreaComboBox();
            for (Area area : areaList) {
                areaComboBox.addItem(area);
            }
            JFrame frame = view.getFrame();
            frame.add(areaComboBox);
        }
    }

}
