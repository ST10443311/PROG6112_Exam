package pkg10443311_prog6112_exam;

public class Main {
public static void main(String[] args) {
        
    // Declarations
        String[] movieNames = {"Napoleon", "Oppenheimer"};
        int[][] ticketSales = {{3000, 1500, 1700},  // Napoleon sales
                               {3500, 1200, 1600}}; // Oppenheimer sales
        MovieTickets movieTickets = new MovieTickets();
        
        //Calculates total sales for each movie
        int totalNapoleon = movieTickets.TotalMovieSales(ticketSales[0]);
        int totalOppenheimer = movieTickets.TotalMovieSales(ticketSales[1]);
        
        int[] totalSales = {totalNapoleon, totalOppenheimer};
        
    // Process
        System.out.print("MOVIE TICKET SALES REPORT - 2024"
                        + "\n\t\t\t\tJAN\t\t\tFEB\t\t\tMAR"
                        + "\n------------------------------------------------------------------------------------------------"
        );
        
        // Display all the sales data
        for (int i = 0; i < movieNames.length; i++) {
            System.out.print("\n" + movieNames[i]);
            for (int j = 0; j < ticketSales[i].length; j++) {
                System.out.print("\t\t\t" + ticketSales[i][j]);
            }
        }        
        
        System.out.println("\n\nTotal movie ticket sales for Napoleon: " + totalNapoleon
                         + "\nTotal movie ticket sales for Oppenheimer: " + totalOppenheimer);
        
        // Determine the top-performing movie
        String topPerforming = movieTickets.TopMovie(movieNames, totalSales);
        System.out.println("\nTop performing movie: " + topPerforming);
    }
}
