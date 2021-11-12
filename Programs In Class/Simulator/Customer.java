package Simulator;

public class Customer {
   private int arrivalTime;
   private int taskTime;
   
   public Customer(int arrival, int task) {
      arrivalTime = arrival;
      taskTime = task;
   }
   
   public void serve() {
      taskTime--;
   }
   
   public boolean finished() {
      return taskTime == 0;
   }
   
   public int wait(int currentTime) {
      return currentTime - arrivalTime;
   }
}