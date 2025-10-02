/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.dto;

import lombok.Data;

/**
 *
 * @author lescobar
 */
@Data
public class PacienteResponse {

    private Integer idPaciente;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;

}
