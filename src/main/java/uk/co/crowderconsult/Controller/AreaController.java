package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.AreaJdbcTemplate;
import uk.co.crowderconsult.View.AreaUi;

import javax.swing.*;

public class AreaController {
    private AreaUi view;
    private AreaJdbcTemplate model;
    private String[] functions = {"All AREAS", "ACTIVE AREAS", "AREA'S METERS"};
//    private String[] functions = {"Apple", "Peach", "Orange"};

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
        view.getHeader().setText("Data");
        view.createAndShowUi();
        view.getComboBox().addActionListener(new ComboBoxListener(view.getStatus()));
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
