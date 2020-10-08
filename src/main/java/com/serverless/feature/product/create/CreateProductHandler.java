package com.serverless.feature.product.create;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.repository.entity.Product;
import lombok.extern.log4j.Log4j;

import java.util.UUID;

import static com.serverless.Common.*;

@Log4j
public class CreateProductHandler implements RequestHandler<CreateProductRequest, CreateProductResponse> {

    @Override
    public CreateProductResponse handleRequest(CreateProductRequest request, Context context) {
        log.info("Request: " + request);
        final String productId = UUID.randomUUID().toString();
        final Product product = Product.builder()
                .id(productId)
                .name(request.getName())
                .price(request.getPrice())
                .build();
        PRODUCT_TABLE.putItem(product);
        return CreateProductResponse.builder().id(productId).build();
    }
}
