package tad;

import tad.cola.*;

public class TADMain {
    public static void main(String[] args) {
        final int SIZE = 10;
        final Queue<Integer> queue = new QueueDinamica<>();

        //We fill the queue
        for (int i = 0; i < SIZE; i++) queue.enqueue(i);

        assetTrue(queue.size() == SIZE);


        //We remove the first 2 elements
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        //n - 2 should be 2
        assetTrue(queue.size() == SIZE - 2);
        assetTrue(queue.first() == 2);

        queue.enqueue(1000);

    }
    public static void assetTrue(boolean succes) {
        if(!succes) throw new AssertionError();
    }
}
