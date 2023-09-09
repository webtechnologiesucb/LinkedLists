import java.util.LinkedList;

/*
Patrón Singleton: Puedes aplicar el patrón Singleton para garantizar que solo haya una
instancia de tu lista enlazada en todo el programa. Esto puede ser útil si deseas que
la lista sea compartida por varias partes del código sin crear múltiples instancias.
 */
public class LinkedListSingleton {
    private static LinkedListSingleton instance;
    private LinkedList<String> lista; // Crear el Objeto lista enlazada

    // Constructor privado para evitar la creación de instancias desde fuera de la clase.
    private LinkedListSingleton() {
        lista = new LinkedList<>();
    }

    // Método estático para obtener la única instancia de la lista enlazada.
    public static LinkedListSingleton getInstancia() {
        if (instance == null) {
            instance = new LinkedListSingleton();
        }
        return instance;
    }

    // Métodos públicos para operar con la lista enlazada.
    public void adicionarElemento(String item) {
        lista.add(item);
    }

    public void removerElemento(String item) {
        lista.remove(item);
    }

    public void imprimir() {
        for (String item : lista)
            System.out.print(item + "\t");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        LinkedListSingleton listado = LinkedListSingleton.getInstancia();
        listado.adicionarElemento("Item 1");
        listado.adicionarElemento("Item 2");
        listado.adicionarElemento("Item 3");
        listado.adicionarElemento("Item 4");
        listado.adicionarElemento("Item 5");
        listado.adicionarElemento("Item 6");
        listado.imprimir();
    }
}