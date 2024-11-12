package pkg10443311_prog6112_exam_question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface IMovieTickets {
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean ValidateData(MovieTicketData movieTicketData);
}

class MovieTicketData {
    String movieName;
    int numberOfTickets;
    double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }
}

public class Main extends JFrame implements IMovieTickets {
    private JComboBox<String> movieComboBox;
    private JTextField numberOfTicketsField;
    private JTextField ticketPriceField;
    private JTextArea reportArea;

    public Main() {
        // Set up the JFrame
        setTitle("MOVIE TICKETS");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem processMenuItem = new JMenuItem("Process");
        JMenuItem clearMenuItem = new JMenuItem("Clear");

        exitMenuItem.addActionListener(e -> System.exit(0));
        processMenuItem.addActionListener(e -> processTicket());
        clearMenuItem.addActionListener(e -> clearFields());

        fileMenu.add(exitMenuItem);
        toolsMenu.add(processMenuItem);
        toolsMenu.add(clearMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        JLabel movieLabel = new JLabel("MOVIE:");
        movieLabel.setBounds(20, 20, 100, 25);
        mainPanel.add(movieLabel);

        movieComboBox = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        movieComboBox.setBounds(160, 20, 200, 25);
        mainPanel.add(movieComboBox);

        JLabel ticketsLabel = new JLabel("NUMBER OF TICKETS:");
        ticketsLabel.setBounds(20, 60, 140, 25);
        mainPanel.add(ticketsLabel);

        numberOfTicketsField = new JTextField();
        numberOfTicketsField.setBounds(160, 60, 200, 25);
        mainPanel.add(numberOfTicketsField);

        JLabel priceLabel = new JLabel("TICKET PRICE:");
        priceLabel.setBounds(20, 100, 100, 25);
        mainPanel.add(priceLabel);

        ticketPriceField = new JTextField();
        ticketPriceField.setBounds(160, 100, 200, 25);
        mainPanel.add(ticketPriceField);

        JLabel reportLabel = new JLabel("TICKET REPORT:");
        reportLabel.setBounds(20, 140, 100, 25);
        mainPanel.add(reportLabel);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        scrollPane.setBounds(20, 170, 340, 150);
        mainPanel.add(scrollPane);

        setVisible(true);
    }

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        return numberOfTickets * ticketPrice;
    }

    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        return movieTicketData.movieName != null && !movieTicketData.movieName.isEmpty() &&
               movieTicketData.numberOfTickets > 0 &&
               movieTicketData.ticketPrice > 0;
    }

    private void processTicket() {
        try {
            String movie = (String) movieComboBox.getSelectedItem();
            int numberOfTickets = Integer.parseInt(numberOfTicketsField.getText());
            double ticketPrice = Double.parseDouble(ticketPriceField.getText());

            MovieTicketData ticketData = new MovieTicketData(movie, numberOfTickets, ticketPrice);

            if (!ValidateData(ticketData)) {
                JOptionPane.showMessageDialog(this, "Please enter valid data.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalPrice = CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
            double finalPrice = totalPrice * 1.14;
            
            reportArea.setText(
                String.format("MOVIE NAME: %s\n" +
                            "MOVIE TICKET PRICE: R %.1f\n" +
                            "NUMBER OF TICKETS: %d\n" +
                            "TOTAL TICKET PRICE: R %.1f",
                            movie, ticketPrice, numberOfTickets, finalPrice)
            );
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for tickets and price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        movieComboBox.setSelectedIndex(0);
        numberOfTicketsField.setText("");
        ticketPriceField.setText("");
        reportArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}