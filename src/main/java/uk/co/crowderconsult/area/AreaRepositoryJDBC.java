package uk.co.crowderconsult.area;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel.shamaeli
 * @see AreaRepository
 */
public class AreaRepositoryJDBC implements AreaRepository {
    private static final Logger LOG = LoggerFactory.getLogger(AreaRepositoryJDBC.class);
    private Connection connection;

    public AreaRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    private List<Area> generateArea(ResultSet result) throws SQLException {
        List<Area> list = new ArrayList<>();
        while (result.next()) {
            Integer areaId = result.getInt("area_id");//NON-NLS
            String name = result.getString("name");//NON-NLS
            AreaType areaType = AreaType.valueOf(result.getString("area_type"));//NON-NLS
            Boolean isActive = result.getBoolean("is_active");//NON-NLS
            Area area = new Area(areaId, name, areaType, isActive);
            list.add(area);
        }
        return list;
    }

    @Override
    public List<Area> getAllAreas() {
        ResultSet result;
        List<Area> list = new ArrayList<>();
        String query = "select * from area"; //NON-NLS
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            result = preparedStatement.executeQuery();
            list = generateArea(result);
        } catch (SQLException e) {
            LOG.error("getAllAreas query SQLException", e);//NON-NLS
        }
        return list;
    }

    @Override
    public List<Area> getActiveAreas() {
        ResultSet result;
        List<Area> list = new ArrayList<>();
        String query = "select * from area where upper(is_active)='Y'"; //NON-NLS
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            result = preparedStatement.executeQuery();
            list = generateArea(result);
        } catch (SQLException e) {
            LOG.error("getAllAreas query SQLException", e);//NON-NLS
        }
        return list;
    }
}
