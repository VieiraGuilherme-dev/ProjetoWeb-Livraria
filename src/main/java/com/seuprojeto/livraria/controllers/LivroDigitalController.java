package com.seuprojeto.livraria.controllers;

import com.seuprojeto.livraria.entidades.LivroDigital;
import com.seuprojeto.livraria.repositorios.LivroDigitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros-digitais")

public class LivroDigitalController {

    @Autowired
    private LivroDigitalRepository livroDigitalRepository;

    @GetMapping
    public List<LivroDigital> listarTodos() {
        return livroDigitalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDigital> buscarPorId(@PathVariable Long id) {
        Optional<LivroDigital> livro = livroDigitalRepository.findById(id);
        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LivroDigital criar(@RequestBody LivroDigital livroDigital) {
        return livroDigitalRepository.save(livroDigital);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDigital> atualizar(@PathVariable Long id, @RequestBody LivroDigital livroDigital) {
        return livroDigitalRepository.findById(id)
                .map(livroExistente -> {
                    livroExistente.setTitulo(livroDigital.getTitulo());
                    livroExistente.setAutor(livroDigital.getAutor());
                    livroExistente.setFormatoArquivo(livroDigital.getFormatoArquivo());
                    livroExistente.setUrlDownload(livroDigital.getUrlDownload());
                    LivroDigital atualizado = livroDigitalRepository.save(livroExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (livroDigitalRepository.existsById(id)) {
            livroDigitalRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

