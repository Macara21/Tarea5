
package Tarea5;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Mario
 */
public class Vehiculo {
    
    //DECLARACIÓN DE VARIABLES
    private int kms, precio;
    private String marca, matricula, descripcion, nombreProp, dniProp;
    private LocalDate fMatriculacion;

    //CONSTRUCTOR VACIO
    public Vehiculo() {
    }

    //CONSTRUCTOR CON PARÁMETROS
    public Vehiculo(int kms, int precio, String marca, String matricula, String descripcion, String nombreProp, String dniProp, LocalDate fMatriculacion) {
        this.kms = kms;
        this.precio = precio;
        this.marca = marca;
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.nombreProp = nombreProp;
        this.dniProp = dniProp;
        this.fMatriculacion = fMatriculacion;
    }

    //MÉTODOS SETTERS Y GETTERS
    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreProp() {
        return nombreProp;
    }

    public void setNombreProp(String nombreProp) {
        this.nombreProp = nombreProp;
    }

    public String getDniProp() {
        return dniProp;
    }

    public void setDniProp(String dniProp) {
        this.dniProp = dniProp;
    }

    public LocalDate getfMatriculacion() {
        return fMatriculacion;
    }

    public void setfMatriculacion(LocalDate fMatriculacion) {
        this.fMatriculacion = fMatriculacion;
    }
    
    
    //----Método obtener años-----
      
    public int  getAnios() {
        LocalDate fechaActual = LocalDate.now();                //Se crea Localdate con fecha actual
        LocalDate Matriculacion = this.fMatriculacion;          //Se declara la variable con la fecha de matriculación
        Period periodo;
        periodo = Period.between(Matriculacion, fechaActual);  //Con este método obtenemos la diferencia de años
                                                                //entre la fecha de matriculación y la fecha actual.
        
        return periodo.getYears();
}
    
}
