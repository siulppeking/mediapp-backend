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
import pe.com.miempresa.utils.ApiResponse;

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
    public ResponseEntity<ApiResponse> listar() {
        ApiResponse ar = new ApiResponse();
        try {
            List<Medico> lista = medicoService.listar();
            ar.setStatus(ApiResponse.Success);
            ar.setData(lista);
        } catch (Exception e) {
            ar.setStatus(ApiResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(ApiResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> insertar(@Valid @RequestBody Medico medico) {
        ApiResponse ar = new ApiResponse();
        try {
            Medico p = medicoService.insertar(medico);
            ar.setStatus(ApiResponse.Success);
            ar.setData(p);
            ar.setMessage("El medico fue creado correctamente.");
        } catch (Exception e) {
            ar.setStatus(ApiResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(ApiResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> buscarPorId(@PathVariable("id") Integer id) {
        ApiResponse ar = new ApiResponse();
        try {
            Medico medico = medicoService.buscarPorId(id);
            if (medico == null) {
                ar.setStatus(ApiResponse.Warning);
                ar.setMessage("Medico con ID [" + id + "] no encontrado.");
            } else {
                ar.setStatus(ApiResponse.Success);
                ar.setData(medico);
            }
        } catch (Exception e) {
            ar.setStatus(ApiResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(ApiResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody Medico medico) {
        ApiResponse ar = new ApiResponse();
        try {
            Medico medicoTemp = medicoService.buscarPorId(id);
            if (medicoTemp == null) {
                ar.setStatus(ApiResponse.Warning);
                ar.setMessage("Medico con ID [" + id + "] no encontrado.");
            } else {
                medico.setIdMedico(id);
                Medico p = medicoService.actualizar(medico);
                ar.setStatus(ApiResponse.Success);
                ar.setData(p);
                ar.setMessage("El medico fue modificado correctamente.");
            }
        } catch (Exception e) {
            ar.setStatus(ApiResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(ApiResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> eliminar(@PathVariable("id") Integer id) {
        ApiResponse ar = new ApiResponse();
        try {
            Medico medicoTemp = medicoService.buscarPorId(id);
            if (medicoTemp == null) {
                ar.setStatus(ApiResponse.Warning);
                ar.setMessage("Medico con ID [" + id + "] no encontrado.");
            } else {
                medicoService.eliminar(id);
                ar.setStatus(ApiResponse.Success);
                ar.setMessage("El medico fue eliminado correctamente.");
            }
        } catch (Exception e) {
            ar.setStatus(ApiResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(ApiResponse.MensajeController);
        }
        return ResponseEntity.ok(ar);
    }

}
