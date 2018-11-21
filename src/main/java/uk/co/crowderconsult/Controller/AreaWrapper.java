package uk.co.crowderconsult.Controller;

import uk.co.crowderconsult.Model.area.Area;

public class AreaWrapper {
    Area area;

    AreaWrapper(Area area) {
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Area: " + area.getAreaId();
    }
}
