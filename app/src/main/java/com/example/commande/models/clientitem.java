package com.example.commande.models;

public class clientitem {

    // fields
    private String ref;
    private double price;
    private String icon;
    private boolean isurgent;

    //contructor
    public clientitem(String ref, double price, String icon, boolean isurgent) {
        this.ref = ref;
        this.price = price;
        this.icon = icon;
        this.isurgent = isurgent;
    }

    public String getRef() {
        return ref;
    }

    public double getPrice() {
        return price;
    }

    public String getIcon() {
        return icon;
    }

    public boolean isIsurgent() {
        return isurgent;
    }
}
