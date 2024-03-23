package Tests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class AccessToken {


    @Test
    public void Accesstoken() throws IOException {

//       5fde855845098e83d48bcf38f2488d144da7b5fb07bcea7bd027213308384477

        baseURI = "https://simple-books-api.glitch.me";
        byte[] inp = Files.readAllBytes(Paths.get("D:\\Task\\Task Ejada\\Automation Task\\Rest Assured\\src\\test\\java\\Tests\\tokendata.json"));
        String inputravl = new String(inp);

        given().header("Content-Type","application/json").body(inputravl)
                .when().post("/api-clients/")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();
    }

}

