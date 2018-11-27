package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.AreaJdbcTemplate;
import uk.co.crowderconsult.View.AreaUi;

public class mainController {
    public static void main(String[] args) {

        AreaUi view = new AreaUi();
        AreaJdbcTemplate model = new AreaJdbcTemplate();
        AreaController controller = new AreaController(view, model);
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.initView();
        });
    }
}
