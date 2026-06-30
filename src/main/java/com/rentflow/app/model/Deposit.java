package com.rentflow.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "deposits")
@NoArgsConstructor
public class Deposit {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "is_deposit_returned", nullable = false)
    private boolean isDepositReturned;

    @Column(name = "reason_deduction")
    private String reasonDeduction;
}
