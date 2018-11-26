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
    private JList<Area> viewList;
    private DefaultListModel<Area> areaModel;
    private JLabel numberOfRows;
    private AreaUi view;


    AreaComboBoxListener(AreaUi areaUi) {
        viewList = areaUi.getViewAreaList();
        areaModel = areaUi.getAreaModel();
        numberOfRows = areaUi.getNumberOfResults();
        view = areaUi;

    }

    private List<Area> getAllAreas() {
        AreaJdbcTemplate areaDb = new AreaJdbcTemplate();
        areaDb.setDataSource(Database.getDataSource());
        List<Area> areaList = areaDb.getAllAreas();

        return areaList;
    }

    private void addAreaToAreaComboBox(List<Area> areaList) {
        JFrame frame = view.getFrame();
        JComboBox meterComboBox = view.getAreaComboBox();
        meterComboBox.removeAllItems();
        frame.add(meterComboBox);
        for (Area area : areaList) {
            meterComboBox.addItem(area);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        view.getScroll().setViewportView(viewList);
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selected = comboBox.getSelectedItem();
        view.getViewAreaList().setModel(areaModel);
        if (selected.equals("All AREAS")) {
            areaModel.removeAllElements();
            List<Area> areaList = getAllAreas();
            numberOfRows.setText("Number of Areas: " + areaList.size());
            areaList.stream().forEach(area -> areaModel.addElement(area));
        } else if (selected.equals("ACTIVE AREAS")) {
            areaModel.removeAllElements();
            AreaJdbcTemplate areaDb = new AreaJdbcTemplate();
            areaDb.setDataSource(Database.getDataSource());
            List<Area> areaList = areaDb.getActiveAreas();
            numberOfRows.setText("Number of Active Areas: " + areaList.size());
            areaList.stream().forEach(area -> areaModel.addElement(area));
        } else if (selected.equals("AREA'S METERS")) {
        }
    }


}
