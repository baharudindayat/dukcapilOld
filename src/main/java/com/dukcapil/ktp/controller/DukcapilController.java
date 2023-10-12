package com.dukcapil.ktp.controller;

import com.dukcapil.ktp.model.Dukcapil;
import com.dukcapil.ktp.repository.DukcapilRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/dukcapil")
@Controller
public class DukcapilController {

    public final DukcapilRespository respository;

    public  DukcapilController(DukcapilRespository respository) {
        this.respository = respository;
    }

    @GetMapping("/getall")
    public ResponseEntity<Collection<Dukcapil>> getAllDukcapil() {
        return new ResponseEntity<>(respository.findAll(), HttpStatus.OK);

    }

    @GetMapping(params = {"nik"})
    public ResponseEntity<Collection<Dukcapil>> getDukcapilByNik(@RequestParam(value = "nik") String nik) {
        return new ResponseEntity<>(respository.findByNik(nik), HttpStatus.OK);
    }



}
