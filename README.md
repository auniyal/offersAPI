Spring Boot Applications

This is a sample application that helps create a simple RESTful software service that will allow end user to query the product catalog in the provided currency


Running the application

If you want to run the application locally you’ll need to follow these steps:

SQL
DATA.sql is provided which contains simple offer and the products 

mvn spring-boot:run
The sample calls a remote REST service that must be running. 
curl localhost:8080/products/GBP/
--> This would list all the products in the inventory after applying discount if applicable
--> Default currency is GBP but can be dynamically changed as path variable 

curl localhost:8080/products/GBP/1
--> This would list single product with the ID provided as path variable

