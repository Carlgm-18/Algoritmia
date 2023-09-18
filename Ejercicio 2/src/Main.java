


public class Main {
    public static void main(String[] args) {

        System.out.println("Test pila por cursor:\n");
        //Pila por cursor
        PilaArray<Integer> pilaArray = new PilaArray<>(5);

        try {
            System.out.println(pilaArray.pop());
        }catch (EmptyStackException e){
            System.out.println(e.getMessage());
        }

        System.out.println("***** Llenando la pila *****");
        try{
            for (int i = 1; i <= 6; i++) {
                pilaArray.push(i);
            }
        }catch(FullStackException e){
            System.out.println(e.getMessage());
        }
        System.out.println("***** Vaciando pila *****");
        try{
            System.out.println(pilaArray.pop());
            System.out.println(pilaArray.seek());
            System.out.println(pilaArray.pop());
            System.out.println(pilaArray.seek());
        }catch(EmptyStackException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nTest pila por referencia:\n");

        //Pila por referencia
        PilaReferencia<Integer> pilaReferencia = new PilaReferencia<>();

        try {
            System.out.println(pilaReferencia.pop());
        }catch (EmptyStackException e){
            System.out.println(e.getMessage());
        }

        System.out.println("***** Llenando la pila *****");
            for (int i = 1; i <= 6; i++) {
                pilaReferencia.push(i);
            }
        System.out.println("***** Vaciando pila *****");
        try{
            System.out.println(pilaReferencia.pop());
            System.out.println(pilaReferencia.seek());
            System.out.println(pilaReferencia.pop());
            System.out.println(pilaReferencia.seek());
        }catch(EmptyStackException e){
            System.out.println(e.getMessage());
        }
    }
}