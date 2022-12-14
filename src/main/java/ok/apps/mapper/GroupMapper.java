package ok.apps.mapper;

import ok.apps.model.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements RowMapper<Group> {
    public Group mapRow(ResultSet resultSet, int i) throws SQLException {
        Group group = new Group();
        group.setId(resultSet.getLong("id"));
        group.setName(resultSet.getString("name"));
        group.setSpecId(resultSet.getLong("specid"));
        group.setSpecName(resultSet.getString("specname"));
        return group;
    }
}