package com.dukcapil.ktp.repository;

import com.dukcapil.ktp.model.Dukcapil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DukcapilRespository  extends JpaRepository<Dukcapil, Long> {
    List<Dukcapil> findByNik(String nik);
}
