package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ManagementDepartment extends JFrame {
    private Container container;
    private JLabel instructionLabel, managementLabel, itDepartmentLabel, messageLabel, backgroundImageLabel,imageLabel;
    private JButton managementButton, itDepartmentButton, backButton;

    public ManagementDepartment() {
        setupmanagementDepartment();
    }

    private void setupmanagementDepartment() {
        
		container = getContentPane();
        container.setLayout(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Font instructionFont = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font largeLabelFont = new Font("Arial", Font.BOLD, 20);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(labelFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
		backButton.addActionListener(this::goBack);
        container.add(backButton);

        instructionLabel = new JLabel("Welcome To Management department Page", JLabel.CENTER);
        instructionLabel.setBounds(200, 50, 600, 50);
        instructionLabel.setFont(instructionFont);
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setOpaque(true);
        instructionLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(instructionLabel);

        managementButton = new JButton("Management page ");
        managementButton.setBounds(350, 200, 280, 60);  
        managementButton.setFont(buttonFont);
        managementButton.setBackground(new Color(34, 139, 34));
        managementButton.setForeground(Color.WHITE);
        managementButton.setCursor(cursor);
		managementButton.addActionListener(this::openManagemnetDepartment);
        container.add(managementButton);

        managementLabel = new JLabel("Where Inventory are Created", JLabel.CENTER);
        managementLabel.setBounds(620, 210, 250, 40);  
        managementLabel.setFont(labelFont);
        managementLabel.setForeground(Color.WHITE);
        managementLabel.setOpaque(true);
        managementLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(managementLabel);

        itDepartmentButton = new JButton("IT Department");
        itDepartmentButton.setBounds(390, 300, 200, 60); 
        itDepartmentButton.setFont(buttonFont);
        itDepartmentButton.setBackground(new Color(255, 69, 0));
        itDepartmentButton.setForeground(Color.WHITE);
        itDepartmentButton.setCursor(cursor);
		itDepartmentButton.addActionListener(this::openItDepartment);
        container.add(itDepartmentButton);


        itDepartmentLabel = new JLabel("Wanna Add Something New ?", JLabel.CENTER);
        itDepartmentLabel.setBounds(590, 310, 250, 40);  
        itDepartmentLabel.setFont(labelFont);
        itDepartmentLabel.setForeground(Color.WHITE);
        itDepartmentLabel.setOpaque(true);
        itDepartmentLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(itDepartmentLabel);

        messageLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        messageLabel.setBounds(270, 450, 460, 40);
        messageLabel.setFont(largeLabelFont);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(messageLabel);
		
		
		imageLabel = new JLabel(new ImageIcon("Busycatsir.png"));
        imageLabel.setBounds(5, 140, 310, 270);
        container.add(imageLabel);
		
        backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	private void openManagemnetDepartment(ActionEvent e) {
        
		ManagementDepartmentOfFoodPage managementDepartmentOfFoodPage = new ManagementDepartmentOfFoodPage();
        managementDepartmentOfFoodPage.setTitle("Food Delivery System");
        managementDepartmentOfFoodPage.setSize(900, 600);
        managementDepartmentOfFoodPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managementDepartmentOfFoodPage.setLocationRelativeTo(null);
        managementDepartmentOfFoodPage.setVisible(true);
        managementDepartmentOfFoodPage.setResizable(false);
		this.setVisible(false);
    }

	
	private void openItDepartment(ActionEvent e) {
         JOptionPane.showMessageDialog(this, "IT Department page are under construction .- IT Department");
		
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
