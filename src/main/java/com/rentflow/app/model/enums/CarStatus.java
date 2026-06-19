package com.rentflow.app.model.enums;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public enum CarStatus {
    FREE("Вільний"),
    RENTED("Орендований"),
    MAINTENANCE("Під техобслуговування"),
    DISCONTINUED("Виведений з експлуатації");

    private final String label;

    CarStatus(String label) {
        this.label = label;
    }
}
