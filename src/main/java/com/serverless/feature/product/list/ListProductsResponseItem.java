package com.serverless.feature.product.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListProductsResponseItem implements Serializable {

    private String id;
    private String name;
    private Double price;
}
