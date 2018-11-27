package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.View.AreaUi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author daniel.shamaeli
 */
public class AreaController {
    private AreaUi view;
    private AreaRepositoryHibernate model;
    private String[] functions = {"All AREAS", "ACTIVE AREAS"};

    public AreaController(AreaUi view, AreaRepositoryHibernate model) {
        this.view = view;
        this.model = model;
    }

    public AreaUi getView() {
        return view;
    }

    public void setView(AreaUi view) {
        this.view = view;
    }

    public AreaRepositoryHibernate getModel() {
        return model;
    }

    public void setModel(AreaRepositoryHibernate model) {
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
        view.getAddButton().addActionListener(new AddButtonListener(model));
        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JList areaList = view.getViewAreaList();
                if (!areaList.isSelectionEmpty()) {
                    Area area = (Area) areaList.getSelectedValue();
                    model.deleteArea(area);
                } else {
                    JOptionPane optionPane = new JOptionPane("Please select an area(s)", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Delete Area Error");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
            }
        });
        view.getEditButton().addActionListener(new EditButtonActionListener(view, model));

        view.getViewAreaList().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    Area area = view.getViewAreaList().getSelectedValue();
                    new MeterController(view).getAllMeter(area);
                }
            }
        });
    }
}
