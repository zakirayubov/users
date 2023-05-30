package ru.users.model.internal;

import lombok.Getter;

import java.util.Arrays;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    @Getter
    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender fromValue(String value) {
        return Arrays.stream(values())
                .filter(gender -> gender.name().equalsIgnoreCase(value))
                .findFirst()
                .orElse(OTHER);
    }
}
