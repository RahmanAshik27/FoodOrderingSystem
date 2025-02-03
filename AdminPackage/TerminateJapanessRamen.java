package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;

public class TerminateJapanessRamen extends JFrame {
    private Container container;
    private JLabel imageLabel, titleLabel;
    private JButton nextButton,previousButton, backButton, confirmButton;

    public TerminateJapanessRamen() {
        setUpTerminateJapanessRamen();
    }

    private void setUpTerminateJapanessRamen() {
        
		container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 255, 240));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        titleLabel = new JLabel("Japaness Ramen ", JLabel.CENTER);
        titleLabel.setBounds(15, 205, 250, 30);
        titleLabel.setFont(boldFont);
        container.add(titleLabel);

        nextButton = new JButton("Next Food");
        nextButton.setBounds(150, 240, 130, 50);
        nextButton.setFont(boldFont);
        nextButton.setBackground(new Color(255, 99, 71));
        nextButton.setForeground(Color.WHITE);
        nextButton.setCursor(cursor);
        nextButton.addActionListener(this::onNextButtonClick);
        container.add(nextButton);
		
		String message = "<html><div style='text-align: center;'><b> Previous </b><br> Food </div></html>";
		
		previousButton = new JButton(message);
		previousButton.setBounds(10, 240, 130, 50);
		previousButton.setFont(backFont);
		previousButton.setBackground(new Color(255, 99, 71));
		previousButton.setForeground(Color.WHITE);
		previousButton.setCursor(cursor);
		previousButton.addActionListener(this::onPreviousButtonClick);
		container.add(previousButton);


        confirmButton = new JButton("Wanna Terminate This Food? ");
        confirmButton.setBounds(10, 300, 265, 50);
        confirmButton.setFont(backFont);
        confirmButton.setBackground(new Color(50, 150, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setCursor(cursor);
        confirmButton.addActionListener(this::wannaTerminateThisFood);
        container.add(confirmButton);

        backButton = new JButton("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        imageLabel = new JLabel(new ImageIcon("Src_ImageStore/Japaness Ramen img.png"));
        imageLabel.setBounds(0, 0, 300, 200);
        container.add(imageLabel);
    }

    private void onNextButtonClick(ActionEvent e) {
			
			TerminateChikhenDumBiriyani mainPage = new TerminateChikhenDumBiriyani();
			mainPage.setTitle("Food Delivery System");
			mainPage.setSize(300, 400);
			mainPage.setLocationRelativeTo(null);
			mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainPage.setVisible(true);
			mainPage.setResizable(false);
			this.setVisible(false);
    }
	
	private void onPreviousButtonClick(ActionEvent e) {
       
		TerminateCreammyPasta mainPage = new TerminateCreammyPasta();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(300, 400);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
		this.setVisible(false);
		
    }
	
	private void wannaTerminateThisFood(ActionEvent e) {
    ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
	ImageIcon okImg = new ImageIcon("Src_ImageStore/okImg.png");
			int choice = JOptionPane.showConfirmDialog(
				this,
				"Are you sure? You want to terminate this food.",
				"Are You Sure?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				blankImg
			);
			
    if (choice == JOptionPane.YES_OPTION) {
        
			JOptionPane.showMessageDialog(
				this,
				"Your request has been forwarded to the IT Department. They will address it promptly.",
				"Request Sent",
				JOptionPane.INFORMATION_MESSAGE,okImg
			);
    }
}




    private void goBack(ActionEvent e) {
        
		this.setVisible(false);
		IncomeStatementDepartmentOfFoodPage incomeStatementDepartmentOfFoodPage = new IncomeStatementDepartmentOfFoodPage();
        incomeStatementDepartmentOfFoodPage.setTitle("Income Statement Department Of FoodPage");
        incomeStatementDepartmentOfFoodPage.setSize(900, 600);
        incomeStatementDepartmentOfFoodPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        incomeStatementDepartmentOfFoodPage.setLocationRelativeTo(null);
        incomeStatementDepartmentOfFoodPage.setVisible(true);
        incomeStatementDepartmentOfFoodPage.setResizable(false);
		
    }

}
