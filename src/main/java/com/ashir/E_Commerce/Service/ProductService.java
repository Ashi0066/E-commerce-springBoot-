package com.ashir.E_Commerce.Service;


import com.ashir.E_Commerce.DTOS.Product.ProductGetDTO;
import com.ashir.E_Commerce.DTOS.Product.ProductPostDTO;
import com.ashir.E_Commerce.Models.Category;
import com.ashir.E_Commerce.Models.Product;
import com.ashir.E_Commerce.Repositories.CategoryRepository;
import com.ashir.E_Commerce.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


// Product service class which handles all the logic concerning the product
@Service
public class ProductService
{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public ProductService (ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    public ProductGetDTO grtMapToDTO(Product product){

        return new ProductGetDTO(product);
    }





    public List<ProductGetDTO> getProducts(){

       return productRepository.findAll().stream().map(this::grtMapToDTO).collect(Collectors.toList());
    }
    public List<Product> getProductsNoDTO(){
       return productRepository.findAll();
    }

    public Product addProduct(ProductPostDTO postDTO){

        Category category= categoryRepository.findByName(postDTO.getCategory()).orElseThrow(()-> new RuntimeException("Category not found"));

        Product product = new Product();
               product.setName(postDTO.getName());
               product.setCategory(category);
               product.setDescription(postDTO.getDescription());
               product.setPrice(postDTO.getPrice());
               product.setWeight(postDTO.getWeight());
               product.setQuantity(postDTO.getQuantity());
               product.setStock(postDTO.getStock());

        return productRepository.save(product);
    }

    public ProductGetDTO getOneProduct(Long id){
        return productRepository.findById(id).map(this::grtMapToDTO).orElseThrow(()-> new RuntimeException("Can not find product with this id " +id));

    }

    public ProductGetDTO getProductByName(String name){
        return productRepository.findByName(name.toLowerCase()).map(this::grtMapToDTO).orElseThrow(()-> new RuntimeException("Can not find product with this id " +name));
    }










}
