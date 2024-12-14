package com.ashir.E_Commerce.Repositories;

import com.ashir.E_Commerce.Models.Category;
import com.ashir.E_Commerce.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{
    Optional<Category> findByName(String name);

}
