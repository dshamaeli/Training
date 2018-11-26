package uk.co.crowderconsult.Model.utility;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class to connect to JDBC
 *
 * @author Daniel.shamaeli
 */
public class Database {
    private static BasicDataSource createDataSource(String url) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");//NON-NLS
        dataSource.setUsername("nb"); //NON-NLS
        dataSource.setPassword("NB");//NON-NLS
        dataSource.setUrl(url);//NON-NLS
        return dataSource;
    }

    private Database() {

    }

    private static String getUrl(String url) {
        if ("NIGHT5".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT5";//NON-NLS

        } else if ("FEAT04".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMFEATURE:1521:FEAT04";//NON-NLS
        }
        return url;
    }

    /**
     * creates database connection
     *
     * @return statement object to query JDBC
     * @throws SQLException throws exception if it fails to connect
     */
    public static Connection getConnection() throws SQLException {
        String url = "NIGHT5";
        url = getUrl(url);
        BasicDataSource db = createDataSource(url);
        return db.getConnection();
    }

    /**
     * gives database connection
     *
     * @return database source
     */
    public static JdbcTemplate getDataSource() {
        String url = "NIGHT5";
        url = getUrl(url);
        return new JdbcTemplate(createDataSource(url));
    }
}
