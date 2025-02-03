package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RiderPageDetails extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, imageLabel;
    private JButton pathaoButton, foodiBdButton, ieatrayButton, jhinkuFoodBdButton, raihanExpressButton,backButton;
    private ImageIcon backgroundImageIcon;

    public RiderPageDetails() {
        setupRiderPageDetails();
    }

    private void setupRiderPageDetails() {
        container = this.getContentPane();
        container.setLayout(null);
		
		Font boldFont = new Font("Arial", Font.BOLD, 18);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to Rider Management Page", JLabel.CENTER);
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
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

       
        backgroundImageIcon = new ImageIcon("Src_ImageStore/RiderLogin.png");
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

    private void handleButtonClick(String buttonName) {
        if (buttonName.equals("Pathao")) {
			
			this.setVisible(false); 
			PathaoRiderDetails pathaoRiderDetails = new PathaoRiderDetails();
			pathaoRiderDetails.setTitle("Customer Login");
			pathaoRiderDetails.setSize(900, 600);
			pathaoRiderDetails.setLocationRelativeTo(null);
			pathaoRiderDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pathaoRiderDetails.setVisible(true);
			 
        } else if (buttonName.equals("FoodiBd")) {

			this.setVisible(false); 
			FoodiBdDetails foodiBdDetails = new FoodiBdDetails();
			foodiBdDetails.setTitle("Customer Login");
			foodiBdDetails.setSize(900, 600);
			foodiBdDetails.setLocationRelativeTo(null);
			foodiBdDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			foodiBdDetails.setVisible(true);
		 
        } else if (buttonName.equals("IEatray")) {
			
			this.setVisible(false);
			IEatrayDetails iEatrayDetails = new IEatrayDetails();
			iEatrayDetails.setTitle("Customer Login");
			iEatrayDetails.setSize(900, 600);
			iEatrayDetails.setLocationRelativeTo(null);
			iEatrayDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			iEatrayDetails.setVisible(true);
		
        } else if (buttonName.equals("Jhinku Food Bd")) {
			
			this.setVisible(false);
			JhinkuFoodBdDetails jhinkuFoodBdRiderDetails = new JhinkuFoodBdDetails();
			jhinkuFoodBdRiderDetails.setTitle("JhinkuFoodBd Rider Details");
			jhinkuFoodBdRiderDetails.setSize(900, 600);
			jhinkuFoodBdRiderDetails.setLocationRelativeTo(null);
			jhinkuFoodBdRiderDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jhinkuFoodBdRiderDetails.setVisible(true);

        } else if (buttonName.equals("Raihan Express")) {

			
			this.setVisible(false);
            
			RaihanExpressDetails raihanExpressBdRiderDetails = new RaihanExpressDetails();
			raihanExpressBdRiderDetails.setTitle("RaihanExpressBd Rider Details");
			raihanExpressBdRiderDetails.setSize(900, 600);
			raihanExpressBdRiderDetails.setLocationRelativeTo(null);
			raihanExpressBdRiderDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			raihanExpressBdRiderDetails.setVisible(true);	
		
        }
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
}