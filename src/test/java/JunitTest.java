import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
    @Suite.SuiteClasses({
            ParamsExchanges.class,
            RickAndMorty.class,
            Exchanges.class
    })
    public class JunitTest {
    }

