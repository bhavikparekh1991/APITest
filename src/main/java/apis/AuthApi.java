package apis;

import base.BaseApi;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi {

    public Response basicAuth(String username, String password, String endpoint) {
        return given().auth().preemptive().basic(username, password)
                .when().get(endpoint).then().log().all().extract().response();
    }

    public Response oauth2Token(String token, String endpoint) {
        return given().auth().oauth2(token)
                .when().get(endpoint).then().log().all().extract().response();
    }
}
