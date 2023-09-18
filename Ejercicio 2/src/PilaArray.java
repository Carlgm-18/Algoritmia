public class PilaArray<T> {
    private int top;
    private T[] data;

    public PilaArray(int tam){
        this.top = -1;
        this.data = (T[]) new Object[tam];
    }

    public void push(T e) throws FullStackException{
        if(this.top + 1 == this.data.length){
            throw new FullStackException("La pila está llena");
        }
        this.data[++top] = e;
    }

    public T pop() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException("La pila está vacía");
        }
        return this.data[top--];
    }

    public T seek() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException("La pila está vacía");
        }
        return this.data[top];
    }

    public boolean isEmpty(){
        return top < 0;
    }
}
