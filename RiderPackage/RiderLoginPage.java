package RiderPackage;

import AdminPackage.*;
import CustomerPackage.*;
import ReviewPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RiderLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, imageLabel;
    private JButton pathaoButton, foodiBdButton, ieatrayButton, jhinkuFoodBdButton, raihanExpressButton,backButton;
    private ImageIcon backgroundImageIcon;

    public RiderLoginPage() {
        setupRiderLoginPage();
    }

    private void setupRiderLoginPage() {
        container = this.getContentPane();
        container.setLayout(null);
		
		 Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to Rider Login Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        pathaoButton = createButton("Pathao", 40, 120, new Color(255, 87, 34)); 
        foodiBdButton = createButton("FoodiBd", 40, 190, new Color(34, 193, 195)); 
        ieatrayButton = createButton("IEatray", 40, 260, new Color(252, 140, 3)); 
        jhinkuFoodBdButton = createButton("Jhinku Food Bd", 40, 330, new Color(83, 109, 254)); 
        raihanExpressButton = createButton("Raihan Express", 40, 400, new Color(255, 82, 82)); 

        container.add(pathaoButton);
        container.add(foodiBdButton);
        container.add(ieatrayButton);
        container.add(jhinkuFoodBdButton);
        container.add(raihanExpressButton);


        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);
       
        backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
		
    }

    private JButton createButton(String text, int x, int y, Color buttonColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBounds(x, y, 250, 50);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(buttonColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(buttonColor, 2));
        button.addActionListener(e -> handleButtonClick(text));  
        return button;
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

    private void handleButtonClick(String buttonName) {
        if (buttonName.equals("Pathao")) {
            
            PathaoRider pathaoRiderPage = new PathaoRider();  
            pathaoRiderPage.setTitle("Pathao Rider Login");
            pathaoRiderPage.setSize(900, 600);
            pathaoRiderPage.setLocationRelativeTo(null);
            pathaoRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            pathaoRiderPage.setVisible(true);
			pathaoRiderPage.setResizable(false);


            this.setVisible(false);
        } else if (buttonName.equals("FoodiBd")) {
           
			 
			FoodIBdRider foodIBdRiderRiderPage = new FoodIBdRider();  
            foodIBdRiderRiderPage.setTitle("FoodIBd Rider Login");
            foodIBdRiderRiderPage.setSize(900, 600);
            foodIBdRiderRiderPage.setLocationRelativeTo(null);
            foodIBdRiderRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            foodIBdRiderRiderPage.setVisible(true);
			foodIBdRiderRiderPage.setResizable(false);
			
			this.setVisible(false);
		
        } else if (buttonName.equals("IEatray")) {
			
			IEatRayRider IEatRayRiderPage = new IEatRayRider();  
            IEatRayRiderPage.setTitle("Pathao Rider Login");
            IEatRayRiderPage.setSize(900, 600);
            IEatRayRiderPage.setLocationRelativeTo(null);
            IEatRayRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            IEatRayRiderPage.setVisible(true);
			IEatRayRiderPage.setResizable(false);
			
			this.setVisible(false);
			
		
        } else if (buttonName.equals("Jhinku Food Bd")) {
			
			JhinkuFoodBdRider JhinkuFoodBdRiderPage = new JhinkuFoodBdRider();  
            JhinkuFoodBdRiderPage.setTitle("Pathao Rider Login");
            JhinkuFoodBdRiderPage.setSize(900, 600);
            JhinkuFoodBdRiderPage.setLocationRelativeTo(null);
            JhinkuFoodBdRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            JhinkuFoodBdRiderPage.setVisible(true);
			JhinkuFoodBdRiderPage.setResizable(false);
			
			this.setVisible(false);
    
        } else if (buttonName.equals("Raihan Express")) {

            RaihanExpressFoodBdRider raihanExpressFoodBdRiderPage = new RaihanExpressFoodBdRider();  
            raihanExpressFoodBdRiderPage.setTitle("Pathao Rider Login");
            raihanExpressFoodBdRiderPage.setSize(900, 600);
            raihanExpressFoodBdRiderPage.setLocationRelativeTo(null);
            raihanExpressFoodBdRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            raihanExpressFoodBdRiderPage.setVisible(true);
			raihanExpressFoodBdRiderPage.setResizable(false);
			this.setVisible(false);
        }
    }
}

