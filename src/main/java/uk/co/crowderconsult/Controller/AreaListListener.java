package uk.co.crowderconsult.Controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AreaListListener implements ListSelectionListener {
    private MeterController controller;

    public AreaListListener(MeterController controller) {
        this.controller = controller;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
}
