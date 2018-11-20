package uk.co.crowderconsult.Model.area;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Spring repository for Area class
 *
 * @author daniel.shamaeli
 */
public class AreaJdbcTemplate implements AreaRepository {
    private JdbcTemplate jdbcTemplate;

    /**
     * creates data source to connect to database
     *
     * @param dataSource a database
     */
    public void setDataSource(BasicDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Area> getAllAreas() {
        String query = "select * from area"; //NON-NLS
        List<Area> list = jdbcTemplate.query(query, new AreaMapper());
        return list;
    }

    @Override
    public List<Area> getActiveAreas() {
        String query = "select * from area where upper(is_active)='Y'"; //NON-NLS
        List<Area> list = jdbcTemplate.query(query, new AreaMapper());
        return list;
    }
}
