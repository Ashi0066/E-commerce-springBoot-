package com.ashir.E_Commerce.Repositories;

import com.ashir.E_Commerce.Models.Cart;
import com.ashir.E_Commerce.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>
{
    Optional<Cart> findByUserId (Long useID);
}
