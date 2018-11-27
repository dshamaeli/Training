package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.View.AddUi;
import uk.co.crowderconsult.View.AreaUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener {
    private AreaUi view;

    public AddButtonListener(AreaUi view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AddUi();
    }


}
