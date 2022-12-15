package es.uem.desarrollofinal.proyectofinalivanyluis.model;

import javafx.beans.property.*;

import java.sql.Date;


public class Empleado {
    private IntegerProperty id;

    private StringProperty nombre;
    private StringProperty apellido;
    private StringProperty email;
    private StringProperty telefono;
    private StringProperty fechaing;
    private StringProperty id_trabajo;
    private DoubleProperty salario;
    private DoubleProperty comision_pct;
    private IntegerProperty id_manager;
    private IntegerProperty id_departamento;

    public Empleado() {
        this.id = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.apellido = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty();
        this.fechaing = new SimpleStringProperty();
        this.id_trabajo = new SimpleStringProperty();
        this.salario = new SimpleDoubleProperty();
        this.comision_pct = new SimpleDoubleProperty();
        this.id_manager = new SimpleIntegerProperty();
        this.id_departamento = new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public String getFechaing() {
        return fechaing.get();
    }

    public StringProperty fechaingProperty() {
        return fechaing;
    }

    public void setFechaing(String fechaing) {
        this.fechaing.set(fechaing);
    }

    public String getId_trabajo() {
        return id_trabajo.get();
    }

    public StringProperty id_trabajoProperty() {
        return id_trabajo;
    }

    public void setId_trabajo(String id_trabajo) {
        this.id_trabajo.set(id_trabajo);
    }

    public double getSalario() {
        return salario.get();
    }

    public DoubleProperty salarioProperty() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario.set(salario);
    }

    public void setSalario(int salario) {
        this.salario.set(salario);
    }

    public double getComision_pct() {
        return comision_pct.get();
    }

    public DoubleProperty comision_pctProperty() {
        return comision_pct;
    }

    public void setComision_pct(double comision_pct) {
        this.comision_pct.set(comision_pct);
    }

    public int getId_manager() {
        return id_manager.get();
    }

    public IntegerProperty id_managerProperty() {
        return id_manager;
    }

    public void setId_manager(int id_manager) {
        this.id_manager.set(id_manager);
    }

    public int getId_departamento() {
        return id_departamento.get();
    }

    public IntegerProperty id_departamentoProperty() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento.set(id_departamento);
    }
}