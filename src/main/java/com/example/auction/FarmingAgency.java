package com.example.auction;

public class FarmingAgency extends User implements Buyer,Seller{

    public FarmingAgency(String name, String surname, String password, Long contactNo, String address) {
        super(name, surname, password, contactNo, address);
    }

    public FarmingAgency(int ID, String name, String surname, String password, Long contactNo, String address) {
        super(ID, name, surname, password, contactNo, address);
    }

    @Override
    public void buy(Product product) {

    }

    @Override
    public void sell(Product product) {
        Auction auction = new Auction();
        auction.getAuction().put(this,product);
        DatabaseConnection.addToAuction(this,product);
    }
}
