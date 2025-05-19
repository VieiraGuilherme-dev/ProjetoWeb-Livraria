package com.seuprojeto.livraria.repositorios;

import com.seuprojeto.livraria.entidades.Fregues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreguesRepository extends JpaRepository<Fregues, Long> {
}
