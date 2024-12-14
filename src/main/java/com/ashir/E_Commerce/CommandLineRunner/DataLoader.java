package com.ashir.E_Commerce.CommandLineRunner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashir.E_Commerce.DTOS.CategoryDTO.CategoryPostDTO;
import com.ashir.E_Commerce.DTOS.Product.ProductPostDTO;
import com.ashir.E_Commerce.Service.CategoryService;
import com.ashir.E_Commerce.Service.ProductService;
import com.ashir.E_Commerce.Service.UserService;


@Component
public class DataLoader implements CommandLineRunner
{

    private CategoryService categoryService;
    private ProductService productService;
    private UserService userRepository;

    public DataLoader(CategoryService categoryService,ProductService productService,UserService userRepository)
    {
        this.categoryService = categoryService;
        this.productService=productService;
        this.userRepository= userRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {

        userRepository.createNewUser("Ali hamza rehman ","LONDON","12345678");
        categoryService.addOneCategory(new CategoryPostDTO("Tech"));
        categoryService.addMultipleCategories(List.of(new CategoryPostDTO("Accessories")));
       productService.addProduct(new ProductPostDTO(1L,"Laptop",1000,10,1000,"Lenovo Laptop ","Tech",10));
        productService.addProduct(new ProductPostDTO(1L,"Laptop",1000,10,1000,"Lenovo Laptop ","Tech",10));
        productService.addProduct(new ProductPostDTO(1L,"Laptop",1000,10,1000,"Lenovo Laptop ","Tech",10));
        productService.addProduct(new ProductPostDTO(1L,"Laptop",1000,10,1000,"Lenovo Laptop ","Tech",10));
        productService.addProduct(new ProductPostDTO(1L,"Laptop",1000,10,1000,"Lenovo Laptop ","Tech",10));
    }
}
