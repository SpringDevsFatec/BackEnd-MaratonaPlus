package com.maratonaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maratonaApi.model.Maratona;
import com.maratonaApi.service.MaratonaService;

@RestController
@RequestMapping("/api/maratonas")
@CrossOrigin(origins = "http://192.168.0.30:8081")

public class MaratonaController {
    // instancia a classe Maratona service
    @Autowired
    MaratonaService maratonaService;

    // chama classe service para listar todos os Maratonas
    @GetMapping
    public List<Maratona> listAll() {
        return maratonaService.obterTodos();
    }

    // pega dado id e manda para classe service buscar
    @GetMapping("/{id}")
    public Maratona getById(@PathVariable Integer id) {
        return maratonaService.read(id);
    }

    //obter maratonas abertas por id do corredor
    @GetMapping("/maratonas-abertas/{idCorredor}")
    public List<Maratona> listAllMaratonasAbertasByCorredor(@PathVariable Integer idCorredor) {
        return maratonaService.obterMaratonasAbertasPorCorredor(idCorredor);
    }

    // pega dados do corpo da requisição e passa a classe service para inserir
    @PostMapping
    public Maratona insert(@RequestBody Maratona maratona) {
        return maratonaService.insert(maratona);
    }

    // pega corpo da requisição e manda para classe service para atualizar
    @PutMapping("/{id}")
    public Maratona update(@RequestBody Maratona maratona, @PathVariable Integer id) {
        return maratonaService.update(maratona, id);
    }

    // pega parametro da requisição e manda para classe servece afim de deletar um
    // Maratona
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        maratonaService.deleteById(id);
        return "Maratona excluído com sucesso!";
    }

}