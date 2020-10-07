package com.serverless;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class Common {

    public static final Region DDB_AWS_REGION = Region.of(System.getenv("DDB_AWS_REGION"));
    public static final DynamoDbClient DDB = DynamoDbClient.builder().region(DDB_AWS_REGION).build();
    public static final DynamoDbEnhancedClient DDBE = DynamoDbEnhancedClient.builder().dynamoDbClient(DDB).build();
    public static final DynamoDbTable<Product> PRODUCT_TABLE = DDBE.table("Products", TableSchema.fromBean(Product.class));
}
