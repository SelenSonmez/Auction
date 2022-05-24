package com.example.auction;

public class Farmer extends User implements Seller{

    public Farmer(String name, String surname, String password, Long contactNo, String address) {
        super(name, surname, password, contactNo, address);
    }

    public Farmer(int ID, String name, String surname, String password, Long contactNo, String address) {
        super(ID, name, surname, password, contactNo, address);
    }

    @Override
    public void sell() {

    }
}
