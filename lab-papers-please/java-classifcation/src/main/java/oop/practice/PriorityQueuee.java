package oop.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuee<T> implements Queue<T> {
    private PriorityQueue<T> queue;

    public PriorityQueuee(Comparator<T> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    @Override
    public void enqueue(T item) {
        queue.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue.poll();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
