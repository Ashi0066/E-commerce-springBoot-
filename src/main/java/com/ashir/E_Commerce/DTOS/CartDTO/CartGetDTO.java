package com.ashir.E_Commerce.DTOS.CartDTO;

import com.ashir.E_Commerce.DTOS.Product.ProductGetDTO;

import java.util.List;

public class CartGetDTO
{
    private Long cartId;
    private Long userId;
    private List<CartItemDTO> cartItems;
    private double totalAmount;

    // Constructor
    public CartGetDTO(Long cartId, Long userId, List<CartItemDTO> cartItems, double totalAmount) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount()
    {
        totalAmount=cartItems.stream().mapToDouble(item -> item.getProductPrice()*item.getQuantity()).sum();
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getCartId()
    {
        return cartId;
    }

    public void setCartId(Long cartId)
    {
        this.cartId = cartId;
    }

    public List<CartItemDTO> getCartItems()
    {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems)
    {
        this.cartItems = cartItems;
    }
}
