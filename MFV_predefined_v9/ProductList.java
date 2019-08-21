import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Store details of shopping
 * @ Team 126
 * @ version (11/10/2018)
 */
public class ProductList
{
    public boolean feedback;
    public ArrayList<Integer> cart;
    

    public ProductList()
    {
        feedback = true;
        cart = new ArrayList<Integer>();
    }
    
    
    public Integer addProductInList(int type)
    {
        System.out.println("\n===========================================================\n");
        System.out.println("<< Adding product >>");
        
        int searchId = 0;
        boolean validId = false;
        while(validId == false) // continue loop if false
        {
            System.out.println("Searching the product by ID, please enter the valid ID: ");
            Scanner inputId = new Scanner(System.in);
            while(!inputId.hasNextInt()) // id must be an integer
            {
                inputId.next();
                System.out.println("Searching the product by ID, please enter the valid ID: ");
            }
            searchId = inputId.nextInt();
            if(type == 1)
            {
                if(searchId>0 && searchId<9) // if id is valid
                {
                    validId = true; // stop loop
                }
            }
            else
            {
                if(searchId>8 && searchId<17) // if id is valid
                {
                    validId = true; // stop loop
                }
            }
        }
        cart.add(searchId); // add valid id into cart
        return searchId;
    }
    
    
    public double getWeight()
    {
        double countWeight = 0.0;
        System.out.print("Please enter how many weights you want: ");
        Scanner inputWeight = new Scanner(System.in);
        countWeight = inputWeight.nextDouble();
        return countWeight; // return input weights
    }
    
    
    public int getBag()
    {
        int countBag = 0;
        System.out.print("Please enter how many bags you want: ");
        Scanner inputBag = new Scanner(System.in);
        while(!inputBag.hasNextInt()) // input bag must be an integer
        {
            inputBag.next();
            System.out.print("Please enter an integer.");
            System.out.print("\n\nPlease enter how many bags you want: ");
        }
        countBag = inputBag.nextInt();
        return countBag; // return input bags
    }
    
    
    public String getDate()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // format the date hh:mm:ss
        String date = df.format(new Date());
        return date;
    }
    
    
    public boolean setFeedback()
    {
        boolean validOption = false;
        String option = "";
        while(validOption == false) // continue loop if false
        {
            System.out.println("\n===========================================================\n");
            System.out.println("Please give us your feedback, thank you (1:thumb up / 2:thumb down):");
            Scanner inputOption = new Scanner(System.in);
            option = inputOption.nextLine();
            switch(option)
            {
                case "1":
                validOption = true; // stop loop
                feedback = true; // set feedback as true
                break;
                    
                case "2":
                validOption = true; // stop loop
                feedback = false; // set feedback as false
                break;
                   
                default: // if input not "1" or "2"
                System.out.println("The number you entered is invalid, please enter again.");
                validOption = false; // continue loop
            }
        }
        System.out.println("Thank you for giving the feedback to us!");
        return feedback;
    }
}
