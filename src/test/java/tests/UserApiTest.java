package tests;

import apis.UserApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import utils.PayloadUtil;
import pojo.UserResponse;
public class UserApiTest extends BaseTest {

    UserApi userApi = new UserApi();

    @Test(priority = 1)
    public void createUserTest() throws IOException {
//        Map<String, String> payload = new HashMap<>();
//        payload.put("name", "Tenali Ramakrishna");
//        payload.put("gender", "male");
//        payload.put("email", "tenali" + System.currentTimeMillis() + "@15ce.com"); // ✅ unique email
//        payload.put("status", "active");
	    	String payload = PayloadUtil.getPayload("src/test/resources/user.json");
	
	        String dynamicEmail = "FileTestUserPKB" + System.currentTimeMillis() + "@15ce.com";
	        payload = payload.replace("FileTestUser@15ce.com", dynamicEmail);
	        
	        Response response = userApi.createUser(payload);
	//      Assert.assertEquals(response.statusCode(), 201);
	//      Assert.assertEquals(response.jsonPath().getString("name"), "FileTestUser");
	//      Assert.assertEquals(response.jsonPath().getString("gender"), "female");
	//      Assert.assertEquals(response.jsonPath().getString("status"), "active");
	        
	//      List<UserResponse> users = response.as(new TypeRef<List<UserResponse>>() {});
	//      System.out.println("Total users retrieved: " + users.size());
	//		for (UserResponse user : users) {
	//            System.out.println("User: " + user.getName() + ", Status: " + user.getStatus());
	//            Assert.assertNotNull(user.getId());
	//            Assert.assertNotNull(user.getName());
	//      }
        
        
	      UserResponse user = response.as(UserResponse.class);
	      Assert.assertEquals(user.getName(), "FileTestUser");
	      Assert.assertEquals(user.getGender(), "female");
	      Assert.assertEquals(user.getStatus(), "active");
	      Assert.assertEquals(user.getEmail(), dynamicEmail);
	      Assert.assertTrue(user.getId() > 0);
    }

    @Test(enabled = false)
    public void getUserTest() {
        Response response = userApi.getUser(2);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(enabled = false)
    public void updateUserTest() {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", "Jane Doe");
        payload.put("job", "Dev Manager");

        Response response = userApi.updateUser(2, payload);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(enabled = false)
    public void patchUserTest() {
        Map<String, String> payload = new HashMap<>();
        payload.put("job", "Director");

        Response response = userApi.patchUser(2, payload);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(enabled = false)
    public void deleteUserTest() {
        Response response = userApi.deleteUser(2);
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test(enabled = false)
    public void getUserWithQueryParamTest() {
        Response response = given().log().all()
                .queryParam("page", 2)
                .when().get("/users")
                .then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
