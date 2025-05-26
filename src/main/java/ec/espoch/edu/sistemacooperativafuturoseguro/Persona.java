/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espoch.edu.sistemacooperativafuturoseguro;

/**
 *
 * @author KARLA
 */
public class Persona {
    
    public String nombre;
    public String identificacion;
    public String corre;
    public Cuenta [] cuentas;
    public int numCuentas;

    public Persona(String nombre, String identificacion, String corre) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.corre = corre;
        this.cuentas =  new Cuenta[5];
        this.numCuentas=0;
    }
     public boolean agregarCuentas(Cuenta cuenta){
         if (numCuentas< cuentas.length){
             cuentas [numCuentas]= cuenta;
             numCuentas++;
             return true;             
         }
         return false;
     }
     
    public Cuenta getCuenta(int index) {
        if (index >= 0 && index < numCuentas) {
            return cuentas[index];
        }
        return null;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        String correo = null;
        return correo;
    }

    public int getNumCuentas() {
        return numCuentas;
    }

    public void imprimir() {
        System.out.println(" TITULAR");
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificacion: " + identificacion);
        String correo = null;
        System.out.println("Correo: " + correo);
        for (int i = 0; i < numCuentas; i++) {
            cuentas[i].imprimir();
        }
    }
}
