/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.services;

import pe.com.miempresa.dto.ConsultaListaExamenDTO;
import pe.com.miempresa.entities.Consulta;

/**
 *
 * @author lescobar
 */
public interface ConsultaService extends ICRUD<Consulta> {

    Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO);

}
