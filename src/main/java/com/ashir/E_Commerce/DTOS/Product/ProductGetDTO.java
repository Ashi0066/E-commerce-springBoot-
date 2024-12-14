package com.ashir.E_Commerce.DTOS.Product;

import com.ashir.E_Commerce.Models.Product;

public class ProductGetDTO
{
    private final Long id;
    private final String name;
    private final double price;
    private final int quantity;
    private final double weight;
    private final String description;
    private final int Stock;
    private final byte[] image;
    private final String categoryName;
    private final String addToCartLink;



    public ProductGetDTO(Product product)
    {

        this.id = product.getId();

        this.name = product.getName();

        this.description = product.getDescription();
        this.image = product.getImage();
        this.weight = product.getWeight();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.categoryName = product.getCategory().getName();
        this.Stock = product.getStock();
        this.addToCartLink= "/cart"+"/1";
    }

    public byte[] getImage()
    {
        return image;
    }


    public String getDescription()
    {
        return description;
    }


    public double getWeight()
    {
        return weight;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public double getPrice()
    {
        return price;
    }


    public String getName()
    {
        return name;
    }
    public int getStock()
    {
        return Stock;
    }
    public String getCategoryName()
    {
        return categoryName;
    }
}
