/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.com.miempresa.common.PacienteResponseMapper;
import pe.com.miempresa.dto.PacienteResponse;
import pe.com.miempresa.entities.Paciente;
import pe.com.miempresa.repositories.PacienteRepository;
import pe.com.miempresa.services.PacienteService;

/**
 *
 * @author dukz
 */
@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteResponseMapper prm;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, PacienteResponseMapper prm) {
        this.pacienteRepository = pacienteRepository;
        this.prm = prm;
    }

    @Override
    public List<PacienteResponse> listar() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteResponse> pacientesResponse = prm.PacienteListToPacienteResponseList(pacientes);
        return pacientesResponse;
    }

    @Override
    public Paciente insertar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer idPaciente) {
        Optional<Paciente> optional = pacienteRepository.findById(idPaciente);
        if (optional.isEmpty()) {
            return null;
        } else {
            return optional.get();
        }
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Integer idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }

}
