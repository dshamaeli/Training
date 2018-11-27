package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.Model.area.AreaType;
import uk.co.crowderconsult.View.AddUi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAreaButtonListener implements ActionListener {
    private AddUi view;
    private AreaRepositoryHibernate model;

    public SaveAreaButtonListener(AddUi view, AreaRepositoryHibernate model) {
        this.view = view;
        this.model = model;
    }

    private Area buildArea() {
        Area area = new Area();
        try {
            area.setAreaId(Integer.parseInt(view.getId().getText()));
            area.setAreaName(view.getName().getText());
            area.setIsActive(view.getIsActive().isSelected());
            area.setAreaType((AreaType) view.getComboBox().getSelectedItem());
        } catch (Exception e) {
            System.out.println(e);
            new JOptionPane("Please enter the area ID");
        }
        return area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Area area = buildArea();
        System.out.println(area);
        area = new Area();
        area.setAreaId(666);
        area.setAreaName("hello");
        area.setIsActive(true);
        area.setAreaType(AreaType.QUALITY);
        model.addArea(area);
    }
}

