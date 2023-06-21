package com.pooAluno.alunoapi.service;

import com.pooAluno.alunoapi.dto.AlunoDto;
import com.pooAluno.alunoapi.model.AlunoException;
import com.pooAluno.alunoapi.model.AlunoModel;
import com.pooAluno.alunoapi.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoModel> selectAllAlunos() {
        return alunoRepository.findAll();
    }

    public AlunoModel selectAluno(Long id) throws Exception {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            throw new Exception("Aluno não registrado");
        }
        return aluno.get();
    }

    public AlunoModel insert(AlunoDto alunoDto) {
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return alunoRepository.save(alunoModel);
    }

    public AlunoModel update(Long id, AlunoDto alunoDto) throws Exception {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            throw new Exception("Aluno não registrado");
        }
        var alunoModel = aluno.get();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return alunoRepository.save(alunoModel);
    }

    public String delete(Long id) throws Exception {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            throw new Exception("Aluno não registrado");
        }
        var alunoModel = aluno.get();
        alunoRepository.delete(alunoModel);
        return id + "";
    }

}
