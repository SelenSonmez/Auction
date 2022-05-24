package com.example.auction;

public class AgricultureAgency extends User implements Buyer{

    public AgricultureAgency(String name, String surname, String password, Long contactNo, String address) {
        super(name, surname, password, contactNo, address);
    }

    public AgricultureAgency(int ID, String name, String surname, String password, Long contactNo, String address) {
        super(ID, name, surname, password, contactNo, address);
    }

    @Override
    public void buy() {

    }
}
