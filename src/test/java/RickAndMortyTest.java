import configRick.BaseClass;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import jsonObject.Characters;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RickAndMortyTest extends BaseClass {
    static String baseURL = "character";

    @Test
    public void printAll() {
        String str = when()
                .get(baseURL)
                .then()
                .log()
                .all().toString();
        System.out.println(str);

    }

    @Test
    public void test1() {
        when()
                .get(baseURL).then().body("info.count", equalTo(26));
    }
    @Test
    public void test2() {
      String url=  when()
                .get(baseURL).then().extract().body().path("info.next");
        System.out.println(url);
    }
    @Test
    public void test3() {
        List<String> url=  when()
                .get(baseURL).then().extract().jsonPath().getList("results.url",String.class);
        System.out.println(url);
    }
@Test
@Description("Generating report to temp directory...\n" +
        "Report successfully generated to C:\\Users\\User\\AppData\\Local\\Temp\\17733142214234190609\\allure-report\n" +
        "Starting web server...\n")
@DisplayName("Very impotent test")
    public void test4(){
    Characters characters= when()
            .get(baseURL)
            .then()
            .extract()
            .body()
            .as(Characters.class);
    System.out.println(characters.results.get(0).name);
}
}
