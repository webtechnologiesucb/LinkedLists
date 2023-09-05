/*
2.	Crea un programa que tome una lista enlazada y la divida en dos mitades aproximadamente iguales.
Si la lista tiene un número impar de elementos, la primera mitad debe tener un elemento más que la
segunda.
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

    public void agregar(int dato) {
        Nodo<E> nuevo = new Nodo(dato);
        if (cab == null) {
            cab = nuevo;
        } else {
            Nodo<E> aux;
            for(aux = cab; aux.sig != null; aux = aux.sig);
            aux.sig = nuevo;
        }
    }

    public void dividirEnDos() {
        if (cab == null) {
            return; // La lista está vacía, no hay nada que dividir
        }
        Nodo<E> aux;
        int totalNodos = 0;

        for(aux = cab; aux.sig != null;
            aux = aux.sig)
            totalNodos++;

        int mitad = 0;
        if (totalNodos % 2 == 0)
             mitad = totalNodos / 2;
        else
            mitad = (totalNodos / 2) - 1;
        aux = cab;

        // Avanzar hasta el punto medio
        for (int i = 0; i < mitad; i++) {
            aux = aux.sig;
        }

        // Dividir la lista en dos
        Nodo<E> segunda = aux.sig;
        aux.sig = null;

        // Mostrar las dos listas resultantes
        mostrar();
        ListaEnlazada<E> listasegunda = new ListaEnlazada();
        listasegunda.cab = segunda;
        listasegunda.mostrar();
    }

    public void mostrar() {
        Nodo<E> aux;
        for(aux = cab; aux != null; aux = aux.sig)
            System.out.print(aux.dato + "=>");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        System.out.println("Lista original:");
        lista.mostrar();

        System.out.println("Dividiendo en dos mitades:");
        lista.dividirEnDos();
    }
}