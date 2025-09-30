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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author dukz
 */
@Data
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(name = "nombres", nullable = false, length = 50)
    @NotBlank(message = "El campo nombres es requerido.")
    @Size(min = 3, max = 50, message = "El nombre debe tener minimo 3 caracteres.")
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    @NotBlank(message = "El campo apellidos es requerido.")
    @Size(min = 3, max = 50, message = "El apellidos debe tener minimo 3 caracteres.")
    private String apellidos;

    @Column(name = "cmp", nullable = false, length = 12)
    @NotBlank(message = "El campo cmp es requerido.")
    @Size(min = 12, max = 12, message = "El cmp debe tener minimo 12 caracteres.")
    private String cmp;

}
