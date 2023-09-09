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
            System.out.print("CAB->");
            for (aux = cab; aux != null; aux = aux.sig)
                System.out.print(aux.dato + "->");
            System.out.print("NULL\n");
        }

        public void agregar_izq(int dato){
            Nodo<E> nuevo = new Nodo<>(dato);
            nuevo.sig = cab;
            cab = nuevo;
        }
        public void agregar_der(int dato){
            Nodo<E> nuevo = new Nodo<>(dato);
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

         // Método para sumar dos listas enlazadas
         public static LinkedList sumarListas(LinkedList lista1, LinkedList lista2) {
             LinkedList<Integer> resultado = new LinkedList<>();
             Nodo nodo1 = lista1.cab;
             Nodo nodo2 = lista2.cab;

             for(nodo1 = lista1.cab, nodo2 = lista2.cab; nodo1 != null && nodo2 != null;
                 nodo1 = nodo1.sig, nodo2 = nodo2.sig){
                 resultado.agregar_der(nodo1.dato + nodo2.dato);
             }
             // Si las listas son de diferente longitud, agrega los elementos restantes
             while (nodo1 != null) {
                 resultado.agregar_der(nodo1.dato);
                 nodo1 = nodo1.sig;
             }

             while (nodo2 != null) {
                 resultado.agregar_der(nodo2.dato);
                 nodo2 = nodo2.sig;
             }

             return resultado;
         }

         // Método para realizar la multiplicación de vectores
         public static int multiplicarVectores(LinkedList lista1, LinkedList lista2) {
             int resultado = 0;
             Nodo nodo1 = lista1.cab;
             Nodo nodo2 = lista2.cab;

             for(nodo1 = lista1.cab, nodo2 = lista2.cab; 
                 nodo1 != null && nodo2 != null;
                 nodo1 = nodo1.sig, nodo2 = nodo2.sig)
                 resultado += nodo1.dato * nodo2.dato;

             return resultado;
         }
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.agregar_der(5);
        lista.agregar_der(9);
        lista.agregar_der(14);
        lista.agregar_der(22);
        int k = 8;
        lista.multiplicaEscalar(k);
        lista.mostrar();

        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.agregar_der(1);
        lista1.agregar_der(2);
        lista1.agregar_der(3);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.agregar_der(4);
        lista2.agregar_der(5);
        lista2.agregar_der(6);

        System.out.println("Lista 1:");
        lista1.mostrar();
        System.out.println("Lista 2:");
        lista2.mostrar();

        LinkedList<Integer> resultado = LinkedList.sumarListas(lista1, lista2);
        System.out.println("Resultado de la suma:");
        resultado.mostrar();
        int respuesta = resultado.multiplicarVectores(lista1, lista2);
        System.out.println("Resultado de la multiplicacion: " + respuesta);

    }
}
