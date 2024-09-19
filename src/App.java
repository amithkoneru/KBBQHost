import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int currentParties = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi! Welcome to Iron Dish! How large is your party?");
        int partySize = scanner.nextInt();
        
        while(!scanner.hasNextInt() || (!scanner.hasNextInt() && scanner.nextInt() <= 0))    {
            System.err.println("Invalid Party Size, please enter a value greater than 0");
            System.out.println("Please provide a valid party size");


        }

        
        
        // if (partySize > 0 && scanner.hasNextInt())  {
        //     currentParties++;
        //     Party partyOne = new Party(currentParties, partySize);
        // }
        // else    {

        //     while (partySize )
        //     System.err.println("Party size must be greater than 0!");
        //     System.out.println("Please provide a valid party size")
            
       // }



    }
}