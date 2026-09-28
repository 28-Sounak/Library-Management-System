package ui;

import java.awt.*;

import javax.swing.*;

public class HeaderPanel extends JPanel
{
    public HeaderPanel(String customerName)
    {
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(0, 70));

        //Left Side - Application Title

        setBackground(new Color(30, 30, 30));

        JLabel title = new JLabel("Library Management System");

        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        title.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        //Right Side

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 15));

        rightPanel.setOpaque(false);

        JLabel welcome = new JLabel("Welcome, " + customerName);

        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        welcome.setForeground(Color.WHITE);

        JButton logoutButton = new JButton("Logout");

        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        logoutButton.setFocusPainted(false);

        rightPanel.add(welcome);

        rightPanel.add(logoutButton);

        //Add Components

        add(title, BorderLayout.WEST);

        add(rightPanel, BorderLayout.EAST);
    }
}