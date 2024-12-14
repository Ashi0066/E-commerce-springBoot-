package com.ashir.E_Commerce.Repositories;

import com.ashir.E_Commerce.Models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    Optional<Product> findByName(String name);
}
