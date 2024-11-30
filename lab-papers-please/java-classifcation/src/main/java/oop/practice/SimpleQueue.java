package oop.practice;

// Queue Implementation 1: SimpleQueue
import java.util.LinkedList;

public class SimpleQueue<T> implements Queue<T> {
    private java.util.Queue<T> queue = new LinkedList<>();

    @Override
    public void enqueue(T item) {
        queue.add(item);
    }

    @Override
    public T dequeue() {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

