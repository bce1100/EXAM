package com.ljj.entity;

import java.util.Date;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class Language {
    private short languageId;
    private String name;
    private Date lastUpdate;

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
