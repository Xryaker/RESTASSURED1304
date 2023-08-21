import ExchangeObject.Exchange;
import groovy.transform.ASTTest;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Exchanges {

    @Test
    public void test0(){
        String str=when()
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                .then()
                .log()
                .body()// response only body, all() response all request
                .toString();
        System.out.println(str);
    }
    @Test
    public void test1(){
        List<String> list = when()
                    .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                    .then()
                    .extract()
                .jsonPath()// convert in to json psevdo
                .getList("rate",String.class); // get list all "field" data
        for (String s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void test2(){
        List<ExchangeObject.Exchange> listEx = when()
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                .then()
                .extract()
                .jsonPath()
                .getList(".", ExchangeObject.Exchange.class); // . all objects
        for (ExchangeObject.Exchange ex : listEx) {
            System.out.println(ex.cc);
        }
    }
    @Test
    public void test3(){
        when()
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                .then()
                .body("rate",notNullValue()); // check all fields "rate" in objects !=null
    }
    @Test
    public void test4(){
        when()
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                .then()
                .body("rate",equalTo(56233));
    }
    @Test
    public void test5(){
        ExchangeObject.Exchange rate= when()
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json")
                .then()
                .extract()
                .jsonPath()
                .getList(".", ExchangeObject.Exchange.class).get(0);

        System.out.println(rate.rate);
    }
}
