package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIplm implements  ProductService{
    private static Map<Integer,Product> products;
    static {
        products= new HashMap<>();
        products.put(1, new Product(1, "Tivi", 800, 1));
        products.put(2, new Product(2, "Computer", 800,1));
        products.put(3, new Product(3, "Laptop", 800,1));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return  products.get(id);
    }
}
