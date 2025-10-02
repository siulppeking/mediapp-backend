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
import pe.com.miempresa.entities.Examen;
import pe.com.miempresa.services.ExamenService;
import pe.com.miempresa.utils.DataResponse;

/**
 *
 * @author dukz
 */
@RestController
@RequestMapping("/api/examenes")
@RequiredArgsConstructor
public class ExamenRestController {

    private final ExamenService examenService;

    @GetMapping()
    public ResponseEntity<DataResponse> listar() {
        DataResponse ar = new DataResponse();
        try {
            List<Examen> lista = examenService.listar();
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
    public ResponseEntity<DataResponse> insertar(@Valid @RequestBody Examen examen) {
        DataResponse ar = new DataResponse();
        try {
            Examen p = examenService.insertar(examen);
            ar.setStatus(DataResponse.Success);
            ar.setData(p);
            ar.setMessage("El examen fue creado correctamente.");
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
            Examen examen = examenService.buscarPorId(id);
            if (examen == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Examen con ID [" + id + "] no encontrado.");
            } else {
                ar.setStatus(DataResponse.Success);
                ar.setData(examen);
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody Examen examen) {
        DataResponse ar = new DataResponse();
        try {
            Examen examenTemp = examenService.buscarPorId(id);
            if (examenTemp == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Examen con ID [" + id + "] no encontrado.");
            } else {
                examen.setIdExamen(id);
                Examen p = examenService.actualizar(examen);
                ar.setStatus(DataResponse.Success);
                ar.setData(p);
                ar.setMessage("El examen fue modificado correctamente.");
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
            Examen examenTemp = examenService.buscarPorId(id);
            if (examenTemp == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Examen con ID [" + id + "] no encontrado.");
            } else {
                examenService.eliminar(id);
                ar.setStatus(DataResponse.Success);
                ar.setMessage("El examen fue eliminado correctamente.");
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

}
