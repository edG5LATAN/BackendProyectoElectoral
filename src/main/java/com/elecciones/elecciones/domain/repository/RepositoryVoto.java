package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVoto extends JpaRepository<Voto,Long> {
}
