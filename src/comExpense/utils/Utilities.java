package comExpense.utils;

import java.util.List;

public class Utilities {
    public static <T> void imprimirElementos(List<T> lista) {
        for (T elemento : lista) { // se recorren los elementos de la lista y se los muestra por consola

            System.out.println(elemento);
        }
    }
}