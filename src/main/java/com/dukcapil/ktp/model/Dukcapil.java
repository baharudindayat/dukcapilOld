package com.dukcapil.ktp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Dukcapil")
public class Dukcapil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nik")
    private String nik;

    @Column(name = "provinsi")
    private String Provinsi;

    @Column(name = "kota")
    private String Kota;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getProvinsi() {
        return Provinsi;
    }

    public void setProvinsi(String provinsi) {
        Provinsi = provinsi;
    }

    public String getKota() {
        return Kota;
    }

    public void setKota(String kota) {
        Kota = kota;
    }

    @Override
    public String toString() {
        return "Dukcapil{" +
                "id=" + id +
                ", nik='" + nik + '\'' +
                ", Provinsi='" + Provinsi + '\'' +
                ", Kota='" + Kota + '\'' +
                '}';
    }

}
