import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class to connect to JDBC
 *
 * @author Daniel.shamaeli
 */
public class Database {
    private static BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");//NON-NLS
        dataSource.setUsername("nb"); //NON-NLS
        dataSource.setPassword("NB");//NON-NLS
        dataSource.setUrl("jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT5");//NON-NLS
//        dataSource.setUrl("jdbc:oracle:thin:@CCVMFEATURE:1521:FEAT04"); //NON-NLS
        return dataSource;
    }

    private Database() {

    }

    /**
     * @return statement object to query JDBC
     * @throws SQLException throws exception if it fails to connect
     */
    public static Connection getConnection() throws SQLException {
        BasicDataSource db = createDataSource();
        return db.getConnection();
    }
}
