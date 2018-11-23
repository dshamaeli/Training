package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.View.AreaUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondAreaComboBoxListener implements ActionListener {
    private AreaUi view;
    private int counter = 0;

    SecondAreaComboBoxListener(AreaUi view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Area area = (Area) view.getAreaComboBox().getSelectedItem();
        System.out.println("selection " + counter);
    }
}
