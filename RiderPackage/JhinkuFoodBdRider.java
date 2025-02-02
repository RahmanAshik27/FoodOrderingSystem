package RiderPackage;

import AdminPackage.*;
import CustomerPackage.*;
import ReviewPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class JhinkuFoodBdRider extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel,imageLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;
	private ImageIcon backgroundImageIcon;

public JhinkuFoodBdRider() {
        setupRiderPage();
    }

    private void setupRiderPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
        welcomeLabel = new JLabel("Hello, I am Mr.Jhiku Rider  ", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 180, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(160, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 240, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(415, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(e -> togglePasswordVisibility());
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 310, 120, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(e -> handleLogin(e));
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 310, 120, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(e -> clearFields());
        container.add(clearButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		 backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);;
    }

    private void togglePasswordVisibility() {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

 
    private void clearFields() {
        textField.setText("");
        passwordField.setText("");
    }

    

private void handleLogin(ActionEvent e) {
    String username = textField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon blankImg = new ImageIcon("FillAllbox.png");

    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
        return;
    }

    boolean isLoginSuccessful = false;

    
    try (BufferedReader reader = new BufferedReader(new FileReader("src/AdminPackage/JhinkuFoodBdRiderDetails.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
           
            String[] details = line.split(",");
            if (details.length >= 2) { 
                String fileUsername = details[0].trim();
                String filePassword = details[1].trim();

                if (username.equals(fileUsername) && password.equals(filePassword)) {
                    isLoginSuccessful = true;
                    break;
                }
            }
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, 
            "Error reading login details. Please contact support.", 
            "File Error", 
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (isLoginSuccessful) {
        String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Welcome to Jhinku Food Bd Rider Dashboard.</div></html>";
        JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
		
		 JhinkuFoodBdRiderDeliveryPage jhinkuFoodBdRiderDeliveryPage = new JhinkuFoodBdRiderDeliveryPage();
        jhinkuFoodBdRiderDeliveryPage.setTitle("Jhinku Food Bd Rider Food Delivery Page");
        jhinkuFoodBdRiderDeliveryPage.setSize(900, 600);
        jhinkuFoodBdRiderDeliveryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jhinkuFoodBdRiderDeliveryPage.setLocationRelativeTo(null);
        jhinkuFoodBdRiderDeliveryPage.setVisible(true);
        jhinkuFoodBdRiderDeliveryPage.setResizable(false);
		this.dispose();
		
    } else {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}


    private void goBack(ActionEvent e) {
        this.setVisible(false);
        RiderLoginPage mainPage = new RiderLoginPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}

