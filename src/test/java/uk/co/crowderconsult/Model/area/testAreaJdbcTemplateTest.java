package uk.co.crowderconsult.Model.area;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class testAreaJdbcTemplateTest {

    @Test
    public void getAllAreasTest() {
        Integer id = 123;
        Area area = new Area();
        area.setAreaId(id);
        List<Area> areaList = new ArrayList<>();
        areaList.add(area);
        JdbcTemplate mockDB = mock(JdbcTemplate.class);
        String sql = "select * from area"; //NON-NLS
        given(mockDB.query(sql, AreaMapper.getInstance())).willReturn(areaList);
        AreaJdbcTemplate areaDB = new AreaJdbcTemplate();
        areaDB.setDataSource(mockDB);
        List<Area> result = areaDB.getAllAreas();
        Assert.assertEquals(id, result.get(0).getAreaId());

    }

    @Test
    public void getActiveAreasTest() {
        Integer id = 123;
        Area area = new Area();
        area.setAreaId(id);
        List<Area> areaList = new ArrayList<>();
        areaList.add(area);
        JdbcTemplate mockDB = mock(JdbcTemplate.class);
        String sql = "select * from area where upper(is_active)='Y'"; //NON-NLS
        given(mockDB.query(sql, AreaMapper.getInstance())).willReturn(areaList);
        AreaJdbcTemplate areaDB = new AreaJdbcTemplate();
        areaDB.setDataSource(mockDB);
        List<Area> result = areaDB.getActiveAreas();
        Assert.assertEquals(id, result.get(0).getAreaId());
    }
}