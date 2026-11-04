package com.example.demo.repository;
import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Pencarian parsial (LIKE %code%) tanpa memedulikan huruf besar/kecil
    List<Product> findByCodeContainingIgnoreCase(String code);
}