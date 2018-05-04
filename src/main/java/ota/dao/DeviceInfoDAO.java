package ota.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ota.model.DeviceInfo;
import ota.model.DeviceInfoMapper;

@Repository
@Transactional
public class DeviceInfoDAO extends JdbcDaoSupport {
    @Autowired
    public DeviceInfoDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public DeviceInfo findDeviceName(String deviceName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = DeviceInfoMapper.BASE_SQL + " where d.device_name = ? ";

        Object[] params = new Object[] { deviceName };
        DeviceInfoMapper mapper = new DeviceInfoMapper();
        try {
            DeviceInfo deviceInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return deviceInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
