import org.apache.commons.dbcp2.BasicDataSource;

public class Database {
    public static BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername("nb");
        dataSource.setPassword("NB");
        dataSource.setUrl("jdbc:oracle:thin:@CCVMDBS12:1521:NBBDEV1");
        return dataSource;
    }
}
