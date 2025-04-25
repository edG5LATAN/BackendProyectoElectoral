package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPartido extends JpaRepository<Partido,Long> {
}
