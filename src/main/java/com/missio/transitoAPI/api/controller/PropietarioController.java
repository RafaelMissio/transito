package com.missio.transitoAPI.api.controller;

import com.missio.transitoAPI.api.domain.model.Propietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @GetMapping
    public List<Propietario> listar() {
        List<Propietario> propietarios = new ArrayList<>();
        propietarios.add(new Propietario(1L, "João Silva", "123456789", "Terste@Teste"));
        propietarios.add(new Propietario(2L, "Maria Souza", "987654321", "teste2@teste"));
        return propietarios;
    }
}
