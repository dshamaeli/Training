package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.Model.area.AreaType;
import uk.co.crowderconsult.View.AddUi;

public class AddController {
    private AddUi view;
    private AreaRepositoryHibernate areaRepo = new AreaRepositoryHibernate();

    public AddController(AddUi view) {
        this.view = view;
    }


    private void saveArea() {
        Area area = new Area();
        area.setAreaId(Integer.parseInt(view.getId().getText()));
        area.setAreaName(view.getName().getText());
        area.setIsActive(view.getIsActive().isSelected());
        area.setAreaType((AreaType) view.getComboBox().getSelectedItem());
        areaRepo.addArea(area);
    }
}
