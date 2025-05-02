package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {
    UserDetails findByCorreo(String username);
}
