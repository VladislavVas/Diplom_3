package ru.praktikum.model;

import com.github.javafaker.Faker;

public class UserData {

    private final Faker faker = new Faker();

    public CreateUserDto getUserData() {
        return CreateUserDto.builder()
                .password(faker.internet().password(6,7))
                .email(faker.internet().emailAddress())
                .name(faker.name().name())
                .build();
    }

    public String getNewUserName() {
        return faker.name().name();
    }

    public String getNewUserMail() {
        return faker.internet().emailAddress();
    }

    public String getInvalidPassword() {
        return faker.internet().password(1,5);
    }

}
