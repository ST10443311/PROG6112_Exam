package pkg10443311_prog6112_exam.tests;

import org.junit.jupiter.api.Test;
import pkg10443311_prog6112_exam.MovieTickets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTicketTests {
    
    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales() {
        MovieTickets movieTickets = new MovieTickets();
        int[] sales = {3000, 1500, 1700};
        int expectedTotal = 6200;
        assertEquals(expectedTotal, movieTickets.TotalMovieSales(sales));
    }

    @Test
    public void TopMovieSales_ReturnsTopMovie() {
        MovieTickets movieTickets = new MovieTickets();
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};  // Oppenheimer has higher sales
        String expectedTopMovie = "Oppenheimer";
        assertEquals(expectedTopMovie, movieTickets.TopMovie(movies, totalSales));
    }
}
