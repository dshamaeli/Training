package uk.co.crowderconsult.Model.utility;

import org.apache.commons.dbcp2.BasicDataSource;

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

    /**
     * creates database connection
     *
     * @return statement object to query JDBC
     * @throws SQLException throws exception if it fails to connect
     */
    public static Connection getConnection() throws SQLException {
        String url = "NIGHT9";
        if ("NIGHT9".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT9";//NON-NLS

        } else if ("FEAT04".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMFEATURE:1521:FEAT04";//NON-NLS

        }

        BasicDataSource db = createDataSource(url);
        return db.getConnection();
    }

    /**
     * gives database connection
     *
     * @return database source
     */
    public static BasicDataSource getDataSource() {
        String url = "NIGHT9";
        if ("NIGHT9".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT9";//NON-NLS

        } else if ("FEAT04".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMFEATURE:1521:FEAT04";//NON-NLS

        }
        return createDataSource(url);
    }
}
