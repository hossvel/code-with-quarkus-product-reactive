package com.hossvel.client;

import com.hossvel.model.Price;
import com.hossvel.model.ProductPriceHistory;
import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

import java.util.List;

@Path( "/prices" )
@RegisterRestClient(configKey = "price-service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IPricesService {

    @GET
    Uni<List<Price>>  getHistoryPrice();

   // @GET
   // Uni<List<Price>> getProductPriceHistory(@PathParam( "productId" ) final Long productId );
}


