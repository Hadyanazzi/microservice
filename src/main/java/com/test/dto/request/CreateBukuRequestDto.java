package com.test.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateBukuRequestDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("judul")
    private String judul;

    @JsonProperty("penulis")
    private String penulis;

    @JsonProperty("tahun_terbit")
    private Integer tahunTerbit;

}


