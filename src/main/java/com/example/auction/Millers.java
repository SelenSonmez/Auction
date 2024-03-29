package com.example.auction;

public class Millers extends User implements Buyer,Seller {

    public Millers(String name, String surname, String password, Long contactNo, String address) {
        super(name, surname, password, contactNo, address);
    }

    public Millers(int ID, String name, String surname, String password, Long contactNo, String address) {
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
