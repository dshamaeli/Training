package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Model.meter.Meter;

import javax.swing.*;
import java.awt.*;

public class MeterRenderer extends JLabel implements ListCellRenderer<Meter> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Meter> list, Meter value, int index, boolean isSelected, boolean cellHasFocus) {
        setText("Meter: \"" + value.getId() + "\" | \"" + value.getName() + "\"");

        Color background;
        Color foreground;

        if (isSelected) {
            background = Color.white;
            foreground = Color.BLUE;

            // unselected, and not the DnD drop location
        } else {
            background = Color.white;
            foreground = Color.BLACK;
        }

        setBackground(background);
        setForeground(foreground);

        return this;
    }
}
