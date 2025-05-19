package com.seuprojeto.livraria.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCompra;

    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "fregues_id")
    private Fregues fregues;

    @ManyToMany
    @JoinTable(
            name = "compra_livro_fisico",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_fisico_id")
    )
    private List<LivroFisico> livrosFisicos;

    @ManyToMany
    @JoinTable(
            name = "compra_livro_digital",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_digital_id")
    )
    private List<LivroDigital> livrosDigitais;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fregues getFregues() {
        return fregues;
    }

    public void setFregues(Fregues fregues) {
        this.fregues = fregues;
    }

    public List<LivroFisico> getLivrosFisicos() {
        return livrosFisicos;
    }

    public void setLivrosFisicos(List<LivroFisico> livrosFisicos) {
        this.livrosFisicos = livrosFisicos;
    }

    public List<LivroDigital> getLivrosDigitais() {
        return livrosDigitais;
    }

    public void setLivrosDigitais(List<LivroDigital> livrosDigitais) {
        this.livrosDigitais = livrosDigitais;
    }
}
