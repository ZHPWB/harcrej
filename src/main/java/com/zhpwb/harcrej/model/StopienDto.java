package com.zhpwb.harcrej.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StopienDto {

    OCH("Ochotnik"),
    ML("Młodzik"),
    CW("Ćwik"),
    HO("Harcerz Orli"),
    ASP("Aspirant"),
    HR("Harcerz Rzeczypospolitej"),
    PWD("Przewodnik"),
    PHM("Podharcmistrz"),
    HM("Harcmistrz");

    private String value;

    StopienDto(String value) {
        this.value = value;
    }
}
