/*
Patrón Decorator: Si necesitas agregar funcionalidad adicional a los nodos de la lista sin
alterar su estructura básica, el patrón Decorator puede ser útil. Esto te permitirá extender
la funcionalidad de los nodos de la lista de manera flexible.
 */
public class LinkedListDecorator {
    // Interfaz Node
    public interface Nodo<E> {
        void setDato(E dato);
        E getDato();
        void setSig(Nodo<E> sig);
        Nodo<E> getSig();
        void mostrar();
    }

    // Implementación de Node
    public static class LinkedListNodo<E> implements Nodo {
        private E dato;
        private Nodo<E> sig;

        public LinkedListNodo(E dato) {
            this.dato = dato;
        }

        public void setDato(Object dato) {
            this.dato = (E) dato;
        }

        public E getDato() {
            return dato;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }

        public Nodo<E> getSig() {
            return sig;
        }

        public void mostrar() {
            System.out.println("Nodo de lista enlazada con data: " + dato);
        }
    }

    // Clase decoradora abstracta
    static abstract class NodoDecorator<E> implements Nodo {
        protected Nodo<E> nodoDecorado;

        public NodoDecorator(Nodo<E> nodoDecorado) {
            this.nodoDecorado = nodoDecorado;
        }

        public void setDato(Object dato) {
            nodoDecorado.setDato((E) dato);
        }

        public E getDato() {
            return nodoDecorado.getDato();
        }

        public void setSig(Nodo sig) {
            nodoDecorado.setSig(sig);
        }

        public Nodo<E> getSig() {
            return nodoDecorado.getSig();
        }

        public abstract void mostrar();
    }

    // Clase concreta de decorador
    public static class BoldNodeDecorator<E> extends NodoDecorator {
        public BoldNodeDecorator(Nodo<E> nodoDecorado) {
            super(nodoDecorado);
        }

        public void mostrar() {
            System.out.println("<b>" + nodoDecorado.getDato() + "</b>");
        }
    }

    public static void main(String[] args) {
        // Crear un nodo de lista enlazada
        Nodo nodo = new LinkedListNodo("Texto normal");

        // Aplicar decoradores para agregar funcionalidades adicionales
        Nodo boldNode = new BoldNodeDecorator(nodo);
        // Mostrar el nodo decorado
        nodo.mostrar(); // Muestra "Texto normal"
        boldNode.mostrar(); // Muestra "<b>Texto normal</b>"
    }
}
