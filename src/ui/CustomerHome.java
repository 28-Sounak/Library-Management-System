package ui;

import java.awt.*;
import javax.swing.*;

public class CustomerHome extends JFrame 
{

    public CustomerHome() 
    {

        setTitle("Customer Home");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, Customer", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 28));

        add(label);

        setVisible(true);
    }
}