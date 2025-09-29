/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author dukz
 */
//@ControllerAdvice
//@RestController
public class ResponseExceptionHandler {//extends ResponseEntityExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
//            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        //ex.getBindingResult().getAllErrors();
//        ExceptionResponse exceptionResponse = new ExceptionResponse("Validacion fallida", request.getDescription(false));
//        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(ModelNotFoundException.class)
//    public final ResponseEntity<ExceptionResponse> manejarModeloExcepciones(ModelNotFoundException ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//    
}
