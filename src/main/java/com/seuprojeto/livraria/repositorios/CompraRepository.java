package com.seuprojeto.livraria.repositorios;

import com.seuprojeto.livraria.entidades.compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<compra, Long> {
}
