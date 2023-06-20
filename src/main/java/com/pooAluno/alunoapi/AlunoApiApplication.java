package com.pooAluno.alunoapi;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Scanner;

@SpringBootApplication
public class AlunoApiApplication {
    public static void main(String[] args) throws ParseException {
        SpringApplication.run(AlunoApiApplication.class, args);
    }
}
