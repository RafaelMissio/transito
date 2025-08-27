package com.missio.transitoAPI.api.controller;

import com.missio.transitoAPI.api.domain.model.Propietario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public List<Propietario> listar() {
        TypedQuery<Propietario> query=  manager.createQuery("from Propietario ", Propietario.class);
        return query.getResultList();
    }
}
