package ota.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ota.model.FirmwareInfo;
import org.springframework.jdbc.core.RowMapper;

public class FirmwareInfoMapper implements RowMapper<FirmwareInfo> {

    public static final String BASE_SQL //
            = "Select d.Device_Id, d.Device_Name, d.DEVICE_FW_VERSION, d.device_date, d.device_comment From DEVICE_INFO d ";

    @Override
    public FirmwareInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long device_id = rs.getLong("DEVICE_ID");
        String deviceName = rs.getString("DEVICE_NAME");
        String deviceVersion = rs.getString("DEVICE_FW_VERSION");
        Date deviceDate = rs.getDate(4);
        String deviceComment = rs.getString("DEVICE_COMMENT");

        return new FirmwareInfo(device_id, deviceName, deviceVersion, deviceDate, deviceComment);
    }

}