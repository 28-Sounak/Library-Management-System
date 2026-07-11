package ui;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame 
{

    private final String role;

    public Login(String role) 
    {

        this.role = role;

        setTitle(role + " Login");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel(role + " Login");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBounds(170, 20, 200, 30);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(60, 80, 100, 25);

        JTextField username = new JTextField();
        username.setBounds(60, 105, 360, 35);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(60, 155, 100, 25);

        JPasswordField password = new JPasswordField();
        password.setBounds(60, 180, 360, 35);

        JButton login = new JButton("Login");
        login.setBounds(60, 250, 100, 35);

        JButton clear = new JButton("Clear");
        clear.setBounds(190, 250, 100, 35);

        JButton back = new JButton("Back");
        back.setBounds(320, 250, 100, 35);

        clear.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });

        back.addActionListener(e -> {
            dispose();
            new RoleSelection();
        });

        login.addActionListener(e -> {

            dispose();

            if(role.equals("Customer"))
                new CustomerHome();
            else
                new LibrarianHome();

        });

        panel.add(title);
        panel.add(userLabel);
        panel.add(username);
        panel.add(passLabel);
        panel.add(password);
        panel.add(login);
        panel.add(clear);
        panel.add(back);

        add(panel);
        setVisible(true);
    }
}