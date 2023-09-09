/*
Patrón Composite: Si estás trabajando con listas enlazadas complejas que contienen
sub-listas o estructuras jerárquicas, el patrón Composite puede ser útil para tratar
todos los elementos de la lista de manera uniforme.
 */
import java.util.ArrayList;
import java.util.List;

public class LinkedListComposite {
    // Interfaz Component
    public interface Component {
        void operacion();
    }

    // Implementación de Leaf (elemento individual)
    public static class LinkedListNodo<E> implements Component {
        private E dato;

        public LinkedListNodo(E dato) {
            this.dato = dato;
        }

        public void operacion() {
            System.out.println("Nodo enlazado con dato: " + dato);
        }
    }

    // Implementación de Composite (composición de elementos)
    public static class LinkedList<E> implements Component {
        private List<Component> items = new ArrayList<>();

        public void adicionarComponente(Component componente) {
            items.add(componente);
        }

        public void operacion() {
            for (Component componente : items)
                componente.operacion();
        }
    }

    public static void main(String[] args) {
        // Crear elementos individuales
        Component nodo1 = new LinkedListNodo("Item 1");
        Component nodo2 = new LinkedListNodo("Item 2");

        // Crear una composición (lista enlazada) y agregar elementos
        LinkedList lista = new LinkedList();
        lista.adicionarComponente(nodo1);
        lista.adicionarComponente(nodo2);

        // Operar sobre la composición de elementos (lista enlazada)
        lista.operacion();
    }
}
