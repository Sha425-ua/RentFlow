package com.rentflow.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter @Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "driver_license", nullable = false, unique = true)
    private String driverLicense;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Rental> rentals;
}
