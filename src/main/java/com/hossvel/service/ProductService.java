package com.hossvel.service;

import com.hossvel.client.IPricesService;
import com.hossvel.model.Price;
import com.hossvel.model.Product;
import com.hossvel.repository.IProductRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
@ApplicationScoped
public class ProductService implements IProductService{

    @Inject
    @RestClient
    IPricesService iPricesService;

    @Inject
    IProductRepository iProductRepository;


    @Override
    public Uni<List<Price>> getHistoryPrice() {
        return iPricesService.getHistoryPrice();
    }

    public Uni<List<Product>> getAll() {

        return iProductRepository.listAll();
    }

    public Uni<Product> getById(Long id) {
        return iProductRepository.findById(id);
    }

    public Uni<Product> create(Product product) {
        return iProductRepository.persist(product);
    }

    public Uni<Boolean> delete(Long id) {
        return iProductRepository.deleteById(id);
    }

}
