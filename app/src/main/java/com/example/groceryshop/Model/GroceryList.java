package com.example.groceryshop.Model;

public class GroceryList {
    private String item_Name;
    private String item_type;
    private String quantity;
    private String price;
    private String unit;

    public GroceryList(String item_Name, String item_type, String quantity, String price, String unit) {
        this.item_Name = item_Name;
        this.item_type = item_type;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
    }

    public GroceryList() {
    }

    public String getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}