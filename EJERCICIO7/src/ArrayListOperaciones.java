import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayListOperaciones<E> implements Iterable<E> {
    private ArrayList<E> lista;

    public ArrayListOperaciones() {
        lista = new ArrayList<>();
    }

    public void agregarElemento(E elemento) {
        lista.add(elemento);
    }

    public E obtenerElemento(int indice) {
        return lista.get(indice);
    }

    public E modificarElemento(int indice, E valor) {
        return lista.set(indice, valor);
    }

    public E quitarElemento(E valor) {
        int indice = lista.indexOf(valor);
        if (indice == -1) return null;
        else return lista.remove(indice);
    }

    public E quitarElemento(int indice) {
        return lista.remove(indice);
    }

    public int tamaño() {
        return lista.size();
    }

    public void ordenar(Comparator<E> comparador) {
        lista.sort(comparador);
    }

    public void mostrar(){
        //Utilizar el iterador personalizado para recorrer la lista
        for (E elemento : lista)
            System.out.print(elemento + "\t");
        System.out.print("\n");
    }
    @Override
    public Iterator<E> iterator() {
        return new MiIterator();
    }

    private class MiIterator implements Iterator<E> {
        private int indiceActual = 0;

        @Override
        public boolean hasNext() {
            return indiceActual < lista.size();
        }

        @Override
        public E next() {
            if (hasNext()) {
                E elemento = lista.get(indiceActual);
                indiceActual++;
                return elemento;
            }
            throw new java.util.NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ArrayListOperaciones<String> miLista = new ArrayListOperaciones<>();
        miLista.agregarElemento("Uno");
        miLista.agregarElemento("Dos");
        miLista.agregarElemento("Tres");
        miLista.mostrar();

        miLista.ordenar(Comparator.naturalOrder());
        miLista.mostrar();
    }
}