package by.karpovich.jstexample.service;

import by.karpovich.jstexample.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String id);
    void save(Product product);
    void delete(String id);
    //List<Product> findByPrice(int price);
}
