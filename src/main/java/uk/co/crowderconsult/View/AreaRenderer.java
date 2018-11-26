package uk.co.crowderconsult.View;

import uk.co.crowderconsult.Model.area.Area;

import javax.swing.*;
import java.awt.*;

/**
 * @author daniel.shamaeli
 */
public class AreaRenderer extends JLabel implements ListCellRenderer<Area> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Area> list, Area value, int index, boolean isSelected, boolean cellHasFocus) {

        setText("Area: \"" + value.getAreaId() + "\" | \"" + value.getAreaName() + "\"");

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
