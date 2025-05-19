package com.seuprojeto.livraria.controllers;

import com.seuprojeto.livraria.entidades.LivroFisico;
import com.seuprojeto.livraria.repositorios.LivroFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros-fisicos")
public class LivroFisicoController {

    @Autowired
    private LivroFisicoRepository livroFisicoRepository;

    @GetMapping
    public List<LivroFisico> listarTodos() {
        return livroFisicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroFisico> buscarPorId(@PathVariable Long id) {
        Optional<LivroFisico> livroOpt = livroFisicoRepository.findById(id);
        return livroOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LivroFisico criar(@RequestBody LivroFisico livroFisico) {
        return livroFisicoRepository.save(livroFisico);
    }

    @PutMapping("/{id}/estoque")
    public ResponseEntity<LivroFisico> atualizarEstoque(@PathVariable Long id, @RequestParam int quantidade) {
        Optional<LivroFisico> optionalLivro = livroFisicoRepository.findById(id);
        if (optionalLivro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        LivroFisico livro = optionalLivro.get();

        int estoqueAtual = livro.getQuantidadeEstoque();
        int novoEstoque = estoqueAtual + quantidade; // quantidade pode ser negativa para diminuir estoque

        if (novoEstoque < 0) {
            return ResponseEntity.badRequest().body(null); // não pode ter estoque negativo
        }

        livro.setQuantidadeEstoque(novoEstoque);
        livroFisicoRepository.save(livro);

        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (livroFisicoRepository.existsById(id)) {
            livroFisicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
