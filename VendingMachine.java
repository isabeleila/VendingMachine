import java.util.Scanner;

public class VendingMachine{
    
    private static final String[] Items = {"Snickers", "Skittles", "Cookies", "Granola Bar", "Hershey" };
    private static final double [] Prices = {1.50, 1.25, 2.0, 1.75, 2.0};
    public static final int[] Inventory = {4, 4, 4, 4, 4};

    public static void main(String args[]){
    Scanner scanner = new Scanner(System.in); 
    System.out.print("Welcome, Please pick a number for the snack you want: "); 
    int snack = scanner.nextInt(); 

    }
}