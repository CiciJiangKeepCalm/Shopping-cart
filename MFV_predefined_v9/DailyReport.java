import java.util.*;
/**
 * Generate daily report
 * @ Team 126
 * @ version (11/10/2018)
 */
public class DailyReport
{
    public ArrayList<String> adminIdList;
    public ArrayList<String> adminNameList;
    public ArrayList<String> dateList;
    public ArrayList<Double> priceList;
    public ArrayList<Boolean> feedbackList;
    public double totalRevenue;
    public int totalThumbsUp;
    public int totalThumbsDown;

    
    public DailyReport()
    {
        adminIdList = new ArrayList<String>();
        adminIdList.add("a12");
        adminIdList.add("a12");
        adminIdList.add("a25");
        adminIdList.add("a25");
        adminIdList.add("a03");
        
        adminNameList = new ArrayList<String>();
        adminNameList.add("Ray");
        adminNameList.add("Ray");
        adminNameList.add("Frank");
        adminNameList.add("Frank");
        adminNameList.add("Cindy");
        
        dateList = new ArrayList<String>();
        dateList.add("2018-10-10");
        dateList.add("2018-10-10");
        dateList.add("2018-10-11");
        dateList.add("2018-10-11");
        dateList.add("2018-10-11");
        
        priceList = new ArrayList<Double>();
        priceList.add(45.5);
        priceList.add(50.0);
        priceList.add(205.5);
        priceList.add(65.0);
        priceList.add(100.0);
        
        feedbackList = new ArrayList<Boolean>();
        feedbackList.add(true);
        feedbackList.add(false);
        feedbackList.add(true);
        feedbackList.add(true);
        feedbackList.add(true);
        
        totalRevenue = 0.00;
        totalThumbsUp = 0;
        totalThumbsDown = 0;
    } 
    
    
    public void addToDailyReport(String adminId, String adminName, String date, double price, boolean feedback)
    {
        adminIdList.add(adminId); // add admin id into adminId list
        adminNameList.add(adminName); // add admin name into adminName list
        dateList.add(date); // add date into date list
        priceList.add(price); // add price into price list
        feedbackList.add(feedback); // add feedback into feedback list
    }
    
    
    public void viewDailyReport(String date)
    {
        int countSameAdmin = 1;
        Double adminRevenue = 0.00;
        int adminUp = 0;
        int adminDown = 0;
        String id = "";
        String name = "";
        String admin = "";
        for(int i=0; i<dateList.size(); i++)
        {
            if(dateList.get(i).equals(date)) // if date is the same as input
            {
                if(i != dateList.size()-1) // if not the last index
                {
                    if(adminIdList.get(i) == adminIdList.get(i+1)) // get the same admin info
                    {
                        adminRevenue += priceList.get(i);
                        if(feedbackList.get(i) == true)
                        {
                            adminUp+=1;
                        }
                        else
                        {
                            adminDown+=1;
                        }
                    }
                    else
                    {
                        adminRevenue += priceList.get(i);
                        if(feedbackList.get(i) == true)
                        {
                            adminUp+=1;
                        }
                        else
                        {
                            adminDown+=1;
                        }
                        String adminResult = // each admin daily report
                            "\n----- Report Detail (each admin) -----" + 
                            "\n   Date: " + date +
                            "\n   Admin Id: " + adminIdList.get(i) +
                            "\n   Admin Name: " + adminNameList.get(i) +
                            "\n   Total Revenue: " + adminRevenue +
                            "\n   Total Thumbs Up: " + adminUp +
                            "\n   Total Thumbs Down: " + adminDown;
                        System.out.println(adminResult);
                        adminRevenue = 0.00;
                        adminUp = 0;
                        adminDown = 0;
                    }
                }
                else
                {
                    adminRevenue += priceList.get(i);
                    if(feedbackList.get(i) == true)
                    {
                        adminUp+=1;
                    }
                    else
                    {
                        adminDown+=1;
                    }
                    String adminResult = // each admin daily report
                        "\n----- Report Detail (each admin) -----" + 
                        "\n   Date: " + date +
                        "\n   Admin Id: " + adminIdList.get(i) +
                        "\n   Admin Name: " + adminNameList.get(i) +
                        "\n   Total Revenue: " + adminRevenue +
                        "\n   Total Thumbs Up: " + adminUp +
                        "\n   Total Thumbs Down: " + adminDown;
                    System.out.println(adminResult);
                    adminRevenue = 0.00;
                    adminUp = 0;
                    adminDown = 0;
                }
                
                totalRevenue += priceList.get(i);
                if(feedbackList.get(i) == true)
                {
                    totalThumbsUp+=1;
                }
                else
                {
                    totalThumbsDown+=1;
                }
            }
        }
        
        String result = 
            "\n----- Report Detail (total) -----" + 
            "\n   Date: " + date +
            "\n   Total Revenue: " + totalRevenue +
            "\n   Total Thumbs Up: " + totalThumbsUp +
            "\n   Total Thumbs Down: " + totalThumbsDown;
        System.out.println(result);
        
        totalRevenue = 0.00;
        totalThumbsUp = 0;
        totalThumbsDown = 0;
    }
}