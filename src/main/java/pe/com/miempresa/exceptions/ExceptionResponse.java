/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.exceptions;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author dukz
 */
@Data
public class ExceptionResponse {

    private Date timestamp;
    private String mensaje;
    private String detalles;

    public ExceptionResponse(String mensaje, String detalles) {
        this.timestamp = new Date();
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
}
