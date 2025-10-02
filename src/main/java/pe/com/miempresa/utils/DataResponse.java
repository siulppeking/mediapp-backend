/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author lescobar
 */
@Data
public class DataResponse {

    public static final String Success = "success";
    public static final String Warning = "warning";
    public static final String Info = "info";
    public static final String Error = "error";

    public static final String MensajeController = "Lo sentimos, hubo un error al procesar la informacion.";

    @Schema(name = "status", required = true, example = "success|warning|info|error|error_body", defaultValue = "error", description = "Estado de la respuesta.")
    private String status;
    private Object data;
    private String message;
    private LocalDateTime timestamp;

    public DataResponse() {
        this.timestamp = LocalDateTime.now();
    }
}
