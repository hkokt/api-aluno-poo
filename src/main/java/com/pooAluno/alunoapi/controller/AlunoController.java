package com.pooAluno.alunoapi.controller;

import com.pooAluno.alunoapi.dto.AlunoDto;
import com.pooAluno.alunoapi.model.AlunoModel;
import com.pooAluno.alunoapi.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping("/alunos")
    public ResponseEntity<AlunoModel> insertAluno(@RequestBody @Valid AlunoDto alunoDto) {
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return ResponseEntity.status(200).body(alunoRepository.save(alunoModel));
    }


}
