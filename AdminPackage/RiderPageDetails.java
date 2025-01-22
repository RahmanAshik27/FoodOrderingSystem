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
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
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

    private void handleButtonClick(String buttonName) {
        if (buttonName.equals("Pathao")) {

			JOptionPane.showMessageDialog(this, "IT Department page are under construction .- IT Department");
			 
        } else if (buttonName.equals("FoodiBd")) {

			JOptionPane.showMessageDialog(this, "IT Department page are under construction .- IT Department");
		 
        } else if (buttonName.equals("IEatray")) {
		
			JOptionPane.showMessageDialog(this, "IT Department page are under construction .- IT Department");
		
        } else if (buttonName.equals("Jhinku Food Bd")) {
		
			JOptionPane.showMessageDialog(this, "IT Department page are under construction .- IT Department");

        } else if (buttonName.equals("Raihan Express")) {

			JOptionPane.showMessageDialog(this, "IT Department page are under construction .- IT Department");		
		
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