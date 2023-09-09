/*
Patrón Factory Method: Utiliza este patrón para crear instancias de nodos de la lista.
Esto puede ser útil si tienes varios tipos de nodos en tu lista enlazada (por ejemplo,
nodos simples y nodos dobles) y deseas desacoplar la creación de nodos de la lógica
de la lista en sí.
 */
public class LinkedListFactory {
    public interface Nodo<E> {
        void setDato(E dato);
        E getDato();
        void setSig(Nodo<E> sig);
        Nodo<E> getSig();
    }


    static class LinkedListNodo<E> implements Nodo {
        private E dato;
        private Nodo<E> sig;

        @Override
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
    }

    public interface NodoFactory<E> {
        Nodo<E> crearNodo();
    }

    public static class LinkedListNodeFactory<E> implements NodoFactory {
        public Nodo<E> crearNodo() {
            return new LinkedListNodo();
        }
    }

    public static class LinkedList<E> {
        private NodoFactory<E> fabricaNodo;
        private Nodo<E> cab;

        public LinkedList(NodoFactory<E> fabricaNodo) {
            this.fabricaNodo = fabricaNodo;
            this.cab = null;
        }

        public Nodo<E> createNodo() {
            return fabricaNodo.crearNodo();
        }
        public void adicionar(E dato) {
            Nodo nuevo = createNodo();
            nuevo.setDato(dato);
            nuevo.setSig(cab);
            cab = nuevo;
        }

        public void mostrarLista() {
            Nodo<E> aux;
            for(aux = cab;aux != null; aux = aux.getSig())
                System.out.print(aux.getDato() + " -> ");
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de LinkedList con un Factory Method de nodos enlazados
        LinkedList listado = new LinkedList(new LinkedListNodeFactory());
        // Agregar elementos a la lista
        listado.adicionar("Item 1");
        listado.adicionar("Item 2");
        listado.adicionar("Item 3");

        // Mostrar la lista enlazada
        listado.mostrarLista();
    }
}
