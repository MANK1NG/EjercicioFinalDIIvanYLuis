package es.uem.desarrollofinal.proyectofinalivanyluis.model;


import es.uem.desarrollofinal.proyectofinalivanyluis.util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmpleadoDAO {

    //Selecciona un empleado

    public static Empleado buscarEmpleado (String empId) throws SQLException, ClassNotFoundException, ParseException {
        //Declara la sentencia SELECT
        String selectStmt = "SELECT * FROM EMPLEADO WHERE ID = " + empId;
        //Ejecuta la sentencia SELECT
        try {
            //Obtener ResultSet del método dbExecuteQuery
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
            //Enviar el ResultSet al método getEmployeeFromResultSet y obtener el objeto empleado
            Empleado empleado = getEmployeeFromResultSet(rsEmp);
            //Retornar el objeto empleado
            return empleado;
        } catch (SQLException e) {
            System.out.println("Mientras se buscaba un empleado con el id " + empId + ", se produjo un error: " + e);
            //Retorna la excepción
            throw e;
        }
    }
    //Utiliza el ResultSet de la BD como parámetro y establece los atributos del objeto empleado y devuelve el objeto empleado.
    private static Empleado getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Empleado emp = null;
        if (rs.next()) {
            emp = new Empleado();
            emp.setId(rs.getInt("ID"));
            emp.setNombre(rs.getString("NOMBRE"));
            emp.setApellido(rs.getString("APELLIDO"));
            emp.setEmail(rs.getString("EMAIL"));
            emp.setTelefono(rs.getString("TELEFONO"));
            emp.setFechaing(rs.getString("FECHAING"));
            emp.setId_trabajo(rs.getString("ID_TRABAJO"));
            emp.setSalario(rs.getDouble("SALARIO"));
            emp.setComision_pct(rs.getDouble("COMISION_PCT"));
            emp.setId_manager(rs.getInt("ID_MANAGER"));
            emp.setId_departamento(rs.getInt("ID_DEPARTAMENTO"));
        }
        return emp;
    }

    //Selecciona empleados

    public static ObservableList<Empleado> buscaEmpleados () throws SQLException, ClassNotFoundException {
        //Declarar la sentencia SELECT
        String selectStmt = "SELECT * FROM EMPLEADO";
        //Ejecuta la sentencia SELECT
        try {
            //Obtener el ResultSet del método dbExecuteQuery
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);
            //Enviar el ResultSet al método getEmployeeList y obtener el objeto empleado
            ObservableList<Empleado> empList = getEmployeeList(rsEmps);
            //Retorna el Objeto empleado
            return empList;
        } catch (SQLException e) {
            System.out.println("La sentencia SQL ha fallado: " + e);
            //Retorna una excepción
            throw e;
        }
    }

    //Seleccione * de la operación empleados
    private static ObservableList<Empleado> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declarar la ObservableList que comprende los objetos Empleados
        ObservableList<Empleado> empList = FXCollections.observableArrayList();
        while (rs.next()) {
            Empleado emp = new Empleado();
            emp.setId(rs.getInt("ID"));
            emp.setNombre(rs.getString("NOMBRE"));
            emp.setApellido(rs.getString("APELLIDO"));
            emp.setEmail(rs.getString("EMAIL"));
            emp.setTelefono(rs.getString("TELEFONO"));
            emp.setFechaing((rs.getString("FECHAING")));
            emp.setId_trabajo(rs.getString("ID_TRABAJO"));
            emp.setSalario(rs.getDouble("SALARIO"));
            emp.setComision_pct(rs.getDouble("COMISION_PCT"));
            emp.setId_manager(rs.getInt("ID_MANAGER"));
            emp.setId_departamento(rs.getInt("ID_DEPARTAMENTO"));
            //Añade el empleado a la ObservableList
            empList.add(emp);
        }
        //retorna empList (ObservableList de Empleados)
        return empList;
    }
    //*************************************
    //UPDATE de la dirección de correo electrónico de un empleado
    //*************************************
    public static void updateEmpEmail (String empId, String empEmail) throws SQLException, ClassNotFoundException {
        //Declara un UPDATE
        String updateStmt =
                "UPDATE EMPLEADO " +
                        "SET EMAIL = '" + empEmail + " ' " +
                        "WHERE ID = " + empId + " ;";
        //Ejecuta la operación UPDATE
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("Error mientras se hacía la operación UPDATE: " + e);
            throw e;
        }
    }
    //*************************************
    //DELETE un empleado
    //*************************************
    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declara la operación DELETE
        String updateStmt =
                "DELETE FROM EMPLEADO " +
                        "WHERE ID = "
                        + empId ;
        //Ejecuta la operación UPDATE
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("Error mientras se hacía la operación DELETE: " + e);
            throw e;
        }
    }

    //INSERT empleado

    public static void insertEmp(String name, String lastname, String email) throws SQLException, ClassNotFoundException {
        //Declara una operación INSERT
        String updateStmt =
               "INSERT INTO EMPLEADO " +
                        "(NOMBRE, APELLIDO, EMAIL) " +
                        "VALUES " +
                        "('" + name + "', '"
                       + lastname + "', '" + email + "');";
        //Ejecuta la operación UPDATE
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("Error mientras se hacía la operación INSERT: " + e);
            throw e;
        }
    }
}