import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername("nb");
        dataSource.setPassword("NB");
        dataSource.setUrl("jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT5");
        return dataSource;
    }

    public static Statement getStatement() throws SQLException {
        BasicDataSource db = createDataSource();
        Connection conn = db.getConnection();
        Statement statement = conn.createStatement();
        return statement;
    }
}
