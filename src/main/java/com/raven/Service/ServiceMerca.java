package com.raven.Service;

import com.raven.connection.DatabaseConnectionMercadillo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceMerca {
    private final DatabaseConnectionMercadillo con;
    private PreparedStatement pstActual = null;

    public ServiceMerca() {
       con = new DatabaseConnectionMercadillo();
    }
    public ResultSet searchDataNombre(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT c.cod_cl,  c.nombre, c.dni, a.n_puesto, t.f_ultm_pago, c.vencimiento, c.deuda FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl WHERE c.nombre LIKE ?;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, searchText + "%");
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataNombreTodo(String column) {
        ResultSet rs = null;
        String query = "SELECT c.cod_cl,  c.nombre, c.dni, a.n_puesto, t.f_ultm_pago, c.vencimiento, c.deuda FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl ORDER BY c.nombre ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataNombrePend(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT c.cod_cl,  c.nombre, c.dni, a.n_puesto, t.f_ultm_pago, c.vencimiento, c.deuda FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl WHERE c.nombre LIKE ? AND c.deuda > 0;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, searchText + "%");
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataNombrePendTodo(String column) {
        ResultSet rs = null;
        String query = "SELECT c.cod_cl,  c.nombre, c.dni, a.n_puesto, t.f_ultm_pago, c.vencimiento, c.deuda FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl WHERE c.deuda > 0 ORDER BY c.nombre ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    
    public ResultSet searchDataEpi(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT a.epigrafe, c.cod_cl, c.nombre, c.dni, a.n_puesto  FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl WHERE a.epigrafe LIKE ?;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, searchText + "%");
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataEpiTodo(String column) {
        ResultSet rs = null;
        String query = "SELECT a.epigrafe, c.cod_cl, c.nombre, c.dni, a.n_puesto  FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl ORDER BY a.epigrafe ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataVencimiento(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT c.vencimiento, c.cod_cl, c.nombre, c.dni, a.n_puesto  FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl WHERE c.vencimiento LIKE ?;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, searchText);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataVencimientoTodo(String column) {
        ResultSet rs = null;
        String query = "SELECT c.vencimiento, c.cod_cl, c.nombre, c.dni, a.n_puesto  FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl ORDER BY c.vencimiento ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataPago(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT t.cod_pago, c.cod_cl, c.nombre, c.dni, t.f_ultm_pago, t.importe_pago, a.n_puesto  FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl WHERE c.nombre LIKE ? ORDER BY t.f_ultm_pago ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, searchText + "%");
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataPagoTodo(String column) {
        ResultSet rs = null;
        String query = "SELECT t.cod_pago, c.cod_cl, c.nombre, c.dni, t.f_ultm_pago, t.importe_pago, a.n_puesto  FROM CLIENTE c  LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl ORDER BY c.nombre ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataPuesto(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT a.n_puesto, a.epigrafe, c.cod_cl, c.nombre, c.dni, a.finicio FROM CLIENTE c LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl LEFT JOIN TIEMPO_PAGO_CLIENTE t ON c.cod_cl = t.cod_cl WHERE a.n_puesto LIKE ?;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, searchText);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    public ResultSet searchDataPuestoTodo(String column) {
        ResultSet rs = null;
        String query = "SELECT a.n_puesto, a.epigrafe, c.cod_cl, c.nombre, c.dni, a.finicio FROM CLIENTE c LEFT JOIN ALQUILER a ON c.cod_cl = a.cod_cl ORDER BY a.n_puesto ASC;";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    
    public ResultSet searchDataImporte(String column, String searchText) {
        ResultSet rs = null;
        String query = "SELECT cod_cl, nombre, dni, importe_mes	 FROM cliente WHERE " + column + " LIKE ?";
        try {
        // Cierra cualquier PreparedStatement anterior
        if (pstActual != null) {
            pstActual.close();
        }

        pstActual = con.getPreparedStatement(query);
        pstActual.setString(1, "%" + searchText + "%");
        rs = pstActual.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron resultados");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta:");
        e.printStackTrace();
    }

        return rs;
    }
    
}
