package ReviewPackage;

import AdminPackage.*;
import CustomerPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class GiveReviewService extends JFrame {
    private Container container;
    private JLabel welcomeLabel, categoryLabel, foodNameLabel1, foodNameLabel2, foodNameLabel3, foodNameLabel4, orderInfoLabel;
    private JButton button1, button2, button3, button4,backButton;
	private String username;

   public GiveReviewService(String username) {
		this.username=username;
        setupCustomerFoodServicePage();
    }

    private void setupCustomerFoodServicePage() {
        container = getContentPane();
        container.setLayout(null);

        Font boldFont = new Font("Arial", Font.BOLD, 18);
        Font headerFont = new Font("Arial", Font.BOLD, 30);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the Review Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(headerFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(200, 110, 500, 40);
        searchButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchButton.setBackground(new Color(240, 255, 240));  
        searchButton.setForeground(Color.BLACK);
        searchButton.setCursor(cursor);
		searchButton.addActionListener(this::performSearch);
        container.add(searchButton);

        categoryLabel = new JLabel("The Best You Can Order From Our Page", JLabel.CENTER);
        categoryLabel.setBounds(150, 170, 600, 40);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(categoryLabel);

        button1 = new JButton();
        button1.setBounds(140, 250, 130, 130);
        button1.setIcon(new ImageIcon("chikenbiriyani.png"));
        button1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        button1.setContentAreaFilled(true);
        button1.setBackground(new Color(255, 99, 71));
        button1.setCursor(cursor);
        button1.setFocusPainted(false);
        button1.addActionListener(this::orderChickenBiriyani);
        container.add(button1);

        foodNameLabel1 = new JLabel("Chikhen Dum Biriyani", JLabel.CENTER);
        foodNameLabel1.setBounds(140, 380, 130, 30);
        foodNameLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        foodNameLabel1.setForeground(Color.WHITE);
        foodNameLabel1.setOpaque(true);
        foodNameLabel1.setBackground(new Color(0, 0, 0, 150));
        container.add(foodNameLabel1);

        button2 = new JButton();
        button2.setBounds(310, 250, 130, 130);
        button2.setIcon(new ImageIcon("beef burger.png"));
        button2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        button2.setContentAreaFilled(true);
        button2.setBackground(new Color(50, 205, 50));
        button2.setCursor(cursor);
        button2.setFocusPainted(false);
		button2.addActionListener(this::orderBeefBurger);
        container.add(button2);

        foodNameLabel2 = new JLabel("Beef Burger", JLabel.CENTER);
        foodNameLabel2.setBounds(310, 380, 125, 30);
        foodNameLabel2.setFont(new Font("Arial", Font.BOLD, 16));
        foodNameLabel2.setForeground(Color.WHITE);
        foodNameLabel2.setOpaque(true);
        foodNameLabel2.setBackground(new Color(0, 0, 0, 150));
        container.add(foodNameLabel2);

        button3 = new JButton();
        button3.setBounds(475, 250, 130, 130);
        button3.setIcon(new ImageIcon("pasta.png"));
        button3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        button3.setContentAreaFilled(true);
        button3.setBackground(new Color(255, 165, 0));
        button3.setCursor(cursor);
        button3.setFocusPainted(false);
        button3.addActionListener(this::orderCreamyPasta);
        container.add(button3);

        foodNameLabel3 = new JLabel("Creamy Pasta", JLabel.CENTER);
        foodNameLabel3.setBounds(475, 380, 130, 30);
        foodNameLabel3.setFont(new Font("Arial", Font.BOLD, 16));
        foodNameLabel3.setForeground(Color.WHITE);
        foodNameLabel3.setOpaque(true);
        foodNameLabel3.setBackground(new Color(0, 0, 0, 150));
        container.add(foodNameLabel3);

        button4 = new JButton();
        button4.setBounds(645, 250, 130, 130);
        button4.setIcon(new ImageIcon("rammen.png"));
        button4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        button4.setContentAreaFilled(true);
        button4.setBackground(new Color(123, 104, 238));
        button4.setCursor(cursor);
        button4.setFocusPainted(false);
        button4.addActionListener(this::orderRamen);
        container.add(button4);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        foodNameLabel4 = new JLabel("Ramen", JLabel.CENTER);
        foodNameLabel4.setBounds(645, 380, 130, 30);
        foodNameLabel4.setFont(new Font("Arial", Font.BOLD, 16));
        foodNameLabel4.setForeground(Color.WHITE);
        foodNameLabel4.setOpaque(true);
        foodNameLabel4.setBackground(new Color(0, 0, 0, 150));
        container.add(foodNameLabel4);

        orderInfoLabel = new JLabel("Click on the above food items to Give Review of those best meals!", JLabel.CENTER);
        orderInfoLabel.setBounds(100, 450, 700, 50);
        orderInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        orderInfoLabel.setForeground(Color.WHITE);
        orderInfoLabel.setOpaque(true);
        orderInfoLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(orderInfoLabel);

        JLabel backgroundLabel = new JLabel(new ImageIcon("Review.png"));
        backgroundLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundLabel);
    }
	
	private void performSearch(ActionEvent e) {
		
		this.setVisible(false);
		ReviewGivenPage reviewGivenPage = new ReviewGivenPage(username);
        reviewGivenPage.setTitle("Food Ordering sysytem ");
        reviewGivenPage.setSize(900, 600);
        reviewGivenPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reviewGivenPage.setLocationRelativeTo(null);
        reviewGivenPage.setVisible(true);
        reviewGivenPage.setResizable(false);
	}
	
private boolean isFoodOrderedByUser(String foodItem) {
   
    File file = new File("AdminPackage/"+username + ".txt");
    String line;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        while ((line = br.readLine()) != null) {
            
            if (line.toLowerCase().contains(foodItem.toLowerCase())) {
                return true; 
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false; 
}
private void orderChickenBiriyani(ActionEvent e) {
    String foodItem = "Chikhen Dum Biriyani"; 
	
	ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
    ImageIcon okImg = new ImageIcon("okImg.png");
	
    if (isFoodOrderedByUser(foodItem)) {
        JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
		
		this.setVisible(false);
		ReviewForChikhenDumBiriyani frame = new ReviewForChikhenDumBiriyani(username);
        frame.setTitle("Food Ordering sysytem");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		frame.setResizable(false);
		
		
    } else {
        JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
    }
}

    private void orderBeefBurger(ActionEvent e) {
         String foodItem = "Beef Burger"; 
	
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
	
		if (isFoodOrderedByUser(foodItem)) {
			JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
			
			this.setVisible(false);
			ReviewForBeefBurger frame = new ReviewForBeefBurger(username);
			frame.setTitle("Food Ordering sysytem");
			frame.setSize(900, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
		}
		}

    private void orderCreamyPasta(ActionEvent e) {
        String foodItem = "Creammy Pasta"; 
	
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
	
		if (isFoodOrderedByUser(foodItem)) {
			JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
			
			this.setVisible(false);
			ReviewForCreammyPasta frame = new ReviewForCreammyPasta(username);
			frame.setTitle("Food Ordering sysytem");
			frame.setSize(900, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
		}
    }

    private void orderRamen(ActionEvent e) {
        String foodItem = "Japaness Ramen"; 
	
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
	
		if (isFoodOrderedByUser(foodItem)) {
			JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
			
			this.setVisible(false);
			ReviewForJapanessRamen frame = new ReviewForJapanessRamen(username);
			frame.setTitle("Food Ordering sysytem");
			frame.setSize(900, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
		}
    }
	   
	
	private void goBack(ActionEvent e) {    		
			
			this.setVisible(false);
			ReviewsFoodPage foodReviewsPage = new ReviewsFoodPage();
			foodReviewsPage.setTitle("Food Reviews Page");
			foodReviewsPage.setSize(900, 600);
			foodReviewsPage.setLocationRelativeTo(null);
			foodReviewsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			foodReviewsPage.setVisible(true);
			foodReviewsPage.setResizable(false);       	
		} 
}



