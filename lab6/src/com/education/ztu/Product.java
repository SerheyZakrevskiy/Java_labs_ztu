package com.education.ztu;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, quantity=%d, totalCost=%.2f}",
                name, price, quantity, getTotalCost());
    }
}
