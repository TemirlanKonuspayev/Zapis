
package com.example.temirlan.zapis.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FullSalonInfo {

    @SerializedName("salon")
    @Expose
    private Salon salon;
    @SerializedName("masters")
    @Expose
    private List<Master> masters = null;
    @SerializedName("services")
    @Expose
    private List<Service> services = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public List<Master> getMasters() {
        return masters;
    }

    public void setMasters(List<Master> masters) {
        this.masters = masters;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
