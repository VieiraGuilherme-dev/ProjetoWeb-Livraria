package com.seuprojeto.livraria.controllers;

import com.seuprojeto.livraria.entidades.Fregues;
import com.seuprojeto.livraria.repositorios.FreguesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fregueses")
public class FreguesController {

    @Autowired
    private FreguesRepository freguesRepository;

    @GetMapping
    public List<Fregues> listarTodos() {
        return freguesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fregues> buscarPorId(@PathVariable Long id) {
        Optional<Fregues> fregues = freguesRepository.findById(id);
        return fregues.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fregues criar(@RequestBody Fregues fregues) {
        return freguesRepository.save(fregues);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fregues> atualizar(@PathVariable Long id, @RequestBody Fregues fregues) {
        return freguesRepository.findById(id).map(freguesExistente -> {
            freguesExistente.setNome(fregues.getNome());
            freguesExistente.setEmail(fregues.getEmail());
            freguesExistente.setTelefone(fregues.getTelefone());
            Fregues atualizado = freguesRepository.save(freguesExistente);
            return ResponseEntity.ok(atualizado);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (freguesRepository.existsById(id)) {
            freguesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
