
package ejemplo1;
// Describiendo un sistema bancario
//Metodos son: consignar, retirar, tranferencia
// Clase cliente y clase cuenta

import java.text.DecimalFormat;

class Cuenta {
    Cliente cliente;
    double saldo;
    String numeroCuenta;

    // Formato para mostrar los números con separador de miles
    private static final DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
    // Constructor de la clase Cuenta,recibe un cliente y un saldo inicial
    public Cuenta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.numeroCuenta = cliente.dni;
    }

    // Método para consignar (depositar) dinero en la cuenta
    public void consignar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Consignación exitosa. Nuevo saldo: " + formatoDecimal.format(saldo) + " COP.");
        } else {
            System.out.println("La cantidad a consignar debe ser mayor a 0.");
        }
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double cantidad) {
        if (cantidad <= saldo && cantidad > 0) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + formatoDecimal.format(saldo) + " COP.");
        } else {
            System.out.println("Saldo insuficiente o cantidad no válida. Intente nuevamente.");
        }
    }

    // Método para transferir dinero de una cuenta a otra
    public void transferir(double cantidad, Cuenta cuentaDestino) {
        if (cantidad <= saldo && cantidad > 0) {
            saldo -= cantidad;
            cuentaDestino.saldo += cantidad;
            System.out.println("Transferencia exitosa. Nuevo saldo: " + formatoDecimal.format(saldo) + " COP.");
            System.out.println("Saldo de la cuenta destino: " + formatoDecimal.format(cuentaDestino.saldo) + " COP.");
        } else {
            System.out.println("Saldo insuficiente o cantidad no válida. Intente nuevamente.");
        }
    }
}