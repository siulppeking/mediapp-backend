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
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExamen;

    @Column(name = "nombre", nullable = false, length = 30)
    @NotBlank(message = "El campo nombre es requerido.")
    @Size(min = 3, max = 30, message = "El nombre debe tener minimo 3 caracteres.")
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 100)
    @NotBlank(message = "El campo descripcion es requerido.")
    @Size(min = 3, max = 100, message = "La descripcion debe tener minimo 3 caracteres.")
    private String descripcion;

}
