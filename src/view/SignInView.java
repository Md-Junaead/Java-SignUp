package view;

import viewmodel.AuthViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInView {
    private JFrame frame;
    private AuthViewModel authViewModel;

    public SignInView() {
        authViewModel = new AuthViewModel();
        frame = new JFrame("Sign In");

        // Set window size
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Properly center the window
        frame.setLocationRelativeTo(null); // This centers the window on the screen

        frame.setVisible(true);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);

        // Center Panel (Login Form)
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Sign In", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centerPanel.add(titleLabel, gbc);

        // Email Field
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.BLACK);
        centerPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        centerPanel.add(emailField, gbc);

        // Password Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK);
        centerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        centerPanel.add(passwordField, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.RED);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(loginButton, gbc);

        // Forgot Password Link
        gbc.gridy = 4;
        JLabel forgotPasswordLabel = new JLabel("Forgot Password?", SwingConstants.CENTER);
        forgotPasswordLabel.setForeground(Color.RED);
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                new ForgotPasswordView();
            }
        });

        centerPanel.add(forgotPasswordLabel, gbc);

        // Sign-Up Link
        gbc.gridy = 5;
        JLabel signUpLabel = new JLabel("Don't have an account? Sign Up", SwingConstants.CENTER);
        signUpLabel.setForeground(Color.RED);
        signUpLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                new SignUpView();
            }
        });

        centerPanel.add(signUpLabel, gbc);

        // Add Center Panel to Main Panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Login Button Click
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authViewModel.login(emailField.getText(), new String(passwordField.getPassword()));
            }
        });
    }
}