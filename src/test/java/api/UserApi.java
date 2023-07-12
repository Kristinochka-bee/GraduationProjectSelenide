package api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class UserApi extends ApiBase {
    RegistrationDTO dto;
    Response response;
    Faker faker = new Faker();
    String defaultPassword = "12345678";

    public RegistrationDTO randomUserData() {
        dto = new RegistrationDTO();
        dto.setFull_Name(faker.name().firstName());
        dto.setEmail(faker.internet().emailAddress());
        dto.setPassword(defaultPassword);
        dto.setGenerate_magic_link(false);
        return dto;
    }

    public Response registrationNewUserApi(Integer StatusCode) {
        String endPoint = "/v1/api/users";
        response = doPostRequest(endPoint, StatusCode, randomUserData());
        return response;
    }

    public void deleteExistingUser(String userEmail, Integer code){
        String endpoint = "/v1/api/users/{email}";
        doDeleteRequest(endpoint,code, userEmail);
    }
}