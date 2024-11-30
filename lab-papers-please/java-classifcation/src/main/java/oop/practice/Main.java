package oop.practice;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println("ArrayQueue: " + arrayQueue.dequeue());
        System.out.println("ArrayQueue: " + arrayQueue.peek());

        Queue<Integer> priorityQueue = new PriorityQueuee<>((a, b) -> b - a);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(15);
        System.out.println("PriorityQueue: " + priorityQueue.dequeue());
        System.out.println("PriorityQueue: " + priorityQueue.peek());


        Queue<String> circularQueue = new CircularQueue<>(3);
        circularQueue.enqueue("A");
        circularQueue.enqueue("B");
        circularQueue.enqueue("C");
        System.out.println("CircularQueue: " + circularQueue.dequeue());
        circularQueue.enqueue("D");
        System.out.println("CircularQueue: " + circularQueue.peek());
    }
}
