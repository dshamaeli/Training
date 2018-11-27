package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.View.AreaUi;

public class mainController {
    public static void main(String[] args) {

        AreaUi areaView = new AreaUi();
        AreaRepositoryHibernate model = new AreaRepositoryHibernate();
        AreaController controller = new AreaController(areaView, model);
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.initView();
        });
    }
}
