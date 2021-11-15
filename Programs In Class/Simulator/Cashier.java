package Simulator;

import java.util.Random;

public class Cashier {
   // declare queue of customers
   private Queue<Customer> queue = new ArrayQueue<Customer>();
   private Customer currentCustomer;
   private double newCustomerProbability;
   private int maxWait;
   private int count;
   private int totalWait;
   private Random gen;
   
   public Cashier(double newCustomerProbability, int maxWait) {
      gen = new Random();
      this.newCustomerProbability = newCustomerProbability;
      this.maxWait = maxWait;
   }
   
   public void maybeAddCustomer(int time) {
      if (gen.nextDouble() < newCustomerProbability) {
         int wait = 1 + gen.nextInt(maxWait);
         Customer c = new Customer(time, wait);
         addCustomer(c);
      }
   }
   
   private void addCustomer(Customer c) {
      // if no current customer, c becomes current; otherwise c has to wait in the queue
      if (free()) {
         currentCustomer = c;
      } else {
         queue.enqueue(c);
      }
      count++;
   }
   
   public void tick(int time) {
      // if free and someone is waiting, make that customer current
      if (free() && !queue.isEmpty()) {
         currentCustomer = queue.dequeue();
      }
      // if not free
      //    serve current customer
      //    if they finish, add their waiting time to the total wait time
      //        and set current customer to null
      if (!free()) {
         currentCustomer.serve();
         if (currentCustomer.finished()) {
            totalWait += currentCustomer.wait(time);
            currentCustomer = null;
         }
      }
   }
   
   public boolean free() {
      return currentCustomer == null;
   }
   
   public boolean finished() {
      // return true if there is no current customer and the queue is empty
      return free() && queue.isEmpty();
   }
   
   public int count() {
      return count;
   }
   
   public int totalWait() {
      return totalWait;
   }
   
   public int maxWait() {
      return maxWait;
   }
   
}