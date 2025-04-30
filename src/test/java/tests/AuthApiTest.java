package tests;

import apis.AuthApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthApiTest extends BaseTest {

    AuthApi authApi = new AuthApi();

    @Test
    public void testBasicAuth() {
        Response response = authApi.basicAuth("admin", "password123", "/protected/basic");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testOauth2Auth() {
        String token = "your_token_here";
        Response response = authApi.oauth2Token(token, "/protected/oauth");
        Assert.assertEquals(response.statusCode(), 200);
    }
}
