package ota.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "device_info", schema = "db_user")

public class DeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String name;
    private String version;
    private Date date;
    private String comment;

    public DeviceInfo(long id, String name, String version, Date date, String comment) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.date = date;
        this.comment = comment;
    }

    public DeviceInfo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
