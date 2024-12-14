package com.ashir.E_Commerce.Models;

import jakarta.persistence.*;


@Entity
public class CartItem
{
    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartItem(){}

    public CartItem(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }
}
