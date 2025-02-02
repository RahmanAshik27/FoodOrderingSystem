package ReviewPackage;

import AdminPackage.*;
import CustomerPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ShowReviewForCreamyPasta extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, ratingLabel, imageLabel, messageLabel, foodLabel, reviewLabel;
    private JTextArea reviewTextArea;
    private JScrollPane scrollPane;
    private JSlider ratingSlider;
    private JButton postReviewButton, clearReviewButton, moreFoodsButton, homePageButton, backButton,orderButton;
    private JTextField ratingDisplayTextField;

public ShowReviewForCreamyPasta() {
        setupPage();
        loadReviewsAndRatings(); 
    }

    private void setupPage() {
        container = getContentPane();
        container.setLayout(null);

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Font textAreaFont = new Font("Arial", Font.BOLD, 20);
        Font headerFont = new Font("Arial", Font.BOLD, 30);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to Food Review Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 10, 600, 60);
        welcomeLabel.setFont(headerFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        ratingLabel = new JLabel("How much Our Customers like it?", JLabel.CENTER);
        ratingLabel.setBounds(60, 85, 310, 40);
        ratingLabel.setFont(buttonFont);
        ratingLabel.setForeground(Color.RED);
        ratingLabel.setOpaque(true);
        ratingLabel.setBackground(Color.WHITE);
        ratingLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 2));
        container.add(ratingLabel);

        ratingSlider = new JSlider(1, 5, 3);
        ratingSlider.setBounds(40, 130, 350, 40);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setCursor(cursor);
		ratingSlider.setEnabled(false);
        ratingSlider.setPaintLabels(true);
        ratingSlider.setLabelTable(ratingSlider.createStandardLabels(1));
        ratingSlider.setFont(new Font("Arial", Font.BOLD, 15));
        ratingSlider.setBackground(Color.WHITE);
        container.add(ratingSlider);

        ratingDisplayTextField = new JTextField();
        ratingDisplayTextField.setBounds(400, 130, 50, 40);
        ratingDisplayTextField.setFont(new Font("Arial", Font.BOLD, 20));
        ratingDisplayTextField.setHorizontalAlignment(JTextField.CENTER);
        ratingDisplayTextField.setEditable(false);
        ratingDisplayTextField.setBackground(new Color(220, 240, 255));
        ratingDisplayTextField.setForeground(Color.RED);
        ratingDisplayTextField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 2));
        container.add(ratingDisplayTextField);

        reviewLabel = new JLabel("Review From Our Customers ", JLabel.CENTER);
        reviewLabel.setBounds(120, 180, 300, 30);
        reviewLabel.setFont(buttonFont);
        reviewLabel.setForeground(Color.RED);
        reviewLabel.setBackground(new Color(240, 255, 240));
        reviewLabel.setOpaque(true);
        container.add(reviewLabel);

        reviewTextArea = new JTextArea();
        reviewTextArea.setFont(textAreaFont);
        reviewTextArea.setBackground(new Color(240, 255, 240));
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setWrapStyleWord(true);
        reviewTextArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 128, 255), 2),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        scrollPane = new JScrollPane(reviewTextArea);
        scrollPane.setBounds(30, 220, 500, 230);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 2));
        container.add(scrollPane);
        moreFoodsButton = new JButton("Review More Foods");
        moreFoodsButton.setBounds(460, 470, 200, 40);
        moreFoodsButton.setFont(buttonFont);
        moreFoodsButton.setBackground(new Color(34, 139, 34));
        moreFoodsButton.setForeground(Color.WHITE);
        moreFoodsButton.setCursor(cursor);
        moreFoodsButton.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 2));
        moreFoodsButton.addActionListener(this::goMoreFoodsButton);
        container.add(moreFoodsButton);

        homePageButton = new JButton("Home Page");
        homePageButton.setBounds(690, 470, 140, 40);
        homePageButton.setFont(buttonFont);
        homePageButton.setBackground(new Color(50, 205, 50));
        homePageButton.setForeground(Color.WHITE);
        homePageButton.setCursor(cursor);
        homePageButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50), 2));
        homePageButton.addActionListener(this::goHomePageButton);
        container.add(homePageButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(buttonFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);

        foodLabel = new JLabel(" Creamy Pasta", JLabel.CENTER);
        foodLabel.setBounds(580, 290, 250, 30);
        foodLabel.setFont(labelFont);
        foodLabel.setForeground(Color.WHITE);
        foodLabel.setOpaque(true);
        foodLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(foodLabel);
		
		String message = "<html><div style='text-align: center;'><b>Your opinion is valuable</b><br>to us.</div></html>";
		messageLabel = new JLabel(message, JLabel.CENTER);
        messageLabel.setBounds(550, 350, 300, 70);
        messageLabel.setFont(labelFont);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(messageLabel);
		
		String oderMessage = "<html><div style='text-align: center;'><b>Click here for </b><br>Order Creamy Pasta (^_~) </div></html>";
		orderButton = new JButton(oderMessage);
        orderButton.setBounds(60, 462, 300, 60);
        orderButton.setFont(buttonFont);
        orderButton.setBackground(new Color(255, 99, 71));
        orderButton.setForeground(Color.WHITE);
        orderButton.setCursor(cursor);
        orderButton.addActionListener(this::ToOrderLogin);
        container.add(orderButton);
		
        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(buttonFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        imageLabel = new JLabel(new ImageIcon("ReviewCreammyPasta.png"));
        imageLabel.setBounds(550, 80, 300, 200);
        container.add(imageLabel);

        JLabel backgroundLabel = new JLabel(new ImageIcon("Review.png"));
        backgroundLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundLabel);
    }

    private void loadReviewsAndRatings() {
        File reviewFile = new File("ReviewPackage/CustomersReviewsForCreamyPasta.txt");
        if (!reviewFile.exists()) {
            JOptionPane.showMessageDialog(this, "Review file not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder reviewsBuilder = new StringBuilder();
        int totalRating = 0;
        int ratingCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(reviewFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Rating:")) {
                    int ratingIndex = line.lastIndexOf("Rating:") + 8;
                    int rating = Integer.parseInt(line.substring(ratingIndex).trim());
                    totalRating += rating;
                    ratingCount++;
                }
                reviewsBuilder.append(line).append("\n");
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error reading reviews file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        reviewTextArea.setText(reviewsBuilder.toString());

        if (ratingCount > 0) {
			
            double averageRating = (double) totalRating / ratingCount;
            ratingDisplayTextField.setText(String.format("%.2f", averageRating));
		   
        } else {
            ratingDisplayTextField.setText("N/A");
        }
    }

    private void goBack(ActionEvent e) {
		
		this.setVisible(false); 
			 
			ShowReviewService page = new ShowReviewService();
			page.setTitle("Customer Food Service");
			page.setSize(900, 600);
			page.setLocationRelativeTo(null);
			page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			page.setVisible(true);
			page.setResizable(false);
				
    }
	
	private void ToOrderLogin(ActionEvent e) {
			
				this.setVisible(false); 
				 
				CreamyPastaCustomerLoginPage page = new CreamyPastaCustomerLoginPage();
				page.setTitle("Customer Food Service");
				page.setSize(900, 600);
				page.setLocationRelativeTo(null);
				page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				page.setVisible(true);
				page.setResizable(false);
					
		}

    private void goHomePageButton(ActionEvent e) {
		
        this.setVisible(false);
        ReviewsFoodPage foodReviewsPage = new ReviewsFoodPage();
        foodReviewsPage.setTitle("Food Reviews Page");
        foodReviewsPage.setSize(900, 600);
        foodReviewsPage.setLocationRelativeTo(null);
        foodReviewsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        foodReviewsPage.setVisible(true);
        foodReviewsPage.setResizable(false); 
    }

    private void goMoreFoodsButton(ActionEvent e) {
        
		this.setVisible(false); 
		ReviewShowPage reviewShowPage = new ReviewShowPage();
        reviewShowPage.setTitle("Food Delivery System");
        reviewShowPage.setSize(900, 600);
        reviewShowPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reviewShowPage.setLocationRelativeTo(null);
        reviewShowPage.setVisible(true);
        reviewShowPage.setResizable(false);
    }

}

