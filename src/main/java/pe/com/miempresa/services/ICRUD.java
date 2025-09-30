/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.services;

import java.util.List;

/**
 *
 * @author lescobar
 */
public interface ICRUD<T> {

    T registrar(T t);

    T modificar(T t);

    T leerPorId(Integer id);

    List<T> listar();

    void eliminar(Integer id);

}
