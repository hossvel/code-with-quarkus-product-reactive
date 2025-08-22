package com.hossvel.service;

import com.hossvel.client.IPricesService;
import com.hossvel.model.Price;
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

    @Override
    public Uni<List<Price>> getHistoryPrice() {
        return iPricesService.getHistoryPrice();
    }
}
