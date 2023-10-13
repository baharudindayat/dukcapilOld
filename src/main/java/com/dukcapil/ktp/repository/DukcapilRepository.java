package com.dukcapil.ktp.repository;

import com.dukcapil.ktp.model.Dukcapil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DukcapilRepository extends JpaRepository<Dukcapil, Long>{
    Optional<Dukcapil> findByNik(String nik);
    void deleteByNik(String nik);
}
