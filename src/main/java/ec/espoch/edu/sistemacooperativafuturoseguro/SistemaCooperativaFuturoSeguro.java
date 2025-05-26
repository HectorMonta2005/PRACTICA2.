/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.espoch.edu.sistemacooperativafuturoseguro;
import java.util.Scanner;

/**
 *
 * @author KARLA
 */
public class SistemaCooperativaFuturoSeguro {

    public static void main(String[] args) {
 
            Scanner scanner = new Scanner(System.in);
            Persona[] personas = new Persona[3];
            int totalPersonas = 0;
            int opcion = -1;

            while (opcion != 0) {
                System.out.println(" MENU");
                System.out.println("1. Registrar persona");
                System.out.println("2. Crear cuenta");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Retirar dinero");
                System.out.println("5. Transferir dinero");
                System.out.println("6. Ver información");
                System.out.println("0. Salir");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        if (totalPersonas < personas.length) {
                            scanner.nextLine();
                            System.out.print("Ingrese el nombre: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese la identificación: ");
                            String identificacion = scanner.nextLine();
                            System.out.print("Ingrese el correo electrónico: ");
                            String correo = scanner.nextLine();
                            personas[totalPersonas] = new Persona(nombre, identificacion, correo);
                            totalPersonas++;
                            System.out.println("Persona registrada correctamente.");
                        } else {
                            System.out.println("Se ha alcanzado el límite máximo de personas.");
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el número de la persona: ");
                        int indicePersona = scanner.nextInt();
                        if (indicePersona >= 0 && indicePersona < totalPersonas) {
                            scanner.nextLine();
                            System.out.print("Ingrese el tipo de cuenta: ");
                            String tipoCuenta = scanner.nextLine();
                            System.out.print("Ingrese el saldo inicial: ");
                            double saldoInicial = scanner.nextDouble();
                            Cuenta cuenta = new Cuenta(tipoCuenta, saldoInicial, personas[indicePersona]);
                            boolean cuentaAgregada = personas[indicePersona].agregarCuentas(cuenta);
                            if (cuentaAgregada) {
                                System.out.println("Cuenta creada exitosamente.");
                            } else {
                                System.out.println("No se pudo agregar la cuenta.");
                            }
                        } else {
                            System.out.println("Persona no encontrada.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el número de persona: ");
                        int personaDeposito = scanner.nextInt();
                        System.out.print("Ingrese el número de cuenta: ");
                        int cuentaDeposito = scanner.nextInt();
                        if (personaDeposito >= 0 && personaDeposito < totalPersonas) {
                            if (cuentaDeposito >= 0 && cuentaDeposito < personas[personaDeposito].numCuentas) {
                                System.out.print("Ingrese el monto a depositar: ");
                                double monto = scanner.nextDouble();
                                personas[personaDeposito].cuentas[cuentaDeposito].depositar(monto);
                                System.out.println("Depósito realizado correctamente.");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el número de persona: ");
                        int personaRetiro = scanner.nextInt();
                        System.out.print("Ingrese el número de cuenta: ");
                        int cuentaRetiro = scanner.nextInt();
                        if (personaRetiro >= 0 && personaRetiro < totalPersonas) {
                            if (cuentaRetiro >= 0 && cuentaRetiro < personas[personaRetiro].numCuentas) {
                                System.out.print("Ingrese el monto a retirar: ");
                                double monto = scanner.nextDouble();
                                personas[personaRetiro].cuentas[cuentaRetiro].retirar(monto);
                                System.out.println("Retiro realizado correctamente.");
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese el número de la persona origen: ");
                        int personaOrigen = scanner.nextInt();
                        System.out.print("Ingrese el número de cuenta origen: ");
                        int cuentaOrigen = scanner.nextInt();
                        System.out.print("Ingrese el número de la persona destino: ");
                        int personaDestino = scanner.nextInt();
                        System.out.print("Ingrese el número de cuenta destino: ");
                        int cuentaDestino = scanner.nextInt();
                        System.out.print("Ingrese el monto a transferir: ");
                        double montoTransferencia = scanner.nextDouble();

                        if (personaOrigen >= 0 && personaOrigen < totalPersonas
                                && personaDestino >= 0 && personaDestino < totalPersonas) {
                            if (cuentaOrigen >= 0 && cuentaOrigen < personas[personaOrigen].numCuentas
                                    && cuentaDestino >= 0 && cuentaDestino < personas[personaDestino].numCuentas) {
                                personas[personaOrigen].cuentas[cuentaOrigen]
                                        .transferir(personas[personaDestino].cuentas[cuentaDestino], montoTransferencia);
                                System.out.println("Transferencia realizada correctamente.");
                            }
                        }
                        break;

                    case 6:
                        for (int i = 0; i < totalPersonas; i++) {
                            System.out.println("Persona número " + i);
                            personas[i].imprimir();
                        }
                        break;

                    case 0:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            }

            scanner.close();
        }
    }
