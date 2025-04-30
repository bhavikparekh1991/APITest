package apis;

import base.BaseApi;
import io.restassured.response.Response;

public class UserApi extends BaseApi {
    public Response getUser(int userId) {
        return getRequest("/users/" + userId);
    }
    public Response createUser(Object payload) {
    	return postRequest("/public/v2/users", payload);
    }
    public Response updateUser(int userId, Object payload) {
        return putRequest("/users/" + userId, payload);
    }
    public Response patchUser(int userId, Object payload) {
        return patchRequest("/users/" + userId, payload);
    }
    public Response deleteUser(int userId) {
        return deleteRequest("/users/" + userId);
    }
}
