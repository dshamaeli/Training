package uk.co.crowderconsult;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AreaRepositoryJDBCTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);

    private AreaRepositoryJDBC areaDB;

    {
        try {
            areaDB = new AreaRepositoryJDBC(Database.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Area> result = null;

    @BeforeClass
    public static void setUp() {
        try {
            Connection connection = Database.getConnection();
            String insertArea1 = "insert into area (area_id,name,area_type,is_active) values (321,'Quality Area 1','QUALITY','y')";//NON-NLS
            String insertArea2 = "insert into area (area_id,name,area_type,is_active) values (987,'Quality Area 2','QUALITY','N')";//NON-NLS
            String insertArea3 = "insert into area (area_id,name,area_type,is_active) values (556,'Hydraulic Area 1','HYDRAULIC','Y')";//NON-NLS
            String insertArea4 = "insert into area (area_id,name,area_type,is_active) values (864,'Hydraulic Area 1','HYDRAULIC','Y')";//NON-NLS
            String insertArea5 = "insert into area (area_id,name,area_type,is_active) values (777,'Operational Area 1','OPERATIONAL','Y')";//NON-NLS
            String insertArea6 = "insert into area (area_id,name,area_type,is_active) values (256,'Operational Area 2','OPERATIONAL','N')";//NON-NLS

            String[] query = {insertArea1, insertArea2, insertArea3, insertArea4, insertArea5, insertArea6};

            for (String q : query) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    LOG.error("Error", e);//NON-NLS
                }
            }
        } catch (SQLException e) {
            LOG.error("Error", e);//NON-NLS
        }
    }

    @AfterClass
    public static void tearDown() {
        try {
            Connection connection = Database.getConnection();
            String deleteArea1 = "delete from area where area_id=321";//NON-NLS
            String deleteArea2 = "delete from area where area_id=987";//NON-NLS
            String deleteArea3 = "delete from area where area_id=556";//NON-NLS
            String deleteArea4 = "delete from area where area_id=864";//NON-NLS
            String deleteArea5 = "delete from area where area_id=777";//NON-NLS
            String deleteArea6 = "delete from area where area_id=256";//NON-NLS
            String[] query = {deleteArea1, deleteArea2, deleteArea3, deleteArea4, deleteArea5, deleteArea6};
            for (String q : query) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    LOG.error("getAllMeters query SQLException", e);//NON-NLS
                }
            }
        } catch (SQLException e) {
            LOG.error("Error", e); //NON-NLS
        }

    }

    @Test
    public void getAllAreas() {
        Integer id = 321;
        result = areaDB.getAllAreas();
        Assert.assertEquals(id, result.get(0).getId());
    }

    @Test
    public void getActiveAreas() {
        result = areaDB.getActiveAreas();
        Assert.assertEquals(4, result.size());
    }
}