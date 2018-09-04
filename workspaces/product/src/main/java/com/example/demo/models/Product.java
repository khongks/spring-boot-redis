package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "products")
@Data
public class Product {
    @Id
    private String id;
    private String prodName;
    private String prodDesc;
    private Double prodPrice;
    private String prodImage;

    public Product() {
    }

    public Product(String prodName, String prodDesc, Double prodPrice, String prodImage) {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodImage = prodImage;
    }
}