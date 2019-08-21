import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Store details of each product
 * @ Team 126
 * @ version (11/10/2018)
 */
public class Product
{
    public ArrayList<String> productList;
    public ArrayList<String> supplierList;
    public ArrayList<String> desList;
    public ArrayList<String> dateList;
    public ArrayList<Double> weightPriceList;
    public ArrayList<Double> prepacked5kgPriceList;
    public ArrayList<Double> prepacked10kgPriceList;
    
    
    
    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        productList = new ArrayList<String>();
        productList.add("apple");
        productList.add("banana");
        productList.add("pear");
        productList.add("kiwi");
        productList.add("grape");
        productList.add("watermelon");
        productList.add("cherry");
        productList.add("lime");
        productList.add("carrot");
        productList.add("tomato");
        productList.add("broccoli");
        productList.add("cucumber");
        productList.add("lettuce");
        productList.add("zucchini");
        productList.add("corn");
        productList.add("onion");
        
        supplierList = new ArrayList<String>();
        supplierList.add("oversea");
        supplierList.add("local");
        supplierList.add("local");
        supplierList.add("oversea");
        supplierList.add("oversea");
        supplierList.add("oversea");
        supplierList.add("local");
        supplierList.add("local");
        supplierList.add("local");
        supplierList.add("oversea");
        supplierList.add("oversea");
        supplierList.add("oversea");
        supplierList.add("local");
        supplierList.add("oversea");
        supplierList.add("local");
        supplierList.add("oversea");
        
        desList = new ArrayList<String>();
        for (int i=1; i<17; i++)
        {
            desList.add("Good");
        }
        
        dateList = new ArrayList<String>();
        for (int i=1; i<17; i++)
        {
            dateList.add("10/10/2018");
        }
        
        weightPriceList = new ArrayList<Double>();
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(2.5);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        weightPriceList.add(3.0);
        
        prepacked5kgPriceList = new ArrayList<Double>(); // price for 5kg
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(5.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        prepacked5kgPriceList.add(6.0);
        
        prepacked10kgPriceList = new ArrayList<Double>(); // price for 10kg
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(10.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
        prepacked10kgPriceList.add(12.0);
    }
    
    
    public List<String> getNameList() 
    {
        return productList;
    }
    
    public List<String> getSupplierList() 
    {
        return supplierList;
    }
    
    public List<String> getDesList() 
    {
        return desList;
    }
    
    public List<String> getDateList() 
    {
        return dateList;
    }
    
    public List<Double> getWeightPriceList() 
    {
        return weightPriceList;
    }
    
    public List<Double> getprepacked5kgPriceList() 
    {
        return prepacked5kgPriceList;
    }
    
    public List<Double> getprepacked10kgPriceList() 
    {
        return prepacked10kgPriceList;
    }
    
    
    public void display(int productId)
    {
        System.out.println("The detail of the product ID_" + productId + " is following:");
        System.out.println("  Product ID: " + productId);
        System.out.println("  Name: " + getNameList().get(productId-1));
        System.out.println("  Supplier: " + getSupplierList().get(productId-1));
        System.out.println("  Description: " + getDesList().get(productId-1));
        System.out.println("  ArrivalDate: " + getDateList().get(productId-1));
        System.out.println("  Weight Price: " + getWeightPriceList().get(productId-1));
        System.out.println("  Prepacked Bag Price (5kg): " + getprepacked5kgPriceList().get(productId-1));
        System.out.println("  Prepacked Bag Price (10kg): " + getprepacked10kgPriceList().get(productId-1));
    }

    
    public String toString(int productId)
    {
        String productDetails = 
            "\n   ID: " + productId +
            "\n   Name: " + getNameList().get(productId-1) +
            "\n   Supplier: " + getSupplierList().get(productId-1) +
            "\n   Description: " + getDesList().get(productId-1) + 
            "\n   ArrivalDate : " + getDateList().get(productId-1) +
            "\n   Weight Price: " + getWeightPriceList().get(productId-1) +
            "\n   Prepacked Bag Price (5kg): " +  getprepacked5kgPriceList().get(productId-1) +
            "\n   Prepacked Bag Price (10kg): " +  getprepacked10kgPriceList().get(productId-1);
        return productDetails;
    }
}

