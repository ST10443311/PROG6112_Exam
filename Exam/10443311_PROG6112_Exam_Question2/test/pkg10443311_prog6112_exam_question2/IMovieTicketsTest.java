
package pkg10443311_prog6112_exam_question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IMovieTicketsTest {
    
    public IMovieTicketsTest() {
    }

    @Test
    public void testCalculateTotalTicketPrice_CalculatedSuccessfully() {
        // Arrange
        int numberOfTickets = 3;
        double ticketPrice = 100.0;
        double expectedTotal = 300.0;
        
        // Act
        double actualTotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        
        // Assert
        assertEquals("Total ticket price should be calculated correctly", 
                    expectedTotal, actualTotal, 0.01);
    }

    @Test
    public void testValidateData() {
    }

    public class IMovieTicketsImpl implements IMovieTickets {

        public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
            return 0.0;
        }

        public boolean ValidateData(MovieTicketData movieTicketData) {
            return false;
        }
    }
    
}
