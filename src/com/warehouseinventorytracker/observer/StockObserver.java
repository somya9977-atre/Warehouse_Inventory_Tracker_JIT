package com.warehouseinventorytracker.observer;

import com.warehouseinventorytracker.model.Product;

public interface StockObserver 
{
    void onLowStock(Product product);
}

