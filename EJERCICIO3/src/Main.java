/*
3.	Desarrolla un programa que encuentre el elemento medio de una lista enlazada.
Si la lista tiene un número par de elementos, debería devolver los dos elementos centrales.
 */

/**
 * Creamos la clase Nodo
 * @param <E> que contiene datos genericos
 */
class Nodo<E> {
    E dato;
    Nodo<E> sig;

    public Nodo(E dato) {
        this.dato = dato;
        this.sig = null;
    }
}

class ListaEnlazada<E> {
    Nodo<E> cab;

    public ListaEnlazada() {
        this.cab = null;
    }

    public void agregar(E dato) {
        Nodo<E> nuevo = new Nodo(dato);
        if (cab == null) {
            cab = nuevo;
        } else {
            Nodo<E> aux;
            for(aux=cab; aux.sig!=null; aux=aux.sig);
            aux.sig = nuevo;
        }
    }

    public void encontrarElementoMedio() {
        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<E> pre = cab;
        Nodo<E> post = cab;

        while (post != null && post.sig != null) {
            pre = pre.sig;
            post = post.sig.sig;
        }

        if (post == null) {  // La lista tiene un número par de elementos
            System.out.println("Elementos medios: " + pre.dato + " y " + pre.sig.dato);
        } else {  // La lista tiene un número impar de elementos
            System.out.println("Elemento medio: " + pre.dato);
        }
    }
    public void mostrar() {
        Nodo<E> aux = cab;
        for (aux = cab; aux != null; aux = aux.sig)
            System.out.print(aux.dato + "=>");
        System.out.println();
    }

}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>(); // usamos enteros
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);
        lista.agregar(6);

        System.out.println("Lista original:");
        lista.mostrar();
        lista.encontrarElementoMedio();
    }
}
