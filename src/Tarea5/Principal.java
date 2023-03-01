package Tarea5;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);  //Creamos un nuevo objeto Scanner par aedir datos por teclado
    

    //DECLARACIÓN DE VARIABLES
    static String dni, nombre, apellidos, direccion, poblacion;
    static String marca, matricula, descripcion, nombreProp, dniP;
    static int kms, precio;
    static LocalDate fMatriculacion;

    private static int cPostal, numVehiculos1 = 0, numVehiculos2 = 0;
    static int numCliente = 0;
    static Cliente cliente1;
    static Cliente cliente2;
    static Vehiculo vehiculo1;
    static Vehiculo vehiculo2;
    static Vehiculo vehiculo3;
    static Vehiculo vehiculo4;
    
    //METODO MAIN
    public static void main(String[] args) {

        int opcion = 0;
        boolean salir = false;

        while (!salir) {//Mientras no marquemos la opción salir, el bucle se repite

            System.out.printf("\t***MENÚ***\n");
            System.out.println("_______________________________________");
            System.out.println("1. Nuevo cliente.");
            System.out.println("2. Nuevo vehículo.");
            System.out.println("3. Ver vehículos de un cliente.");
            System.out.println("4. Listado de clientes y sus vehículos.");
            System.out.println("5. Salir.");
            System.out.println("_______________________________________");
            System.out.println("Elija una opción (1-5)");
            try {
                opcion = teclado.nextInt();

                switch (opcion) {//Condicional con varias alternativas
                    case 1:
                        nuevoCliente(); //MÉTODO QUE CREA UN NUEVO CLIENTE
                        break;
                    case 2:

                        nuevoVehiculo();//MÉTODO QUE CREA UN NUEVO VEHÍCULO
                        break;

                    case 3://INTRODUCIMOS UN DNI VALIDO Y EL MÉTODO MUESTRA TODOS LOS VEHÍCULOS DE ESE CLIENTE
                        System.out.println("Introduzca DNI del cliente.");
                        dni = teclado.next().toUpperCase();

                        vehiculosCliente(dni);
                        break;

                    case 4://EN ESTE MÉTODO SE MUESTRA UN LISTADO DE TODOS LOS CLIENTES Y SUS VEHÍCULOS
                        listadoClientesVehic();

                        break;
                    case 5:
                        //Opción para salir del menú
                        System.out.println("Ha elegido la opción salir, hasta pronto");
                        salir = true;//Cambiamos a true para salir del bucle while
                        break;

                    default://Si no introducimos ninguna de las condiciones, mensaje
                        System.out.println("Debe introducir opción entre 1 y 5");
                        ;

                }

            } catch (InputMismatchException e) {//Mensaje de excepción si no introducimos valor numerico
                System.out.println("Introduce un valor valido");
                teclado.nextLine();
            }
        }
    }
    //MÉTODO QUE CREA UN NUEVO CLIENTE, TENIENDO EN CUENTA QUE EL LIMITE SON DOS CLIENTES
    public static void nuevoCliente() {
        
        //CONDICIONAL EN EL CUAL CREAMOS UN CLIENTE NUEVO SIEMPRE QUE HAYA MENOS DE DOS CLIENTES
        if (numCliente < 2) {
            //BUCLE EN EL CUAL MIENTRAS NO DEMOS UN DNI VALIDO SEGUIRÁ PIDIENDOLO
            do {
                System.out.println("Introduzca DNI del cliente");
                dni = teclado.next().toUpperCase();

                if (!Validaciones.validarDni(dni)) {
                    System.err.println("El DNI introducido no es correcto");
                }
            } while (!Validaciones.validarDni(dni));

            System.out.println("Introduzca nombre de cliente");
            nombre = teclado.next();
            System.out.println("Introduzca apellidos de cliente");
            apellidos = teclado.next();
            teclado.nextLine();
            System.out.println("Introduzca direción del cliente");
            direccion = teclado.next();
            teclado.nextLine();
            System.out.println("Introduzca población del cliente");
            poblacion = teclado.next();
            System.out.println("Introduzca código postal del cliente");
            cPostal = teclado.nextInt();

            //SI EL CLIENTE 1 ESTÁ VACIO, CREAMOS NUEVO CLIENTE
            if (cliente1 == null) {

                cliente1 = new Cliente(cPostal, numVehiculos1, dni, nombre, apellidos, direccion, poblacion);
                numCliente++;

            } else {
            //SINO CREAMOS EL SEGUNDO CLIENTE SIEMPRE QUE ESTE VACIO
                cliente2 = new Cliente(cPostal, numVehiculos2, dni, nombre, apellidos, direccion, poblacion);
                numCliente++;
            }

        } else { //SI TENEMOS DOS CLIENTES, NO PODREMOS CREAR MAS
            System.err.println("No puede introducir más clientes");
        }
    }

    //MÉTODO QUE NOS CREA UN NUEVO VEHÍCULO
    public static void nuevoVehiculo() {

        if (numCliente > 0) {//SI TENEMOS CLIENTES CREADOS, PODREMOS CREAR VEHÍCULOS

            System.out.println("Introduzca marca del vehículo");
            marca = teclado.next();
            System.out.println("Introduzca matricula del vehículo");
            matricula = teclado.next();

            do {//BUCLE QUE NOS PEDIRÁ LOS KILOMETROS HASTA QUE LA VALIDACIÓN SEA CORRECTA
                System.out.println("Introduzca kilometros del Vehículo");
                kms = teclado.nextInt();
                teclado.nextLine();

                if (Validaciones.kmMayorCero(kms)) {
                    System.out.println("Kilometraje correcto");
                } else {
                    System.err.println("Los kilometros introducidos deben ser mayor que \" 0 \"");
                }

            } while (!Validaciones.kmMayorCero(kms));

            do {//BUCLE QUE NOS PEDIRA UNA FECHA HASTA QUE LA VALIDACIÓN SEA CORRECTA
                System.out.println("Día de matriculación del vehículo");
                int dia = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Mes de matriculación del vehículo");

                int mes = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Año de matriculación del vehículo");
                int anio = teclado.nextInt();
                teclado.nextLine();

                fMatriculacion = LocalDate.of(anio, mes, dia);

                if (Validaciones.validarFecha(fMatriculacion)) {
                    System.out.println("fecha correcta");
                } else {
                    System.err.println("La fecha debe ser anterior a la actual");
                }
            } while (!Validaciones.validarFecha(fMatriculacion));

            System.out.println("Descripción del Vehículo");
            descripcion = teclado.next();
            teclado.nextLine();
            System.out.println("Introduzca precio del vehículo");
            precio = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Nombre del propietario");
            nombreProp = teclado.next();
            teclado.nextLine();
            System.out.println("Introduzca DNI del propietario");
            dniP = teclado.next().toUpperCase();

            if (Validaciones.validarDni(dni)) {//SI DNI CORRECTO, IREMOS ASIGNANDO VEHÍCULOS EN LOS QUE ESTÉN VACIOS

                try {//DEBE COINCIDIR DNI Y NOMBRE
                    if ((cliente1.getDni().equals(dniP) && cliente1.getNombre().equals(nombreProp))) {

                        if (vehiculo1 == null) {
                            vehiculo1 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                            numVehiculos1++;

                        } else {
                            if (vehiculo2 == null) {
                                vehiculo2 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                                numVehiculos1++;
                            } else {
                                if (vehiculo3 == null) {
                                    vehiculo3 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                                    numVehiculos1++;
                                } else {
                                    vehiculo4 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                                    numVehiculos1++;
                                }
                            }
                        }
                        cliente1.setNumVehiculos(numVehiculos1);//CONTADOR QUE NOS PROPORCIONA EL NÚMERO DE VEHÍCULOS QUE TIENE EL CLIENTE

                    } else if ((cliente2.getDni().equals(dniP) && cliente2.getNombre().equals(nombreProp))) {

                        if (vehiculo1 == null) {
                            vehiculo1 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                            numVehiculos2++;

                        } else {
                            if (vehiculo2 == null) {
                                vehiculo2 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                                numVehiculos2++;
                            } else {
                                if (vehiculo3 == null) {
                                    vehiculo3 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                                    numVehiculos2++;
                                } else {
                                    vehiculo4 = new Vehiculo(kms, precio, marca, matricula, descripcion, nombreProp, dniP, fMatriculacion);
                                    numVehiculos2++;
                                }
                            }
                        }

                        cliente2.setNumVehiculos(numVehiculos2);

                    } else {
                        System.err.println("El DNI o nombre del cliente no coincide con el de ningún propietario ");
                    }
                } catch (NullPointerException e) {//SI EL CLIENTE ESTA VACIO(NULL) SALTARÁ LA EXCEPCIÓN
                    System.err.println("El DNI o cliente no existe, vuelva a crear nuevo vehículo");
                }
            }
        } else {
            System.err.println("Debe crear primero un cliente");
        }
    }
    
     /**
     * @param dni en este método se pide el parámetro dni.
     */
    //MÉTODO DONDE PROPORCIONANDO EL DNI DEL CLIENTE NOS MUESTRA TODOS SUS VEHÍCULOS
    public static void vehiculosCliente(String dni) {
        try {

            if (dni.equals(cliente1.getDni())) {

                System.out.println("El cliente " + cliente1.getNombre() + " tiene " + cliente1.getNumVehiculos() + " vehículos: ");

                if (cliente1.getDni().equals(vehiculo1.getDniProp())) {

                    System.out.println("*-- " + vehiculo1.getMarca() + "    Matricula: " + vehiculo1.getMatricula() + "    Kilometros: " + vehiculo1.getKms() + "    Matriculación: " + vehiculo1.getfMatriculacion() + "    Vehículo de " + vehiculo1.getAnios() + " años.");
                }
                if (cliente1.getDni().equals(vehiculo2.getDniProp())) {

                    System.out.println("*-- " + vehiculo2.getMarca() + "    Matricula: " + vehiculo2.getMatricula() + "    Kilometros: " + vehiculo2.getKms() + "    Matriculación: " + vehiculo2.getfMatriculacion() + "    Vehículo de " + vehiculo2.getAnios() + " años.");
                }
                if (cliente1.getDni().equals(vehiculo3.getDniProp())) {

                    System.out.println("*-- " + vehiculo3.getMarca() + "    Matricula: " + vehiculo3.getMatricula() + "    Kilometros: " + vehiculo3.getKms() + "    Matriculación: " + vehiculo3.getfMatriculacion() + "    Vehículo de " + vehiculo3.getAnios() + " años.");
                }
                if (cliente1.getDni().equals(vehiculo4.getDniProp())) {

                    System.out.println("*-- " + vehiculo4.getMarca() + "    Matricula: " + vehiculo4.getMatricula() + "    Kilometros: " + vehiculo4.getKms() + "    Matriculación: " + vehiculo4.getfMatriculacion() + "    Vehículo de " + vehiculo4.getAnios() + " años.");
                }

            } else if (dni.equals(cliente2.getDni())) {

                {
                    System.out.println("El cliente " + cliente2.getNombre() + " tiene " + cliente2.getNumVehiculos() + " vehículos: ");

                    if (cliente2.getDni().equals(vehiculo1.getDniProp())) {

                        System.out.println("*-- " + vehiculo1.getMarca() + "    Matricula: " + vehiculo1.getMatricula() + "    Kilometros: " + vehiculo1.getKms() + "    Matriculación: " + vehiculo1.getfMatriculacion() + "    Kilometros: " + vehiculo1.getKms());
                    }
                    if (cliente2.getDni().equals(vehiculo2.getDniProp())) {

                        System.out.println("*-- " + vehiculo2.getMarca() + "    Matricula: " + vehiculo2.getMatricula() + "    Kilometros: " + vehiculo2.getKms() + "    Matriculación: " + vehiculo2.getfMatriculacion() + "    Kilometros: " + vehiculo2.getKms());
                    }
                    if (cliente2.getDni().equals(vehiculo3.getDniProp())) {

                        System.out.println("*-- " + vehiculo3.getMarca() + "    Matricula: " + vehiculo3.getMatricula() + "    Kilometros: " + vehiculo3.getKms() + "    Matriculación: " + vehiculo3.getfMatriculacion() + "    Kilometros: " + vehiculo3.getKms());
                    }
                    if (cliente2.getDni().equals(vehiculo4.getDniProp())) {

                        System.out.println("*-- " + vehiculo4.getMarca() + "    Matricula: " + vehiculo4.getMatricula() + "    Kilometros: " + vehiculo4.getKms() + "    Matriculación: " + vehiculo4.getfMatriculacion() + "    Kilometros: " + vehiculo4.getKms());
                    }

                }
            } else {
                System.err.println("El DNI introducido no pertenece a ningún cliente");
            }
        } catch (NullPointerException e) {
            // System.err.println("El DNI introducido no pertenece a ningún cliente");
        }
    }

    //MÉTODO QUE NOS MUESTRA UN LISTADO DE TODOS LOS CLIENTES Y SUS RESPECTIVOS VEHÍCULOS
    public static void listadoClientesVehic() {

        try {
            if (cliente1 != null || cliente2 != null) {

                System.out.println("\nDNI: " + cliente1.getDni() + "    Nombre: " + cliente1.getNombre() + "    Apellidos: " + cliente1.getApellidos());
                System.out.println("**************************************************************************************************************");

                if (cliente1.getDni().equals(vehiculo1.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo1.getMatricula() + "    Marca: " + vehiculo1.getMarca() + "    Kilometros: " + vehiculo1.getKms());
                }
                if (cliente1.getDni().equals(vehiculo2.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo2.getMatricula() + "    Marca: " + vehiculo2.getMarca() + "    Kilometros: " + vehiculo2.getKms());
                }
                if (cliente1.getDni().equals(vehiculo3.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo3.getMatricula() + "    Marca: " + vehiculo3.getMarca() + "    Kilometros: " + vehiculo3.getKms());
                }
                if (cliente1.getDni().equals(vehiculo4.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo4.getMatricula() + "    Marca: " + vehiculo4.getMarca() + "    Kilometros: " + vehiculo4.getKms());
                }

                System.out.println("\nDNI: " + cliente2.getDni() + "    Nombre: " + cliente2.getNombre() + "    Apellidos: " + cliente2.getApellidos());
                System.out.println("**************************************************************************************************************");

                if (cliente2.getDni().equals(vehiculo1.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo1.getMatricula() + "    Marca: " + vehiculo1.getMarca() + "    Kilometros: " + vehiculo1.getKms());
                }
                if (cliente2.getDni().equals(vehiculo2.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo2.getMatricula() + "    Marca: " + vehiculo2.getMarca() + "    Kilometros: " + vehiculo2.getKms());
                }
                if (cliente2.getDni().equals(vehiculo3.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo3.getMatricula() + "    Marca: " + vehiculo3.getMarca() + "    Kilometros: " + vehiculo3.getKms());
                }
                if (cliente2.getDni().equals(vehiculo4.getDniProp())) {

                    System.out.println("Matricula: " + vehiculo4.getMatricula() + "    Marca: " + vehiculo4.getMarca() + "    Kilometros: " + vehiculo4.getKms());
                }

            } else {
                System.err.println("Primeramente debe crear un cliente");
            }

        } catch (NullPointerException e) {
        }
    }
}
