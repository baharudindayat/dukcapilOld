package com.dukcapil.ktp.mapper;

import com.dukcapil.ktp.dto.DukcapilDto;
import com.dukcapil.ktp.model.Dukcapil;

public class DukcapilMapper {

    public static DukcapilDto mapToDukcapilDto(Dukcapil dukcapil) {
        DukcapilDto dukcapilDto = new DukcapilDto();
        dukcapilDto.setId(dukcapil.getId());
        dukcapilDto.setNik(dukcapil.getNik());
        dukcapilDto.setProvinsi(dukcapil.getProvinsi());
        dukcapilDto.setKota(dukcapil.getKota());
        return dukcapilDto;
    }

    public static Dukcapil mapToDukcapil(DukcapilDto dukcapilDto) {
        Dukcapil dukcapil = new Dukcapil();
        dukcapil.setId(dukcapilDto.getId());
        dukcapil.setNik(dukcapilDto.getNik());
        dukcapil.setProvinsi(dukcapilDto.getProvinsi());
        dukcapil.setKota(dukcapilDto.getKota());
        return dukcapil;
    }
}
