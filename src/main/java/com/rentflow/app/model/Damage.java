package com.rentflow.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "damages")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Damage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    @Column(nullable = false)
    private Rental rental;

    @Column(nullable = false)
    private String description;

    @Column(name = "damage_date", nullable = false)
    private BigDecimal fineAmount;
}
