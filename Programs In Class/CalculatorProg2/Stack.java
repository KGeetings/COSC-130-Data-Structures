package CalculatorProg2;

public interface Stack<E> {
   void push(E item);
   E pop();
   boolean isEmpty();
   int size();
   E peek();
}