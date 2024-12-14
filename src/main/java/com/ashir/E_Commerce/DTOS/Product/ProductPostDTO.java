package com.ashir.E_Commerce.DTOS.Product;

public class ProductPostDTO
{

    private Long id;
    private  String name;
    private  double price;
    private  int quantity;
    private double weight;
    private  String description;
    private String category;
    private int stock;

    public ProductPostDTO(Long id, String name, double price, int quantity, int weight, String description,String category,int stock)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.description = description;
        this.category=category;
        this.stock=stock;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getDescription()
    {
        return description;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }
}
