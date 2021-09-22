package initialJavaFunctions;
public class SimplePopMachine {
    //fields (variables stored in each object)
    private String drink;
    private int price;
    private int amountDeposited;
    private static final int DEFAULT_PRICE = 150; 

    //constructors (set up a new object)
    public SimplePopMachine(String drink, int price) {
        this.drink = drink;
        this.price = price;
    }

    public SimplePopMachine(String drink) {
        this(drink, DEFAULT_PRICE);
    }

    //methods
    public void deposit(int amount){
        amountDeposited += amount;
        System.out.println("Thanks for depositing! Balance: " + amountDeposited + "\u00A2.");
    }
    public void refund() {
        System.out.println("Your current balance is: " + amountDeposited + "\u00A2.");
        if(amountDeposited > 0){
        amountDeposited = 0;
        System.out.println("Your money has been refunded.");
        }
    }

    public void select(){
        if(amountDeposited >= price) {
            System.out.println("Here's your: " + drink);
            amountDeposited -= price;
            refund();
        } else {
            System.out.println("Please enter " + (price - amountDeposited) + "\u00A2 more.");
        }
    }

    public String toString() {
        // return a string that represents our object
        // called automatically by SYstem.out.println()
        return drink + ": " + price + "\u00A2";
    }

   public static void main(String[] args) {
        SimplePopMachine machine = new SimplePopMachine("water", 100);
        //money will be given back to user as there will not be enough in balance
        machine.deposit(50);
        machine.select();
        
        //user will now deposit enough for one drink and select, leaving 0 balance left
        machine.deposit(100);
        machine.select();

        //user will now deposit an amount and refund the money
        machine.deposit(50);
        machine.refund();

        SimplePopMachine pepsi = new SimplePopMachine("pepsi");
        pepsi.deposit(150);
        pepsi.select();

        System.out.println(pepsi);
   } 
}
