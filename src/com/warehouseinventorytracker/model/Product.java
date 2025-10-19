package com.warehouseinventorytracker.model;

public class Product 
{
    private int id;
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Product(int id, String name, int quantity, int reorderThreshold) 
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getReorderThreshold() { return reorderThreshold; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
