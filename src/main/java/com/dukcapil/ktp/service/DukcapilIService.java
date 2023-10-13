package com.dukcapil.ktp.service;

import com.dukcapil.ktp.dto.DukcapilDto;
import com.dukcapil.ktp.model.Dukcapil;

import java.util.List;

public interface DukcapilIService {
    DukcapilDto createNIK(DukcapilDto dukcapil);

    DukcapilDto getNIKById(Long id);

    DukcapilDto getNIKByNIK(String nik);

    DukcapilDto updateNIK(DukcapilDto dukcapil);

    void deleteNIKid(Long id);

    void deleteNIK(String nik);

    List<Dukcapil> getAllNIK();
}
