package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.View.AddUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener {
    private AreaRepositoryHibernate model;

    public AddButtonListener(AreaRepositoryHibernate model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AddController(new AddUi(), model).initView();
    }


}
