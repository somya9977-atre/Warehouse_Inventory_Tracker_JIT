package com.warehouseinventorytracker.main;

import com.warehouseinventorytracker.model.Product;
import com.warehouseinventorytracker.service.AlertService;
import com.warehouseinventorytracker.service.Warehouse;

public class Main 
{
    public static void main(String[] args) 
    {
        AlertService alertService = new AlertService();
        Warehouse warehouse = new Warehouse(alertService);

        Product laptop = new Product(1, "Laptop", 0, 5);
        warehouse.addProduct(laptop);

        warehouse.receiveShipment(1, 10);
        warehouse.fulfillOrder(1, 6);
        warehouse.displayInventory();

        Product phone = new Product(2, "Smartphone", 3, 4);
        warehouse.addProduct(phone);
        warehouse.fulfillOrder(2, 1);

        warehouse.fulfillOrder(99, 5);
        warehouse.fulfillOrder(1, 20);
    }
    
}

