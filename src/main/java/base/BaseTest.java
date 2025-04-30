package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ConfigUtil;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigUtil.getProperty("base.url");
    }
}
