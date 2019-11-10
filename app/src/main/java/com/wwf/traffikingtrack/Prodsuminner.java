package com.wwf.traffikingtrack;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Prodsuminner implements Serializable {

    @SerializedName("productTypeName")
    private String Prodtypname;

    @SerializedName("isNaturalSeasonsed")
   private String isIssesnd;
    @SerializedName("productAge")
    private String agge;

    @SerializedName("productListName")
    private String prodlstnam;


    public String getProdtypname() {
        return Prodtypname;
    }

    public void setProdtypname(String prodtypname) {
        Prodtypname = prodtypname;
    }



    public String getAgge() {
        return agge;
    }

    public void setAgge(String agge) {
        this.agge = agge;
    }

    public String getProdlstnam() {
        return prodlstnam;
    }

    public void setProdlstnam(String prodlstnam) {
        this.prodlstnam = prodlstnam;
    }

    public String getIsIssesnd() {
        return isIssesnd;
    }

    public void setIsIssesnd(String isIssesnd) {
        this.isIssesnd = isIssesnd;
    }
}
