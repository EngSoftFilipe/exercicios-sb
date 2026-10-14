package br.com.javaprojects.exerciciossb.controllers;
import br.com.javaprojects.models.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes") 
public class ClienteController {
    
    @GetMapping("/qualquer") // Sem annotation, só digito o path
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "123.456.789-00");
    }

    @GetMapping("/{id}") // Digito um ID na URL (/clientes/10)
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "Maria", "987.654.321-00");
    }

    @GetMapping("/parametros") // Digito com filtro depois da '?' de (/parametros?)
    public Cliente obterClienteId2(@RequestParam(name = "id") int id){
        return new Cliente(id, "João Augusto", "111.222.333-44");
    }
}