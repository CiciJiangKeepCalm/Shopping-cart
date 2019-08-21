import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Main system
 * @ Team 126
 * @ version (11/10/2018)
 */
public class MVFSystem
{
    public Menu menu;
    public Product product;
    public ProductList productList;
    public DailyReport report;
    public String adminId;
    public String adminName;
    public boolean feedback;
    public double totalPrice;
    public ArrayList<String> dateList;
    public ArrayList<Integer> unitList;
    public ArrayList<Double> amountWeightList;
    public ArrayList<Integer> kgList;
    public ArrayList<Integer> amountPrepackedList;
    
    
    public MVFSystem()
    {
        menu = new Menu();
        product = new Product();
        productList = new ProductList();
        report = new DailyReport();
        adminId = "";
        adminName = "";
        feedback = true;
        totalPrice = 0.00;
        dateList = new ArrayList<String>();
        unitList = new ArrayList<Integer>();
        amountWeightList = new ArrayList<Double>();
        kgList = new ArrayList<Integer>();
        amountPrepackedList = new ArrayList<Integer>();
    }
    
    
    public void mainMenu()
    {
        while (adminId.equals("")) // continue loop if input nothing
        {
            System.out.println("Please enter your Id:");
            Scanner inputId = new Scanner(System.in);
            adminId = inputId.nextLine();
            report.adminIdList.add(adminId);
        }
        
        while (adminName.equals("")) // continue loop if input nothing
        {    
            System.out.println("Please enter your name:");
            Scanner inputName = new Scanner(System.in);
            adminName = inputName.nextLine();
            report.adminNameList.add(adminName);
        }
        
        String menuOption = "";
        while (!menuOption.equals("4")) // continue loop if input not 4
        {
            menu.mainMenu();
            Scanner inputOption = new Scanner(System.in);
            menuOption = inputOption.nextLine();
            switch(menuOption)
            {   
                case "1": // check out & add product
                System.out.println("You chose the option 1");
                String nameOption = "";
                boolean validUnitOption = false;
                while(validUnitOption == false) // continue loop if false
                {
                    System.out.println("\nPlease select the product type:");
                    System.out.println("(1) Fruit");
                    System.out.println("(2) Vegetable");
                    Scanner name = new Scanner(System.in);
                    nameOption = name.nextLine();
                    
                    int existId = 0;
                    switch(nameOption)
                    {
                        case "1":
                        viewFruitProduct();
                        existId = productList.addProductInList(1); // add product into list by its id
                        product.display(existId); // display the detail of product
                        calculatePrice(existId); // calculate price
                        validUnitOption = true;
                        break;
                        
                        case "2":
                        viewVegProduct();
                        existId = productList.addProductInList(2); // add product into list by its id
                        product.display(existId); // display the detail of product
                        calculatePrice(existId); // calculate price
                        validUnitOption = true;
                        break;
                        
                        default: // if input not "1" "2"
                        System.out.println("The number you enter is invalid, please enter again.");
                        validUnitOption = false;
                    }
                }
                break;
                
                
                case "2": // print receipt
                System.out.println("You chose the option 2");
                if(productList.cart.size() != 0)
                {
                    printReceipt(); // print receipt method
                    
                    // clear the list for the next shopping
                    productList.cart.clear();
                    unitList.clear();
                    amountWeightList.clear();
                    kgList.clear();
                    amountPrepackedList.clear();
                    
                    // clear the price for the next shopping
                    totalPrice = 0.00; 
                }
                else
                {
                    System.out.println("Nothing can print.");
                }
                break;
                
                
                case "3": // view daily report
                System.out.println("You chose the option 3");
                System.out.println("\n<< Daily Report >>");
                String inputDate = "";
                System.out.println("Please enter the date (e.g. 2018-10-10):");
                Scanner input = new Scanner(System.in);
                inputDate = input.nextLine();
                report.viewDailyReport(inputDate);
                break;
                
                
                case "4": // exit the system
                System.out.println("You chose the option 4");
                System.out.println("Bye...\n");
                break;
                
                
                default: // if input not "1" "2" "3" "4"
                System.out.println("The number you enter is invalid, please enter again.");
            }
        }
    }
    
    
    private void calculatePrice(int id)
    {
        double price = 0.0;
        boolean validUnitOption = false;
        while(validUnitOption == false) // continue loop if false
        {
            String option = "";
            System.out.println("\nPlease choose the way you buy:");
            System.out.println("(1) Weight");
            System.out.println("(2) Prepacked Bag");
            Scanner inputUnitOption = new Scanner(System.in);
            option = inputUnitOption.nextLine();
            switch(option)
            {   
                case "1": // weight
                unitList.add(1);
                double countWeight = getWeight();
                amountWeightList.add(countWeight);
                kgList.add(0);
                amountPrepackedList.add(0);
                if(id>0 && id<9) // type: fruit
                {
                    price = product.getWeightPriceList().get(id-1) * countWeight; // calculate fruit price
                }
                else // type: vegetable
                {
                    price = product.getWeightPriceList().get(id-1) * countWeight; // calculate veg price
                }
                totalPrice += price; // add into total price
                validUnitOption = true; // stop loop
                break;
                
                case "2": // prepacked
                unitList.add(2);
                int kg = getPrepacked(); // get 5kg / 10kg
                amountWeightList.add(0.00);
                kgList.add(kg);
                int bag = 0;
                System.out.println("How many prepacked bags you want?");
                Scanner inputBag = new Scanner(System.in);
                while(!inputBag.hasNextInt()) // input bag must be an integer
                {
                    inputBag.next();
                    System.out.println("Please enter integer, how many prepacked bags you want?");
                }
                bag = inputBag.nextInt();
                amountPrepackedList.add(bag);
                if(id>0 && id<9) // type: fruit
                {
                    if(kg == 5) // 5kg
                    {
                        price = (product.getprepacked5kgPriceList().get(id-1)) * bag; // calculate fruit (5kg) price
                    }
                    else // 10kg
                    {
                        price = (product.getprepacked10kgPriceList().get(id-1)) * bag; // calculate fruit (10kg) price
                    }
                }
                else  // type: vegetable
                {
                    if(kg == 5) // 5kg
                    {
                        price = (product.getprepacked5kgPriceList().get(id-1)) * bag; // calculate veg (5kg) price
                    }
                    else // 10kg
                    {
                        price = (product.getprepacked10kgPriceList().get(id-1)) * bag; // calculate veg (10kg) price
                    }
                }
                totalPrice += price; // add into total price
                validUnitOption = true; // stop loop
                break;
                
                default: // if input not "1" or "2"
                System.out.println("The number you entered is invalid, please enter again.\n");
                validUnitOption = false; // continue loop
            }
        }
    }
    
    
    private double getWeight() // get weights that admin entered
    {
        double countWeight = 0.0;
        System.out.println("Please enter how many weights you want: ");
        Scanner inputWeight = new Scanner(System.in);
        // input type have to be Double
        while(!inputWeight.hasNextDouble()) {
            System.out.println("Invalid Input. Please enter again:");
            inputWeight.nextLine();
        }
        countWeight = inputWeight.nextDouble();
        return countWeight; // return input weights
    }
    
    
    private int getPrepacked() // get bags that admin entered
    {
        int kg = 0;
        String option = "";
        boolean validUnitOption = false;
        while(validUnitOption == false) // continue loop if false
        {
            System.out.println("\nPlease choose how many kg of prepacked bags you want:");
            System.out.println("(1) 5Kg");
            System.out.println("(2) 10Kg");
            Scanner inputPrepacked = new Scanner(System.in);
            option = inputPrepacked.nextLine();
            switch(option)
            {   
                case "1":
                kg = 5;
                validUnitOption = true;
                break;
                
                case "2":
                kg = 10;
                validUnitOption = true;
                break;
                
                default: // if input not "1" or "2"
                System.out.println("The number you entered is invalid, please enter again.\n");
                validUnitOption = false;
            }
        }
        return kg;
    }
    
    
    private double getTotalPrice()
    {
        return totalPrice;
    }

    
    private void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    
    private void viewFruitProduct()
    {
        for(int i=0;i<8;i++) // get the name of fruit
        { 
            System.out.println((i+1) + ": " + product.getNameList().get(i));
        }
    }
    
    
    private void viewVegProduct()
    {
        for(int i=8;i<16;i++) // get the name of vegetable
        { 
            System.out.println((i+1) + ": " + product.getNameList().get(i));
        }
    }
    
    
    private void printReceipt()
    {
        String date = productList.getDate(); // get the current date
        
        // weight
        ArrayList<Integer> nonRepeatProductWeightList;
        nonRepeatProductWeightList = new ArrayList<Integer>();
        ArrayList<Double> weightPriceList;
        weightPriceList = new ArrayList<Double>();
        ArrayList<Double> weightAmountList;
        weightAmountList = new ArrayList<Double>();
        
        // prepacked bag
        ArrayList<Integer> nonRepeatProductBagList;
        nonRepeatProductBagList = new ArrayList<Integer>();
        ArrayList<Double> bag5kgPriceList;
        bag5kgPriceList = new ArrayList<Double>();
        ArrayList<Double> bag10kgPriceList;
        bag10kgPriceList = new ArrayList<Double>();
        ArrayList<Integer> bag5kgAmountList;
        bag5kgAmountList = new ArrayList<Integer>();
        ArrayList<Integer> bag10kgAmountList;
        bag10kgAmountList = new ArrayList<Integer>();
        
        
        System.out.println("\n<< Receipt >>");
        for(int i=0; i<productList.cart.size(); i++) // get the id of each product
        {
            Double price = 0.00;
            Double weightAmount = 0.00;
            
            Double price5kg = 0.00;
            Double price10kg = 0.00;
            int bag5kgAmount = 0;
            int bag10kgAmount = 0;
            
            int productInCart = productList.cart.get(i);
            
            if(unitList.get(i) == 1) // weight
            {
                if(nonRepeatProductWeightList.contains(productInCart)) // if the product exists
                {
                    price = product.getWeightPriceList().get(productInCart-1); // get the product price
                    int index = nonRepeatProductWeightList.indexOf(productInCart); // get the index
                    Double value = weightPriceList.get(index); // get the value by the index
                    
                    weightAmount = amountWeightList.get(i); // get the input amount
                    Double amountValue = weightAmountList.get(index); // get the value by the index
                    
                    weightAmountList.set(index, (amountValue+weightAmount)); // add and set the value at the same index
                    weightPriceList.set(index, (value+price*weightAmount)); // add and set the value at the same index
                }
                else // if the product not existent
                {
                    nonRepeatProductWeightList.add(productInCart); // add product id into list
                    price = product.getWeightPriceList().get(productInCart-1); // get the product price
                    weightAmount = amountWeightList.get(i); // get the input amount
                    weightAmountList.add(weightAmount); // add the amount into list
                    weightPriceList.add(price*weightAmount); // add the price into list
                }
            }
            else // prepacked bag
            {
                int kgBase = kgList.get(i);
                if(nonRepeatProductBagList.contains(productInCart)) // if the product exists
                {
                    int index = nonRepeatProductBagList.indexOf(productInCart); // get the index
                    if(kgBase == 5) // 5kg
                    {
                        price5kg = product.getprepacked5kgPriceList().get(productInCart-1); // get the product price
                        Double value = bag5kgPriceList.get(index); // get the value by the index
                        
                        bag5kgAmount = amountPrepackedList.get(i); // get the input amount
                        int amountValue = bag5kgAmountList.get(index); // get the value by the index
                        
                        bag5kgAmountList.set(index, (amountValue+bag5kgAmount));// add and set the value at the same index
                        bag5kgPriceList.set(index, (value+price5kg*bag5kgAmount));// add and set the value at the same index
                    }
                    else // 10 kg
                    {
                        price10kg = product.getprepacked10kgPriceList().get(productInCart-1); // get the product price
                        Double value = bag10kgPriceList.get(index); // get the value by the index
                        
                        bag10kgAmount = amountPrepackedList.get(i); // get the input amount
                        int amountValue = bag10kgAmountList.get(index); // get the value by the index
                        
                        bag10kgAmountList.set(index, (amountValue+bag10kgAmount));// add and set the value at the same index
                        bag10kgPriceList.set(index, (value+price10kg*bag10kgAmount));// add and set the value at the same index
                    }
                }
                else // if the product not existent
                {
                    nonRepeatProductBagList.add(productInCart); // add product id into list
                    if(kgBase == 5) // 5kg
                    {
                        price5kg = product.getprepacked5kgPriceList().get(productInCart-1); // get the product price
                        bag5kgAmount = amountPrepackedList.get(i); // get the input amount
                        bag5kgAmountList.add(bag5kgAmount); // add the amount into list
                        bag10kgAmountList.add(0);
                        bag5kgPriceList.add(price5kg*bag5kgAmount); // add the price into list
                        bag10kgPriceList.add(0.00);
                    }
                    else // 10 kg
                    {
                        price10kg = product.getprepacked10kgPriceList().get(productInCart-1); // get the product price
                        bag10kgAmount = amountPrepackedList.get(i); // get the input amount
                        bag10kgAmountList.add(bag10kgAmount); // add the amount into list
                        bag5kgAmountList.add(0);
                        bag10kgPriceList.add(price10kg*bag10kgAmount); // add the price into list
                        bag5kgPriceList.add(0.00);
                    }
                }
            }
        }
        
        // if the date is within 2 days of expiry date, then 20 percent discount
        if((date.compareTo("2018-10-16")>0) && (date.compareTo("2018-10-20")<0))
        {
            // print those products whose unit based on weight 
            System.out.println("\n   - Weight -");
            for(int w=0; w<nonRepeatProductWeightList.size(); w++)
            {
                System.out.println("(" + (w+1) + ") " + product.toString(nonRepeatProductWeightList.get(w)));
                System.out.println("   ====== You chose ======");
                System.out.println("   1. Unit: Weight");
                System.out.println("   2. Amount: " + weightAmountList.get(w));
                System.out.println("   * This product has expired 1 day, so you can get 20% off.");
                System.out.println("      \t\t\t\t\tTotal price: " + weightPriceList.get(w)*0.8);
            }
            
            // print those products whose unit based on prepacked bag 
            System.out.println("\n   - Prepacked Bag -");
            for(int b=0; b<nonRepeatProductBagList.size(); b++)
            {
                Double price5 = bag5kgPriceList.get(b);
                Double price10 = bag10kgPriceList.get(b);
                int amount5 = bag5kgAmountList.get(b);
                int amount10 = bag10kgAmountList.get(b);
                Double total = price5 + price10;
                System.out.println("(" + (b+1) + ") " + product.toString(nonRepeatProductBagList.get(b)));
                System.out.println("   ====== You chose ======");
                System.out.println("   1. Unit: Prepacked Bag");
                System.out.println("   2. Amount(5 kg): " + amount5);
                System.out.println("   3. Amount(10 kg): " + amount10);
                System.out.println("   * This product has expired 1 day, so you can get 20% off.");
                System.out.println("       \t\t\t\t\tTotal price: " + total*0.8);
            }
            
            System.out.println("\n--- Total price for this shopping: " + totalPrice*0.8 + " ---");
            dateList.add(date); // add date into date list
            boolean feedback = productList.setFeedback(); // set feedback
            report.addToDailyReport(adminId, adminName, date, totalPrice*0.8, feedback); // add info into report
        }
        
        
        //clear all the lists
        nonRepeatProductWeightList.clear();
        weightPriceList.clear();
        weightPriceList.clear();
        weightAmountList.clear();
        
        nonRepeatProductBagList.clear();
        bag5kgPriceList.clear();
        bag10kgPriceList.clear();
        bag5kgAmountList.clear();
        bag10kgAmountList.clear();
    }
    
    
    private String checkDate()
    {
        System.out.println("\n<< Daily Report >>");
        System.out.println("Please enter the date (e.g. 2018-10-10):");
        Scanner input = new Scanner(System.in);
        String inputDate = "";
        boolean validDate = false;
        while(validDate == false) // continue loop if false
        {
            inputDate = input.nextLine();
            if(dateList.contains(inputDate)) // if date in list
            {
                validDate = true; // stop loop
            }
            else
            {
                System.out.println("The Date you entered is not existent, please enter again:");
                validDate = false; // continue loop
            }
        }
        return inputDate;
    }
}
