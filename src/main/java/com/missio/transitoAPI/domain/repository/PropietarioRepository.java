package com.missio.transitoAPI.domain.repository;

import com.missio.transitoAPI.domain.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

    List<Propietario> findByNome(String nome);
    List<Propietario> findByNomeContaining(String nome);
}
