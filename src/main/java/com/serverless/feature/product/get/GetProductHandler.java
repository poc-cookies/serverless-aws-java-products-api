package com.serverless.feature.product.get;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.repository.entity.Product;
import lombok.extern.log4j.Log4j;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import static com.serverless.Common.*;

@Log4j
public class GetProductHandler implements RequestHandler<GetProductRequest, GetProductResponse> {

    @Override
    public GetProductResponse handleRequest(GetProductRequest request, Context context) {
        log.info("Request: " + request);
        final Key key = Key.builder().partitionValue(request.getId()).sortValue(request.getName()).build();
        final Product product = PRODUCT_TABLE.getItem(key);
        if (product == null) throw new RuntimeException(String.format("[404] Product not found. Request: %s", request));

        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
