import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


class GiveReviewService extends JFrame {
    private Container container;
    private JLabel welcomeLabel, categoryLabel, foodNameLabel1, foodNameLabel2, foodNameLabel3, foodNameLabel4, orderInfoLabel;
    private JButton button1, button2, button3, button4,backButton;
	private String username;

    GiveReviewService(String username) {
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
   
    File file = new File(username + ".txt");
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





class ReviewForChikhenDumBiriyani extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, ratingLabel,imageLabel,messageLabel,foodLabel,reviewLabel;
    private JTextArea reviewTextArea;
    private JScrollPane scrollPane;
    private JSlider ratingSlider;
    private JButton postReviewButton, clearReviewButton, moreFoodsButton, homePageButton, giveStarButton, changeRatingButton,backButton;
    private JTextField ratingDisplayTextField; 
    private int fixedRating = 0;
    private String username ; 

    ReviewForChikhenDumBiriyani(String username) {
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
		
		foodLabel = new JLabel("Chikhen Dum Biriyani", JLabel.CENTER);
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
		
		imageLabel = new JLabel(new ImageIcon("ReviewDumBiriyani.png"));
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
        File file = new File("CustomersReviewsForChikhenDumBiriyani.txt");
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


class ReviewForBeefBurger extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, ratingLabel,imageLabel,messageLabel,foodLabel,reviewLabel;
    private JTextArea reviewTextArea;
    private JScrollPane scrollPane;
    private JSlider ratingSlider;
    private JButton postReviewButton, clearReviewButton, moreFoodsButton, homePageButton, giveStarButton, changeRatingButton,backButton;
    private JTextField ratingDisplayTextField; 
    private int fixedRating = 0;
    private String username ; 

    ReviewForBeefBurger(String username) {
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
        File file = new File("CustomersReviewsForBeefBurger.txt");
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


class ReviewForCreammyPasta extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, ratingLabel,imageLabel,messageLabel,foodLabel,reviewLabel;
    private JTextArea reviewTextArea;
    private JScrollPane scrollPane;
    private JSlider ratingSlider;
    private JButton postReviewButton, clearReviewButton, moreFoodsButton, homePageButton, giveStarButton, changeRatingButton,backButton;
    private JTextField ratingDisplayTextField; 
    private int fixedRating = 0;
    private String username ; 

    ReviewForCreammyPasta(String username) {
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
		
		foodLabel = new JLabel("Creammy Pasta", JLabel.CENTER);
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
		
		imageLabel = new JLabel(new ImageIcon("ReviewCreammyPasta.png"));
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
        File file = new File("CustomersReviewsForCreamyPasta.txt");
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



class ReviewForJapanessRamen extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, ratingLabel,imageLabel,messageLabel,foodLabel,reviewLabel;
    private JTextArea reviewTextArea;
    private JScrollPane scrollPane;
    private JSlider ratingSlider;
    private JButton postReviewButton, clearReviewButton, moreFoodsButton, homePageButton, giveStarButton, changeRatingButton,backButton;
    private JTextField ratingDisplayTextField; 
    private int fixedRating = 0;
    private String username ; 

    ReviewForJapanessRamen(String username) {
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
		
		foodLabel = new JLabel("Japaness Ramen", JLabel.CENTER);
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
		
		imageLabel = new JLabel(new ImageIcon("ReviewJapanessRamen.png"));
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
            } else {
                JOptionPane.showMessageDialog(this, "You can edit your review.", "Edit Review", JOptionPane.INFORMATION_MESSAGE,okImg);
            }
        }
    }

    private void saveReviewToFile(String username, int rating, String review) {
        File file = new File("CustomersReviewsForJapaneseRamen.txt");
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		try (FileWriter writer = new FileWriter(file, true)) { 
            writer.write(username);
			  writer.write(" : " + review );
            writer.write(" - Rating: " + rating + "\n");
			 reviewTextArea.setText("");
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

