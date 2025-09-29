/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.com.miempresa.entities.Medico;
import pe.com.miempresa.repositories.MedicoRepository;
import pe.com.miempresa.services.MedicoService;

/**
 *
 * @author dukz
 */
@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico insertar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico buscarPorId(Integer idMedico) {
        Optional<Medico> optional = medicoRepository.findById(idMedico);
        if (optional.isEmpty()) {
            return null;
        } else {
            return optional.get();
        }
    }

    @Override
    public Medico actualizar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void eliminar(Integer idMedico) {
        medicoRepository.deleteById(idMedico);
    }

}
