package com.example.auction;

public class Product {

    private String name;
    private double price;
    private int ID;
    private Seller seller;
    private String sellerType;
    private String sellerName;
    private Buyer buyer;
    private String buyerName;
    private String buyerType;
    private double buyerBid;

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public double getBuyerBid() {
        return buyerBid;
    }

    public void setBuyerBid(double buyerBid) {
        this.buyerBid = buyerBid;
    }

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product( int ID,double price) {
        this.price = price;
        this.ID = ID;
    }

    public Product(String name, double price, int ID) {
        this.name = name;
        this.price = price;
        this.ID = ID;
    }
    public Product(String name, double price, int ID, Seller seller){
        this.name = name;
        this.price = price;
        this.ID = ID;
        this.seller = seller;
        if(seller instanceof Farmer){
            sellerType = "Farmer";
            this.sellerName = ((Farmer) seller).getName();
        }
        if(seller instanceof Millers){
            sellerType = "Miller";
            this.sellerName = ((Millers) seller).getName();
        }
        if(seller instanceof FarmingAgency){
            sellerType = "Farming Agency";
            this.sellerName = ((FarmingAgency) seller).getName();
        }
    }
    public Product(String name, double price,Seller seller){
        this.name = name;
        this.price = price;
        this.seller = seller;
        if(seller instanceof Farmer){
            sellerType = "Farmer";
            this.sellerName = ((Farmer) seller).getName();
        }
        if(seller instanceof Millers){
            sellerType = "Miller";
            this.sellerName = ((Millers) seller).getName();
        }
        if(seller instanceof FarmingAgency){
            sellerType = "Farming Agency";
            this.sellerName = ((FarmingAgency) seller).getName();
        }
    }
}
