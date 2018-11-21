package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.meter.Meter;
import uk.co.crowderconsult.Model.meter.MeterRepositoryJDBC;
import uk.co.crowderconsult.Model.utility.Database;
import uk.co.crowderconsult.View.AreaUi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MeterComboBoxListener implements ActionListener {
    private AreaUi view;

    MeterComboBoxListener(AreaUi view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MeterRepositoryJDBC meterRepo;
        List<Meter> meterList;
        Area area = (Area) view.getAreaComboBox().getSelectedItem();
        try {
            meterRepo = new MeterRepositoryJDBC(Database.getConnection());
            meterList = meterRepo.getAllMeters(area);
            JTextArea status = view.getStatus();
            status.setText("");
            view.getNumberOfResults().setText("Number of Meters: " + meterList.size());
            meterList.stream().forEach(meter -> status.setText(status.getText() + "\n" + meter.toString()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


    }
}
