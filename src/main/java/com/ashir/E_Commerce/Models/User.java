package com.ashir.E_Commerce.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity(name = "'user'")
public class User {




    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 8 , message = "Password must be more than 8 digits")
    private String name;
    private String address;
    private String password;

    public User(Long id)
    {
        this.id = id;
    }
    public User(){}

    public User(String name, String address, String password)
    {
        this.name = name;
        this.address = address;
        this.password = password;
        this.cart = new Cart();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private Cart cart;
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
