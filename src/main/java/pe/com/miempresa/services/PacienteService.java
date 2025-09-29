/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.services;

import java.util.List;
import pe.com.miempresa.entities.Paciente;

/**
 *
 * @author dukz
 */
public interface PacienteService {

    public List<Paciente> listar();

    public Paciente insertar(Paciente paciente);

    public Paciente buscarPorId(Integer idPaciente);

    public Paciente actualizar(Paciente paciente);

    public void eliminar(Integer idPaciente);
    
}
