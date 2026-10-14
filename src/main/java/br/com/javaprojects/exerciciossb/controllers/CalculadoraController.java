package br.com.javaprojects.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    // Com @PathVariable, coloca a rota no @GetMapping. EX: @GetMapping("/somar/{a}/{b}")
    // Com @RequestParam, não se aplica essa rota, mas na URL, colocamos: somar?a=9&b=2

    // Ambos possuem o mesmo nível de segurança, são visíveis na URL, aparecem em histórico e etc
    // @PathVariable: identifica qual recurso. Valor obrigatório, na rota, URL limpa (/clientes/28)
    // @RequestParam: filtra ou ajusta. Dá pra combinar vários (?nome=Filipe&pagina=2)
    // @PathVariable diz qual | @RequestParam diz como.

    @GetMapping("/somar") 
    public double somar(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b){
        return a + b;
    }

    @GetMapping("/subtrair")
    public double subtrair(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b){
        return a - b;
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b){
        return a * b;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam(name = "a") double a, @RequestParam(name = "b") double b){
        return a / b;
    }
}