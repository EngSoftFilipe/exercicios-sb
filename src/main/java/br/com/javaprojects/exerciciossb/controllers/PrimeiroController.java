package br.com.javaprojects.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PrimeiroController {
    
    //@GetMapping(path = {"/teste", "/apresentacao"})
    public String teste(){
        return "Olá Spring Boot!";
    }

    @GetMapping(path = {"/teste", "/apresentacao"})
    public String apresentacao(){
        return "Olá, me chamo Filipe, " 
                + "tenho 21 anos e sou estudante de Engenharia de Software do 4° periodo";
    }
}