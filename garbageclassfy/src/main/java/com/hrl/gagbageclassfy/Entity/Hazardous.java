package com.hrl.gagbageclassfy.Entity;

import lombok.Data;

//有害垃圾

public class Hazardous {
    private Integer id;
    private String hazname;
    private String sorted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHazname() {
        return hazname;
    }

    public void setHazname(String hazname) {
        this.hazname = hazname;
    }

    public String getSorted() {
        return sorted;
    }

    public void setSorted(String sorted) {
        this.sorted = sorted;
    }
}
