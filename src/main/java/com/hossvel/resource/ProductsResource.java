package com.hossvel.resource;


import com.hossvel.client.IPricesService;
import com.hossvel.model.Price;
import com.hossvel.model.ProductPriceHistory;
import com.hossvel.service.IProductService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;

import java.util.List;

@Path( "/products" )
@Produces( MediaType.APPLICATION_JSON )
public class ProductsResource {

    @Inject

    IProductService iProductService;

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

    @Path("/hello")
    public static class GreetingResource {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String hello() {
            return "Hello from Quarkus REST";
        }
    }
}