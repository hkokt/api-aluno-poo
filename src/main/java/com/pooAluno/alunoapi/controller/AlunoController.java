package com.pooAluno.alunoapi.controller;

import com.pooAluno.alunoapi.dto.AlunoDto;
import com.pooAluno.alunoapi.model.AlunoModel;
import com.pooAluno.alunoapi.repository.AlunoRepository;
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
    AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> getAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") UUID id) {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aluno não registrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno.get());
    }

    @PostMapping
    public ResponseEntity<AlunoModel> insertAluno(@RequestBody @Valid AlunoDto alunoDto) {
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(alunoModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "id") UUID id, @RequestBody @Valid AlunoDto alunoDto) {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aluno não registrado");
        }
        var alunoModel = aluno.get();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value = "id") UUID id) {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aluno não registrado");
        }
        var alunoModel = aluno.get();
        alunoRepository.delete(alunoModel);
        return ResponseEntity.status(HttpStatus.OK).body("aluno apagado");
    }

}
