import java.util.ArrayList;
public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar números del argumento a la lista
        for (String arg : args) {
            try {
                int numero = Integer.parseInt(arg);
                numeros.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Ignorando argumento no numérico: " + arg);
            }
        }

        // Calcular la suma de los componentes del ArrayList
        int sumaTotal = 0;
        for (int numero : numeros) {
            sumaTotal += numero;
        }

        System.out.println("ArrayList actual: " + numeros);
        System.out.println("Suma de los componentes: " + sumaTotal);

        // Agregar y quitar elementos del ArrayList
        if (args.length >= 3) {
            String operacion = args[2];
            if ("agregar".equalsIgnoreCase(operacion) && args.length >= 4) {
                try {
                    int numeroAgregar = Integer.parseInt(args[3]);
                    numeros.add(numeroAgregar);
                    System.out.println("Elemento agregado: " + numeroAgregar);
                } catch (NumberFormatException e) {
                    System.out.println("No se pudo agregar el elemento. Argumento no numérico.");
                }
            } else if ("quitar".equalsIgnoreCase(operacion) && args.length >= 4) {
                try {
                    int indiceQuitar = Integer.parseInt(args[3]);
                    if (indiceQuitar >= 0 && indiceQuitar < numeros.size()) {
                        numeros.remove(indiceQuitar);
                        System.out.println("Elemento en el índice " + indiceQuitar + " eliminado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("No se pudo quitar el elemento. Argumento no numérico.");
                }
            }
        }

        System.out.println("ArrayList final: " + numeros);
    }
}
