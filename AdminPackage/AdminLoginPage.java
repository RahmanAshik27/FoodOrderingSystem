package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, imageLabel, footerLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;

   
public AdminLoginPage() {
        setupAdminPage();
    }

    private void setupAdminPage() {
        container = getContentPane();
        container.setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
		Font backFont = new Font("Arial",Font.BOLD, 16);
		Font welcomeFont = new Font("Arial",Font.BOLD, 30);
		Font boldFont = new Font("Arial",Font.BOLD, 18);
		
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
  
        welcomeLabel = new JLabel("Welcome to the Admin Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(360, 180, 120, 30);
        userLabel.setFont(boldFont);
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(480, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

       
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(360, 240, 120, 30);
        passwordLabel.setFont(boldFont);
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(480, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(730, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(this:: togglePasswordVisibility);
        container.add(eyeButton);

       
        loginButton = new JButton("Login");
        loginButton.setBounds(480, 310, 120, 40);
        loginButton.setFont(backFont);
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(this:: handleLogin);
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(620, 310, 120, 40);
        clearButton.setFont(backFont);
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(this:: clearFields);
        container.add(clearButton);	
		
		footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);

        imageLabel = new JLabel(new ImageIcon("FirstPage.png"));
        imageLabel.setBounds(100, 60, 250, 400);
        container.add(imageLabel);

        imageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

    private void togglePasswordVisibility(ActionEvent e) {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

    private void clearFields(ActionEvent e) {
        textField.setText("");
        passwordField.setText("");
    }

   
    private void handleLogin(ActionEvent e) {
        String username = textField.getText();
        String password = new String(passwordField.getPassword());
		ImageIcon blankImg = new ImageIcon("FillAllbox.png");

        ImageIcon okImg = new ImageIcon("okImg.png");
        ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
		
		    if (username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
			return;
			
			}
			
        if ("admin".equals(username) && "CGPA-4.00".equals(password)) {
            String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Please proceed to the Admin page.</div></html>";
            JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
			
			AdminDashboard dashboard = new AdminDashboard();
			dashboard.setTitle("Admin Dashboard");
			dashboard.setSize(900, 600);
			dashboard.setLocationRelativeTo(null);
			dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dashboard.setResizable(false);
			dashboard.setVisible(true);
			this.setVisible(false); 
        } else {
            String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
            JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
        }
    }

    
    private void goBack(ActionEvent e) {
      
        this.setVisible(false); 
        ProjectMainPage mainPage = new ProjectMainPage(); 
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}









