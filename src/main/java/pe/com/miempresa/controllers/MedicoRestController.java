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
import pe.com.miempresa.entities.Medico;
import pe.com.miempresa.services.MedicoService;
import pe.com.miempresa.utils.DataResponse;

/**
 *
 * @author dukz
 */
@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoRestController {

    private final MedicoService medicoService;

    @GetMapping()
    public ResponseEntity<DataResponse> listar() {
        DataResponse ar = new DataResponse();
        try {
            List<Medico> lista = medicoService.listar();
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
    public ResponseEntity<DataResponse> insertar(@Valid @RequestBody Medico medico) {
        DataResponse ar = new DataResponse();
        try {
            Medico p = medicoService.insertar(medico);
            ar.setStatus(DataResponse.Success);
            ar.setData(p);
            ar.setMessage("El medico fue creado correctamente.");
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
            Medico medico = medicoService.buscarPorId(id);
            if (medico == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Medico con ID [" + id + "] no encontrado.");
            } else {
                ar.setStatus(DataResponse.Success);
                ar.setData(medico);
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody Medico medico) {
        DataResponse ar = new DataResponse();
        try {
            Medico medicoTemp = medicoService.buscarPorId(id);
            if (medicoTemp == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Medico con ID [" + id + "] no encontrado.");
            } else {
                medico.setIdMedico(id);
                Medico p = medicoService.actualizar(medico);
                ar.setStatus(DataResponse.Success);
                ar.setData(p);
                ar.setMessage("El medico fue modificado correctamente.");
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
            Medico medicoTemp = medicoService.buscarPorId(id);
            if (medicoTemp == null) {
                ar.setStatus(DataResponse.Warning);
                ar.setMessage("Medico con ID [" + id + "] no encontrado.");
            } else {
                medicoService.eliminar(id);
                ar.setStatus(DataResponse.Success);
                ar.setMessage("El medico fue eliminado correctamente.");
            }
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

}
