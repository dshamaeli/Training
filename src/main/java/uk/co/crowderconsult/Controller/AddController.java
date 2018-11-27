package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.View.AddUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController {
    private AddUi view;
    private AreaRepositoryHibernate areaRepo;

    public AddController(AddUi view, AreaRepositoryHibernate areaRepo) {
        this.view = view;
        this.areaRepo = areaRepo;
    }


    public void initView() {
        view.getSaveButton().addActionListener(new SaveAreaButtonListener(view, areaRepo));
        view.getCancelButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.getFrame().dispose();
            }
        });
    }
}
