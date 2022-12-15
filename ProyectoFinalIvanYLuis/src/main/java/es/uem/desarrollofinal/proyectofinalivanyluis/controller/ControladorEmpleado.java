package es.uem.desarrollofinal.proyectofinalivanyluis.controller;
import es.uem.desarrollofinal.proyectofinalivanyluis.model.Empleado;
import es.uem.desarrollofinal.proyectofinalivanyluis.model.EmpleadoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class ControladorEmpleado {
    @FXML
    private TextField empIdText;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextField newEmailText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField emailText;
    @FXML
    private TableView employeeTable;
    @FXML
    private TableColumn<Empleado, Integer>  empIdColumn;
    @FXML
    private TableColumn<Empleado, String>  empNameColumn;
    @FXML
    private TableColumn<Empleado, String> empLastNameColumn;
    @FXML
    private TableColumn<Empleado, String> empEmailColumn;
    @FXML
    private TableColumn<Empleado, String> empPhoneNumberColumn;
    @FXML
    private TableColumn<Empleado, String> empHireDateColumn;
    //Search an employee
    @FXML
    private void searchEmployee (ActionEvent actionEvent) throws ClassNotFoundException, SQLException, ParseException {
        try {
            //Obtener información del empleado
            Empleado emp = EmpleadoDAO.buscarEmpleado(empIdText.getText());
            //Rellenar empleado en TableView y mostrar en TextArea
            populateAndShowEmployee(emp);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Ocurrió un error al obtener la información del empleado de la base de datos.\n" + e);
            throw e;
        }
    }
    //Buscar todos los empleados
    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Obtenga toda la información de los empleados
            ObservableList<Empleado> empData = EmpleadoDAO.buscaEmpleados();
            //Rellenar empleados en TableView
            populateEmployees(empData);
        } catch (SQLException e){
            System.out.println("Ocurrió un error al obtener la información de los empleados de la base de datos.\n" + e);
            throw e;
        }
    }

    //Este método se llama automáticamente después de cargar el archivo fxml.
    @FXML
    private void initialize () {

        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().fechaingProperty());
    }
    //Rellenar empleado
    @FXML
    private void populateEmployee (Empleado emp) throws ClassNotFoundException {

        ObservableList<Empleado> empData = FXCollections.observableArrayList();
        //Agregar empleado a ObservableList
        empData.add(emp);
        //Establecer elementos en la tabla de empleados
        employeeTable.setItems(empData);
    }
    //Establecer la información del empleado en el área de texto
    @FXML
    private void setEmpInfoToTextArea ( Empleado emp) {
        resultArea.setText("Nombre: " + emp.getNombre() + "\n" +
                "Apellido: " + emp.getApellido());
    }
    //Rellenar empleado para TableView y Mostrar empleado en TextArea
    @FXML
    private void populateAndShowEmployee(Empleado emp) throws ClassNotFoundException {
        if (emp != null) {
            populateEmployee(emp);
            setEmpInfoToTextArea(emp);
        } else {
            resultArea.setText("Este empleado no existe!\n");
        }
    }
    //Rellenar empleados para TableView
    @FXML
    private void populateEmployees (ObservableList<Empleado> empData) throws ClassNotFoundException {
        //Establecer elementos en la tabla de empleados
        employeeTable.setItems(empData);
    }
    //Actualice el correo electrónico del empleado con el correo electrónico que está escrito en el campo newEmailText
    @FXML
    private void updateEmployeeEmail (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmpleadoDAO.updateEmpEmail(empIdText.getText(),newEmailText.getText());
            resultArea.setText("El correo electrónico se actualizó para la identificación del empleado: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Ocurrió un problema al actualizar el correo electrónico: " + e);
        }
    }
    //Insertar un empleado en la base de datos
    @FXML
    private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmpleadoDAO.insertEmp(nameText.getText(),surnameText.getText(),emailText.getText());
            resultArea.setText("Employee inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }
    //Eliminar un empleado con una identificación de empleado determinada de la base de datos
    @FXML
    private void deleteEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmpleadoDAO.deleteEmpWithId(empIdText.getText());
            resultArea.setText("¡Empleado eliminado! ID de empleado: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Ocurrió un problema al eliminar al empleado " + e);
            throw e;
        }
    }
}
