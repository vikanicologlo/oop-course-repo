package oop.practice;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
}


