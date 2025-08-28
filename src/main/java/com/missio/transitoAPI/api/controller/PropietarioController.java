package com.missio.transitoAPI.api.controller;

import com.missio.transitoAPI.domain.model.Propietario;
import com.missio.transitoAPI.domain.repository.PropietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    private final PropietarioRepository repository;


    // metodos para buscar dados no banco

    @GetMapping
    public List<Propietario> findAll() {
       return repository.findAll();
    }


    @GetMapping("/{propietarioId}")
    public ResponseEntity<Propietario> findById(@PathVariable Long propietarioId) {
        return repository.findById(propietarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // metodos para inserir dados no banco
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Propietario save(@RequestBody Propietario propietario) {
        return repository.save(propietario);
    }

    //metodos para atualizar
    @PutMapping("/{propietarioId}")
    public ResponseEntity<Propietario> update(@PathVariable Long propietarioId, @RequestBody Propietario propietario) {
        /*
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        propietario.setId(id);
        Propietario updated = repository.save(propietario);
        return ResponseEntity.ok(updated);
        */

        return repository.findById(propietarioId)
                .map(record -> {
                    record.setNome(propietario.getNome());
                    record.setTelefone(propietario.getTelefone());
                    record.setEmail(propietario.getEmail());
                    Propietario updated = repository.save(record);
                    return ResponseEntity.ok(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    // metodo para excluir

    @DeleteMapping("/{propietarioId}")
    public ResponseEntity<Propietario> delite(@PathVariable Long propietarioId) {
        if(!repository.existsById(propietarioId)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(propietarioId);
        return ResponseEntity.noContent().build();
    }

}
