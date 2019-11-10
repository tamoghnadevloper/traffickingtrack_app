package com.wwf.traffikingtrack;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Prodsum implements Serializable {

    @SerializedName("productProcess")
    private List<Prodsuminner>Inner = null;

    public List<Prodsuminner> getInner() {
        return Inner;
    }

    public void setInner(List<Prodsuminner> inner) {
        Inner = inner;
    }
}
