/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author dukz
 */
@Data
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @Column(name = "nombres", nullable = false, length = 50)
    @Size(min = 3, max = 50, message = "El nombre debe tener minimo 3 caracteres.")
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    @Size(min = 3, max = 50, message = "El apellidos debe tener minimo 3 caracteres.")
    private String apellidos;

    @Column(name = "direccion", nullable = false, length = 200)
    @Size(min = 3, max = 200, message = "La direccion debe tener minimo 3 caracteres.")
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 9)
    @Size(min = 9, message = "El telefono debe tener minimo 9 caracteres.")
    private String telefono;

    @Column(name = "correo", nullable = false, length = 100)
    @Email
    private String correo;

}
