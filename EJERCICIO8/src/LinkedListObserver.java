/*
Patrón Observer: Si deseas que otras partes del código sean notificadas cuando se realice algún cambio
en la lista enlazada, el patrón Observer puede ser útil. Puedes implementar un sistema de notificación
para que los observadores sepan cuándo se realizan cambios en la lista.
 */
import java.util.ArrayList;
import java.util.List;
public class LinkedListObserver {
    // Interfaz Observer
    public interface Observer {
        void actualizar(String mensaje);
    }

    // Clase LinkedList (objeto observado)
    public static class LinkedList {
        private List<String> elementos = new ArrayList<>();
        private List<Observer> observados = new ArrayList<>();

        public void adicionarObservador(Observer observado) {
            observados.add(observado);
        }

        public void removerObservador(Observer observado) {
            observados.remove(observado);
        }

        public void adicionarElemento(String item) {
            elementos.add(item);
            notificarObservador("Se agregó el elemento: " + item);
        }

        public void removerElemento(String item) {
            elementos.remove(item);
            notificarObservador("Se eliminó el elemento: " + item);
        }

        private void notificarObservador(String mensaje) {
            for (Observer observado : observados)
                observado.actualizar(mensaje);
        }
    }

    // Implementación de Observer
    public static class ListObserver implements Observer {
        private String nombre;

        public ListObserver(String nombre) {
            this.nombre = nombre;
        }

        public void actualizar(String mensaje) {
            System.out.println(nombre + " recibió la notificación: " + mensaje);
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de la lista enlazada
        LinkedList linkedList = new LinkedList();

        // Crear observadores y registrarlos en la lista enlazada
        Observer observer1 = new ListObserver("Observer 1");
        Observer observer2 = new ListObserver("Observer 2");
        linkedList.adicionarObservador(observer1);
        linkedList.adicionarObservador(observer2);

        // Agregar y eliminar elementos para generar notificaciones
        linkedList.adicionarElemento("Item 1");
        linkedList.removerElemento("Item 1");
        linkedList.adicionarElemento("Item 2");
    }
}
