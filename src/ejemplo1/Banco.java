
package ejemplo1;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        // Crear los clientes
        Cliente cliente1 = new Cliente("Jaime Garzon", "1002582398");
        Cliente cliente2 = new Cliente("Luis Alberto Fonseca", "1004029374");
        Cliente cliente3 = new Cliente("Martha Gómez", "1001234567");
        Cliente cliente4 = new Cliente("Carlos Pérez", "1009876543");

        // Crear las cuentas
        Cuenta cuenta1 = new Cuenta(cliente1, 10000000);
        Cuenta cuenta2 = new Cuenta(cliente2, 8000000);
        Cuenta cuenta3 = new Cuenta(cliente3, 5000000);
        Cuenta cuenta4 = new Cuenta(cliente4, 12000000);

        Scanner sc = new Scanner(System.in);

        // Mensaje de bienvenida
        System.out.println("Bienvenido a Bancolombia");

        // Validación de número de cuenta (DNI)
        Cuenta cuentaActual = null;
        boolean cuentaValida = false;
        while (!cuentaValida) {
            System.out.print("Por favor, ingrese su número de cuenta (DNI): ");
            String numeroCuenta = sc.nextLine(); // Usar nextLine() para leer la entrada como String

            // Verificar si el número de cuenta es válido
            if (numeroCuenta.equals(cuenta1.numeroCuenta)) {
                cuentaActual = cuenta1;
                System.out.println("Bienvenido " + cliente1.nombre);
                cuentaValida = true;
            } else if (numeroCuenta.equals(cuenta2.numeroCuenta)) {
                cuentaActual = cuenta2;
                System.out.println("Bienvenido " + cliente2.nombre);
                cuentaValida = true;
            } else if (numeroCuenta.equals(cuenta3.numeroCuenta)) {
                cuentaActual = cuenta3;
                System.out.println("Bienvenido " + cliente3.nombre);
                cuentaValida = true;
            } else if (numeroCuenta.equals(cuenta4.numeroCuenta)) {
                cuentaActual = cuenta4;
                System.out.println("Bienvenido " + cliente4.nombre);
                cuentaValida = true;
            } else {
                System.out.println("Número de cuenta no válido. Intente nuevamente.");
            }
        }

        // Solicitar operación a realizar
        boolean operacionValida = false;
        while (!operacionValida) {
            System.out.println("\n¿Qué operación desea realizar?");
            System.out.println("1. Consignación");
            System.out.println("2. Retiro");
            System.out.println("3. Transferencia");
            System.out.print("Seleccione el número de la operación: ");
            int operacion = sc.nextInt(); // Lee la operación seleccionada

            // Limpiar el buffer 
            sc.nextLine(); 

            if (operacion == 1 || operacion == 2 || operacion == 3) {
                operacionValida = true;

                // Solicitar cantidad para la operación seleccionada
                double cantidad = 0;
                boolean cantidadValida = false;
                while (!cantidadValida) {
                    if (operacion == 1) { // Consignación
                        System.out.print("Ingrese la cantidad a consignar: ");
                    } else if (operacion == 2) { // Retiro
                        System.out.print("Ingrese la cantidad a retirar: ");
                    } else if (operacion == 3) { // Transferencia
                        System.out.print("Ingrese la cantidad a transferir: ");
                    }
                    cantidad = sc.nextDouble();

                    if (cantidad > 0) {
                        cantidadValida = true;

                        if (operacion == 1) {
                            cuentaActual.consignar(cantidad);
                        } else if (operacion == 2) {
                            cuentaActual.retirar(cantidad);
                        } else if (operacion == 3) {
                    
                            Cuenta cuentaDestino = null;
                            boolean cuentaDestinoValida = false;
                            while (!cuentaDestinoValida) {
                                System.out.print("Ingrese el DNI de la cuenta destino: ");
                                String dniDestino = sc.next();
                                
                                if (dniDestino.equals(cuenta1.numeroCuenta)) {
                                    cuentaDestino = cuenta1;
                                    cuentaDestinoValida = true;
                                } else if (dniDestino.equals(cuenta2.numeroCuenta)) {
                                    cuentaDestino = cuenta2;
                                    cuentaDestinoValida = true;
                                } else if (dniDestino.equals(cuenta3.numeroCuenta)) {
                                    cuentaDestino = cuenta3;
                                    cuentaDestinoValida = true;
                                } else if (dniDestino.equals(cuenta4.numeroCuenta)) {
                                    cuentaDestino = cuenta4;
                                    cuentaDestinoValida = true;
                                } else {
                                    System.out.println("Cuenta destino no válida. Intente nuevamente.");
                                }
                            }
                            cuentaActual.transferir(cantidad, cuentaDestino);
                        }
                    } else {
                        System.out.println("La cantidad debe ser mayor a 0. Intente nuevamente.");
                    }
                }
            } else {
                System.out.println("Operación no válida. Intente nuevamente.");
            }
        }

        sc.close();
    }
}
