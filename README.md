# Serverless AWS Java Products API

Features:
- Create a product
- Get a product by key
- List products
- Delete a product by key

## Prerequisites

1. [serverless](https://www.serverless.com)
2. Java 8
3. Gradle 6.6+
4. AWS Credentials

## Build

```shell
./gradlew build
```

The aforecited command builds the project and places the distributable under the `build/distributions/` folder.

## Deploy the stack

```shell
serverless deploy
```

## Invoke a Lambda function

Create a new product by calling the `createProduct` Lambda function and output the response:

```shell
serverless invoke --function createProduct --data '{"name": "product1", "price": 9.1}'
```

Create a new product by calling the `createProduct` Lambda function and output the response along with logs:

```shell
serverless invoke --function createProduct --data '{"name": "product2", "price": 9.2}' --log
```

Get a product with given id and name by calling the `getProduct` Lambda function and pipe the response to `jq`:

```shell
serverless invoke --function getProduct --data '{"id": <product_id>, "name": "product1"}' | jq
```

Get all products by calling the `listProducts` Lambda function and pipe the response to `jq`:

```shell
serverless invoke --function listProducts | jq
```

Delete a product with given id and name by calling the `deleteProduct` Lambda function and pipe the response to `jq`:

```shell
serverless invoke --function deleteProduct --data '{"id": <product_id>, "name": "product1"}' | jq
```

## Calling the API

Create a new product via calling the `/products` API Gateway endpoint:  

```shell
curl -X POST <endpoint_base>/dev/products \
  -H "Content-Type: application/json" \
  -d '{"name": "product11", "price": 9.11}' \
  | jq
```

Get a product with given id and name by calling the `/products/{id}` API Gateway endpoint:

```shell
curl -X GET <endpoint_base>/dev/products/{id}?name={name} | jq
```

List products by calling the `/products` API Gateway endpoint:

```shell
curl -X GET <endpoint_base>/dev/products | jq
```

Delete a product with given id and name by calling the `/products/{id}` API Gateway endpoint:

```shell
curl -X DELETE <endpoint_base>/dev/products/{id}?name={name} | jq
```

## View the CloudWatch logs

```shell
serverless logs --function <function_name>
```

## Remove the stack

```shell
serverless remove
```

## Resources

- [Serverless Framework Documentation](https://www.serverless.com/framework/docs/)
- [AWS SDK for Java Documentation](https://docs.aws.amazon.com/sdk-for-java/index.html)
