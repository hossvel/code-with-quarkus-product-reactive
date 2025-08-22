package com.hossvel.repository;


import com.hossvel.model.Product;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class IProductRepository implements PanacheRepository<Product> {
    public Uni<List<Product>> listAllProducts() {
        return listAll();
    }

    public Uni<Product> findProductById(Long id) {
        return findById(id);
    }

    public Uni<Product> save(Product product) {
        return persist(product);
    }

    public Uni<Boolean> deleteProduct(Long id) {
        return deleteById(id);
    }

}