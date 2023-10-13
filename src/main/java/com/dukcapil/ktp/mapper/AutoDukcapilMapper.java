package com.dukcapil.ktp.mapper;

import com.dukcapil.ktp.dto.DukcapilDto;
import com.dukcapil.ktp.model.Dukcapil;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDukcapilMapper {
    AutoDukcapilMapper MAPPER = Mappers.getMapper(AutoDukcapilMapper.class);

    DukcapilDto mapToDukcapilDto(Dukcapil dukcapil);

    Dukcapil mapToDukcapil(DukcapilDto dukcapilDto);

}
