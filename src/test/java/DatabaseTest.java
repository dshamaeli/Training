package uk.co.crowderconsult;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DatabaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);

    @Before
    public void setUp() {
        try {
            Connection connection = Database.getConnection();
            String query = "insert into area (area_id,name,area_type,is_active) values (1011,'Quality Area 1','QUALITY','y')";//NON-NLS
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                LOG.error("Error", e);//NON-NLS
            }
        } catch (SQLException e) {
            LOG.error("Error", e);//NON-NLS
        }
    }

    @After
    public void tearDown() {
        try {
            Connection connection = Database.getConnection();
            String query = "delete from area where area_id=1011";//NON-NLS
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                LOG.error("getAllMeters query SQLException", e);//NON-NLS
            }
        } catch (SQLException e) {
            LOG.error("Error", e); //NON-NLS
        }
    }

    @Test
    public void getConnection() throws SQLException {
        Connection connection;

        connection = Database.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from area");
        result.next();
        Assert.assertEquals(1011, result.getInt("area_id"));


    }
}