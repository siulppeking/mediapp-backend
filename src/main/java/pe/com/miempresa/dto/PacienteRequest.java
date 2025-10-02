/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author lescobar
 */
@Data
public class PacienteRequest {

    private String idPaciente;

    @NotBlank(message = "El campo nombres es requerido.")
    @Size(min = 3, max = 50, message = "El nombre debe tener minimo 3 caracteres.")
    private String nombres;

    @NotBlank(message = "El campo apellidos es requerido.")
    @Size(min = 3, max = 50, message = "El apellidos debe tener minimo 3 caracteres.")
    private String apellidos;

    @NotBlank(message = "El campo direccion es requerido.")
    @Size(min = 3, max = 200, message = "La direccion debe tener minimo 3 caracteres.")
    private String direccion;

    @NotBlank(message = "El campo telefono es requerido.")
    @Size(min = 9, max = 9, message = "El telefono debe tener minimo 9 caracteres.")
    private String telefono;

    @NotBlank(message = "El campo correo es requerido.")
    @Email
    private String correo;

}
