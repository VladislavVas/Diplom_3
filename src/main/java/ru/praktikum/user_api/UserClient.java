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
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }

    @Step("POST request. Create user.")
    public ValidatableResponse createUser(CreateUserDto createUserDto) {
        RequestSpecification request = given(baseRequest());
        request.body(createUserDto);
        return request.post(BASE_URL + CREATE_USER_API).then();

    }

    @Step("POST request. Log in user")
    public ValidatableResponse loginUser(LoginUserDto loginUserDto) {
        RequestSpecification request = given(baseRequest());
        request.body(loginUserDto);
        return request.post(BASE_URL + LOGIN_USER_API).then();
    }


    @Step("DELETE request. Delete user")
    public ValidatableResponse deleteUser(LoginUserDto loginUserDto) {
          String token = getToken(loginUserDto);
          RequestSpecification request = given(baseRequest());
        if (token != null) {
            return request.header("Authorization", token).
                    delete(BASE_URL + UPDATE_USER_API).then();
        } else {
            return null;
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
