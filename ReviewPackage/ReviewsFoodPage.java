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


public class ReviewsFoodPage extends JFrame {
    private Container container;
    private JLabel instructionLabel, showLabel, giveLabel, messageLabel, backgroundImageLabel,imageLabel;
    private JButton showReviewsButton, giveReviewButton, backButton;

    public ReviewsFoodPage() {
        setupFoodReviewsPage();
    }

    private void setupFoodReviewsPage() {
        container = getContentPane();
        container.setLayout(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Font instructionFont = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font largeLabelFont = new Font("Arial", Font.BOLD, 20);
		Font boldFont = new Font("Arial",Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);	

        instructionLabel = new JLabel("Do you want to view reviews or give a review?", JLabel.CENTER);
        instructionLabel.setBounds(200, 50, 600, 50);
        instructionLabel.setFont(instructionFont);
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setOpaque(true);
        instructionLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(instructionLabel);

        showReviewsButton = new JButton("View Reviews");
        showReviewsButton.setBounds(420, 200, 200, 60);  
        showReviewsButton.setFont(buttonFont);
        showReviewsButton.setBackground(new Color(34, 139, 34));
        showReviewsButton.setForeground(Color.WHITE);
        showReviewsButton.setCursor(cursor);
		showReviewsButton.addActionListener(this::showReviewLoginPage);
        container.add(showReviewsButton);

        showLabel = new JLabel("Click to see user reviews", JLabel.CENTER);
        showLabel.setBounds(620, 210, 200, 40);  
        showLabel.setFont(labelFont);
        showLabel.setForeground(Color.WHITE);
        showLabel.setOpaque(true);
        showLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(showLabel);

        giveReviewButton = new JButton("Give a Review");
        giveReviewButton.setBounds(420, 300, 200, 60); 
        giveReviewButton.setFont(buttonFont);
        giveReviewButton.setBackground(new Color(255, 69, 0));
        giveReviewButton.setForeground(Color.WHITE);
        giveReviewButton.setCursor(cursor);
        container.add(giveReviewButton);
        giveReviewButton.addActionListener(this::openReviewLoginPage);

        giveLabel = new JLabel("Click to share your feedback", JLabel.CENTER);
        giveLabel.setBounds(620, 310, 250, 40);  
        giveLabel.setFont(labelFont);
        giveLabel.setForeground(Color.WHITE);
        giveLabel.setOpaque(true);
        giveLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(giveLabel);

        messageLabel = new JLabel("Your opinion is valuable to us", JLabel.CENTER);
        messageLabel.setBounds(270, 450, 460, 40);
        messageLabel.setFont(largeLabelFont);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(messageLabel);
		
		imageLabel = new JLabel(new ImageIcon("Reviewer is Hungry.png"));
        imageLabel.setBounds(100, 60, 250, 400);
        container.add(imageLabel);
		
        backgroundImageLabel = new JLabel(new ImageIcon("Review.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	private void showReviewLoginPage(ActionEvent e) {
        
		this.setVisible(false);
		 
		 
		ShowReviewService page = new ShowReviewService();
        page.setTitle("Customer Food Service");
        page.setSize(900, 600);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setLocationRelativeTo(null);
        page.setVisible(true);	
    }
	
    private void openReviewLoginPage(ActionEvent e) {
        this.setVisible(false);

        ReviewLoginPage reviewLoginPage = new ReviewLoginPage();
        reviewLoginPage.setTitle("Login Page");
        reviewLoginPage.setSize(900, 600);
        reviewLoginPage.setLocationRelativeTo(null);
        reviewLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reviewLoginPage.setVisible(true);
        reviewLoginPage.setResizable(false);
    }
	
	private void goBack(ActionEvent e) {
    
    this.dispose();  
    
		ProjectMainPage mainPage = new ProjectMainPage(); 
		mainPage.setTitle("Food Delivery System");
		mainPage.setSize(900, 600);
		mainPage.setLocationRelativeTo(null);
		mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPage.setVisible(true);
		mainPage.setResizable(false);
}

    
}
