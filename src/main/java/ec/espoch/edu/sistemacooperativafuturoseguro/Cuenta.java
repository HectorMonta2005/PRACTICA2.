/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espoch.edu.sistemacooperativafuturoseguro;

/**
 *
 * @author KARLA
 */
public class Cuenta {

    
    public static int contador = 1000;
    public int numero;
     public double saldo;
     public String tipo;
    private Persona titular;

    public Cuenta(String tipo, double saldo, Persona titular) {
        this.numero = contador++;
        this.tipo = tipo;
        this.saldo = saldo;
        this.titular = titular;
    }

    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public boolean transferir(Cuenta destino, double monto) {
        if (this.retirar(monto)) {
            destino.depositar(monto);
            return true;
        }
        return false;
    }

    // Getters agregados
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void imprimir() {
        System.out.println("Cuenta :" + numero + "  Tipo: " + tipo + "  Saldo: $" + saldo);
    }
}

    
    
    

