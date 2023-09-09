import java.util.Iterator;

/*
4. Escribe un programa que tome dos listas enlazadas y las combine de manera alternada.
Por ejemplo, si tienes las listas [1, 2, 3] y [4, 5, 6],
el resultado debe ser [1, 4, 2, 5, 3, 6].
 */
class Nodo<E> {
    E dato;
    Nodo<E> sig;

    public Nodo(E dato) {
        this.dato = dato;
        this.sig = null;
    }
}

 class ListaEnlazada<E>{
    Nodo<E> cab;
    public ListaEnlazada() {
        this.cab = null;
    }

    public void agregar(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cab == null) {
            cab = nuevo;
        } else {
            Nodo<E> aux;
            for (aux = cab; aux.sig != null; aux = aux.sig);
            aux.sig = nuevo;
        }
    }

    public void mostrar() {
        Nodo<E> aux;
        for (aux = cab; aux.sig != null; aux = aux.sig) {
            System.out.print(aux.dato + "=>");
        }
        System.out.println();
    }

    public static ListaEnlazada combinarAlternadamente(ListaEnlazada lista1, ListaEnlazada lista2) {
        ListaEnlazada unificada = new ListaEnlazada();
        Nodo aux1 = lista1.cab; // 1->2->3
        Nodo aux2 = lista2.cab; // 4->5->6->7

        while (aux1 != null || aux2 != null) {
            if (aux1 != null) {
                unificada.agregar(aux1.dato); // 1->4->2->5->3
                aux1 = aux1.sig;
            }
            if (aux2 != null) {
                unificada.agregar(aux2.dato); //1->4->2->5->3->6->7
                aux2 = aux2.sig;
            }
        }
        return unificada;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista1 = new ListaEnlazada();
        lista1.agregar(1);
        lista1.agregar(2);
        lista1.agregar(3);

        ListaEnlazada<Integer>  lista2 = new ListaEnlazada();
        lista2.agregar(4);
        lista2.agregar(5);
        lista2.agregar(6);

        System.out.println("Lista 1:");
        lista1.mostrar();

        System.out.println("Lista 2:");
        lista2.mostrar();

        ListaEnlazada<Integer> unificada = ListaEnlazada.combinarAlternadamente(lista1, lista2);
        System.out.println("Lista combinada:");
        unificada.mostrar();
    }
}

