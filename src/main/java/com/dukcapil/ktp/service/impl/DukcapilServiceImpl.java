package com.dukcapil.ktp.service.impl;

import com.dukcapil.ktp.dto.DukcapilDto;
import com.dukcapil.ktp.mapper.AutoDukcapilMapper;
import com.dukcapil.ktp.model.Dukcapil;
import com.dukcapil.ktp.repository.DukcapilRepository;
import com.dukcapil.ktp.service.DukcapilIService;
import lombok.AllArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DukcapilServiceImpl implements DukcapilIService {

    private DukcapilRepository repository;


    @Override
    public DukcapilDto createNIK(DukcapilDto dukcapilDto) {
        Optional<Dukcapil> OptionalDukcapil = repository.findByNik(dukcapilDto.getNik());

        if (OptionalDukcapil.isPresent()) {
            throw new OpenApiResourceNotFoundException("NIK already exists");
        }

        Dukcapil dukcapil = AutoDukcapilMapper.MAPPER.mapToDukcapil(dukcapilDto);
        Dukcapil savedDukcapil = repository.save(dukcapil);

        return AutoDukcapilMapper.MAPPER.mapToDukcapilDto(savedDukcapil);
    }

    @Override
    public DukcapilDto getNIKById(Long id) {
        Dukcapil dukcapil = repository.findById(id).orElseThrow(
                () -> new OpenApiResourceNotFoundException("ID not found")
        );
        return AutoDukcapilMapper.MAPPER.mapToDukcapilDto(dukcapil);
    }

    @Override
    public DukcapilDto getNIKByNIK(String nik) {
        Dukcapil dukcapil = repository.findByNik(nik).orElseThrow(
                () -> new OpenApiResourceNotFoundException("NIK not found")
        );
        return AutoDukcapilMapper.MAPPER.mapToDukcapilDto(dukcapil);
    }

    @Override
    public DukcapilDto updateNIK(DukcapilDto dukcapil) {
        Dukcapil existingDukcapil = repository.findByNik(dukcapil.getNik()).orElse(null);
        assert existingDukcapil != null;
        existingDukcapil.setProvinsi(dukcapil.getProvinsi());
        existingDukcapil.setKota(dukcapil.getKota());
        Dukcapil updatedDukcapil = repository.save(existingDukcapil);
        return AutoDukcapilMapper.MAPPER.mapToDukcapilDto(repository.save(updatedDukcapil));
    }

    @Override
    public void deleteNIKid(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteNIK(String nik) {
        repository.deleteByNik(nik);
    }

    @Override
    public List<Dukcapil> getAllNIK() {
        return repository.findAll();
    }
}
