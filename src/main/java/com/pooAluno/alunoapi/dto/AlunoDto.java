package com.pooAluno.alunoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.sql.Date;
import java.util.UUID;

public record AlunoDto(@NotNull Date nascimento, @NotBlank String ra, @NotBlank String nome) {
}
