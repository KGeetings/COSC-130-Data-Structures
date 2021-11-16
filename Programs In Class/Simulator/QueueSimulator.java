package Simulator;

import java.util.List;
import java.util.ArrayList;

public class QueueSimulator {
   private Cashier c1;
   private Cashier c2;
   private int time;
   private int numberOfRuns;
   
   public QueueSimulator(double p, int amountRuns) {
      c1 = new Cashier(p, 7);
      c2 = new Cashier(p, 10);
      numberOfRuns = amountRuns;
   }
   
   public void run(int steps) {
      for (int i = 0; i < steps; i++) {
         c1.maybeAddCustomer(time);
         c2.maybeAddCustomer(time);
         tick();
      }
      while (anyNotFinished()) {
         tick();
      }
   }
   
   public void tick() {
      c1.tick(time);
      c2.tick(time);
      time++;
   }
   
   private boolean anyNotFinished() {
      return !c1.finished() || !c2.finished();
   }

   public void printStats() {
      System.out.println("Time: " + time);
      
      System.out.println();
      System.out.println("Cashier with max wait = " + c1.maxWait());
      System.out.println("Average wait time: " + c1.totalWait() / numberOfRuns);

      System.out.println();
      System.out.println("Cashier with max wait = " + c2.maxWait());
      System.out.println("Average wait time: " + c2.totalWait() / numberOfRuns);
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