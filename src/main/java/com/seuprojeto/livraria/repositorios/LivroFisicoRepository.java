package com.seuprojeto.livraria.repositorios;

import com.seuprojeto.livraria.entidades.LivroFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroFisicoRepository extends JpaRepository<LivroFisico, Long> {
}
