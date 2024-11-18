package com.maratonaApi.controller;

import java.util.List;

import com.maratonaApi.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Corredor;
import com.maratonaApi.service.CorredorService;

@RestController
@RequestMapping("/api/corredores")
@CrossOrigin(origins = "http://192.168.0.30:8081")

public class CorredorController {
	// instancia a classe Corredor service 
    @Autowired
    CorredorService corredorService;
    
    // chama classe service para listar todos os Corredores
    @GetMapping
    public List<Corredor> listAll() {
        return corredorService.obterTodos();
    }

    // chama classe service para listar todos os Corredores
    @GetMapping("/inscritos/{idMaratona}")
    public List<Corredor> listCorredoresInscritos(@PathVariable Integer idMaratona) {
        return corredorService.obterCorredoresInscritosPorMaratona(idMaratona);
    }

    // chama classe service para listar todos os Corredores
    @GetMapping("/participando/{idMaratona}")
    public List<Corredor> listCorredoresParticipantes(@PathVariable Integer idMaratona) {
        return corredorService.obterCorredoresParticipadoPorMaratona(idMaratona);
    }

    // chama classe service para listar todos os Corredores
    @GetMapping("/concluiram/{idMaratona}")
    public List<Corredor> listCorredoresConcluidos(@PathVariable Integer idMaratona) {
        return corredorService.obterCorredoresConcluiramPorMaratona(idMaratona);
    }



    // pega dado id e manda para classe service buscar
    @GetMapping("/{id}")
    public Corredor getById(@PathVariable Integer id) {
        return corredorService.read(id);
    }
    
    // pega dados do corpo da requisição e passa a classe service para inserir
    @PostMapping
    public Corredor insert(@RequestBody Corredor corredor) {
        return corredorService.insert(corredor);
    }

    //pega as credencias de login e passa para o metodo verificar
    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequest loginRequest) {
        return corredorService.verificarLoginCorredorId(loginRequest.getEmail(), loginRequest.getSenha());
    }

    // pega corpo da requisição e manada para classe service para atualizar
    @PutMapping("/{id}")
    public Corredor update(@RequestBody Corredor corredor, @PathVariable Integer id) {
        return corredorService.update(corredor, id);
    }
    
    // pega parameter da requisição e manda para classe service a fim de deletar um Corredor
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        corredorService.delete(id);
        return "Corredor excluído com sucesso!";
    }
}