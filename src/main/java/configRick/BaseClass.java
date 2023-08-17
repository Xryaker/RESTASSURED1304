package configRick;

import config.MySpecif;
import org.junit.BeforeClass;

public class BaseClass {
    public static final String URL="https://rickandmortyapi.com/api/";
    @BeforeClass
    public static void b(){
        MySpecif.create(URL);
    }
}
