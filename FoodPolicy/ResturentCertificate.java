package FoodPolicy;

import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResturentCertificate extends JFrame {
    private Container container;
    private JLabel imageLabel;
    private JButton nextButton, previousButton, backButton;

    public ResturentCertificate() {
        setUpResturentCertificate();
    }

    private void setUpResturentCertificate() {
        container = getContentPane();
        container.setLayout(null); // Use null layout
        container.setBackground(new Color(240, 255, 240));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		String message1 = "<html><div style='text-align: center;'><b> Next </b><br> Certificate </div></html>";
		
        nextButton = new JButton(message1);
        nextButton.setBounds(300, 410, 280, 50); 
        nextButton.setFont(boldFont);
        nextButton.setBackground(new Color(255, 99, 71));
        nextButton.setForeground(Color.WHITE);
        nextButton.setCursor(cursor);
        nextButton.addActionListener(this::onNextButtonClick);
        container.add(nextButton);

        
        String message = "<html><div style='text-align: center;'><b> Previous </b><br> Certificate </div></html>";
        previousButton = new JButton(message);
        previousButton.setBounds(10, 410, 280, 50); 
        previousButton.setFont(backFont);
        previousButton.setBackground(new Color(255, 99, 71));
        previousButton.setForeground(Color.WHITE);
        previousButton.setCursor(cursor);
        previousButton.addActionListener(this::onPreviousButtonClick);
        container.add(previousButton);

     
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 80, 25); 
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);
		
		imageLabel = new JLabel(new ImageIcon("Src_ImageStore/ResturentCertificate.png"));
        imageLabel.setBounds(5, 0, 600, 400);
        container.add(imageLabel);

    }

   
    private void onNextButtonClick(ActionEvent e) {
        
			BusinessTradeLicense mainPage = new BusinessTradeLicense();
			mainPage.setTitle("Food Ordering System");
			mainPage.setSize(400, 600); 
			mainPage.setLocationRelativeTo(null); 
			mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainPage.setVisible(true);
			mainPage.setResizable(false);	
			
        this.setVisible(false);
    }
    private void onPreviousButtonClick(ActionEvent e) {
			
			ETradeLicence mainPage = new ETradeLicence();
			mainPage.setTitle("Food Delivery System");
			mainPage.setSize(400, 600);
			mainPage.setLocationRelativeTo(null);
			mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainPage.setVisible(true);
			mainPage.setResizable(false);
			this.setVisible(false);
    }

    private void goBack(ActionEvent e) {
        this.setVisible(false);
        JFrame mainPage = new ProjectMainPage();
        mainPage.setTitle("Food Ordering System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
    }
    
}
