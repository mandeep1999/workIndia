package com.example.workindia.model;

public class ListModal {
    private String name, price, extra;
    public ListModal(String name, String price, String extra){
        this.extra =extra;
        this.name = name;
        this.price = price;
    }

    public String getExtra() {
        return extra;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}