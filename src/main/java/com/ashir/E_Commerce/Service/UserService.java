package com.ashir.E_Commerce.Service;

import com.ashir.E_Commerce.Models.User;
import com.ashir.E_Commerce.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User createNewUser(String name , String address, String password){
        User user = new User(name, address, password);
      return   userRepository.save(user);


    }
}
