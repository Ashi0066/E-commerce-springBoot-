package com.ashir.E_Commerce.DTOS.CartDTO;

public class CartPostDTO
{

    private Long userID;
    private Long productId;
    private int quantity;  // Quantity of the product to add

    public CartPostDTO(Long productId, int quantity,Long cartID)
    {
        this.productId = productId;
        this.quantity = quantity;
        this.userID =cartID;
    }

    public Long getUserID()
    {
        return userID;
    }

    public void setUserID(Long userID)
    {
        this.userID = userID;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }
}
