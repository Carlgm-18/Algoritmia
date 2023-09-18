import java.util.*;

public class Main {
    public static void main(String[] args){

        Random ran = new Random();
        int tam = 10000;
        int elementoABuscar = 7;

        Lista<Integer> lista = new Lista<Integer>(tam);

        //Ordenamos la lista
        for (int i = 0; i < tam; i++) {
            lista.addElement(ran.nextInt(tam));
        }

        lista.ordenar();

        System.out.println(lista.getPos(elementoABuscar));
    }
}
