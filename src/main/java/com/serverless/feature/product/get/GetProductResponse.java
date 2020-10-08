package com.serverless.feature.product.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse implements Serializable {

    private String id;
    private String name;
    private double price;
}
