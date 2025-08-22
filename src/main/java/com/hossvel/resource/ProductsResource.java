package com.hossvel.resource;


import com.hossvel.client.IPricesService;
import com.hossvel.model.Price;
import com.hossvel.model.Product;
import com.hossvel.model.ProductPriceHistory;
import com.hossvel.service.IProductService;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Response;

import io.smallrye.mutiny.Uni;

import java.util.List;

@Path( "/products" )
@Produces( MediaType.APPLICATION_JSON )
public class ProductsResource {

    @Inject
    IProductService iProductService;


    @WithSession
    @GET
    public Uni<List<Product>> getAll() {
        return iProductService.getAll();
    }

    @WithSession
    @GET
    @Path("/{id}")
    public Uni<Product> getById(@PathParam("id") Long id) {
        return iProductService.getById(id);
    }

    @WithSession
    @POST
    public Uni<Response> create(Product product) {
        return iProductService.create(product)
                .map(p -> Response.status(Response.Status.CREATED).entity(p).build());
    }

    @WithSession
    @DELETE
    @Path("/{id}")
    public Uni<Response> delete(@PathParam("id") Long id) {
        return iProductService.delete(id)
                .map(deleted -> deleted
                        ? Response.noContent().build()
                        : Response.status(Status.NOT_FOUND).build());
    }

    @GET
    @Path( "/priceHistory" )
    public  Uni<List<Price>>  getHistoryPrice() {
        return iProductService.getHistoryPrice();

    }

//    @GET
    //   @Path( "/{productId}/priceHistory" )
    //  public   Uni<List<Price>> getProductPriceHistory(@PathParam( "productId" ) final Long productId ) {

    //    return iPricesService.getProductPriceHistory( productId );
    //}

    @GET
    @Blocking
    @Path( "/blocking" )
    public Uni<String> blocking() {
        try {
            Thread.sleep( 30000 );
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }

        return  Uni.createFrom().item("I am a blocking operation");
    }



}