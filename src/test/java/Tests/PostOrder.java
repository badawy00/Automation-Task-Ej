package Tests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostOrder {


    @Test
    public void Postorder() throws IOException {

        String token = "5fde855845098e83d48bcf38f2488d144da7b5fb07bcea7bd027213308384477";

        baseURI = "https://simple-books-api.glitch.me";
        byte[] inp = Files.readAllBytes(Paths.get("D:\\Task\\Task Ejada\\Automation Task\\Rest Assured\\src\\test\\java\\Tests\\testdata.json"));
        String inputdata = new String(inp);

        given().header("Authorization",token).header("Content-Type","application/json").body(inputdata)
                .when().post("/orders")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();


        // order id : H6e0Tx0ZU98ZHtXQDZgVu , YYVZj8waDa3gqzrzqcV7n ,D5Idu3-Z-A5IjsRlYLXv9

    }

}

