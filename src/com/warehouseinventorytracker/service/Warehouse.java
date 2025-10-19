package com.warehouseinventorytracker.service;

import com.warehouseinventorytracker.model.Product;
import com.warehouseinventorytracker.observer.StockObserver;
import java.util.HashMap;
import java.util.Map;

public class Warehouse 
{
    private Map<Integer, Product> products;
    private StockObserver observer;

    public Warehouse(StockObserver observer) 
    {
        this.observer = observer;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) 
    {
        if (products.containsKey(product.getId())) 
        {
            System.out.println("❌ Product with ID " + product.getId() + " already exists.");
            return;
        }
        products.put(product.getId(), product);
        System.out.println("✅ Product added: " + product.getName());
    }

    public void receiveShipment(int productId, int quantity)
    {
        Product product = products.get(productId);
        if (product == null) 
        {
            System.out.println("❌ Invalid Product ID: " + productId);
            return;
        }
        
        product.setQuantity(product.getQuantity() + quantity);
        System.out.println("📦 Received shipment of " + quantity + " units for " 
            + product.getName() + " (Total: " + product.getQuantity() + ")");
    }

    public void fulfillOrder(int productId, int quantity) 
    {
        Product product = products.get(productId);
        if (product == null)
        {
            System.out.println("❌ Invalid Product ID: " + productId);
            return;
        }
        
        if (product.getQuantity() < quantity) 
        {
            System.out.println("❌ Insufficient stock for " + product.getName() + "!");
            return;
        }

        product.setQuantity(product.getQuantity() - quantity);
        System.out.println("🧾 Fulfilled order of " + quantity + " units for " + product.getName()
                + " (Remaining: " + product.getQuantity() + ")");

        if (product.getQuantity() < product.getReorderThreshold()) 
        {
            observer.onLowStock(product);
        }
        
    }

    public void displayInventory()
    {
        System.out.println("\n📊 Current Inventory:");
        for (Product product : products.values()) 
        {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName()
                    + ", Quantity: " + product.getQuantity()
                    + ", Threshold: " + product.getReorderThreshold());
        }
    }
    
}

