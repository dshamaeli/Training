package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.meter.Meter;
import uk.co.crowderconsult.Model.meter.MeterRepositoryJDBC;
import uk.co.crowderconsult.Model.utility.Database;
import uk.co.crowderconsult.View.AreaUi;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class MeterController {

    private AreaUi view;
    DefaultListModel model;

    public MeterController(AreaUi view) {
        this.view = view;
        model = view.getMeterModel();
        view.getScroll().setViewportView(view.getViewMeterList());
    }

    public void getAllMeter(Area area) {
        view.getViewMeterList().setModel(model);
        MeterRepositoryJDBC meterRepo;
        List<Meter> meterList = null;
        try {
            meterRepo = new MeterRepositoryJDBC(Database.getConnection());
            meterList = meterRepo.getAllMeters(area);

        } catch (SQLException error) {
            error.printStackTrace();
        }
        model.removeAllElements();

        view.getNumberOfResults().setText("Number of Meters: " + meterList.size());
        meterList.stream().forEach(meter -> model.addElement(meter));
    }
}
