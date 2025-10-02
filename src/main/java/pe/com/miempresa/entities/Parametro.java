/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 *
 * @author lescobar
 */
@Data
//@Schema(name = "Parametro", description = "Modelo de que representa el request en la entrada del servicio.")
public class Parametro {

    private Integer idParametro;

    //@Schema(name = "nombre", required = true, example = "estado.cuenta", defaultValue = "-1", description = "Campo que representa el nombre para el parametro.")
    private String nombre;

}
