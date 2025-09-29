/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.services;

import java.util.List;
import pe.com.miempresa.entities.Examen;

/**
 *
 * @author dukz
 */
public interface ExamenService {

    public List<Examen> listar();

    public Examen insertar(Examen examen);

    public Examen buscarPorId(Integer idExamen);

    public Examen actualizar(Examen examen);

    public void eliminar(Integer idExamen);

}
