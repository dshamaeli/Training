package uk.co.crowderconsult.Model.area;

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
     * @param jdbcTemplate a database
     */
    public void setDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Area> getAllAreas() {
        String query = "select * from area"; //NON-NLS
        return jdbcTemplate.query(query, AreaMapper.getInstance());
    }

    @Override
    public List<Area> getActiveAreas() {
        String query = "select * from area where upper(is_active)='Y'"; //NON-NLS
        return jdbcTemplate.query(query, AreaMapper.getInstance());
    }
}
