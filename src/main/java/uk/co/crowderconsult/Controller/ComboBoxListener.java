package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaJdbcTemplate;
import uk.co.crowderconsult.Model.utility.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ComboBoxListener implements ActionListener {
    private JFormattedTextField status;

    ComboBoxListener(JFormattedTextField status) {
        this.status = status;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selected = comboBox.getSelectedItem();
        if (selected.equals("All AREAS")) {
            AreaJdbcTemplate areaDb = new AreaJdbcTemplate();
            areaDb.setDataSource(Database.getDataSource());
            List<Area> areaList = areaDb.getAllAreas();
            areaList.stream().forEach(area -> status.setText(status.getText() + "\n" + area.toString()));
        } else if (selected.equals("ACTIVE AREAS")) {
            AreaJdbcTemplate areaDb = new AreaJdbcTemplate();
            areaDb.setDataSource(Database.getDataSource());
            List<Area> areaList = areaDb.getActiveAreas();
            areaList.stream().forEach(area -> status.setText(status.getText() + "\n" + area.toString()));
        } else if (selected.equals("AREA'S METERS")) {
            System.out.println("AREA'S METERS");
        }
    }

}
