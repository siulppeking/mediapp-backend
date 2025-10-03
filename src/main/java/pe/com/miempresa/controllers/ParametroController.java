/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.miempresa.conn.DataSourceDB;
import pe.com.miempresa.entities.Parametro;
import pe.com.miempresa.utils.DataResponse;

/**
 *
 * @author lescobar
 */
@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

    @GetMapping
    public ResponseEntity<DataResponse> listar() {
        DataResponse ar = new DataResponse();
        try {
            List<Parametro> lista = new ArrayList<>();
            Connection conn = null;//DataSourceDB.getInstance().getConnection();
            CallableStatement cs = conn.prepareCall("{ call SICS.UPKG_PARAM.USP_PAGINAR(?,?,?,?) }");
            cs.setInt(1, 1);
            cs.setInt(2, 20);
            cs.setString(3, "");
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(4);
            while (rs.next()) {
                Parametro parametro = new Parametro();
                parametro.setIdParametro(rs.getInt(3));
                parametro.setNombre(rs.getString(4));

                lista.add(parametro);
            }
            conn.close();

            ar.setStatus(DataResponse.Success);
            ar.setData(lista);
        } catch (Exception e) {
            ar.setStatus(DataResponse.Error);
            ar.setData(e.getMessage());
            ar.setMessage(DataResponse.MensajeController);
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(ar);
    }
}
