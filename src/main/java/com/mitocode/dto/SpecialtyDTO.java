package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDTO {

    private Integer idSpecialty;
    private String nameSpecialty;
    private String descriptionSpecialty;
}
