package com.rentflow.app.controller;

public enum CarStatus {
    AVAILABLE("Вільний"),
    RENTED("В оренді"),
    SERVICE("Обслуговування");

    private final String label;

    CarStatus(String label) { this.label = label; }
    public String getLabel() { return label; }
}
