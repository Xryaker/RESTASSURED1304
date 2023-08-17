import ExchangeObject.Exchange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.when;
@RunWith(Parameterized.class)
public class ParamsExchanges {

    static Exchange ex;
@Parameterized.Parameters
    public static Collection options()
    {
        return Arrays.asList(new String[]{"USD", "CZK", "DKK", "CAD"});
    }
    public ParamsExchanges(String name) {
       ex= when()
                .get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+name+"&json")
                .then()
                .extract()
                .jsonPath()
                .getList(".",Exchange.class).get(0);
    }
    @Test
    public void test(){
        System.out.println(ex.cc+" = "+ex.rate);
    }
}
