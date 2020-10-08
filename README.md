# Serverless AWS Java Products API

Features:
- Create a product

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

## Calling the API

Create a new product via calling the `/products` API Gateway endpoint:  

```
curl -X POST https://92z8tml2td.execute-api.eu-north-1.amazonaws.com/dev/products \
  -H "Content-Type: application/json" \
  -d '{"name": "product11", "price": 9.11}' \
  | jq
```

## Remove the stack

```shell
serverless remove
```

## Resources

- [Serverless Framework Documentation](https://www.serverless.com/framework/docs/)
- [AWS SDK for Java Documentation](https://docs.aws.amazon.com/sdk-for-java/index.html)
