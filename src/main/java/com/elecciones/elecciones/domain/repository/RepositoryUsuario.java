package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {
}
