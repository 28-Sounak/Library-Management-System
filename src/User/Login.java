package User;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame 
{

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton clearButton;
    private JButton exitButton;

    public Login() {

        setTitle("Library Management System");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 247, 250));
        panel.setLayout(null);

        JLabel title = new JLabel("Library Management System");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBounds(75, 25, 350, 35);
        panel.add(title);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        usernameLabel.setBounds(70, 90, 100, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(70, 115, 340, 35);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordLabel.setBounds(70, 165, 100, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 190, 340, 35);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(70, 250, 100, 35);

        clearButton = new JButton("Clear");
        clearButton.setBounds(190, 250, 100, 35);

        exitButton = new JButton("Exit");
        exitButton.setBounds(310, 250, 100, 35);

        panel.add(loginButton);
        panel.add(clearButton);
        panel.add(exitButton);

        JLabel forgot = new JLabel("Forgot Password?");
        forgot.setForeground(Color.BLUE);
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgot.setBounds(180, 300, 150, 25);
        panel.add(forgot);

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        exitButton.addActionListener(e -> System.exit(0));

        loginButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (username.equals("admin") && password.equals("admin")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        add(panel);
        setVisible(true);
    }
}