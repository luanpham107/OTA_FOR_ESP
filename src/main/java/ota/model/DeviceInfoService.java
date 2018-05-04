package ota.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ota.dao.DeviceInfoDAO;

@Service
public class DeviceInfoService {
    @Autowired
    private DeviceInfoDAO deviceInfoDAO;

    public DeviceInfo getDevice(String deviceName){
        DeviceInfo deviceInfo = this.deviceInfoDAO.findDeviceName(deviceName);
        if(deviceInfo == null) {
            System.out.println("Device not found");
            return null;
        }
        else {
            System.out.println("Found " + deviceInfo.getName());
            return deviceInfo;
        }

    }
}
