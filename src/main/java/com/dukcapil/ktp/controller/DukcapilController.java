package com.dukcapil.ktp.controller;

import com.dukcapil.ktp.dto.DukcapilDto;
import com.dukcapil.ktp.dto.ValidateResponse;
import com.dukcapil.ktp.exception.NikNotFoundException;
import com.dukcapil.ktp.service.DukcapilIService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/dukcapil")
public class DukcapilController {

    private DukcapilIService dukcapilIService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<DukcapilDto> createNIK(@RequestBody DukcapilDto dukcapil) {
        DukcapilDto newDukcapil = dukcapilIService.createNIK(dukcapil);
        return new ResponseEntity<>(newDukcapil, HttpStatus.CREATED);
    }

    @PostMapping("/validate")
    @Transactional
    public ResponseEntity<ValidateResponse> createNIKValidate(@RequestBody DukcapilDto dukcapil) {
        DukcapilDto newDukcapil = dukcapilIService.validateNIK(dukcapil);
        return getValidateResponseResponseEntity(newDukcapil);
    }

    private ResponseEntity<ValidateResponse> getValidateResponseResponseEntity(DukcapilDto newDukcapil) {
        if (newDukcapil != null) {
            ValidateResponse response = new ValidateResponse("NIK Terdaftar");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ValidateResponse response = new ValidateResponse("NIK Tidak Ditemukan");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
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

    @PostMapping("/get/nik/{nik}")
    public ResponseEntity<DukcapilDto> getNIKByNIK(@PathVariable("nik") String nik) {
        DukcapilDto dukcapil = dukcapilIService.getNIKByNIK(nik);
        return new ResponseEntity<>(dukcapil,HttpStatus.OK);
    }

    @GetMapping("/get/validate/{nik}")
    public ResponseEntity<ValidateResponse> getNIKBValidation(@PathVariable("nik") String nik) {
        DukcapilDto dukcapil = dukcapilIService.getNIKByNIK(nik);
        return getValidateResponseResponseEntity(dukcapil);
    }


    @PutMapping("/update/{nik}")
    @Transactional
    public ResponseEntity<DukcapilDto> updateNIK(@PathVariable("nik") String nik, @RequestBody DukcapilDto dukcapil) {
        dukcapil.setNik(nik);
        DukcapilDto updateDukcapil = dukcapilIService.updateNIK(dukcapil);
        return new ResponseEntity<>(updateDukcapil, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteNIKid(@PathVariable("id") Long id) {
        dukcapilIService.deleteNIKid(id);
        return new ResponseEntity<>("{User Delete Successfully}",HttpStatus.OK);
    }

    @DeleteMapping("/delete/nik/{nik}")
    @Transactional
    public ResponseEntity<?> deleteNIKNIK(@PathVariable("nik") String nik) {
        dukcapilIService.deleteNIK(nik);
        return new ResponseEntity<>("{User Delete Successfully}",HttpStatus.OK);
    }
}
