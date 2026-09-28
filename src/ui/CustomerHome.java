package ui;

import java.awt.*;
import javax.swing.*;

public class CustomerHome extends JFrame
{
    public CustomerHome()
    {
        setTitle("Customer Home");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Header
        HeaderPanel header = new HeaderPanel("Sounak");

        add(header, BorderLayout.NORTH);


        // Main body
        CustomerDashboardPanel dashboard = new CustomerDashboardPanel();

        add(dashboard, BorderLayout.CENTER);


        // Maximize
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }
}