public class Nodo<T> {
    private Nodo<T> next;
    final private T value;

    public Nodo(T e){
        this.value = e;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getNext(){
        return this.next;
    }

    public T getValue() {
        return this.value;
    }
}
