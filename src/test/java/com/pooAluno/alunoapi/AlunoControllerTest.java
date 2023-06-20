package com.pooAluno.alunoapi;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pooAluno.alunoapi.dto.AlunoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AlunoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllAluno() throws Exception {
        mockMvc.perform(get("/alunos")).andExpect(status().isOk());
    }

    @Test
    public void testInsertAluno() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) dateFormat.parse("2000-04-17");
        AlunoDto testeAluno = new AlunoDto(date, "12345646", "teste");
        mockMvc.perform(post("/alunos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testeAluno)))
                .andExpect(status().isOk());
    }

}
