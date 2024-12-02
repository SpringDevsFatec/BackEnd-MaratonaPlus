package com.maratonaApi.controller;

import java.util.List;

import com.maratonaApi.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Corredor;
import com.maratonaApi.service.CorredorService;

@RestController
@RequestMapping("/api/corredores")
@CrossOrigin(origins = "*/")

public class CorredorController {

    @Autowired
    CorredorService corredorService;
    
    // Retorna todos os Corredores
    @GetMapping
    public List<Corredor> listAll() {
        return corredorService.obterTodos();
    }

    // Retorna todos os corredores inscritos em uma determinada maratona
    @GetMapping("/inscritos/{idMaratona}")
    public List<Corredor> listCorredoresInscritos(@PathVariable Integer idMaratona) {
        return corredorService.obterCorredoresInscritosPorMaratona(idMaratona);
    }

    // Retorna todos os corredores participando em uma determinada maratona
    @GetMapping("/participando/{idMaratona}")
    public List<Corredor> listCorredoresParticipantes(@PathVariable Integer idMaratona) {
        return corredorService.obterCorredoresParticipadoPorMaratona(idMaratona);
    }

    // Retorna todos os corredores finalizaram uma determinada maratona
    @GetMapping("/concluiram/{idMaratona}")
    public List<Corredor> listCorredoresConcluidos(@PathVariable Integer idMaratona) {
        return corredorService.obterCorredoresConcluiramPorMaratona(idMaratona);
    }

    // Retorna um corredor específico pelo ID
    @GetMapping("/{id}")
    public Corredor getById(@PathVariable Integer id) {
        return corredorService.read(id);
    }
    
    // Insere um novo corredor
    @PostMapping
    public Corredor insert(@RequestBody Corredor corredor) {
        return corredorService.insert(corredor);
    }

    // Verifica o login do corredor
    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequest loginRequest) {
        return corredorService.verificarLoginCorredorId(loginRequest.getEmail(), loginRequest.getSenha());
    }

    // Atualiza um corredor pelo ID
    @PutMapping("/{id}")
    public Corredor update(@RequestBody Corredor corredor, @PathVariable Integer id) {
        return corredorService.update(corredor, id);
    }
    
    // Exclui um corredor pelo ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        corredorService.delete(id);
        return "Corredor excluído com sucesso!";
    }
}