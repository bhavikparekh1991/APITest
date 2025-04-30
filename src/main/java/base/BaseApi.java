package base;

import io.restassured.response.Response;
import utils.ConfigUtil;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class BaseApi {
	
	 private Map<String, String> getDefaultHeaders() {
	        Map<String, String> headers = new HashMap<>();
	        headers.put("Authorization", "Bearer " + ConfigUtil.getProperty("token"));
	        headers.put("Accept", "application/json");
	        headers.put("Content-Type", "application/json");
	        return headers;
	    }

    protected Response getRequest(String endpoint) {
        return given().log().all()
                .headers(getDefaultHeaders())
                .when().get(endpoint)
                .then().log().all().extract().response();
    }

    protected Response postRequest(String endpoint, Object body) {
        return given().log().all()
        		.headers(getDefaultHeaders())
                .body(body)
                .when().post(endpoint)
                .then().log().all().extract().response();
    }

    protected Response putRequest(String endpoint, Object body) {
        return given().log().all()
        		.headers(getDefaultHeaders())
                .body(body)
                .when().put(endpoint)
                .then().log().all().extract().response();
    }

    protected Response patchRequest(String endpoint, Object body) {
        return given().log().all()
        		.headers(getDefaultHeaders())
                .body(body)
                .when().patch(endpoint)
                .then().log().all().extract().response();
    }

    protected Response deleteRequest(String endpoint) {
        return given().log().all()
        		.headers(getDefaultHeaders())
                .when().delete(endpoint)
                .then().log().all().extract().response();
    }
}
