/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

/**
 *
 * @author lescobar
 */
@Data
@Entity
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

    @Id
    private Examen examen;

    @Id
    private Consulta consulta;

}
