package com.pooAluno.alunoapi.controller;

import com.fasterxml.jackson.core.util.BufferRecyclers;
import com.pooAluno.alunoapi.dto.AlunoDto;
import com.pooAluno.alunoapi.model.AlunoException;
import com.pooAluno.alunoapi.model.AlunoModel;
import com.pooAluno.alunoapi.repository.AlunoRepository;
import com.pooAluno.alunoapi.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoException alunoException;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> getAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.selectAllAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(alunoService.selectAluno(id));
        } catch (Exception e) {
            alunoException.setErro(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(alunoException);
        }
    }

    @PostMapping
    public ResponseEntity<AlunoModel> insertAluno(@RequestBody @Valid AlunoDto alunoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.insert(alunoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "id") Long id, @RequestBody @Valid AlunoDto alunoDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(alunoService.update(id, alunoDto));
        } catch (Exception e) {
            alunoException.setErro(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(alunoException);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("{id_deletado: \"" + alunoService.delete(id) + "\"}");
        } catch (Exception e) {
            alunoException.setErro(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(alunoException);
        }
    }

}
