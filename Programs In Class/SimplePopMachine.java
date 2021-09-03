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
        if(amountDeposited >= price) {
            System.out.println("Here's your: " + drink);
        } else {
        System.out.println("Please enter more money, you need " + (price-amountDeposited) + "\u00A2 more!");
        }
    }

   public static void main(String[] args) {
        SimplePopMachine machine = new SimplePopMachine("water", 100);
        machine.deposit(50);
        //machine.deposit(25);
        machine.deposit(25);
        machine.select();
   } 
}
