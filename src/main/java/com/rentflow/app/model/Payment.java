package com.rentflow.app.model;

import com.rentflow.app.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    private BigDecimal amount;

    private LocalDateTime date;

    private PaymentMethod method;

    private String description;
}
