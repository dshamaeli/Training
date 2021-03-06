package uk.co.crowderconsult;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaJdbcTemplate;
import uk.co.crowderconsult.Model.utility.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AreaJdbcTemplateTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaRepositoryJDBCTest.class);
    private AreaJdbcTemplate areaDB = new AreaJdbcTemplate();
    private List<Area> result = null;

    @BeforeClass
    public static void setUp() throws SQLException {
        Connection connection = Database.getConnection();
        String insertArea1 = "insert into area (area_id,name,area_type,is_active) values (321,'Quality Area 1','QUALITY','Y')";//NON-NLS
        String insertArea2 = "insert into area (area_id,name,area_type,is_active) values (987,'Quality Area 2','QUALITY','N')";//NON-NLS
        String insertArea3 = "insert into area (area_id,name,area_type,is_active) values (556,'Hydraulic Area 1','HYDRAULIC','Y')";//NON-NLS
        String insertArea4 = "insert into area (area_id,name,area_type,is_active) values (864,'Hydraulic Area 1','HYDRAULIC','Y')";//NON-NLS
        String insertArea5 = "insert into area (area_id,name,area_type,is_active) values (777,'Operational Area 1','OPERATIONAL','Y')";//NON-NLS
        String insertArea6 = "insert into area (area_id,name,area_type,is_active) values (256,'Operational Area 2','OPERATIONAL','N')";//NON-NLS

        String[] query = {insertArea1, insertArea2, insertArea3, insertArea4, insertArea5, insertArea6};

        for (String q : query) {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.executeUpdate();
        }
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        Connection connection = Database.getConnection();
        String deleteArea1 = "delete from area where area_id=321";//NON-NLS
        String deleteArea2 = "delete from area where area_id=987";//NON-NLS
        String deleteArea3 = "delete from area where area_id=556";//NON-NLS
        String deleteArea4 = "delete from area where area_id=864";//NON-NLS
        String deleteArea5 = "delete from area where area_id=777";//NON-NLS
        String deleteArea6 = "delete from area where area_id=256";//NON-NLS
        String[] query = {deleteArea1, deleteArea2, deleteArea3, deleteArea4, deleteArea5, deleteArea6};
        for (String q : query) {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.executeUpdate();
        }

    }

    @Test
    public void getAllAreas() {
        areaDB.setDataSource(Database.getDataSource());
        result = areaDB.getAllAreas();
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void getActiveAreas() {
        areaDB.setDataSource(Database.getDataSource());
        result = areaDB.getActiveAreas();
        Assert.assertEquals(4, result.size());
    }
}