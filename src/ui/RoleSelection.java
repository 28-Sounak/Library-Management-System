package ui;

import java.awt.*;
import javax.swing.*;

public class RoleSelection extends JFrame 
{

    public RoleSelection() 
    {

        setTitle("Library Management System");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("Library Management System");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBounds(70, 30, 320, 30);

        JLabel label = new JLabel("Who is using the software?");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setBounds(110, 75, 220, 25);

        JButton customerButton = new JButton("Customer");
        customerButton.setBounds(140, 120, 150, 40);

        JButton librarianButton = new JButton("Librarian");
        librarianButton.setBounds(140, 180, 150, 40);

        customerButton.addActionListener(e -> {
            dispose();
            new Login("Customer");
        });

        librarianButton.addActionListener(e -> {
            dispose();
            new Login("Librarian");
        });

        panel.add(title);
        panel.add(label);
        panel.add(customerButton);
        panel.add(librarianButton);

        add(panel);
        setVisible(true);
    }
}