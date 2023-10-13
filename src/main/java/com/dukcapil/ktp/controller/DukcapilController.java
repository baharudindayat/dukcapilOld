package com.dukcapil.ktp.controller;

import com.dukcapil.ktp.dto.DukcapilDto;
import com.dukcapil.ktp.dto.ValidateResponse;
import com.dukcapil.ktp.model.Dukcapil;
import com.dukcapil.ktp.service.DukcapilIService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/dukcapil")
public class DukcapilController {

    private DukcapilIService dukcapilIService;

    @PostMapping("/create")//problem
    public ResponseEntity<DukcapilDto> createNIK(@Valid @RequestBody DukcapilDto dukcapil) {
        DukcapilDto newDukcapil = dukcapilIService.createNIK(dukcapil);
        return new ResponseEntity<>(newDukcapil, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllNIK() {
        return new ResponseEntity<>(dukcapilIService.getAllNIK(), HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<DukcapilDto> getNIKById(@PathVariable("id") Long id) {
        DukcapilDto dukcapil = dukcapilIService.getNIKById(id);
        return new ResponseEntity<>(dukcapil, HttpStatus.OK);
    }

    @GetMapping("/get/nik/{nik}")
    public ResponseEntity<DukcapilDto> getNIKByNIK(@PathVariable("nik") String nik) {
        DukcapilDto dukcapil = dukcapilIService.getNIKByNIK(nik);
        return new ResponseEntity<>(dukcapil,HttpStatus.OK);
    }

    @GetMapping("/get/validate/{nik}")
    public ResponseEntity<ValidateResponse> getNIKBValidation(@PathVariable("nik") String nik) {
        DukcapilDto dukcapil = dukcapilIService.getNIKByNIK(nik);

        if (dukcapil != null) {
            ValidateResponse response = new ValidateResponse("NIK Terdaftar");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ValidateResponse response = new ValidateResponse("NIK Tidak Ditemukan");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{id}")//problem
    public ResponseEntity<DukcapilDto> updateNIK(@PathVariable("id") Long id, @RequestBody Dukcapil dukcapil) {
        DukcapilDto updateDukcapil = dukcapilIService.updateNIK(new DukcapilDto());
        return new ResponseEntity<>(updateDukcapil, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteNIKid(@PathVariable("id") Long id) {
        dukcapilIService.deleteNIKid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/nik/{nik}")//problem
    public ResponseEntity<?> deleteNIK(@PathVariable("nik") String nik) {
        dukcapilIService.deleteNIK(nik);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
