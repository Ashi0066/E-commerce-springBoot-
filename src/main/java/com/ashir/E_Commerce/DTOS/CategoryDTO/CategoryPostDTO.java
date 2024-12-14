package com.ashir.E_Commerce.DTOS.CategoryDTO;

public class CategoryPostDTO
{
    private String name;

    public CategoryPostDTO(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
