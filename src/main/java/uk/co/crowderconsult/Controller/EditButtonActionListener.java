package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.View.AddUi;
import uk.co.crowderconsult.View.AreaUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditButtonActionListener implements ActionListener {
    private AreaUi view;
    private AreaRepositoryHibernate model;

    public EditButtonActionListener(AreaUi view, AreaRepositoryHibernate model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Area area = view.getViewAreaList().getSelectedValue();
        new EditController(area, new AddUi(), model);

    }
}
