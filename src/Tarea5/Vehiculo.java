
package Tarea5;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Mario
 */
public class Vehiculo {
    
    //DECLARACI�N DE VARIABLES
    private int kms, precio;
    private String marca, matricula, descripcion, nombreProp, dniProp;
    private LocalDate fMatriculacion;

    //CONSTRUCTOR VACIO
    public Vehiculo() {
    }

    //CONSTRUCTOR CON PAR�METROS
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

    //M�TODOS SETTERS Y GETTERS
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
    
    
    //----M�todo obtener a�os-----
      
    public int  getAnios() {
        LocalDate fechaActual = LocalDate.now();                //Se crea Localdate con fecha actual
        LocalDate Matriculacion = this.fMatriculacion;          //Se declara la variable con la fecha de matriculaci�n
        Period periodo;
        periodo = Period.between(Matriculacion, fechaActual);  //Con este m�todo obtenemos la diferencia de a�os
                                                                //entre la fecha de matriculaci�n y la fecha actual.
        
        return periodo.getYears();
}
    
}
