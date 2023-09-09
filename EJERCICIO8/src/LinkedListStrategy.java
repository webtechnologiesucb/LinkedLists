/*
Patrón Strategy: Si tu lista enlazada necesita admitir diferentes algoritmos de ordenación
o manipulación, el patrón Strategy puede ayudarte a desacoplar estos algoritmos de la
lista principal y permitir que se cambien en tiempo de ejecución.
 */
import java.util.LinkedList;
public class LinkedListStrategy {

    // Interfaz ListStrategy
    public interface ListStrategy<E> {
        void adicionarItem(LinkedList lista, E dato);
    }
    // Implementación concreta de ListStrategy (Agregar al principio)
    static class AddAtBeginningStrategy<E> implements ListStrategy {
        public AddAtBeginningStrategy() {
        }

        public void adicionarItem(LinkedList lista, Object dato) {
            lista.addFirst((E) dato);
        }
    }

    // Implementación concreta de ListStrategy (Agregar al final)
    static class AddAtEndStrategy<E> implements ListStrategy {
        public AddAtEndStrategy() {
        }

        public void adicionarItem(LinkedList lista, Object dato) {
            lista.addLast((E) dato);
        }
    }

    // Clase LinkedList
    static class CustomLinkedList<E> {
        private LinkedList<E> listado;
        private ListStrategy estrategia;

        public CustomLinkedList(ListStrategy estrategia) {
            this.listado = new LinkedList<>();
            this.estrategia = estrategia;
        }

        public void setStrategy(ListStrategy estrategia) {
            this.estrategia = estrategia;
        }

        public void adicionarItem(Object dato) {
            estrategia.adicionarItem(listado, dato);
        }

        public void imprimirLista() {
            for (Object item : listado) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de LinkedList con una estrategia inicial (Agregar al principio)
        CustomLinkedList listado = new CustomLinkedList(new AddAtBeginningStrategy());
        listado.adicionarItem("Item 1");
        listado.adicionarItem("Item 2");

        // Cambiar la estrategia a agregar al final
        listado.setStrategy(new AddAtEndStrategy());
        listado.adicionarItem("Item 3");
        listado.imprimirLista();
    }
}
