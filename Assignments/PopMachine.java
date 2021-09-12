/* Write a PopMachine class to represent a machine that offers different selections.  Include these components:

PopMachine(String[] selections, price) constructor.  Assume all selections have the same price.
deposit(int amount) method like SimplePopMachine
select(int choice) to vend a particular selection.  Choices are numbered by their array index (0, 1, 2, etc.).  
If the choice is invalid, print a message.  Otherwise, handle it like SimplePopMachine did, including a refund of any extra change. 
 (When vending is successful, display the name of the selection.)
refund() method like SimplePopMachine
main() to test your methods

You do not need to include any other methods.
Java notes:

In main, create a String array with your selections in a variable to pass to the constructor.  
You cannot create the array in the call to the constructor.
See page 4 for the && and || boolean operators.  They help you write more complex tests. */

public class PopMachine {
    //fields (variables stored in each object)
    private String drink;
    private int price;
    private int amountDeposited;
    private static final int DEFAULT_PRICE = 150; 

    //constructors (set up a new object)
    public PopMachine(String drink, int price) {
        this.drink = drink;
        this.price = price;
    }

    public PopMachine(String drink) {
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
        // called automatically by System.out.println()
        return drink + ": " + price + "\u00A2";
    }

   public static void main(String[] args) {
        PopMachine machine = new PopMachine("water", 100);
        //money will be given back to user as there will not be enough in balance
        machine.deposit(50);
        machine.select();
        
        //user will now deposit enough for one drink and select, leaving 0 balance left
        machine.deposit(100);
        machine.select();

        //user will now deposit an amount and refund the money
        machine.deposit(50);
        machine.refund();

        PopMachine pepsi = new PopMachine("pepsi");
        pepsi.deposit(150);
        pepsi.select();

        System.out.println(pepsi);
   } 
}

