import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista <T extends Comparable<T>>{
    private List<T> lista;

    public Lista(int tam){
        lista = new ArrayList<T>(tam);
    }

    public void addElement(T e){
        lista.add(e);
    }

    public void ordenar(){
        Collections.sort(lista);
    }

    public int getPos(T e){
        int low = 0;
        int high = lista.size();
        int index;
        while(low < high){
            index = (int) (low + high)/2;
            if(e.compareTo(lista.get(index)) == 0){
                return index;
            }
            if(e.compareTo(lista.get(index)) > 0){
                low = index;
            }else{
                high = index;
            }
        }

        return -1;
    }
}
