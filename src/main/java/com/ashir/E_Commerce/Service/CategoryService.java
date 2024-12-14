package com.ashir.E_Commerce.Service;

import com.ashir.E_Commerce.DTOS.CategoryDTO.CategoryGetDTO;
import com.ashir.E_Commerce.DTOS.CategoryDTO.CategoryPostDTO;
import com.ashir.E_Commerce.Models.Category;
import com.ashir.E_Commerce.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class CategoryService
{
    // Using the category Repository
   private CategoryRepository categoryRepository;


   // Constructor injection to autowire the category repository
    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public Category addOneCategory(CategoryPostDTO categoryPost){

        Category category= new Category();
        category.setName(categoryPost.getName());

        return categoryRepository.save(category);
    }

    public List<Category> addMultipleCategories(List<CategoryPostDTO> category){

        List<Category> categories= new ArrayList<>();

        for (CategoryPostDTO et: category){
            Category category1 = new Category();
            category1.setName(et.getName());
            categories.add(category1);
        }
        return categoryRepository.saveAll(categories);
    }

    public List<CategoryGetDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(category -> new CategoryGetDTO(category.getName())).collect(Collectors.toList());


    }

    public List<CategoryGetDTO> getDTOList(){
        List<Category> categoriesList = categoryRepository.findAll();
        List<CategoryGetDTO> categoryGetDTOS= new ArrayList<>();

        for (Category et:categoriesList){
            CategoryGetDTO category = new CategoryGetDTO(et.getName());

            categoryGetDTOS.add(category);
        }
        return categoryGetDTOS;
    }

    public Category searchByCategoryName(String name){

       return categoryRepository.findByName(name).orElseThrow(()-> new RuntimeException("Category Can not be found " + name));
    }
}
