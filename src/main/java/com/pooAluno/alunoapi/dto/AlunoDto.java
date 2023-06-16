package com.pooAluno.alunoapi.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigInteger;
import java.sql.Date;
import java.util.UUID;

public record AlunoDto(@NotBlank Date nascimento, @NotBlank String ra, @NotBlank String nome) {
}
