/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.services;

import java.util.List;
import pe.com.miempresa.entities.Especialidad;

/**
 *
 * @author dukz
 */
public interface EspecialidadService {

    public List<Especialidad> listar();

    public Especialidad insertar(Especialidad especialidad);

    public Especialidad buscarPorId(Integer idEspecialidad);

    public Especialidad actualizar(Especialidad especialidad);

    public void eliminar(Integer idEspecialidad);

}
