package com.ashir.E_Commerce.Repositories;

import com.ashir.E_Commerce.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
}
