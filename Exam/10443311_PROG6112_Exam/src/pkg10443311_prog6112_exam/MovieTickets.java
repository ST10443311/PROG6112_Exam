
package pkg10443311_prog6112_exam;

import java.util.stream.IntStream;

public class MovieTickets implements IMovieTickets {

    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        return IntStream.of(movieTicketSales).sum();
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int maxSales = totalSales[0];
        int topIndex = 0;
        
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topIndex = i;
            }
        }
        return movies[topIndex];
    }
}
