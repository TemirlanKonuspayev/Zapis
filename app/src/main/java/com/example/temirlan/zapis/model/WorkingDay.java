
package com.example.temirlan.zapis.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkingDay {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("busyTimes")
    @Expose
    private List<Object> busyTimes = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Object> getBusyTimes() {
        return busyTimes;
    }

    public void setBusyTimes(List<Object> busyTimes) {
        this.busyTimes = busyTimes;
    }

}
