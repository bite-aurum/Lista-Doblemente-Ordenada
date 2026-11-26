import java.util.Scanner;

// Menu para probar los metodos de la lista doble
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        listadoble lista = new listadoble();
        int opcion;

        do {
            System.out.println("\nMENU LISTA DOBLE ");
            System.out.println("1. Insertar ordenado");
            System.out.println("2. Insertar en posicion");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Eliminar en posicion");
            System.out.println("5. Eliminar ultimo");
            System.out.println("6. Mostrar lista (adelante y atras)");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: // insertarOrdenado
                    System.out.print("Dato: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    break;

                case 2: // insertarEnPosicion
                    System.out.print("Posicion: ");
                    int pos = teclado.nextInt();
                    System.out.print("Dato: ");
                    int dato = teclado.nextInt();
                    lista.insertarEnPosicion(pos, dato);
                    break;

                case 3: // eliminarPorValor
                    System.out.print("Valor a eliminar: ");
                    if (lista.eliminarPorValor(teclado.nextInt())) {
                        System.out.println("Eliminado.");
                    } else {
                        System.out.println("No se encontro.");
                    }
                    break;

                case 4: // eliminarEnPosicion
                    System.out.print("Posicion a eliminar: ");
                    try {
                        System.out.println("Se elimino el " + lista.eliminarEnPosicion(teclado.nextInt()));
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5: // eliminarUltimo
                    if (lista.eliminarUltimo()) {
                        System.out.println("Ultimo eliminado.");
                    } else {
                        System.out.println("La lista esta vacia.");
                    }
                    break;

                case 6:
                    break; // solo muestra la lista (abajo)

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

            // Despues de cada operacion se imprime en ambos sentidos
            if (opcion != 0) {
                System.out.println("Adelante: " + lista);
                System.out.println("Atras:    " + lista.mostrarReversa());
                System.out.println("Tamanio:  " + lista.getTamanio());
            }

        } while (opcion != 0);

        teclado.close();
    }
}
