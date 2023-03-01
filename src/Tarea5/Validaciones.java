package Tarea5;

import java.time.LocalDate;

/**
 *
 * @author Mario
 */
//------------Clase con m�todos est�ticos para validar los par�metros introducidos en la clase principal-----
public class Validaciones {

    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE"; //Constante para realizar la validacion del dni
    // con el modulo 23.

    public static boolean kmMayorCero(int km) {
        if (km > 0) {                                     //M�todo para validar que los kilometros introducidos
            return true;                                  //sean mayor a cero
        } else {
            return false;
        }
    }

    public static boolean validarFecha(LocalDate fecha) {  //Metodo para validar fecha. Nos comprueba
        //que la fecha introducida es anterior a la actual.
        LocalDate fechaActual = LocalDate.now();   //Creacion de LocalDate con fecha actual

        if (fechaActual.isAfter(fecha)) {
            return true;

        } else {
            return false;
        }
    }

    public static boolean validarDni(String dni) {     // M�todo que comprueba que el DNI introducido es valido.

        boolean valido = true;
        String numDni;

        int dniNum;

        char letraDni;

        char letraOficial;

        if (dni.length() != 9) {                    //Comprueba que el dni introducido tiene 9 caracteres.
            //sino retornar� falso.
            valido = false;
        } else if (dni == null) {                     //Comprueba que el dni no est� vacio.

            valido = false;
        } else {

            numDni = dni.substring(0, dni.length() - 1);     //Extraemos el n�mero del DNI y lo asiganmos a una variable.
            dniNum = Integer.parseInt(numDni);             //La cadena del numero extraido la pasamos a entero.
            letraDni = dni.charAt(dni.length() - 1);         //Extraemos la letra del DNI 
            letraOficial = LETRAS_DNI.charAt(dniNum % 23); //Aplicamos la operaci�n del m�dulo 23. El resto del n�mero del DNI
            //entre 23 nos coge la letra correcta de la cadena de LETRAS_DNI
            if (letraDni == letraOficial) {                //Si coincide la letra sacada del m�dulo 23 con la proporcionada en el 
                //DNI, ser� correcto.
                valido = true;
            } else {
                valido = false;
            }

        }

        return valido;

    }
}
