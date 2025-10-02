/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author lescobar
 */
public class DataSourceDB {

    // Configuración directa (para desarrollo)
    private static final String HOST = "10.129.5.10";
    private static final String PORT = "1521";
    private static final String SID = "DBDESA2";
    private static final String URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + SID;
    private static final String USER = "SICS";
    private static final String PASSWORD = "t4p1r*2023";

    // Nombre JNDI (para producción)
    private static final String JNDI_NAME = "jdbc/miDataSource";

    private DataSource dataSource;

    private DataSourceDB() {
        /*
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup(JNDI_NAME);
                System.out.println("Usando DataSource JNDI: " + JNDI_NAME);
            } catch (Exception ne) {
                throw new RuntimeException("No se encontró el DataSource en JNDI", ne);
            }
         */

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Usando conexión directa JDBC para desarrollo");
        } catch (Exception e) {
            throw new RuntimeException("Error cargando driver de Oracle", e);
        }
    }

    // Singleton con Holder Class
    private static class Holder {

        private static final DataSourceDB INSTANCE = new DataSourceDB();
    }

    public static DataSourceDB getInstance() {
        return Holder.INSTANCE;
    }

    // Retorna siempre una conexión nueva
    public Connection getConnection() throws SQLException {
        //return dataSource.getConnection();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
