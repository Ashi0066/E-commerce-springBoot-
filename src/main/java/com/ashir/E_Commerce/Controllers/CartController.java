package com.ashir.E_Commerce.Controllers;


import com.ashir.E_Commerce.DTOS.CartDTO.CartGetDTO;
import com.ashir.E_Commerce.DTOS.CartDTO.CartPostDTO;
import com.ashir.E_Commerce.DTOS.Product.ProductGetDTO;
import com.ashir.E_Commerce.Service.CartService;
import com.ashir.E_Commerce.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController
{
    private CartService cartService;


    public CartController(CartService cartService)
    {
        this.cartService = cartService;
    }

    @PostMapping(path = "/Cart/{userID}/{productID}/{quantity}")
    public ResponseEntity<String> addToCart(@PathVariable Long userID, @PathVariable Long productID, @PathVariable int quantity){


        try{
            System.out.println("adding product with ");
            cartService.addToCart(userID, productID, quantity);
            return ResponseEntity.ok("Product Added to cart ");
        }catch (Exception e){
            System.out.println();
            e.printStackTrace();
         ;
            return ResponseEntity.badRequest().body("Failed to add product to he cart ");

        }
    }


    @GetMapping(path = "/Cart/{userID}")
    public CartGetDTO getCart(@PathVariable Long userID){
        return cartService.getCart(userID);
    }
}
