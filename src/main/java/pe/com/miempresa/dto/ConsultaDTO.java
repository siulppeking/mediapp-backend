/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.dto;

import lombok.Data;
import pe.com.miempresa.entities.Medico;
import pe.com.miempresa.entities.Paciente;

/**
 *
 * @author lescobar
 */
@Data
public class ConsultaDTO {

    private int idConsulta;
    private Medico medico;
    private Paciente paciente;

}
