package Tests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UpdateOrder {


    @Test
    public void Updateorder() throws IOException {

        String token = "5fde855845098e83d48bcf38f2488d144da7b5fb07bcea7bd027213308384477";

        baseURI = "https://simple-books-api.glitch.me";
        byte[] inp = Files.readAllBytes(Paths.get("D:\\Task\\Task Ejada\\Automation Task\\Rest Assured\\src\\test\\java\\Tests\\Updatedata.json"));
        String Updatedata = new String(inp);

        given().header("Authorization",token).header("Content-Type","application/json").body(Updatedata)
                .when().patch("/orders/rFYEbfAuwQYpi8te9XAhC")
                .then().log().all().assertThat().statusCode(204).extract().response().asString();


        // order id : H6e0Tx0ZU98ZHtXQDZgVu , YYVZj8waDa3gqzrzqcV7n ,D5Idu3-Z-A5IjsRlYLXv9

    }

}

