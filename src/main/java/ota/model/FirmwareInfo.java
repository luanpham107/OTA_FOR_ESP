package ota.model;

import java.util.Date;

public class FirmwareInfo {
    private long id;
    private String name;
    private String version;
    private Date date;
    private String comment;

    public FirmwareInfo(long id, String name, String version, Date date, String comment) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.date = date;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
