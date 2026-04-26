package com.mclods.taco_cloud_secured.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taco_order")
public class TacoOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Delivery Name cannot be null")
    @NotBlank(message = "Delivery Name is required")
    @Column(name = "delivery_name")
    private String deliveryName;

    @NotNull(message = "Delivery Street cannot be null")
    @NotBlank(message = "Delivery Street is required")
    @Column(name = "delivery_street")
    private String deliveryStreet;

    @NotNull(message = "Delivery City cannot be null")
    @NotBlank(message = "Delivery City is required")
    @Column(name = "delivery_city")
    private String deliveryCity;

    @NotNull(message = "Delivery State cannot be null")
    @NotBlank(message = "Delivery State is required")
    @Column(name = "delivery_state")
    private String deliveryState;

    @NotNull(message = "Delivery Zip cannot be null")
    @NotBlank(message = "Delivery Zip is required")
    @Column(name = "delivery_zip")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    @Column(name = "cc_number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    @Column(name = "cc_expiration")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(name = "cc_cvv")
    private String ccCVV;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "tacoOrder", cascade = CascadeType.PERSIST)
    private final List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        if(taco.getCreationDate() == null) {
            taco.setCreationDate(LocalDateTime.now());
        }

        taco.setTacoOrder(this);
        tacos.add(taco);
    }
}
