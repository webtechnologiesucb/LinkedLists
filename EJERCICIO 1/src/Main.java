/*
1.	Escribe un programa que elimine un elemento específico de una lista enlazada.
El programa debe tomar como entrada el valor que se debe eliminar y eliminar
todas las instancias de ese valor en la lista.
 */

/**
 * Clase Nodo
 * @param <E> Parametros genericos
 */
class Nodo<E> {
    E dato;
    Nodo<E> sig;

    /**
     * Cargamos el nodo con los datos iniciales
     * @param dato El dato ingresado en el nodo
     */
    public Nodo(E dato) {
        this.dato = dato;
        this.sig = null;
    }
}

/**
 * Clase de Lista Enlazada con las funciones solicitadas
 * @param <E>
 */
class ListaEnlazada<E> {
    Nodo<E> cab;

    public ListaEnlazada() {
        this.cab = null;
    }

    /**
     * Agregar nodos a la lista
     * @param dato Dato a Ingresar
     */
    public void agregar(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cab == null) {
            cab = nuevo;
        } else {
            Nodo<E> aux;
            for (aux = cab;aux.sig != null; aux = aux.sig);
            aux.sig = nuevo;
        }
    }

    public void eliminar(E valor) {
        while (cab != null && cab.dato == valor) {
            cab = cab.sig; // Eliminar coincidencias en la cab
        }

        Nodo<E> aux = cab;
        while (aux != null && aux.sig != null) {
            if (aux.sig.dato == valor) {
                aux.sig = aux.sig.sig; // Saltar el nodo con el valor
            } else {
                aux = aux.sig;
            }
        }
    }

    public void mostrar() {
        Nodo<E> temp = null;
        for (temp = cab; temp != null; temp = temp.sig)
            System.out.print(temp.dato + "=>");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada();
        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(5);
        lista.agregar(15);
        lista.agregar(5);

        System.out.println("Lista antes de eliminar:");
        lista.mostrar();

        int valorAEliminar = 5;
        lista.eliminar(valorAEliminar);

        System.out.println("Lista después de eliminar " + valorAEliminar + ":");
        lista.mostrar();
    }
}