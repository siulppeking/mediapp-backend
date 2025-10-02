/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.exceptions;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.converter.HttpMessageNotReadableException;
import pe.com.miempresa.utils.DataResponse;

/**
 *
 * @author lescobar
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DataResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            Map<String, String> campoError = new HashMap<>();
            campoError.put("name", error.getField());
            campoError.put("message", error.getDefaultMessage());
            errores.add(campoError);
        });
        DataResponse response = new DataResponse();
        response.setStatus("validation");
        response.setData(errores);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DataResponse> handleGenericException(Exception ex) {
        DataResponse response = new DataResponse();
        response.setStatus("error");
        response.setData(null);
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DataResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        DataResponse response = new DataResponse();
        response.setStatus("error_body");
        response.setMessage("El cuerpo de la petición es requerido o está mal formado.");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
