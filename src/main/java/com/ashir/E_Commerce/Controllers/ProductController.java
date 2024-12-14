package com.ashir.E_Commerce.Controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashir.E_Commerce.DTOS.Product.ProductGetDTO;
import com.ashir.E_Commerce.DTOS.Product.ProductPostDTO;
import com.ashir.E_Commerce.Models.Product;
import com.ashir.E_Commerce.Service.ProductService;

@Controller
public class ProductController
{

    private ProductService productService;


    public ProductController(ProductService productService){
        this.productService=productService;
    }


    @GetMapping(path = "/products")
    public String getAllProducts(Model model){
        List<ProductGetDTO> products = productService.getProducts();
        System.out.println(products);
        model.addAttribute("products",products);


      return   "index";
    }

    @GetMapping(path = "/products/n")
    public List<Product> getProductsDefault(){
        return productService.getProductsNoDTO();
    }

    @GetMapping(path = "/products/id/{id}")
    public ProductGetDTO getProductByID(@PathVariable Long id){
       return productService.getOneProduct(id);
    }

    @GetMapping(path = "/products/name/{name}")
    public ProductGetDTO getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PostMapping(path = "/products",consumes = {"application/json"})
    public ResponseEntity<ProductGetDTO> addProduct(@RequestBody ProductPostDTO product){
      Product product1= productService.addProduct(product);
       return ResponseEntity.ok(new ProductGetDTO(product1));
    }
}
