package by.karpovich.jstexample.model;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private int price;
    public Product(){}
    public Product(String name, int price, String id){
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
