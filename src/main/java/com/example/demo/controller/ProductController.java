package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String code) throws InterruptedException {
        if (code != null && !code.trim().isEmpty()) {
            log.info("Mencari produk dengan filter kode: {}", code);
            Thread.sleep(2000);
            return productRepository.findByCodeContainingIgnoreCase(code.trim());
        }
        log.info("Mengambil semua data produk");
        return productRepository.findAll();
    }
}