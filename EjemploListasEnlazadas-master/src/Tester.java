import java.util.Scanner;

public class Tester {

    // NUMEROS PARES
    public static boolean esPar(int num){
        if (num % 2 == 0) return true;
        else return false;
    }

    // NUMEROS PERFECTOS
    public static boolean esPerfecto(int num){
        int sum = 1;
        for (int i = 2; i <= (num/2); i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if(sum == num) return true;
        else return false;
    }

    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner oScanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de primos que desee agregar: ");
        int n = oScanner.nextInt();  // Cambiar n segun sea necesario
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        int num = 2;
        while (n > 0) {
            if (esPrimo(num)) {
                //lista.insertarDerecha(num);
                lista.insertarIzquierda(num);
                n--;
            }
            num++;
        }
        System.out.println(lista.toString());
        System.out.println("Total items: " + lista.size());
        lista.eliminarIzquierda(11);
        lista.eliminarDerecha(2);
        System.out.println(lista.toString());
        System.out.println("Total items: " + lista.size());
    }
}

