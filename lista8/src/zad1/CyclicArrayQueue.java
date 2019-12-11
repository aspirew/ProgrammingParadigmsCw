package zad1;

import java.util.ArrayList;
import java.util.List;

public class CyclicArrayQueue<E> implements MyQueue<E> {
    private List<E> queue;
    private int f = 0, r = 0;

    public CyclicArrayQueue(int n){
        queue = new ArrayList<E>(n+1);
        for(int i = 0; i <= n; i++){
            queue.add(null);
        }
    }

    @Override
    public void enqueue(E x) throws FullException {
        if(isFull()){
            throw new FullException("CyclicArrayQueue: enqueue");
        }
        else {
            queue.set(r, x);
            r = (r+1) % queue.size();
        }
    }

    @Override
    public void dequeue() {
        if(!isEmpty())
            f = (f+1) % queue.size();
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("CyclicArrayQueue");
        else
            return queue.get(f);
    }

    @Override
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    public boolean isFull() {
        return (r+1) % queue.size() == f;
    }
}

