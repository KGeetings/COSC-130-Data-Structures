public class SimplePopMachine {
    //fields (variables stored in each object)
    private String drink;
    private int price;
    private int amountDeposited;

    //constructors (set up a new object)
    public SimplePopMachine(String drink, int price) {
        this.drink = drink;
        this.price = price;
    }

    //methods
    public void deposit(int amount){
        amountDeposited += amount;
    }

    public void select(){
        //needs to keep track of money
        System.out.println(drink);
    }

   public static void main(String[] args) {
        SimplePopMachine machine = new SimplePopMachine("water", 100);
        machine.deposit(50);
        machine.deposit(25);
        machine.deposit(25);
        machine.select();
   } 
}
