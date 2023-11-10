package ru.praktikum.user_api;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import ru.praktikum.model.CreateUserDto;
import ru.praktikum.model.LoginUserDto;

import static io.restassured.RestAssured.given;
import static ru.praktikum.Constants.*;

public class UserClient {

    private RequestSpecification baseRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }

    @Step("POST request. Create user.")
    public void createUser(CreateUserDto createUserDto) {
        RequestSpecification request = given(baseRequest());
        request.body(createUserDto);
        request.post(CREATE_USER_API).then();

    }

    @Step("POST request. Log in user")
    public ValidatableResponse loginUser(LoginUserDto loginUserDto) {
        RequestSpecification request = given(baseRequest());
        request.body(loginUserDto);
        return request.post(LOGIN_USER_API).then();
    }

    @Step("DELETE request. Delete user")
    public void deleteUser(LoginUserDto loginUserDto) {
        String token = getToken(loginUserDto);
        RequestSpecification request = given(baseRequest());
        if (token != null) {
            request.header("Authorization", token).
                    delete(UPDATE_USER_API).then();
        }
    }

    @Step("Get authorization token")
    public String getToken(LoginUserDto loginUserDto) {
        return loginUser(loginUserDto)
                .extract()
                .body()
                .path("accessToken");
    }

}
