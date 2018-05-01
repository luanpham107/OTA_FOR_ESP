package ota.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ota.model.FirmwareInfo;
import ota.model.FirmwareInfoMapper;

@Repository
@Transactional
public class FirmwareInfoDAO extends JdbcDaoSupport {

    @Autowired
    public FirmwareInfoDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public FirmwareInfo findFirmwareInfo(String deviceName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = FirmwareInfoMapper.BASE_SQL + " where u.Device_Name = ? ";

        Object[] params = new Object[] { deviceName };
        FirmwareInfoMapper mapper = new FirmwareInfoMapper();
        try {
            FirmwareInfo firmwareInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return firmwareInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}