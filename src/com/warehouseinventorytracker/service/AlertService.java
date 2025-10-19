package com.warehouseinventorytracker.service;

import com.warehouseinventorytracker.model.Product;
import com.warehouseinventorytracker.observer.StockObserver;

public class AlertService implements StockObserver 
{
    @Override
    public void onLowStock(Product product) 
    {
        System.out.println("⚠️ Restock Alert: Low stock for " 
            + product.getName() + " – only " + product.getQuantity() + " left!");
    }
    
}
