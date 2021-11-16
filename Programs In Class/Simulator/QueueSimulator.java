package Simulator;

import java.util.List;
import java.util.ArrayList;

public class QueueSimulator {
   List<Cashier> cashierList = new ArrayList<Cashier>(10);
   private int time;
   private int numberOfRuns;
   
   public QueueSimulator(double p, int amountRuns) {
      for (int i = 1; i <= 10; i++) {
         cashierList.add(new Cashier(p, i));
      }
      numberOfRuns = amountRuns;
   }
   
   public void run(int steps) {
      for (int i = 0; i < steps; i++) {
         // for each cashier in the list maybeAddCustomer(time)
         for (Cashier cashier : cashierList) {
            cashier.maybeAddCustomer(time);
         }
         tick();
      }
      while (anyNotFinished()) {
         tick();
      }
   }
   
   public void tick() {
      // for each cashier in the list tick(time)
      for (Cashier cashier : cashierList) {
         cashier.tick(time);
      }
      time++;
   }
   
   private boolean anyNotFinished() {
      // for each cashier in the list check is not finished
      for (Cashier cashier : cashierList) {
         if (!cashier.finished()) {
            return true;
         }
      }
      return false;
   }

   public void printStats() {
      System.out.println("Time: " + time);

      // for each cashier print the cashiers maxWait() and Average wait time
      for (Cashier cashier : cashierList) {
         System.out.println();
         System.out.println("Cashier with max wait = " + cashier.maxWait());
         System.out.println("Average wait time: " + cashier.totalWait() / numberOfRuns);
      }
   }
   
   public static void main(String[] args) {
      QueueSimulator sim = new QueueSimulator(0.2, 10);

      // run the simulation 10 times at 1000 steps each
      for (int i = 0; i < 10; i++) {
         sim.run(1000);
      }
      sim.printStats();
   }
}