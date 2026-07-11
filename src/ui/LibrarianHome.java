package ui;

import java.awt.*;
import javax.swing.*;

public class LibrarianHome extends JFrame 
{

    public LibrarianHome() 
    {

        setTitle("Librarian Home");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, Librarian", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 28));

        add(label);

        setVisible(true);
    }
}