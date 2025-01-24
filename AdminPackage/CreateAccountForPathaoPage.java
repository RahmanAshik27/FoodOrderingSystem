package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class CreateAccountForPathaoPage extends JFrame {
    
	private Container container;
    private JLabel welcomeLabel,userLabel, phoneLabel, emailLabel, passwordLabel, confirmPasswordLabel,imageLabel, manualLabel;
    private JTextField usernameField, phoneField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton createButton, backButton;
    private JCheckBox showPasswordCheckBox, showConfirmPasswordCheckBox;


  public CreateAccountForPathaoPage() {
        setupCreateAccountForPathaoPage();
    }

  
    private void setupCreateAccountForPathaoPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		welcomeLabel = new JLabel("Welcome to the Add New Rider account", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);
				
	
		userLabel = new JLabel("Username:");
		userLabel.setBounds(220, 120, 150, 30);
		userLabel.setFont(new Font("Arial", Font.BOLD, 18));  
		container.add(userLabel);

		usernameField = new JTextField();
		usernameField.setBounds(390, 120, 250, 40);
		usernameField.setFont(labelFont);
		usernameField.setBackground(Color.WHITE);
		usernameField.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 255), 2));
		container.add(usernameField);

		phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setBounds(220, 180, 150, 30);
		phoneLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
		container.add(phoneLabel);

		phoneField = new JTextField();
		phoneField.setBounds(390, 180, 250, 40);
		phoneField.setFont(labelFont);
		phoneField.setBackground(Color.WHITE);
		phoneField.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 255), 2));
		container.add(phoneField);

		emailLabel = new JLabel("Email Adress:");
		emailLabel.setBounds(220, 240, 150, 30);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 18));  
		container.add(emailLabel);

		emailField = new JTextField();
		emailField.setBounds(390, 240, 250, 40);
		emailField.setFont(labelFont);
		emailField.setBackground(Color.WHITE);
		emailField.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 255), 2));
		container.add(emailField);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(220, 300, 150, 30);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
		container.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(390, 300, 250, 40);
		passwordField.setFont(labelFont);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 255), 2));
		container.add(passwordField);

		showPasswordCheckBox = new JCheckBox("Show Password");
		showPasswordCheckBox.setBounds(390, 360, 150, 30);
		showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
		showPasswordCheckBox.setBackground(new Color(240, 248, 255));
		showPasswordCheckBox.addActionListener(e -> togglePasswordVisibility());
		container.add(showPasswordCheckBox);

	
		createButton = new JButton("Add Rider Details To Database ");
		createButton.setBounds(330, 420, 300, 40);
		createButton.setFont(new Font("Arial", Font.BOLD, 16));
		createButton.setBackground(new Color(50, 150, 255));
		createButton.setForeground(Color.WHITE);
		createButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createButton.addActionListener(e -> handleCreateAccount());
		container.add(createButton);


        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(e -> {
				
				this.setVisible(false);
            
				PathaoRiderDetails pathaoRiderDetails = new PathaoRiderDetails();
				pathaoRiderDetails.setTitle("Pathao Rider Details");
				pathaoRiderDetails.setSize(900, 600);
				pathaoRiderDetails.setLocationRelativeTo(null);
				pathaoRiderDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pathaoRiderDetails.setVisible(true);
				
        });
        
		container.add(backButton);
		imageLabel = new JLabel(new ImageIcon("RiderLogin.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }


    private void togglePasswordVisibility() {
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);  
        } else {
            passwordField.setEchoChar('*');  
        }
    }
	private void handleCreateAccount() {
		String username = usernameField.getText().trim();
		String phone = phoneField.getText().trim();
		String email = emailField.getText().trim();
		String password = new String(passwordField.getPassword());

		ImageIcon blankImg = new ImageIcon("FillAllbox.png");
		ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
		ImageIcon okImg = new ImageIcon("okImg.png");

		if (username.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.INFORMATION_MESSAGE, blankImg);
			return;
		}

		if (!phone.matches("01[0-9]{9}")) {
			JOptionPane.showMessageDialog(this, "Phone number must start with '01' and be exactly 11 digits!", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
			return;
		}

		if (!email.matches("^[A-Za-z]+[A-Za-z0-9]*@gmail\\.com$")) {
			JOptionPane.showMessageDialog(this, "Invalid email format. Must contain letters before '@gmail.com'.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
			return;
		}

		if (password.length() < 5 || password.length() > 16) {
			JOptionPane.showMessageDialog(this, "Password must be 5 to 16 characters long.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
			return;
		}

	   
		try (BufferedReader reader = new BufferedReader(new FileReader("src/AdminPackage/PathaoRiderDetails.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length >= 4) {
					String existingUsername = details[0].trim();
					String existingPhone = details[2].trim();
					String existingEmail = details[3].trim();

					if (existingUsername.equals(username)) {
						JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
						return;
					}
					if (existingPhone.equals(phone)) {
						JOptionPane.showMessageDialog(this, "Phone number already exists. Please use a different phone number.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
						return;
					}
					if (existingEmail.equals(email)) {
						JOptionPane.showMessageDialog(this, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
						return;
					}
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error reading data!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}


		try (PrintWriter writer = new PrintWriter(new FileWriter("src/AdminPackage/PathaoRiderDetails.txt", true))) {
			writer.println(username + "," + password + "," + phone + "," + email);
			JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);


			PathaoRiderDetails nextFrame = new PathaoRiderDetails();
			nextFrame.setTitle("Pathao Rider Details");
			nextFrame.setSize(900, 600);
			nextFrame.setLocationRelativeTo(null);
			nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			nextFrame.setVisible(true);

			this.dispose();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error saving data!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
