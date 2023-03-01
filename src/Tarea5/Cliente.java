
package Tarea5;

/**
 *
 * @author Mario
 */
public class Cliente {
    
    private int cPostal, numVehiculos = 0;
    private String dni, nombre, apellidos, direccion, poblacion;

    public Cliente() {
    }

    public Cliente(int cPostal, int numVehiculos, String dni, String nombre, String apellidos, String direccion, String poblacion) {
        this.cPostal = cPostal;
        this.numVehiculos = numVehiculos;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
    }

    public int getcPostal() {
        return cPostal;
    }

    public void setcPostal(int cPostal) {
        this.cPostal = cPostal;
    }

    public int getNumVehiculos() {
        return numVehiculos;
    }

    public void setNumVehiculos(int numVehiculos) {
        this.numVehiculos = numVehiculos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    
    
    
}
