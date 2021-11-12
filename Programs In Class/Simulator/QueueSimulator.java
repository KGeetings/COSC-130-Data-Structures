package Simulator;

public class QueueSimulator {
   private Cashier c1;
   private Cashier c2;
   private int time;
   
   public QueueSimulator(double p) {
      c1 = new Cashier(p, 7);
      c2 = new Cashier(p, 10);
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
      System.out.println("Total wait: " + c1.totalWait());

      System.out.println();
      System.out.println("Cashier with max wait = " + c2.maxWait());
      System.out.println("Total wait: " + c2.totalWait());
   }
   
   public static void main(String[] args) {
      QueueSimulator sim = new QueueSimulator(0.2);
      sim.run(1000);
      sim.printStats();
   }
}