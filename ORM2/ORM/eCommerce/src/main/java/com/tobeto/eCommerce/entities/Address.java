package com.tobeto.eCommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name="address")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name="user_id")
//    private int userId;

//    @Column(name="country_id")
//    private int countryId;
//
//    @Column(name="city_id")
//    private int  cityId;
//
//    @Column(name="district_id")
//    private int districtId;

    //---------------FK--------------------
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;

    @OneToMany(mappedBy = "address")
    private List<Order> orders;

    @OneToMany(mappedBy = "address")
    private List<Invoice> invoices;



}
