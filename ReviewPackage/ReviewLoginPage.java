package ReviewPackage;

import AdminPackage.*;
import CustomerPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReviewLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel, messageLabel, imageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;

    public ReviewLoginPage() {
        setupReviewLoginPage();
    }

    private void setupReviewLoginPage() {
        container = getContentPane();
        container.setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the Review Login Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

       
        userLabel = new JLabel("Username:");
        userLabel.setBounds(360, 180, 110, 30);
        userLabel.setFont(boldFont);
        userLabel.setForeground(Color.WHITE);
        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(480, 170, 250, 40);
        usernameField.setFont(labelFont);
        container.add(usernameField);

     
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(360, 240, 110, 30);
        passwordLabel.setFont(boldFont);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(480, 230, 250, 40);
        passwordField.setFont(labelFont);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(730, 230, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(this::togglePasswordVisibility);
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(480, 310, 120, 40);
        loginButton.setFont(backFont);
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(this::handleLogin);
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(620, 310, 120, 40);
        clearButton.setFont(backFont);
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(this::clearFields);
        container.add(clearButton);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        JLabel footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);

        messageLabel = new JLabel("Your opinion is valuable to us", JLabel.CENTER);
        messageLabel.setBounds(220, 450, 460, 40);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(messageLabel);
		
		imageLabel = new JLabel(new ImageIcon("Thinking Cat.png"));
        imageLabel.setBounds(94, 95, 250, 400);
        container.add(imageLabel);

        imageLabel = new JLabel(new ImageIcon("Review.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

private void handleLogin(ActionEvent e) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon okImg = new ImageIcon("okImg.png");
    String result = checkCredentials(username, password);

    if (result.equals("SUCCESS")) {
        JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);

        this.setVisible(false);
        GiveReviewService page = new GiveReviewService(username);
        page.setTitle("Food Ordering System");
        page.setSize(900, 600);
        page.setLocationRelativeTo(null);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true);
        page.setResizable(false);
    } else if (result.equals("INCORRECT_PASSWORD")) {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    } else {
        String errorMessage = "You do not have an account in our food service.";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}





private String checkCredentials(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/AdminPackage/users.txt"))) {
        String line;
        boolean userFound = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                String fileUsername = parts[0].trim();
                String filePassword = parts[1].trim();

                if (username.equals(fileUsername)) {
                    userFound = true;
                    if (password.equals(filePassword)) {
                        return "SUCCESS"; 
                    } else {
                        return "INCORRECT_PASSWORD"; 
                    }
                }
            }
        }
        if (!userFound) {
            return "INCORRECT_USERNAME"; 
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading user file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return "ERROR"; 
}


    private void togglePasswordVisibility(ActionEvent e) {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

    private void clearFields(ActionEvent e) {
        usernameField.setText("");
        passwordField.setText("");
    }

    private void goBack(ActionEvent e) {
        this.setVisible(false);
        ReviewsFoodPage foodReviewsPage = new ReviewsFoodPage();
        foodReviewsPage.setTitle("Food Reviews Page");
        foodReviewsPage.setSize(900, 600);
        foodReviewsPage.setLocationRelativeTo(null);
        foodReviewsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        foodReviewsPage.setVisible(true);
        foodReviewsPage.setResizable(false);
    }

}
