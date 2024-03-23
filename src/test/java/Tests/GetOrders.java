package Tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class GetOrders {


   @Test
   public void Getorders() {
       String token = "5fde855845098e83d48bcf38f2488d144da7b5fb07bcea7bd027213308384477";
       baseURI = "https://simple-books-api.glitch.me";
       given().header("Authorization",token).get("/orders")
               .then().statusCode(200).body("bookId",hasItem(1)).log().all();

       System.out.println("That's the data of Specific value");
       given().header("Authorization",token).get("/orders/H6e0Tx0ZU98ZHtXQDZgVu")
               .then().statusCode(200).body("bookId",equalTo(1)).log().all();
   }

}

