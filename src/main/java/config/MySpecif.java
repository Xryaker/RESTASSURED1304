package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class MySpecif {
    public static void create(String urlBase){
        RestAssured.requestSpecification= new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(urlBase)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();


        RestAssured.responseSpecification=new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
