package ReviewPackage;

import AdminPackage.*;
import CustomerPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class JapanessRamenCreateAccountPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel,userLabel, phoneLabel, emailLabel, passwordLabel, confirmPasswordLabel,imageLabel, manualLabel,footerLabel;
    private JTextField usernameField, phoneField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton createButton, backButton;
    private JCheckBox showPasswordCheckBox, showConfirmPasswordCheckBox;

public JapanessRamenCreateAccountPage() {
        setupJapanessRamenCreateAccountPage();
    }

    private void setupJapanessRamenCreateAccountPage() {
        
		container = getContentPane();
        container.setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
		Font welcomeFont = new Font("Arial",Font.BOLD, 30);
		Font boldFont = new Font("Arial",Font.BOLD, 18);
		Font logInFont = new Font("Arial",Font.BOLD, 16);
		
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		welcomeLabel = new JLabel("Welcome to the Create New account Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);
		

		userLabel = new JLabel("Username:", JLabel.CENTER);
		userLabel.setBounds(250, 126, 150, 35);
		userLabel.setFont(boldFont); 
		userLabel.setForeground(Color.WHITE);
        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(0, 0, 0, 150));
		container.add(userLabel);

		usernameField = new JTextField();
		usernameField.setBounds(420, 125, 250, 40);
		usernameField.setFont(labelFont);
		usernameField.setBackground(Color.WHITE);
		container.add(usernameField);


		phoneLabel = new JLabel("Phone Number:", JLabel.CENTER);
		phoneLabel.setBounds(250, 186, 150, 35);
		phoneLabel.setFont(boldFont);
		phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setOpaque(true);
        phoneLabel.setBackground(new Color(0, 0, 0, 150));
		container.add(phoneLabel);

		phoneField = new JTextField();
		phoneField.setBounds(420, 185, 250, 40);
		phoneField.setFont(labelFont);
		phoneField.setBackground(Color.WHITE);
		container.add(phoneField);


		emailLabel = new JLabel("Email Adress:", JLabel.CENTER);
		emailLabel.setBounds(250, 246, 150, 35);
		emailLabel.setFont(boldFont);  
		emailLabel.setForeground(Color.WHITE);
        emailLabel.setOpaque(true);
        emailLabel.setBackground(new Color(0, 0, 0, 150));
		container.add(emailLabel);

		emailField = new JTextField();
		emailField.setBounds(420, 245, 250, 40);
		emailField.setFont(labelFont);
		emailField.setBackground(Color.WHITE);
		container.add(emailField);


		passwordLabel = new JLabel("Password:", JLabel.CENTER);
		passwordLabel.setBounds(250, 306, 150, 35);
		passwordLabel.setFont(boldFont); 
		passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(new Color(0, 0, 0, 150));		
		container.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(420, 305, 250, 40);
		passwordField.setFont(labelFont);
		passwordField.setBackground(Color.WHITE);
		container.add(passwordField);


		confirmPasswordLabel = new JLabel("Confirm Password:", JLabel.CENTER);
		confirmPasswordLabel.setBounds(248, 366, 170, 35);
		confirmPasswordLabel.setFont(boldFont);
		confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setOpaque(true);
        confirmPasswordLabel.setBackground(new Color(0, 0, 0, 150));		
		container.add(confirmPasswordLabel);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(420 , 365, 250, 40);
		confirmPasswordField.setFont(labelFont);
		confirmPasswordField.setBackground(Color.WHITE);
		container.add(confirmPasswordField);


		showPasswordCheckBox = new JCheckBox("Show Password");
		showPasswordCheckBox.setBounds(410, 410, 150, 30);
		showPasswordCheckBox.setFont(logInFont);
		showPasswordCheckBox.setBackground(new Color(240, 248, 255));
		showPasswordCheckBox.addActionListener(this:: togglePasswordVisibility);
		container.add(showPasswordCheckBox);

		showConfirmPasswordCheckBox = new JCheckBox("Show Confirm Password");
		showConfirmPasswordCheckBox.setBounds(570, 410, 220, 30);
		showConfirmPasswordCheckBox.setFont(logInFont);
		showConfirmPasswordCheckBox.setBackground(new Color(240, 248, 255));
		showConfirmPasswordCheckBox.addActionListener(this:: toggleConfirmPasswordVisibility);
		container.add(showConfirmPasswordCheckBox);


		createButton = new JButton("Create Account");
		createButton.setBounds(390, 465, 250, 40);
		createButton.setFont(logInFont);
		createButton.setBackground(new Color(50, 150, 255));
		createButton.setForeground(Color.WHITE);
		createButton.setCursor(cursor);
		createButton.addActionListener(this:: handleCreateAccount);
		container.add(createButton);


        
        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(logInFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(e -> {
				
				this.setVisible(false); 
				 
				JapanessRamenCustomerLoginPage page = new JapanessRamenCustomerLoginPage();
				page.setTitle("Customer Food Service");
				page.setSize(900, 600);
				page.setLocationRelativeTo(null);
				page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				page.setVisible(true);
				page.setResizable(false);
				
        });
        container.add(backButton);
		
		footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		imageLabel = new JLabel(new ImageIcon("Src_ImageStore/Review.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

    private void togglePasswordVisibility(ActionEvent e) {
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);  
        } else {
            passwordField.setEchoChar('*');  
        }
    }

    private void toggleConfirmPasswordVisibility(ActionEvent e) {
        if (showConfirmPasswordCheckBox.isSelected()) {
            confirmPasswordField.setEchoChar((char) 0); 
        } else {
            confirmPasswordField.setEchoChar('*');  
        }
    }
private void handleCreateAccount(ActionEvent e) {
    
	String username = usernameField.getText();
    String phone = phoneField.getText();
    String email = emailField.getText();
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmPasswordField.getPassword());

    ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
    ImageIcon wrongImg = new ImageIcon("Src_ImageStore/wrongimg2.png");
    ImageIcon okImg = new ImageIcon("Src_ImageStore/okImg.png");

    if (username.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.INFORMATION_MESSAGE, BlankImg);
    } else if (phone.length() != 11 || !phone.matches("01[0-9]{9}")) {
        JOptionPane.showMessageDialog(this, "Phone number must start with '01' and be exactly 11 digits long!", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    } else if (!email.matches("^[A-Za-z]+[A-Za-z0-9]*@gmail.com$")) {
        JOptionPane.showMessageDialog(this, "Email must contain at least one letter before @gmail.com, and may contain numbers.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    } else if (password.length() < 5 || password.length() > 16) {
        JOptionPane.showMessageDialog(this, "Password must be between 5 and 16 characters", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    } else if (!password.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    } else {
        boolean userExists = false;
        BufferedReader reader = null;

        try {
              File file = new File("src/AdminPackage/users.txt");
				if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs(); 
			}
			if (!file.exists()) {
				file.createNewFile(); 
			}


            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                String existingUsername = userDetails[0];

                if (existingUsername.equals(username)) {
                    userExists = true;
                    JOptionPane.showMessageDialog(this, "Username is already taken! Please choose a different one.", "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
                    break;
                }
            }
        } catch (IOException ex) {
			 ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading user data!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ez) {
            }
        }

        if (!userExists) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("src/AdminPackage/users.txt", true))) {
                writer.println(username + "," + password + "," + phone + "," + email);

                File userFile = new File("src/AdminPackage/"+username + ".txt");
                if (!userFile.exists()) {
                    userFile.createNewFile();
                }

                try (PrintWriter userWriter = new PrintWriter(new FileWriter(userFile))) {
                    userWriter.println("Username: " + username);
                    userWriter.println("Phone: " + phone);
                    userWriter.println("Email: " + email);
                    userWriter.println("Password: " + password);
                }

                JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
             			 
				this.setVisible(false); 
				 
				JapanessRamenCustomerLoginPage page = new JapanessRamenCustomerLoginPage();
				page.setTitle("Customer Food Service");
				page.setSize(900, 600);
				page.setLocationRelativeTo(null);
				page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				page.setVisible(true);
				page.setResizable(false);
				
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


}

