/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.services;

import java.util.List;
import pe.com.miempresa.entities.Medico;

/**
 *
 * @author dukz
 */
public interface MedicoService {

    public List<Medico> listar();

    public Medico insertar(Medico medico);

    public Medico buscarPorId(Integer idMedico);

    public Medico actualizar(Medico medico);

    public void eliminar(Integer idMedico);

}
