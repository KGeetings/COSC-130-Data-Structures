package Simulator;

public interface Queue<E> {
   void enqueue(E item);
   E dequeue();
   E peek();
   int size();
   boolean isEmpty();
}