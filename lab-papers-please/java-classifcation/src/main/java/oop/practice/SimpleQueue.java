package oop.practice;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleQueue<T> implements Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void enqueue(T item) {
        list.addLast(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
