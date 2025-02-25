package view;

import viewmodel.AuthViewModel;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordView {
    private JFrame frame;
    private AuthViewModel authViewModel;

    public ForgotPasswordView() {
        authViewModel = new AuthViewModel();
        frame = new JFrame("Forgot Password");

        // Set window size
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Properly center the window
        frame.setLocationRelativeTo(null); // This centers the window on the screen

        frame.setVisible(true);

        // Main Panel with Margin
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));
        wrapperPanel.setBackground(Color.WHITE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Forgot Password", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Email Label & Field
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel emailLabel = new JLabel("Enter your Email:");
        emailLabel.setForeground(Color.BLACK);
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Submit Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.RED);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(submitButton, gbc);

        // Back to Sign-In
        gbc.gridy = 3;
        JLabel backToLoginLabel = new JLabel("Back to Sign In", SwingConstants.CENTER);
        backToLoginLabel.setForeground(Color.RED);
        backToLoginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backToLoginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                new SignInView();
            }
        });

        panel.add(backToLoginLabel, gbc);

        wrapperPanel.add(panel, BorderLayout.CENTER);
        frame.add(wrapperPanel);
        frame.setVisible(true);

        // Submit button click event
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authViewModel.forgotPassword(emailField.getText());
            }
        });
    }
}