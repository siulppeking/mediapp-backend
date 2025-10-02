/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package pe.com.miempresa.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pe.com.miempresa.entities.Especialidad;
import pe.com.miempresa.services.EspecialidadService;
import pe.com.miempresa.utils.DataResponse;

/**
 *
 * @author dukz
 */
@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadRestController {

    private final EspecialidadService especialidadService;

    @GetMapping()
    public ResponseEntity<DataResponse> listar() {
        DataResponse ar = new DataResponse();
        try {
            List<Especialidad> lista = especialidadService.listar();
            ar.setStatus(DataResponse.Success);
            ar.setData(lista);
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertar(@Valid @RequestBody Especialidad especialidad) {
        DataResponse ar = new DataResponse();
        try {
            Especialidad p = especialidadService.insertar(especialidad);
            ar.setStatus(DataResponse.Success);
            ar.setData(p);
            ar.setMessage("El especialidad fue creado correctamente.");
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> buscarPorId(@PathVariable("id") Integer id) {
        DataResponse ar = new DataResponse();
        try {
            Especialidad especialidad = especialidadService.buscarPorId(id);
            if (especialidad == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Especialidad con ID [" + id + "] no encontrado.");
            } else {
                ar.setStatus(DataResponse.Success);
                ar.setData(especialidad);
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody Especialidad especialidad) {
        DataResponse ar = new DataResponse();
        try {
            Especialidad especialidadTemp = especialidadService.buscarPorId(id);
            if (especialidadTemp == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Especialidad con ID [" + id + "] no encontrado.");
            } else {
                especialidad.setIdEspecialidad(id);
                Especialidad p = especialidadService.actualizar(especialidad);
                ar.setStatus(DataResponse.Success);
                ar.setData(p);
                ar.setMessage("El especialidad fue modificado correctamente.");
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse> eliminar(@PathVariable("id") Integer id) {
        DataResponse ar = new DataResponse();
        try {
            Especialidad especialidadTemp = especialidadService.buscarPorId(id);
            if (especialidadTemp == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Especialidad con ID [" + id + "] no encontrado.");
            } else {
                especialidadService.eliminar(id);
                ar.setStatus(DataResponse.Success);
                ar.setMessage("El especialidad fue eliminado correctamente.");
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

}
