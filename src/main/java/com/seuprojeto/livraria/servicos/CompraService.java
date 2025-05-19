package com.seuprojeto.livraria.servicos;

import com.seuprojeto.livraria.entidades.*;
import com.seuprojeto.livraria.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private LivroFisicoRepository livroFisicoRepository;

    @Autowired
    private LivroDigitalRepository livroDigitalRepository;

    @Autowired
    private FreguesRepository freguesRepository;

    @Transactional
    public compra processarCompraFisica(Long freguesId, List<Long> idsLivrosFisicos, List<Long> idsLivrosDigitais) {
        Fregues fregues = freguesRepository.findById(freguesId)
                .orElseThrow(() -> new RuntimeException("Freguês não encontrado"));

        List<LivroFisico> livrosFisicos = livroFisicoRepository.findAllById(idsLivrosFisicos);
        List<LivroDigital> livrosDigitais = livroDigitalRepository.findAllById(idsLivrosDigitais);

        // Verificar estoque e diminuir para livros físicos
        for (LivroFisico livro : livrosFisicos) {
            int estoqueAtual = livro.getQuantidadeEstoque();
            if (estoqueAtual < 1) {
                throw new RuntimeException("Livro físico '" + livro.getTitulo() + "' sem estoque disponível");
            }
            livro.setQuantidadeEstoque(estoqueAtual - 1);
            livroFisicoRepository.save(livro);
        }

        // Calcular valor total
        double valorTotal = 0;
        for (LivroFisico l : livrosFisicos) {
            valorTotal += 50.0; // valor fixo ou substitua por l.getPreco()
        }
        for (LivroDigital l : livrosDigitais) {
            valorTotal += 30.0; // valor fixo ou substitua por l.getPreco()
        }

        compra compra = new compra();
        compra.setDataCompra(LocalDate.now());
        compra.setFregues(fregues);
        compra.setLivrosFisicos(livrosFisicos);
        compra.setLivrosDigitais(livrosDigitais);
        compra.setValorTotal(valorTotal);

        return compraRepository.save(compra);
    }
}

