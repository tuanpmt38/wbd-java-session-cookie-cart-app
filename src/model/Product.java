package model;

public class Product {
    private  int id ;
    private  String productname;
    double productprice;
    private int amount;
    public Product(){}
    public Product(int id, String productname, double productprice, int amount){
        this.id = id;
        this.productname = productname;
        this.productprice = productprice;
        this.amount = amount ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
