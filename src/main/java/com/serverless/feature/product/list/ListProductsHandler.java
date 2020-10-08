package com.serverless.feature.product.list;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.stream.Collectors;

import static com.serverless.Common.*;

@Log4j
public class ListProductsHandler implements RequestHandler<Void, List<ListProductsResponseItem>> {

    @Override
    public List<ListProductsResponseItem> handleRequest(Void input, Context context) {
        return PRODUCT_TABLE.scan().items().stream()
                .map(p -> ListProductsResponseItem.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .price(p.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
