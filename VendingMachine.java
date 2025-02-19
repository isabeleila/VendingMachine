import java.util.Scanner;

public class VendingMachine{
    
    private static final String[] Items = {"Snickers", "Skittles", "Cookies", "Granola Bar", "Hershey" };
    private static final double [] Prices = {1.50, 1.25, 2.0, 1.75, 2.0};
    public static final int[] Inventory = {4, 4, 4, 4, 4};
    private static double currentBalance = 0;
    
        //displays the snacks avaiable to purchase in the vending machine
        public static void displayInventory(){
            System.out.println("Snacks Available:");
            for (int i = 0; i < Items.length; i++){
                if (Inventory[i] > 0){
                    System.out.println((i+1) + ". " + Items[i] + " -$" + Prices[i]);
                }
            }
            System.out.println("Make A Selection From The Following Options:");

        }
    
        //displays the amount of money the user enters
        public static void insertMoney(double amount){
            currentBalance += amount;
            System.out.println("Current Balance: $" + currentBalance);
        }

        //user can select the snack they want
        public static void selectSnack(int itemNum){
            if (itemNum > 0 && itemNum <=Items.length && Inventory[itemNum -1] >0){
                double price = Prices[itemNum -1];
                if(currentBalance >= price) {
                    System.out.println("You Selected: " + Items[itemNum- 1] + "- $" + price); 
                    System.out.println("Would you like to proceed with your purchase: (yes/no)"); 
                    Scanner scanner = new Scanner(System.in); 
                    String confirmation = scanner.nextLine().toLowerCase(); 


                    if (currentBalance >= price){
                        Inventory[itemNum -1]--;
                        currentBalance -= price;
                        System.out.println("Dispensing " + Items[itemNum -1]);
                        System.out.println("Your remaining balance is: $" + currentBalance);
                    } 
                    
                    else {
                        System.out.println("Your transaction has been canceled, and your money is being returned. ");
                    }
                } 
                
                else {
                System.out.println("Sorry, there are insufficient funds. Please insert more cash.");
                }
            }
            
            else {
                System.out.println("You have made an invalid selection or the item you want is no longer available."); 
            }
        }

        //giving the correct amount of change back
        public static void returnChange(){
            if (currentBalance > 0){
                System.out.println("Change due: $" + currentBalance);
                currentBalance = 0;
            } else {
                System.out.println("No change due.");
            }
        }

        public static void departureMessage(){
            System.out.println("Enjoy your snack and Have a Great Day!!" ); 
        }


    public static void main(String args[]){
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scan = new Scanner(System.in); 
        //System.out.println("Make A Selection From The Following Options:");


        //actual functionality of the vending machine
        while (true) {
            vendingMachine.displayInventory();
            System.out.println("1. Insert 1 dollar bills");
            System.out.println("2. Select snack");
            System.out.println("3. Return change");
            System.out.println("4. Exit");
            System.out.println("Enter the number for the option you would like to make.");

            int option = scan.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter amount to deposit in whole dollars: $");
                    int amount = scan.nextInt();
                    vendingMachine.insertMoney(amount);
                    break;

                case 2:
                    System.out.println("Enter number to select a snack: ");
                    int itemNum = scan.nextInt();
                    vendingMachine.selectSnack(itemNum);
                    break;
                case 3:
                    vendingMachine.returnChange();
                    break;
                case 4:
                    System.out.println("Thank you for using! Now exiting vending machine.");
                    vendingMachine.departureMessage(); 
                return;
                default:
                    System.out.println("Invalid optin. Please enter a valid option number.");
                    vendingMachine.departureMessage(); 
            }
        }
        
    }
    
}