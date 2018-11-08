package uk.co.crowderconsult;

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
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//NON-NLS
        dataSource.setUsername("daniel"); //NON-NLS
        dataSource.setPassword("153426");//NON-NLS
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
    static Connection getConnection() throws SQLException {
        String url = "LOCAL";
        if (url.equals("LOCAL")) {
            url = "jdbc:mysql://localhost/training";
        } else if ("NIGHT5".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT5";//NON-NLS

        } else if ("FEAT04".equals(url)) {
            url = "jdbc:oracle:thin:@CCVMFEATURE:1521:FEAT04";//NON-NLS

        }

        BasicDataSource db = createDataSource(url);
        return db.getConnection();
    }
}
