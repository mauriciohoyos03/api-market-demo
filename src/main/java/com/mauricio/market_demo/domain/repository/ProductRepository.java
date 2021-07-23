package com.mauricio.market_demo.domain.repository;

import com.mauricio.market_demo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
