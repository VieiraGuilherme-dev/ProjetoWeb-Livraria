package com.seuprojeto.livraria.controllers;

import com.seuprojeto.livraria.entidades.compra;
import com.seuprojeto.livraria.repositorios.CompraRepository;
import com.seuprojeto.livraria.servicos.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<compra> listarTodos() {
        return compraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<compra> buscarPorId(@PathVariable Long id) {
        Optional<compra> compra = compraRepository.findById(id);
        return compra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public compra criar(@RequestBody compra compra) {
        return compraRepository.save(compra);
    }

    @PostMapping("/processar")
    public ResponseEntity<compra> processarCompra(
            @RequestParam Long freguesId,
            @RequestParam List<Long> idsLivrosFisicos,
            @RequestParam List<Long> idsLivrosDigitais
    ) {
        try {
            compra compra = compraService.processarCompraFisica(freguesId, idsLivrosFisicos, idsLivrosDigitais);
            return ResponseEntity.ok(compra);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<compra> atualizar(@PathVariable Long id, @RequestBody compra compra) {
        return compraRepository.findById(id).map(compraExistente -> {
            compraExistente.setDataCompra(compra.getDataCompra());
            compraExistente.setValorTotal(compra.getValorTotal());
            compraExistente.setFregues(compra.getFregues());
            compra atualizado = compraRepository.save(compraExistente);
            return ResponseEntity.ok(atualizado);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

