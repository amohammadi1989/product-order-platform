FROM openjdk:21-ea
EXPOSE 7070
ADD target/product-service.jar product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]