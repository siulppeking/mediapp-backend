/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package pe.com.miempresa.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import pe.com.miempresa.dto.PacienteResponse;
import pe.com.miempresa.entities.Paciente;
import pe.com.miempresa.services.PacienteService;
import pe.com.miempresa.utils.DataResponse;

/**
 *
 * @author dukz
 */
@Tag(name = "Paciente API", description = "Esta API contiene la funcionalidad de los Pacientes")
@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteRestController {

    private final PacienteService pacienteService;

    @GetMapping
    @Operation(description = "Retorna toda la lista de pacientes.", summary = "Retorna 200 | OK")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "500", description = "Error")
    })
    public ResponseEntity<DataResponse> listar() {
        DataResponse dr = new DataResponse();
        try {
            List<PacienteResponse> lista = pacienteService.listar();
            dr.setStatus(DataResponse.Success);
            dr.setData(lista);
        } catch (Exception e) {
            dr.setStatus(DataResponse.Error);
            dr.setData(e.getMessage());
            dr.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(dr);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertar(@Valid @RequestBody Paciente paciente) {
        DataResponse dr = new DataResponse();
        try {
            Paciente p = pacienteService.insertar(paciente);
            dr.setStatus(DataResponse.Success);
            dr.setData(p);
            dr.setMessage("El paciente fue creado correctamente.");
        } catch (Exception e) {
            dr.setStatus(DataResponse.Error);
            dr.setData(e.getMessage());
            dr.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(dr);
    }

    /*
    @PostMapping
    public ResponseEntity<Object> post(@Valid @RequestBody Paciente paciente) {
        Paciente p = pacienteService.insertar(paciente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(p.getIdPaciente()).toUri();
        return ResponseEntity.created(location).build();
    }
     */
    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> buscarPorId(@PathVariable("id") Integer id) {
        DataResponse dr = new DataResponse();
        try {
            Paciente paciente = pacienteService.buscarPorId(id);
            if (paciente == null) {
                dr.setStatus(DataResponse.Warning);
                dr.setMessage("Paciente con ID [" + id + "] no encontrado.");
            } else {
                dr.setStatus(DataResponse.Success);
                dr.setData(paciente);
            }
        } catch (Exception e) {
            dr.setStatus(DataResponse.Error);
            dr.setData(e.getMessage());
            dr.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(dr);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody Paciente paciente) {
        DataResponse dr = new DataResponse();
        try {
            Paciente pacienteTemp = pacienteService.buscarPorId(id);
            if (pacienteTemp == null) {
                dr.setStatus(DataResponse.Warning);
                dr.setMessage("Paciente con ID [" + id + "] no encontrado.");
            } else {
                paciente.setIdPaciente(id);
                Paciente p = pacienteService.actualizar(paciente);
                dr.setStatus(DataResponse.Success);
                dr.setData(p);
                dr.setMessage("El paciente fue modificado correctamente.");
            }
        } catch (Exception e) {
            dr.setStatus(DataResponse.Error);
            dr.setData(e.getMessage());
            dr.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(dr);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse> eliminar(@PathVariable("id") Integer id) {
        DataResponse dr = new DataResponse();
        try {
            Paciente pacienteTemp = pacienteService.buscarPorId(id);
            if (pacienteTemp == null) {
                dr.setStatus(DataResponse.Warning);
                dr.setMessage("Paciente con ID [" + id + "] no encontrado.");
            } else {
                pacienteService.eliminar(id);
                dr.setStatus(DataResponse.Success);
                dr.setMessage("El paciente fue eliminado correctamente.");
            }
        } catch (Exception e) {
            dr.setStatus(DataResponse.Error);
            dr.setData(e.getMessage());
            dr.setMessage(DataResponse.MensajeController);
        }
        return ResponseEntity.ok(dr);
    }

}
