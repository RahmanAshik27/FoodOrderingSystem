import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class ReviewsFoodPage extends JFrame {
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
        showReviewsButton.setBounds(420, 200, 200, 60);  // Aligned to the left
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
		 
        ReviewShowPage reviewShowPage = new ReviewShowPage();
        reviewShowPage.setTitle("Food Delivery System");
        reviewShowPage.setSize(900, 600);
        reviewShowPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reviewShowPage.setLocationRelativeTo(null);
        reviewShowPage.setVisible(true);
        reviewShowPage.setResizable(false);
		
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

class ReviewLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel, messageLabel, imageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;

    public ReviewLoginPage() {
        setupReviewLoginPage();
    }

    private void setupReviewLoginPage() {
        container = getContentPane();
        container.setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the Review Login Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

       
        userLabel = new JLabel("Username:");
        userLabel.setBounds(360, 180, 110, 30);
        userLabel.setFont(boldFont);
        userLabel.setForeground(Color.WHITE);
        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(480, 170, 250, 40);
        usernameField.setFont(labelFont);
        container.add(usernameField);

     
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(360, 240, 110, 30);
        passwordLabel.setFont(boldFont);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(480, 230, 250, 40);
        passwordField.setFont(labelFont);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(730, 230, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(this::togglePasswordVisibility);
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(480, 310, 120, 40);
        loginButton.setFont(backFont);
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(this::handleLogin);
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(620, 310, 120, 40);
        clearButton.setFont(backFont);
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(this::clearFields);
        container.add(clearButton);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(470, 380, 300, 40);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.BLACK);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(255, 255, 255, 150));
        container.add(footerLabel);

        messageLabel = new JLabel("Your opinion is valuable to us", JLabel.CENTER);
        messageLabel.setBounds(220, 450, 460, 40);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(messageLabel);
		
		imageLabel = new JLabel(new ImageIcon("Thinking Cat.png"));
        imageLabel.setBounds(94, 95, 250, 400);
        container.add(imageLabel);

        imageLabel = new JLabel(new ImageIcon("Review.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

    private void handleLogin(ActionEvent e) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon okImg = new ImageIcon("okImg.png");
    String result = checkCredentials(username, password);
    if (result.equals("SUCCESS")) {
        JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
		
		this.setVisible(false);
		ReviewGivenPage reviewGivenPage = new ReviewGivenPage();
        reviewGivenPage.setTitle("Food Delivery System");
        reviewGivenPage.setSize(900, 600);
        reviewGivenPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reviewGivenPage.setLocationRelativeTo(null);
        reviewGivenPage.setVisible(true);
        reviewGivenPage.setResizable(false);
		
    } else if (result.equals("INCORRECT_PASSWORD")) {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    } else {
        String errorMessage = "you do not have an account in our food service.";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}

private String checkCredentials(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
        String line;
        boolean userFound = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                String fileUsername = parts[0].trim();
                String filePassword = parts[1].trim();

                if (username.equals(fileUsername)) {
                    userFound = true;
                    if (password.equals(filePassword)) {
                        return "SUCCESS"; 
                    } else {
                        return "INCORRECT_PASSWORD"; 
                    }
                }
            }
        }
        if (!userFound) {
            return "INCORRECT_USERNAME"; 
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading user file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return "ERROR"; 
}


    private void togglePasswordVisibility(ActionEvent e) {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

    private void clearFields(ActionEvent e) {
        usernameField.setText("");
        passwordField.setText("");
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
