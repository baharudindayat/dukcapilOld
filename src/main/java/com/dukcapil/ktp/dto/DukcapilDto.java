package com.dukcapil.ktp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DukcapilDto {


    @Schema(
            description = "Dukcapil ID"
    )
    @NotEmpty(message = "Dukcapil ID should not be null or empty")
    private long id;

    @Schema(
            description = "Dukcapil NIK"
    )
    @NotEmpty(message = "Dukcapil NIK should not be null or empty")
    private String nik;

    @Schema(
            description = "Dukcapil Provinsi"
    )
    @NotEmpty(message = "Dukcapil Provinsi should not be null or empty")
    private String provinsi;

    @Schema(
            description = "Dukcapil Kota"
    )
    @NotEmpty(message = "Dukcapil Kota should not be null or empty")
    private String kota;

}
