package com.rentflow.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rentals")
@Getter
@Setter
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @Column(nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Column(nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @Column(nullable = false)
    private Employee employee;

    @Column(name = "start_odometer", nullable = false)
    private Integer startOdometer;

    @Column(name = "end_odometer")
    private Integer endOdometer;







}
