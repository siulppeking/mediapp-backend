/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package pe.com.miempresa.controllers;

import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.com.miempresa.entities.Paciente;
import pe.com.miempresa.exceptions.ModelNotFoundException;
import pe.com.miempresa.services.PacienteService;

/**
 *
 * @author dukz
 */
@RestController
@RequestMapping("/api/pacientes")
public class PacienteRestController {

    private final PacienteService pacienteService;

    public PacienteRestController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping()
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @PostMapping
    public ResponseEntity<Object> post(@Valid @RequestBody Paciente paciente) {
        Paciente p = pacienteService.insertar(paciente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(p.getIdPaciente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public Paciente get(@PathVariable("id") Integer id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            throw new ModelNotFoundException("Id [" + id + "] no encontrado.");
        }
        return paciente;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody Paciente paciente) {
        paciente.setIdPaciente(id);
        Paciente p = pacienteService.actualizar(paciente);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Paciente p = pacienteService.buscarPorId(id);
        if (p == null) {
            throw new ModelNotFoundException("Id [" + id + "] no encontrado.");
        }
        pacienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
