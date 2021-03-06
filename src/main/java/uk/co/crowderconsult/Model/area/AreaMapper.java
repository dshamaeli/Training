package uk.co.crowderconsult.Model.area;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Maps Area class to Area Table
 *
 * @author daniel.shamaeli
 */
public class AreaMapper implements RowMapper<Area> {
    private static final AreaMapper singleInstance = new AreaMapper();

    private AreaMapper() {
    }

    public static AreaMapper getInstance() {
        return singleInstance;
    }

    @Override

    public Area mapRow(ResultSet rs, int rowNum) throws SQLException {
        Area area = new Area();
        area.setAreaId(rs.getInt("area_id"));//NON-NLS
        area.setAreaName(rs.getString("name"));//NON-NLS
        area.setAreaType(AreaType.valueOf(rs.getString("area_type")));//NON-NLS
        area.setIsActive(rs.getBoolean("is_active"));//NON-NLS
        return area;
    }
}
