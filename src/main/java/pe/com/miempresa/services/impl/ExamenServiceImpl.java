/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.com.miempresa.entities.Examen;
import pe.com.miempresa.repositories.ExamenRepository;
import pe.com.miempresa.services.ExamenService;

/**
 *
 * @author dukz
 */
@Service
public class ExamenServiceImpl implements ExamenService {

    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public List<Examen> listar() {
        return examenRepository.findAll();
    }

    @Override
    public Examen insertar(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen buscarPorId(Integer idExamen) {
        Optional<Examen> optional = examenRepository.findById(idExamen);
        if (optional.isEmpty()) {
            return null;
        } else {
            return optional.get();
        }
    }

    @Override
    public Examen actualizar(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public void eliminar(Integer idExamen) {
        examenRepository.deleteById(idExamen);
    }

}
