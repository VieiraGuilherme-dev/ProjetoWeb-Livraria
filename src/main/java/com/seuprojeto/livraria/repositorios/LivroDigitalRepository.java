package com.seuprojeto.livraria.repositorios;

import com.seuprojeto.livraria.entidades.LivroDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroDigitalRepository extends JpaRepository<LivroDigital, Long> {
}
