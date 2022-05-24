FROM openjdk:18

COPY ./build/libs/ec-products-api-0.0.1-SNAPSHOT.jar ec-products-api-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "ec-products-api-0.0.1-SNAPSHOT.jar"]