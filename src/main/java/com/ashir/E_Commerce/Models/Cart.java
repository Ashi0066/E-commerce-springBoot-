package com.ashir.E_Commerce.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<CartItem> cartItems=new ArrayList<>();

    private int toalAmount;


    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Cart(){}
    public Cart(CartItem cartItem){
        this.cartItems = new ArrayList<>();
        cartItems.add(cartItem);

    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public int getToalAmount()
    {
        return toalAmount;
    }

    public void setToalAmount(int toalAmount)
    {
        this.toalAmount = toalAmount;
    }

    public List<CartItem> getCartItems()
    {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems)
    {
        this.cartItems = cartItems;
    }


    public void addItemToCart(Product product,int qunatity ){
        CartItem cartItem = cartItems.stream().filter(
                item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (cartItem==null){
            CartItem cartItem1 = new CartItem(product,qunatity);
            cartItems.add(cartItem1);
        }else {
            cartItem.setQuantity(cartItem.getQuantity()+qunatity);
        }

    }

    public void updateTotal(){
        toalAmount= (int) cartItems.stream()
                .mapToDouble(item-> item.getProduct().getPrice()*item.getQuantity())
                .sum();
    }
}
