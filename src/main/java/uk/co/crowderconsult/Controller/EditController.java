package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaRepositoryHibernate;
import uk.co.crowderconsult.View.AddUi;

public class EditController {
    private Area area;
    private AddUi view;
    private AreaRepositoryHibernate model;

    //todo
    public EditController(Area area, AddUi view, AreaRepositoryHibernate model) {
        this.area = area;
        this.view = view;
        this.model = model;
    }

}
