package DashboardPackage;

import AdminPackage.*;
import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;

import javax.swing.*;
import java.awt.*;


public class ProjectMainPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, imageLabel;
    private JButton adminLoginButton, customersLoginButton, foodReviewsButton, riderLoginButton, foodPolicyButton;

    public ProjectMainPage() {
        setupMainPage();
    }

    private void setupMainPage() {
        container = this.getContentPane();
        container.setLayout(null);

        welcomeLabel = new JLabel("Welcome to the Food Delivery System", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        adminLoginButton = createButton("Admin Login", 500, 120);
        adminLoginButton.addActionListener(e -> handleButtonClick("Admin Login"));

        customersLoginButton = createButton("Customer Login", 500, 190);
        customersLoginButton.addActionListener(e -> handleCustomersButtonClick("Customer Login"));
	
        foodReviewsButton = createButton("Food Reviews", 500, 260);
		foodReviewsButton.addActionListener(e -> handleFoodReviewButtonClick("Food Reviews"));
		
        riderLoginButton = createButton("Rider Login", 500, 330);
		riderLoginButton.addActionListener(e -> handleRiderLoginButtonClick("Rider Login"));
		
		
        foodPolicyButton = createButton("Food Policy", 30, 480);

        container.add(adminLoginButton);
        container.add(customersLoginButton);
        container.add(foodReviewsButton);
        container.add(riderLoginButton);
        container.add(foodPolicyButton);
		 
        imageLabel = new JLabel(new ImageIcon("FirstPage.png"));
        imageLabel.setBounds(100, 60, 250, 400);
        container.add(imageLabel);

        imageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBounds(x, y, 250, 50);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void handleButtonClick(String buttonName) {
        if (buttonName.equals("Admin Login")) {
			
            AdminLoginPage adminPage = new AdminLoginPage();
            adminPage.setTitle("Admin Login Page");
            adminPage.setSize(900, 600); 
            adminPage.setLocationRelativeTo(null); 
            adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            adminPage.setVisible(true);
			adminPage.setResizable(false);
            this.setVisible(false);
        } else {
            System.out.println(buttonName + " button clicked.");
        }
    }

    private void handleCustomersButtonClick(String buttonName) {
        if (buttonName.equals("Customer Login")) {
			
            CustomerLoginPage loginPage = new CustomerLoginPage();
            loginPage.setTitle("Customer Login");
            loginPage.setSize(900, 600);
            loginPage.setLocationRelativeTo(null);
            loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginPage.setVisible(true);
			loginPage.setResizable(false);
            this.setVisible(false);
        } else {
            System.out.println(buttonName + " button clicked.");
        }
	}
	
		private void handleRiderLoginButtonClick(String buttonName) {
        if (buttonName.equals("Rider Login")) {
			
            RiderLoginPage loginPage = new RiderLoginPage();
            loginPage.setTitle("Rider Login");
            loginPage.setSize(900, 600);
            loginPage.setLocationRelativeTo(null);
            loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginPage.setVisible(true);
			loginPage.setResizable(false);
            this.setVisible(false);
        } else {
            System.out.println(buttonName + " button clicked.");
        }
    }
	
	private void handleFoodReviewButtonClick(String buttonName) {
        if (buttonName.equals("Food Reviews")) {
			
			ReviewsFoodPage foodReviewsPage = new ReviewsFoodPage();
			foodReviewsPage.setTitle("Food Reviews Page");
			foodReviewsPage.setSize(900, 600);
			foodReviewsPage.setLocationRelativeTo(null);
			foodReviewsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			foodReviewsPage.setVisible(true);
			foodReviewsPage.setResizable(false);
		
			this.setVisible(false);
			} else {
            System.out.println(buttonName + " button clicked.");
			}
			       
    }	
}
