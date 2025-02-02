package ReviewPackage;

import AdminPackage.*;
import CustomerPackage.*;
import DashboardPackage.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class CreamyPastaCustomerLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel,imageLabel, footerLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton, createAccountButton;
    private JCheckBox showPasswordCheckBox;

    
public CreamyPastaCustomerLoginPage() {
        
		setupCreamyPastaCustomerLoginPage();
    }

    private void setupCreamyPastaCustomerLoginPage() {
        
		container = getContentPane();
        container.setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
		Font eyeFont = new Font("Arial", Font.PLAIN, 14);
		Font logInFont = new Font("Arial",Font.BOLD, 16);
		Font welcomeFont = new Font("Arial",Font.BOLD, 30);
		Font boldFont = new Font("Arial",Font.BOLD, 18);
		
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

       
        welcomeLabel = new JLabel("Welcome to the Customer Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);
 		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);	
		
        userLabel = new JLabel(" Username:",JLabel.CENTER);
	    userLabel.setBounds(250, 151, 120, 40);
        userLabel.setFont(boldFont);
        userLabel.setForeground(Color.WHITE);
        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(0, 0, 0, 150));
		container.add(userLabel);		

        usernameField = new JTextField();
        usernameField.setBounds(380, 150, 250, 40);
        usernameField.setFont(labelFont);
        usernameField.setBackground(Color.WHITE);
        container.add(usernameField);

        passwordLabel = new JLabel(" Password:",JLabel.CENTER);
		passwordLabel.setBounds(250, 221, 120, 40);
		passwordLabel.setFont(boldFont); 
		passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(new Color(0, 0, 0, 150));		
		container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(380, 220, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(380, 280, 150, 30);
        showPasswordCheckBox.setFont(eyeFont);
        showPasswordCheckBox.setBackground(new Color(240, 248, 255));
        showPasswordCheckBox.addActionListener(this:: togglePasswordVisibility);
        container.add(showPasswordCheckBox);

        loginButton = new JButton("Login");
        loginButton.setBounds(380, 315, 120, 40);
        loginButton.setFont(logInFont);
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(this::handleLogin);
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(510, 315, 120, 40);
        clearButton.setFont(logInFont);
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(this:: clearFields);
        container.add(clearButton);

        
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(380, 370, 250, 40);
        createAccountButton.setFont(logInFont);
        createAccountButton.setBackground(new Color(34, 139, 34));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setCursor(cursor);
        createAccountButton.addActionListener(this::openCreateAccountPage);
        container.add(createAccountButton);

		
        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		imageLabel = new JLabel(new ImageIcon("Review.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

    private void clearFields(ActionEvent e) {
        usernameField.setText("");
        passwordField.setText("");
    }

  private void handleLogin(ActionEvent e) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");

    try (Scanner scanner = new Scanner(new File("src/AdminPackage/users.txt"))) {
        boolean loginSuccessful = false;
        while (scanner.hasNextLine()) {
            String[] checkInfo = scanner.nextLine().split(",");
            if (checkInfo[0].equals(username) && checkInfo[1].equals(password)) {
                loginSuccessful = true;
                break;
            }
        }

		if (loginSuccessful) {
			
			String filename = "src/AdminPackage/"+username + ".txt";
			
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        writer.write("Login Successful: " + username + "\n");
		} catch (IOException b) {
			b.printStackTrace();
		}

		JOptionPane.showMessageDialog(this, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
				
				CreammyPastaDetails creammyPasta = new CreammyPastaDetails(username);
				creammyPasta.setTitle("Food Order Details");
				creammyPasta.setSize(900, 600);
				creammyPasta.setLocationRelativeTo(null);
				creammyPasta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				creammyPasta.setVisible(true);
				creammyPasta.setResizable(false);
                
				this.setVisible(false); 
	
	}else {
            String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
            JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
        }
    } catch (FileNotFoundException ex) {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}



    private void togglePasswordVisibility(ActionEvent e) {
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');  
        }
    }

   
    private void openCreateAccountPage(ActionEvent e) {
        
		this.setVisible(false);
        
		CreamyPastaCreateAccountPage createAccountPage = new CreamyPastaCreateAccountPage();
        createAccountPage.setTitle("Create Account");
        createAccountPage.setSize(900, 600);
        createAccountPage.setLocationRelativeTo(null);
        createAccountPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccountPage.setVisible(true);
		createAccountPage.setResizable(false);
    }
	
	    private void goBack(ActionEvent e) {
      
        ShowReviewForCreamyPasta frame = new ShowReviewForCreamyPasta();
        frame.setTitle("Food Ordering sysytem");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		frame.setResizable(false);
		this.setVisible(false); 
    }

}
