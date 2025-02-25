package viewmodel;

import javax.swing.*;

public class AuthViewModel {

    public void login(String email, String password) {
        // Simulated authentication check
        if (email.equals("admin@example.com") && password.equals("password123")) {
            JOptionPane.showMessageDialog(null, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Email or Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void forgotPassword(String email) {
        JOptionPane.showMessageDialog(null, "Password reset link sent to " + email);
    }

    public void signUp(String name, String email, String password) {
        JOptionPane.showMessageDialog(null, "Account Created Successfully for " + name);
    }
}