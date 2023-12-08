package com.example.hseandroidlab2;

public class Product {

    private String name; // название
    private int amount;  // столица

    public Product(String name, int amount){

        this.name=name;
        this.amount = amount;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}