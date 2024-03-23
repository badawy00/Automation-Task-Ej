package Tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class GetBooks {


   @Test
    public void GetBooks() {
        baseURI = "https://simple-books-api.glitch.me";
       given().get("/books")
               .then().statusCode(200).body("id",hasItem(1)).log().all();

       System.out.println("That's the data of Specific value");

       given().get("/books/2")
               .then().statusCode(200).body("id",equalTo(2)).log().all();

    }

}

