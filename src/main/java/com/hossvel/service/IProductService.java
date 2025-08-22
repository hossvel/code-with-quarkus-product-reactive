package com.hossvel.service;

import com.hossvel.model.Price;
import com.hossvel.model.Product;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface IProductService {
    public Uni<List<Price>> getHistoryPrice();

    public Uni<List<Product>> getAll();

    public Uni<Product> getById(Long id);

    public Uni<Product> create(Product product);

    public Uni<Boolean> delete(Long id);

}
