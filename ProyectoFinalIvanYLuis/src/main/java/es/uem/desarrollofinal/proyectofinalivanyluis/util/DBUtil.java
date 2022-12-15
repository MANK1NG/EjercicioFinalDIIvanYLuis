package es.uem.desarrollofinal.proyectofinalivanyluis.util;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DBUtil {


        //Conexión
        private static Connection conn = null;

        private static final String connStr = "jdbc:sqlite:EMPLEADO.db";
        //Conectar a la base de datos
        public static void dbConnect() throws SQLException, ClassNotFoundException {

            try {
                conn= DriverManager.getConnection(connStr);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console" + e);
                e.printStackTrace();
                throw e;
            }

        }
        //Cerrar conexión
        public static void dbDisconnect() throws SQLException {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception e){
                throw e;
            }
        }
        //Operacion para ejecutar las querys de la base de datos
        public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
            //Declarar statement, resultset y cacheRowSet
            Statement stmt = null;
            ResultSet resultSet = null;
            CachedRowSet crs;
            try {
                //Conectar a la base de datos
                dbConnect();
                System.out.println("Select statement: " + queryStmt + "\n");
                //Crear statement
                stmt = conn.createStatement();
                //Ejecutar la query seleccionada
                resultSet = stmt.executeQuery(queryStmt);
                //Implementar el cacheRowset
                //para prevenir el error "java.sql.SQLRecoverableException: Closed Connection: next"
                //Usamos CachedRowSet
                crs = RowSetProvider.newFactory().createCachedRowSet();
                crs.populate(resultSet);
            } catch (SQLException e) {
                System.out.println("Problem occurred at executeQuery operation : " + e);
                throw e;
            } finally {
                if (resultSet != null) {
                    //Cerrar resultset
                    resultSet.close();
                }
                if (stmt != null) {
                    //cerrar statement
                    stmt.close();
                }
                //Cerrar la conexion
                dbDisconnect();
            }
            //Retornar el CachedRowSet
            return crs;
        }
        //Operación de actualización de ejecución de base de datos (para actualizar/insertar/eliminar)
        public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
            //Declarar statement como nula
            Statement stmt = null;
            try {
                //Conectar BD
                dbConnect();
                //Crear Statement
                stmt = conn.createStatement();
                //Ejecute la operación executeUpdate con la instrucción sql dada
                stmt.executeUpdate(sqlStmt);
            } catch (SQLException e) {
                System.out.println("Problem occurred at executeUpdate operation : " + e);
                throw e;
            } finally {
                if (stmt != null) {
                    //Cerrar statement
                    stmt.close();
                }
                //Cerrar connection
                dbDisconnect();
            }
        }
}