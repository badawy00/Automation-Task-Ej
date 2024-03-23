package Tests;


import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class DeleteOrder {


    @Test
    public void Deleteorder() throws IOException {

        String token = "5fde855845098e83d48bcf38f2488d144da7b5fb07bcea7bd027213308384477";

        baseURI = "https://simple-books-api.glitch.me";

        given().header("Authorization",token)
                .when().delete("/orders/rFYEbfAuwQYpi8te9XAhC")
                .then().log().all().assertThat().statusCode(204).extract().response().asString();


        // order id : H6e0Tx0ZU98ZHtXQDZgVu ,D5Idu3-Z-A5IjsRlYLXv9

    }
}

