/*
5. Desarrollar un menu de opciones para listas enlazadas simples en Java que permita uso de parametros args[] del main,
que considere las siguientes operaciones:
java ListaEnlazadaSimpleMenu agregar_inicio 5
java ListaEnlazadaSimpleMenu agregar_final 10
java ListaEnlazadaSimpleMenu agregar_posicion 1 7
java ListaEnlazadaSimpleMenu eliminar 1
java ListaEnlazadaSimpleMenu mostrar
java ListaEnlazadaSimpleMenu tamano
 */
public class ListaEnlazadaSimpleMenu {

    /**
     * Aca se usa el nombre del programa ListaEnlazadaSimpleMenu con parametros al lado
     * @param args Los parametros que son enviados a la funcion
     */
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        // cargamos datos de ejemplo para el menu
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(5);

        if (args.length == 0) {
            System.out.println("Uso: java ListaEnlazadaSimpleMenu [comando] [argumento]");
            return;
        }
        // obtenemos el comando del primer argumento
        String comando = args[0];
        // elegimos que hara el comando elegido
        switch (comando) {
            case "agregar_inicio":
                if (args.length < 2) { // validamos si ingreso los dos argumentos
                    System.out.println("Falta el valor a agregar.");
                    return;
                }
                int valorInicio = Integer.parseInt(args[1]);
                System.out.println("Valores previos:");
                lista.mostrar();
                lista.agregarAlInicio(valorInicio); // agregamos al inicio el valor
                System.out.println("Lista Final:");
                lista.mostrar(); // mostramos los resultados
                break;

            case "agregar_final":
                if (args.length < 2) { // validamos si ingreso los dos argumentos
                    System.out.println("Falta el valor a agregar.");
                    return;
                }
                int valorFinal = Integer.parseInt(args[1]);
                System.out.println("Valores previos:");
                lista.mostrar();
                System.out.println("Lista Final:");
                lista.agregarAlFinal(valorFinal); // agregamos al final el valor
                lista.mostrar(); // mostramos los resultados
                break;

            case "agregar_posicion":
                if (args.length < 3) { // validamos si ingreso los tres argumentos
                    System.out.println("Faltan argumentos. Uso: java ListaEnlazadaSimple agregar_posicion [posición] [valor]");
                    return;
                }
                int posicion = Integer.parseInt(args[1]); // anotar la posicion
                int valor = Integer.parseInt(args[2]); // anotar el valor
                lista.agregarEnPosicion(posicion, valor); // agregamos en la posicion definida
                lista.mostrar(); // mostramos los resultados
                break;

            case "eliminar":
                if (args.length < 2) {  // validamos si ingreso los dos argumentos
                    System.out.println("Falta la posición a eliminar.");
                    return;
                }
                int posicionEliminar = Integer.parseInt(args[1]); // anotar la posicion
                lista.eliminarEnPosicion(posicionEliminar); // eliminamos en la posicion ingresada
                lista.mostrar(); // mostramos los resultados
                break;

            case "mostrar":
                lista.mostrar(); // mostrar la lista actual de datos
                break;

            case "tamano":
                int tamano = lista.tamano();
                System.out.println("Tamaño de la lista: " + tamano); // mencionar el tamaño de la lista
                break;

            default:
                System.out.println("Comando no válido. Las opciones válidas son: agregar_inicio, agregar_final, agregar_posicion, eliminar, mostrar, tamano.");
                break;
        }
    }
}

class Nodo<E> {
    E valor;
    Nodo<E> sig;

    public Nodo(E valor) {
        this.valor = valor;
        this.sig = null;
    }
}

class LinkedList<E> {
    private Nodo<E> cab;

    public LinkedList() {
        this.cab = null;
    }

    public void agregarAlInicio(int valor) {
        Nodo<E> nuevo = new Nodo(valor);
        nuevo.sig = cab;
        cab = nuevo;
    }

    public void agregarAlFinal(int valor) {
        Nodo<E> nuevo = new Nodo(valor);
        if (cab == null) {
            cab = nuevo;
            return;
        }
        Nodo<E> aux = cab;
        for (aux = cab; aux.sig != null; aux = aux.sig);
        aux.sig = nuevo;
    }

    public void agregarEnPosicion(int posicion, int valor) {
        if (posicion < 0) {
            System.out.println("La posición no puede ser negativa.");
            return;
        }
        if (posicion == 0) {
            agregarAlInicio(valor);
            return;
        }

        Nodo<E> nuevo = new Nodo(valor);
        Nodo<E> aux = cab;
        int contador = 0;
        for (aux = cab; aux != null && contador < posicion - 1; aux = aux.sig, contador++);
        if (aux == null) {
            System.out.println("La posición especificada no existe en la lista.");
            return;
        }
        nuevo.sig = aux.sig;
        aux.sig = nuevo;
    }

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0) {
            System.out.println("La posición no puede ser negativa.");
            return;
        }
        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        if (posicion == 0) {
            cab = cab.sig;
            return;
        }
        // 1 -> 2 -> 3 -> 5 -> NULL
        Nodo<E> aux = cab;
        int contador = 1;
        for (aux = cab; aux != null && contador < posicion - 1; aux = aux.sig, contador++);  
        if (aux == null || aux.sig == null) {
            System.out.println("La posición especificada no existe en la lista.");
            return;
        }
        aux.sig = aux.sig.sig;
    }

    public void mostrar() {
        Nodo<E> aux = cab;
        for (aux = cab; aux != null; aux = aux.sig)
            System.out.print(aux.valor + " -> ");
        System.out.println("null");
    }

    public int tamano() {
        Nodo<E> aux;
        int tamano = 0;
        for (aux = cab; aux != null; aux = aux.sig)
            tamano++;
        
        return tamano;
    }
}
