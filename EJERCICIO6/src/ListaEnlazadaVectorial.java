public class ListaEnlazadaVectorial {
    static class Nodo<E>{
        private int dato;
        private Nodo<E> sig;

        public Nodo(int dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

     static class LinkedList<E>{
        private Nodo<E> cab;

        public LinkedList(){
            cab = null;
        }

        public void mostrar(){
            Nodo<E> aux;
            System.out.print("\n CAB->");
            for (aux = cab; aux != null; aux = aux.sig)
                System.out.print(aux.dato + "->");
            System.out.print("NULL\n");
        }

        public void agregar_izq(int dato){
            Nodo<E> nuevo = new Nodo(dato);
            nuevo.sig = cab;
            cab = nuevo;
        }
        public void agregar_der(int dato){
            Nodo<E> nuevo = new Nodo(dato);
            Nodo<E> aux;
            if(cab == null)
                cab = nuevo;
            else{
                for (aux = cab; aux.sig != null; aux = aux.sig) ;
                aux.sig = nuevo;
                nuevo.sig = null;
            }
        }

        // multiplicar la lista por un escalar
        public void multiplicaEscalar(int valor){
            Nodo<E> aux;
            for (aux = cab; aux != null; aux = aux.sig){
                aux.dato = aux.dato * valor;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList();
        lista.agregar_der(5);
        lista.agregar_der(9);
        lista.agregar_der(14);
        lista.agregar_der(22);
        int k = 8;
        lista.multiplicaEscalar(k);
        lista.mostrar();
    }
}
