package com.ashir.E_Commerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private int Stock;
    private double weight;
    private String description;
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;





    public Product( String name, double price, int quantity, int weight, String description,Category category)
    {


        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.description = description;
        this.category=category;

    }
    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }


    public int getStock()
    {
        return Stock;
    }

    public void setStock(int stock)
    {
        Stock = stock;
    }


    public Product(){}

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getWeight()
    {
        return weight;
    }



    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", weight=" + weight +
                ", description='" + description + '\'' +

                ", category=" + category.getName() +

                '}';
    }
}
