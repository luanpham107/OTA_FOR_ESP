package ota.model;

import org.springframework.jdbc.core.RowMapper;

import ota.model.DeviceInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DeviceInfoMapper implements RowMapper<DeviceInfo> {
    public static final String BASE_SQL //
    = "Select d.Id, d.Name, d.VERSION, d.date, d.comment From DEVICE_INFO d";

    @Override
    public DeviceInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long Id = rs.getLong("id");
        String name = rs.getString("name");
        String version = rs.getString("version");
        Date date = rs.getDate("date");
        String comment = rs.getString("comment");
        return new DeviceInfo(Id, name, version, date, comment);
    }
}
