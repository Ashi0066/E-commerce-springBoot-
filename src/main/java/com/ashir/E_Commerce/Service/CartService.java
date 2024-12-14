package com.ashir.E_Commerce.Service;

import com.ashir.E_Commerce.DTOS.CartDTO.CartGetDTO;
import com.ashir.E_Commerce.DTOS.CartDTO.CartItemDTO;
import com.ashir.E_Commerce.DTOS.CartDTO.CartPostDTO;
import com.ashir.E_Commerce.Models.Cart;
import com.ashir.E_Commerce.Models.Product;
import com.ashir.E_Commerce.Models.User;
import com.ashir.E_Commerce.Repositories.CartRepository;
import com.ashir.E_Commerce.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CartService
{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    public CartService(CartRepository cartRepository, ProductService productService,ProductRepository productRepository)
    {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.productRepository=productRepository;
    }




    @Transactional
    public CartGetDTO addToCart(Long userId,Long productID, int quantity){

        System.out.println("porduct id = "+productID);

        Product product = productRepository.findById(productID).orElseThrow(() -> new RuntimeException("No product as such exist "));

        System.out.printf("Product found with name: %s and stock: %s",product.getName(),product.getStock());
        if (product.getStock()<quantity){
            throw new RuntimeException("Selected Amount exceeds avaliable stock");
        }


        Cart cart = cartRepository.findByUserId(userId).
                orElseGet(()-> {
                    Cart newCart = new Cart();
                  newCart.setUser(new User(userId));

            return cartRepository.save(newCart);


        });

        cart.addItemToCart(product,quantity);
        product.setStock(product.getStock()-quantity);
        cartRepository.save(cart);
        productRepository.save(product);

        return mapToCartGetDTO(cart);

    }

    private CartGetDTO mapToCartGetDTO(Cart cart) {

        return new CartGetDTO(
                cart.getId(),
                cart.getUser().getId(),
                cart.getCartItems().stream()
                        .map(item -> new CartItemDTO(
                                item.getProduct().getId(),
                                item.getProduct().getName(),
                                item.getProduct().getPrice(),
                                item.getQuantity()
                        ))
                        .collect(Collectors.toList()),
                cart.getToalAmount()
        );
    }

    public CartGetDTO getCart(Long userID){
        Cart cart = cartRepository.findByUserId(userID).orElseThrow(()-> new RuntimeException("User not found"));

        return mapToCartGetDTO(cart);
    }



}
