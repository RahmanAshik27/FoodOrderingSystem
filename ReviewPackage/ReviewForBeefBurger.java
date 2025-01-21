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

public class ReviewForBeefBurger extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, ratingLabel,imageLabel,messageLabel,foodLabel,reviewLabel;
    private JTextArea reviewTextArea;
    private JScrollPane scrollPane;
    private JSlider ratingSlider;
    private JButton postReviewButton, clearReviewButton, moreFoodsButton, homePageButton, giveStarButton, changeRatingButton,backButton;
    private JTextField ratingDisplayTextField; 
    private int fixedRating = 0;
    private String username ; 

   public ReviewForBeefBurger(String username) {
		this.username=username;
        setupPage();
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

		ratingLabel = new JLabel("How much do you like it?",JLabel.CENTER);
		ratingLabel.setBounds(50, 90, 300, 40);
		ratingLabel.setFont(buttonFont);
		ratingLabel.setForeground(Color.RED);
		ratingLabel.setOpaque(true);
		ratingLabel.setBackground(Color.WHITE);
		ratingLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 2));
		container.add(ratingLabel);

        
        ratingSlider = new JSlider(1, 5, 3);
		ratingSlider.setBounds(40, 140, 350, 70);
		ratingSlider.setMajorTickSpacing(1);
		ratingSlider.setPaintTicks(true);
		ratingSlider.setCursor(cursor);
		ratingSlider.setPaintLabels(true);
		ratingSlider.setLabelTable(ratingSlider.createStandardLabels(1));
		ratingSlider.setFont(new Font("Arial", Font.BOLD, 18)); 
		ratingSlider.setBackground(Color.WHITE);
		container.add(ratingSlider);


		ratingDisplayTextField = new JTextField();
		ratingDisplayTextField.setBounds(400, 145, 50, 50);
		ratingDisplayTextField.setFont(new Font("Arial", Font.BOLD, 22));
		ratingDisplayTextField.setHorizontalAlignment(JTextField.CENTER);
		ratingDisplayTextField.setEditable(false);
		ratingDisplayTextField.setBackground(new Color(220, 240, 255)); 
		ratingDisplayTextField.setForeground(Color.RED);
		ratingDisplayTextField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 2)); 
		container.add(ratingDisplayTextField);


        giveStarButton = new JButton("Give Star");
        giveStarButton.setBounds(50, 220, 140, 40);
        giveStarButton.setFont(buttonFont);
        giveStarButton.setBackground(new Color(50, 150, 250));
        giveStarButton.setForeground(Color.WHITE);
		giveStarButton.setCursor(cursor);
        giveStarButton.setBorder(BorderFactory.createLineBorder(new Color(50, 150, 250), 2)); 
        giveStarButton.addActionListener(this::giveStar);
        container.add(giveStarButton);


        changeRatingButton = new JButton("Clear Rating");
        changeRatingButton.setBounds(210, 220, 140, 40);
        changeRatingButton.setFont(buttonFont);
        changeRatingButton.setBackground(new Color(255, 165, 0));
        changeRatingButton.setForeground(Color.WHITE);
        changeRatingButton.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0), 2)); 
        changeRatingButton.addActionListener(this::changeRating);
        container.add(changeRatingButton);

        reviewLabel = new JLabel("Write your Review here",JLabel.CENTER);
		reviewLabel.setBounds(120, 280, 300, 30);
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
			BorderFactory.createEmptyBorder(35, 10, 35, 10) 
		));

		scrollPane = new JScrollPane(reviewTextArea);
		scrollPane.setBounds(30, 275, 500, 180);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 2)); // Border for the scroll pane
		container.add(scrollPane);

		
       
        postReviewButton = new JButton("Post Review");
        postReviewButton.setBounds(50, 470, 140, 40);
        postReviewButton.setFont(buttonFont);
        postReviewButton.setBackground(new Color(50, 150, 250));
        postReviewButton.setForeground(Color.WHITE);
		postReviewButton.setCursor(cursor);
        postReviewButton.setBorder(BorderFactory.createLineBorder(new Color(50, 150, 250), 2)); 
        postReviewButton.addActionListener(this::postReview);
        container.add(postReviewButton);

       
        clearReviewButton = new JButton("Clear Review");
        clearReviewButton.setBounds(230, 470, 140, 40);
        clearReviewButton.setFont(buttonFont);
        clearReviewButton.setBackground(new Color(255, 99, 71));
        clearReviewButton.setForeground(Color.WHITE);
		clearReviewButton.setCursor(cursor);
        clearReviewButton.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 2)); 
        clearReviewButton.addActionListener(this::clearReview);
        container.add(clearReviewButton);

        
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
        footerLabel.setBounds(0, 520, 900, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		foodLabel = new JLabel("Beef Burger", JLabel.CENTER);
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
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(buttonFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);
		
		imageLabel = new JLabel(new ImageIcon("ReviewBeefBurger.png"));
        imageLabel.setBounds(550, 80, 300, 200);
        container.add(imageLabel);
		
        
        JLabel backgroundLabel = new JLabel(new ImageIcon("Review.png"));
        backgroundLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundLabel);
    }

    private void giveStar(ActionEvent e) {
		
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
		
        fixedRating = ratingSlider.getValue();
        ratingDisplayTextField.setText(String.valueOf(fixedRating)); 
        JOptionPane.showMessageDialog(this, "Rating fixed to: " + fixedRating, "Rating Fixed", JOptionPane.INFORMATION_MESSAGE,okImg);
    }

    private void changeRating(ActionEvent e) {
        fixedRating = 0;
        ratingDisplayTextField.setText(""); 
        
    }

    private void postReview(ActionEvent e) {
        String review = reviewTextArea.getText();
        
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
		
		if (review.isEmpty()) {
			
            JOptionPane.showMessageDialog(this, "Please write a review before posting.", "Warning", JOptionPane.WARNING_MESSAGE,BlankImg);
        } else if (fixedRating == 0) {
            JOptionPane.showMessageDialog(this, "Please fix a rating before posting.", "Warning", JOptionPane.WARNING_MESSAGE,BlankImg);
        } else {
           
            int choice = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to post this review?",
                    "Confirm Review",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,okImg);

            if (choice == JOptionPane.YES_OPTION) {
                
                saveReviewToFile(username, fixedRating, review);
                JOptionPane.showMessageDialog(this, "Review posted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE,okImg);
				 reviewTextArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "You can edit your review.", "Edit Review", JOptionPane.INFORMATION_MESSAGE,okImg);
            }
        }
    }

    private void saveReviewToFile(String username, int rating, String review) {
        File file = new File("ReviewPackage/CustomersReviewsForBeefBurger.txt");
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		try (FileWriter writer = new FileWriter(file, true)) { 
            writer.write(username);
			  writer.write(" : " + review );
            writer.write(" - Rating: " + rating + "\n");
          
            writer.write("----------------------------------------\n"); 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the review.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
        }
    }

    private void clearReview(ActionEvent e) {
        reviewTextArea.setText("");
    }
	
	private void goBack(ActionEvent e) {    		
		
		this.setVisible(false);

            GiveReviewService page = new GiveReviewService(username);
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
		ReviewGivenPage reviewGivenPage = new ReviewGivenPage(username);
        reviewGivenPage.setTitle("Food Ordering sysytem ");
        reviewGivenPage.setSize(900, 600);
        reviewGivenPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reviewGivenPage.setLocationRelativeTo(null);
        reviewGivenPage.setVisible(true);
        reviewGivenPage.setResizable(false);	
	}

  
}

