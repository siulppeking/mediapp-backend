/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.dto;

import java.util.List;
import lombok.Data;
import pe.com.miempresa.entities.Consulta;
import pe.com.miempresa.entities.Examen;

/**
 *
 * @author lescobar
 */
@Data
public class ConsultaListaExamenDTO {

    private Consulta consulta;
    private List<Examen> listExamen;

}
