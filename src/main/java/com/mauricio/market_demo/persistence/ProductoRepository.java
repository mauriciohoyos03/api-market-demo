package com.mauricio.market_demo.persistence;

import com.mauricio.market_demo.domain.Product;
import com.mauricio.market_demo.domain.repository.ProductRepository;
import com.mauricio.market_demo.persistence.crud.ProductoCrudRepository;
import com.mauricio.market_demo.persistence.entity.Producto;
import com.mauricio.market_demo.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategory(int idCategoria) {
        List<Producto> productos = productoCrudRepository.findByIdCategoria(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }


    public Optional<Product> getProduct(int idProducto) {
        return productoCrudRepository.findById(idProducto).map(producto -> mapper.toProduct(producto));
    }

    public Product save (Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

    public void delete(Integer productId) {
        productoCrudRepository.deleteById(productId);
    }
}