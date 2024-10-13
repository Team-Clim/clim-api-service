package com.example.climserver.domain.user.entity.enums;

import lombok.Getter;

@Getter
public enum Grade {
    FIRST(1),

    SECOND(2),

    THIRD(3);

    private final int value;

    Grade(int value) {
        this.value = value;
    }

}
