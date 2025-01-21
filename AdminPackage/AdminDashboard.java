package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, backgroundImageLabel, imageLabel;
    private JButton incomeStatementButton, inventoryButton, ridersDetailsButton, foodReviewsButton, itDepartmentButton, backButton;

public AdminDashboard() {
        setupDashboard();
    }

    private void setupDashboard() {
        container = getContentPane();
        container.setLayout(null);

        
        Font welcomeFont = new Font("Arial", Font.BOLD, 28);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font footerFont = new Font("Arial", Font.BOLD, 14);
		Font backFont = new Font("Arial",Font.BOLD, 16);
		Font boldFont = new Font("Arial", Font.BOLD, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the Admin Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

       
		incomeStatementButton = new JButton("Income Statement");
		incomeStatementButton.setBounds(550, 105, 250, 50);
		incomeStatementButton.setFont(buttonFont);
		incomeStatementButton.setBackground(new Color(50, 150, 255));
		incomeStatementButton.setForeground(Color.WHITE);
		incomeStatementButton.setCursor(cursor);
		incomeStatementButton.addActionListener(this::handleIncomeStatement);
		container.add(incomeStatementButton);


		inventoryButton = new JButton("Inventory");
		inventoryButton.setBounds(550, 180, 250, 50);
		inventoryButton.setFont(buttonFont);
		inventoryButton.setBackground(new Color(255, 99, 71)); 
		inventoryButton.setForeground(Color.WHITE);
		inventoryButton.setCursor(cursor);
		inventoryButton.addActionListener(this::handleInventory);
		container.add(inventoryButton);


		ridersDetailsButton = new JButton("Riders Details");
		ridersDetailsButton.setBounds(550, 255, 250, 50);
		ridersDetailsButton.setFont(buttonFont);
		ridersDetailsButton.setBackground(new Color(60, 179, 113)); 
		ridersDetailsButton.setForeground(Color.WHITE);
		ridersDetailsButton.setCursor(cursor);
		ridersDetailsButton.addActionListener(this::handleRidersDetails);
		container.add(ridersDetailsButton);


		foodReviewsButton = new JButton("Food Reviews");
		foodReviewsButton.setBounds(550, 330, 250, 50);
		foodReviewsButton.setFont(buttonFont);
		foodReviewsButton.setBackground(new Color(147, 112, 219)); 
		foodReviewsButton.setForeground(Color.WHITE);
		foodReviewsButton.setCursor(cursor);
		foodReviewsButton.addActionListener(this::handleFoodReviews);
		container.add(foodReviewsButton);


		itDepartmentButton = new JButton("Managemnet Department");
		itDepartmentButton.setBounds(525, 408, 300, 50);
		itDepartmentButton.setFont(buttonFont);
		itDepartmentButton.setBackground(new Color(178, 34, 34)); 
		itDepartmentButton.setForeground(Color.WHITE);
		itDepartmentButton.setCursor(cursor);
		itDepartmentButton.addActionListener(this::handleITDepartment);
		container.add(itDepartmentButton);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(10, 520, 880, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);

      
        imageLabel = new JLabel(new ImageIcon("FirstPage.png"));
        imageLabel.setBounds(100, 60, 250, 400);
        container.add(imageLabel);

        
        backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }

    
    private void handleIncomeStatement(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Income Statement Page is under construction.");
    }

    private void handleInventory(ActionEvent e) {
        InventoryOfFoodPage inventoryPage = new InventoryOfFoodPage();
        inventoryPage.setTitle("Food Delivery System");
        inventoryPage.setSize(900, 600);
        inventoryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPage.setLocationRelativeTo(null);
        inventoryPage.setVisible(true);
        inventoryPage.setResizable(false);
		this.setVisible(false);
    }

    private void handleRidersDetails(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Riders Details page are under construction .- IT Department");
    }

    private void handleFoodReviews(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Food Reviews page are under construction .- IT Department");
    }

    private void handleITDepartment(ActionEvent e) {
        
		ManagementDepartment managementDepartmentPage = new ManagementDepartment ();
        managementDepartmentPage.setTitle("Food Reviews Page");
        managementDepartmentPage.setSize(900, 600);
        managementDepartmentPage.setLocationRelativeTo(null);
        managementDepartmentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managementDepartmentPage.setVisible(true);
        managementDepartmentPage.setResizable(false);
		this.setVisible(false);
    }
	
	private void goBack(ActionEvent e) {
			
			AdminLoginPage adminPage = new AdminLoginPage();
            adminPage.setTitle("Admin Login Page");
            adminPage.setSize(900, 600); 
            adminPage.setLocationRelativeTo(null); 
            adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            adminPage.setVisible(true);
			adminPage.setResizable(false);
            this.setVisible(false);
    }

    
}
