package com.pooAluno.alunoapi.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record AlunoDto(
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate nascimento,
        @NotBlank String ra,
        @NotBlank String nome) {}
