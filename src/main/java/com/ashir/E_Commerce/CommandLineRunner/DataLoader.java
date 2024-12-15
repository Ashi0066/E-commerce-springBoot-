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
        productService.addProduct(new ProductPostDTO(
                1L, "Laptop", 1000, 10, 1000, "LG Gram 500GB 32GB RAM NVIDIA RTX 3060", "Tech", 10));

        productService.addProduct(new ProductPostDTO(
                2L, "Laptop", 950, 15, 1200, "Lenovo ThinkPad 512GB 16GB RAM NVIDIA GTX 1650", "Tech", 15));

        productService.addProduct(new ProductPostDTO(
                3L, "Laptop", 1200, 8, 1100, "Dell XPS 13 1TB SSD 32GB RAM NVIDIA RTX 3050", "Tech", 8));

        productService.addProduct(new ProductPostDTO(
                4L, "Laptop", 800, 20, 1500, "HP Pavilion 256GB SSD 8GB RAM Integrated Graphics", "Tech", 20));

        productService.addProduct(new ProductPostDTO(
                5L, "Laptop", 1300, 5, 1050, "Apple MacBook Air M1 512GB SSD 8GB RAM Apple GPU", "Tech", 5));


        productService.addProduct(new ProductPostDTO(
                1L, "Phone", 700, 25, 180, "Samsung Galaxy S22 Ultra 256GB 12GB RAM Quad Camera 5000mAh", "Tech", 25));

        productService.addProduct(new ProductPostDTO(
                2L, "Phone", 800, 30, 200, "Apple iPhone 14 Pro Max 128GB 6GB RAM A16 Bionic Chip 3200mAh", "Tech", 30));

        productService.addProduct(new ProductPostDTO(
                3L, "Phone", 600, 20, 190, "Google Pixel 7 128GB 8GB RAM Tensor G2 Chip 4350mAh", "Tech", 20));

        productService.addProduct(new ProductPostDTO(
                4L, "Phone", 500, 40, 170, "OnePlus Nord 2T 128GB 8GB RAM Dimensity 1300 4500mAh", "Tech", 40));

        productService.addProduct(new ProductPostDTO(
                5L, "Phone", 900, 15, 210, "Sony Xperia 1 IV 512GB 12GB RAM Snapdragon 8 Gen 1 5000mAh", "Tech", 15));

    }
}
