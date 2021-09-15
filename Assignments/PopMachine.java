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
    private String[] selections;
    private int price;
    private int amountDeposited;

    //constructors (set up a new object)
    public PopMachine(String[] selections, int price) {
        this.selections = selections;
        this.price = price;
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

    public void select(int choice){
        if(choice >= 0 && choice <= selections.length){
            if(amountDeposited >= price) {
                System.out.println("Here's your: " + selections[choice]);
                amountDeposited -= price;
                refund();
            } else {
                System.out.println("Please enter " + (price - amountDeposited) + "\u00A2 more.");
            }
        } else {
            System.out.println("The item you have entered does not exist, if you believe this is an error please contact support at 641-628-1411");
        }   
    }

   public static void main(String[] args) {
        String[] selections = {"water", "pepsi", "coke", "gatorade"};
        PopMachine machine = new PopMachine(selections, 150);
        //money will stay in machine as the user has not deposited enough
        /* machine.deposit(100);
        machine.select(0); */
        
        //user will now deposit enough for one drink and select, leaving 0 balance left
        /* machine.deposit(150);
        machine.select(1); */

        //user will now deposit enough money for one drink, but will choose the wrong number. No money will be refunded, as they can choose another number.
        machine.deposit(150);
        machine.select(-1);
        machine.select(5);
        machine.select(2);

        //user will now deposit an amount and refund the money
        /* machine.deposit(50);
        machine.refund(); */
   } 
}

