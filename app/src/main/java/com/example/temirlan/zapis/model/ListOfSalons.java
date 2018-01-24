
package com.example.temirlan.zapis.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListOfSalons {

    @SerializedName("salons")
    @Expose
    private List<ListItemSalon> salons = null;

    public List<ListItemSalon> getSalons() {
        return salons;
    }

    public void setSalons(List<ListItemSalon> salons) {
        this.salons = salons;
    }

}