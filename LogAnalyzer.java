/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */

/**
 * Q1. The busiest time of the day is at 18:00.
 * 
 * Q2. private int[] people;
 * 
 * Q3. private boolean[] vacant;
 * 
 * Q4. "hourCounts" is used in the LogAnalyser and two of the methods, analyzeHourlyData and printHourlyData.
 * 
 * Q5. The square brackets in front of "int" in the Array "counts" should be place after it.
 *     The Array "occupied" should not contain size.
 *     
 *     Corrected version:
 *     private int[] counts; 
 *     private boolean[] occupied;
 *     (...)
 *     occupied = new boolean[5000];
 *     
 * Q6. private double[] readings;
 *     private String[] urls;
 *     private TicketMachine[] machines;
 *     
 *     public exemple()
 *     { 
 *         readings = new double[60];
 *         urls = new String[90];
 *         machines = new double[5];
 *     }
 *     
 * Q7. String[] labels = new String[20];
 *     There is a total 20 String objects will be created.
 *     
 * Q8. It should be using square brackets instead of parentheses.
 *     Corrected version: double[] prices = new double[50];
 * 
 * Q9. An error occurs due to the fact
 *     To fix it, a "-1" will need to be added in the condition
 * 
 *     Error message:
 *     java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 24
 *     at LogAnalyzer.printHourlyCounts(LogAnalyzer.java:103)
 * 
 * Q10. for(int hour = 0; hour <= hourCounts.length - 1; hour++) {
 *          System.out.println(hour + ": " + hourCounts[hour]);
 *      }
 * 
 */

public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    //private int[] people; //Q2
    //private boolean[] vacant; //Q3
    //private int[] counts; //Q5
    //private boolean[] occupied; //Q5
    //double[] readings; //Q6
    //private String[] urls; //Q6
    //private TicketMachine[] machines; //Q6

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename) //Q12
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        
        //occupied = new boolean[5000]; //Q5
        //readings = new double[60]; //Q6
        //urls = new String[90]; //Q6
        //double[] prices = new double[50]; //Q8
        
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename); //Q12
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        /** 
        // Original version
        for(int hour = 0; hour < hourCounts.length; hour++) { 
            System.out.println(hour + ": " + hourCounts[hour]);
        }
        */
        for(int hour = 0; hour <= hourCounts.length - 1; hour++) { //Q10
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    //Q11
    public void printGreater(double[] marks, double mean) 
    {
        int index;
        for(index = 0; index <= marks.length - 1; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            }
        }
    }
}
