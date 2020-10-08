package com.serverless.feature.product.delete;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.repository.entity.Product;
import lombok.extern.log4j.Log4j;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import static com.serverless.Common.*;

@Log4j
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, DeleteProductResponse> {

    @Override
    public DeleteProductResponse handleRequest(DeleteProductRequest request, Context context) {
        log.info("Request: " + request);
        final Key key = Key.builder().partitionValue(request.getId()).sortValue(request.getName()).build();
        final Product product = PRODUCT_TABLE.deleteItem(key);
        if (product == null) throw new RuntimeException(String.format("[404] Product not found. Request: %s", request));

        return DeleteProductResponse.builder().id(product.getId()).build();
    }
}
