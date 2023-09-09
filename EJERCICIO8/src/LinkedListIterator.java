/*
Patrón Iterator: El patrón Iterator te permite recorrer la lista de manera eficiente
sin exponer la estructura interna de la lista. Implementa un iterador que permita a
los usuarios recorrer los elementos de la lista enlazada de manera segura.
 */
import java.util.NoSuchElementException;

public class LinkedListIterator {
    // Interfaz Node
    public interface Nodo<E> {
        void setDato(E data);
        E getDato();
        void setSig(Nodo<E> sig);
        Nodo<E> getSig();
    }

    // Implementación concreta de Nodo
    public static class LinkedListNodo<E> implements Nodo {
        private E dato;
        private Nodo<E> sig;

        public void setDato(Object dato) {
            this.dato = (E) dato;
        }

        public E getDato() {
            return dato;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }

        public Nodo getSig() {
            return sig;
        }
    }

    // Interfaz Iterator
    public interface Iterator {
        boolean hasNext();
        Object next();
    }

    // Implementación de Iterator para lista enlazada
    public static class LinkedListIteratorBase<E> implements Iterator {
        private Nodo<E> actual;

        public LinkedListIteratorBase(Nodo<E> cab) {
            this.actual = cab;
        }

        public boolean hasNext() {
            return actual != null;
        }

        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Object data = actual.getDato();
            actual = actual.getSig();
            return data;
        }
    }
    public static class LinkedList<E> {
        private Nodo<E> cab;

        public void adicionar(Object dato) {
            LinkedListNodo<E> nuevo = new LinkedListNodo<>();
            nuevo.setDato(dato);
            nuevo.setSig(cab);
            cab = nuevo;
        }

        public Iterator iterator() {
            return new LinkedListIteratorBase<>(cab);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> listado = new LinkedList<>();
        listado.adicionar("Item 1");
        listado.adicionar("Item 2");
        listado.adicionar("Item 3");

        // Usar el Iterator para recorrer la lista enlazada
        Iterator iterador = listado.iterator();
        while (iterador.hasNext())
            System.out.println(iterador.next());
    }
}
