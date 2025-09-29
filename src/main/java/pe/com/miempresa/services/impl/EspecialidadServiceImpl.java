/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.com.miempresa.entities.Especialidad;
import pe.com.miempresa.repositories.EspecialidadRepository;
import pe.com.miempresa.services.EspecialidadService;

/**
 *
 * @author dukz
 */
@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public List<Especialidad> listar() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad insertar(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad buscarPorId(Integer idEspecialidad) {
        Optional<Especialidad> optional = especialidadRepository.findById(idEspecialidad);
        if (optional.isEmpty()) {
            return null;
        } else {
            return optional.get();
        }
    }

    @Override
    public Especialidad actualizar(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void eliminar(Integer idEspecialidad) {
        especialidadRepository.deleteById(idEspecialidad);
    }

}
