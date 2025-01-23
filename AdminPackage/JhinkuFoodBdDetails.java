package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class JhinkuFoodBdDetails extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel,imageLabel, footerLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton, createAccountButton;
    private JCheckBox showPasswordCheckBox;

    
    public JhinkuFoodBdDetails() {
        setupJhinkuFoodBdRiderDetails();
    }

    private void setupJhinkuFoodBdRiderDetails() {
        
		container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the JhinkuFoodBd Rider Managemnet Page", JLabel.CENTER);
        welcomeLabel.setBounds(100, 20, 700, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(10, 15, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
		backButton.addActionListener(this::goBack);
        container.add(backButton);

        loginButton = new JButton("Jhinku FoodBd Rider Details");
        loginButton.setBounds(100, 200, 400, 60);
        loginButton.setFont(new Font("Arial", Font.BOLD, 24));
        loginButton.setBackground(new Color(255, 99, 71));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        container.add(loginButton);


        createAccountButton = new JButton("Add New Rider");
        createAccountButton.setBounds(180, 270, 250, 60);
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 24));
        createAccountButton.setBackground(new Color(34, 139, 34));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setCursor(cursor);
        createAccountButton.addActionListener(this::openCreateAccountPage);
        container.add(createAccountButton);
	
		
        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(600, 520, 280, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        footerLabel.setForeground(Color.BLACK);
		 footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(255, 255, 255, 150));
        container.add(footerLabel);
		
		 imageLabel = new JLabel(new ImageIcon("RiderLogin.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

   private void goBack(ActionEvent e) {
			
			AdminDashboard dashboard = new AdminDashboard();
			dashboard.setTitle("Admin Dashboard");
			dashboard.setSize(900, 600);
			dashboard.setLocationRelativeTo(null);
			dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dashboard.setResizable(false);
			dashboard.setVisible(true);
			this.setVisible(false); 
    }
	
    private void openCreateAccountPage(ActionEvent e) {
        this.setVisible(false);
        
		CreateAccountForJhinkuFoodBdPage createAccountForJhinkuFoodBdPage = new CreateAccountForJhinkuFoodBdPage();
        createAccountForJhinkuFoodBdPage.setTitle("Create Account");
        createAccountForJhinkuFoodBdPage.setSize(900, 600);
        createAccountForJhinkuFoodBdPage.setLocationRelativeTo(null);
        createAccountForJhinkuFoodBdPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccountForJhinkuFoodBdPage.setVisible(true);
    }
}