package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaJdbcTemplate;
import uk.co.crowderconsult.View.AreaUi;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author daniel.shamaeli
 */
public class AreaController {
    private AreaUi view;
    private AreaJdbcTemplate model;
    private String[] functions = {"All AREAS", "ACTIVE AREAS"};

    public AreaController(AreaUi view, AreaJdbcTemplate model) {
        this.view = view;
        this.model = model;
    }

    public AreaUi getView() {
        return view;
    }

    public void setView(AreaUi view) {
        this.view = view;
    }

    public AreaJdbcTemplate getModel() {
        return model;
    }

    public void setModel(AreaJdbcTemplate model) {
        this.model = model;
    }

    public String[] getFunctions() {
        return functions;
    }

    public void setFunctions(String[] functions) {
        this.functions = functions;
    }

    public void initView() {
        view.setComboBox(new JComboBox<String>(functions));
        view.createAndShowUi();
        view.getComboBox().addActionListener(new AreaComboBoxListener(view));
        view.getAddButton().addActionListener(new AddButtonListener(view));

        view.getViewAreaList().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    Area area = view.getViewAreaList().getSelectedValue();
                    new MeterController(view).getAllMeter(area);
                }
            }
        });
    }

    public static void main(String[] args) {
        AreaUi view = new AreaUi();
        AreaJdbcTemplate model = new AreaJdbcTemplate();
        AreaController controller = new AreaController(view, model);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                controller.initView();
            }
        });
    }
}
