package com.ashir.E_Commerce.Controllers;


import com.ashir.E_Commerce.DTOS.CategoryDTO.CategoryGetDTO;
import com.ashir.E_Commerce.Service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController
{

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }


    @GetMapping(path = "/categories")
    public List<CategoryGetDTO> getAllCategory(){
        return categoryService.getAllCategories();
    }

}
