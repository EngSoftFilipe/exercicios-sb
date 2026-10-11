package br.com.javaprojects.exerciciossb.controllers;
import br.com.javaprojects.models.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes") 
public class ClienteController {
    
    @GetMapping("/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "123.456.789-00");
    }
}