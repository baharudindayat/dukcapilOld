package com.dukcapil.ktp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dukcapil")
public class Dukcapil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID should not be null")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nik;

    @Column(nullable = false)
    private String Provinsi;

    @Column(nullable = false)
    private String kota;



}
