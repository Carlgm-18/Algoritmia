public class PilaReferencia <T>{
    private Nodo<T> top;

    public PilaReferencia(){
        this.top = null;
    }

    public void push(T e){
        Nodo<T> newNode = new Nodo<>(e);

        if(this.isEmpty()){
            newNode.setNext(null);
        }else{
            newNode.setNext(this.top);
        }

        this.top = newNode;
    }

    public T pop() throws EmptyStackException{
        if(this.isEmpty()) {
            throw new EmptyStackException("La pila está vacía");
        }

        T ret = top.getValue();
        this.top = top.getNext();

        return ret;
    }

    public T seek(){
        return this.top.getValue();
    }

    public boolean isEmpty(){
        return this.top == null;
    }
}
