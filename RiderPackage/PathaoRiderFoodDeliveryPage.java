package RiderPackage;

import AdminPackage.*;
import CustomerPackage.*;
import ReviewPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.util.List;


public class PathaoRiderFoodDeliveryPage extends JFrame {
    private JLabel welcomeLabel, imageLabel,orderCountLabel, backgroundImageLabel;
    private JButton backButton,requestBoardButton,addBoardButton,homePageButton,addMoreBoardButton;
	private JTextArea foodDeliveryOrderArea;
	private JScrollPane scrollPane;
	private int riderTakenOrder = 0;
    private static final int MAX_ORDERS = 3;
	private boolean isOrderAccepted = false; 

  public PathaoRiderFoodDeliveryPage() {
    setUpPathaoRiderFoodDeliveryPage();
 
}

    private void setUpPathaoRiderFoodDeliveryPage() {
        
		Container container = getContentPane();
        container.setLayout(null);

        JPanel scrollablePanel = new JPanel();
        scrollablePanel.setLayout(null);
        scrollablePanel.setBackground(new Color(255, 223, 186));
        scrollablePanel.setOpaque(true);
        scrollablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Font largeLabelFont = new Font("Arial", Font.BOLD, 17);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the Pathao Food Rider Page", JLabel.CENTER);
        welcomeLabel.setBounds(155, 20, 650, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);


		String addMessage = "<html><div style='text-align: center;'><b>Accept Requested</b><br>Order</div></html>";
		
		addBoardButton = new JButton(addMessage);
        addBoardButton.setBounds(435, 485, 200, 60);
        addBoardButton.setFont(largeLabelFont);
        addBoardButton.setBackground(new Color(255, 99, 71));
        addBoardButton.setForeground(Color.WHITE);
        addBoardButton.setCursor(cursor);
		addBoardButton.addActionListener(this::onRequestBoardButtonClicked);		
        container.add(addBoardButton);
		
		String addMoreMessage = "<html><div style='text-align: center;'><b>Click here for Accpet</b><br>More Order</div></html>";
		
		addMoreBoardButton = new JButton(addMoreMessage);
        addMoreBoardButton.setBounds(650, 485, 200, 60);
        addMoreBoardButton.setFont(largeLabelFont);
        addMoreBoardButton.setBackground(new Color(50, 205, 50));
        addMoreBoardButton.setForeground(Color.WHITE);
        addMoreBoardButton.setCursor(cursor);
		addMoreBoardButton.addActionListener(this::onaddMoreBoardButton);		
        container.add(addMoreBoardButton);

		String requestMessage = "<html><div style='text-align: center;'><b> Click here to see </b><br> Customers Orders</div></html>";
		
		requestBoardButton = new JButton(requestMessage);
		requestBoardButton.setBounds(55, 100, 320, 60);
		requestBoardButton.setFont(new Font("Arial", Font.BOLD, 18));
		requestBoardButton.setBackground(new Color(50, 150, 255));
		requestBoardButton.setForeground(Color.WHITE);
		requestBoardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		requestBoardButton.addActionListener(this::loadFoodInventory); 
		container.add(requestBoardButton);
		
		
		homePageButton = new JButton("Home page");
		homePageButton.setBounds(10, 20, 135, 30);
		homePageButton.setFont(new Font("Arial", Font.BOLD, 18));
		homePageButton.setBackground(new Color(255, 99, 71));
		homePageButton.setForeground(Color.WHITE);
		homePageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homePageButton.addActionListener(this::goBack); 
		container.add(homePageButton);
		

        orderCountLabel = new JLabel("Orders Taken: ", JLabel.CENTER);
        orderCountLabel.setBounds(610, 430, 200, 40);
        orderCountLabel.setFont(boldFont);
        orderCountLabel.setForeground(Color.RED);
        orderCountLabel.setOpaque(true);
        orderCountLabel.setBackground(Color.WHITE);
        orderCountLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 2));
        container.add(orderCountLabel);
		
		foodDeliveryOrderArea = new JTextArea();
		foodDeliveryOrderArea.setEditable(false); 
		foodDeliveryOrderArea.setFont(new Font("Arial", Font.PLAIN, 16));  
		foodDeliveryOrderArea.setLineWrap(true);  
		foodDeliveryOrderArea.setWrapStyleWord(true); 
		foodDeliveryOrderArea.setBackground(new Color(240, 255, 240));  
		foodDeliveryOrderArea.setForeground(new Color(0, 0, 0));  		
		foodDeliveryOrderArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 128, 255), 2),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		
		scrollPane = new JScrollPane(foodDeliveryOrderArea);
		scrollPane.setBounds(25, 163, 400, 380); 
		container.add(scrollPane);
		
        backgroundImageLabel = new JLabel(new ImageIcon("Src_ImageStore/RiderLogin.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);

       
    }
	
	private boolean isFoodInventoryLoaded = false;  

private void loadFoodInventory(ActionEvent e) {
		if (isFoodInventoryLoaded) {
			
			ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
			JOptionPane.showMessageDialog(this, "Request Order Box has already been loaded.", " hello ", JOptionPane.ERROR_MESSAGE,blankImg);
			
			return;
		}

		try {
			Path filePath = Paths.get("src/AdminPackage/Pathao Riders Orders.txt");

			List<String> fileLines = Files.readAllLines(filePath);

			if (fileLines.isEmpty()) {
				foodDeliveryOrderArea.setText("\n \n \n \n              There are no orders from customers.\n              Thank you.");
				return;  
			}

			StringBuilder orderDetails = new StringBuilder();
			boolean readingOrder = false;
			int linesRead = 0;

			for (String line : fileLines) {
				if (line.contains("-------------------------------------------------------------") && !readingOrder) {                
					readingOrder = true;
					orderDetails.append(line).append("\n");
				} else if (readingOrder) {
					orderDetails.append(line).append("\n");                
					if (line.contains("Payment Status: Done")) {
						linesRead++; 
						break;
					}
				}
				linesRead++;
			}

			foodDeliveryOrderArea.setText(orderDetails.toString());

			List<String> remainingLines = fileLines.subList(linesRead, fileLines.size());
			Files.write(filePath, remainingLines);

			
			isFoodInventoryLoaded = true;

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
		}
	}

	private void onaddMoreBoardButton(ActionEvent e) {
		
		if (riderTakenOrder >= MAX_ORDERS) {
			try {
			Path filePath = Paths.get("src/AdminPackage/Pathao Riders Orders.txt");
			
			List<String> fileLines = Files.readAllLines(filePath);
			StringBuilder orderDetails = new StringBuilder();
			boolean readingOrder = false;
			int linesRead = 0;

			for (String line : fileLines) {
				if (line.contains("-------------------------------------------------------------") && !readingOrder) {                
					readingOrder = true;
					orderDetails.append(line).append("\n");
				} else if (readingOrder) {
					orderDetails.append(line).append("\n");                
					if (line.contains("Payment Status: Done")) {
						linesRead++; 
						break;
					}
				}
				linesRead++;
			}

			foodDeliveryOrderArea.setText(orderDetails.toString());
			} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
		}
			
			ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
			JOptionPane.showMessageDialog(this,  "You can take maximum 3 orders. Thank you.", "Maximum Orders Reached", JOptionPane.ERROR_MESSAGE,blankImg);
			
			return;  
		}

		try {
			Path filePath = Paths.get("src/AdminPackage/Pathao Riders Orders.txt");
			
			List<String> fileLines = Files.readAllLines(filePath);
			
			if (fileLines.isEmpty()) {
				foodDeliveryOrderArea.setText("\n \n \n \n \n \n \n  There are no orders from customers.\n \n   Thank you.");
				return; 
			}

			StringBuilder orderDetails = new StringBuilder();
			boolean readingOrder = false;
			int linesRead = 0;

			for (String line : fileLines) {
				if (line.contains("-------------------------------------------------------------") && !readingOrder) {                
					readingOrder = true;
					orderDetails.append(line).append("\n");
				} else if (readingOrder) {
					orderDetails.append(line).append("\n");                
					if (line.contains("Payment Status: Done")) {
						linesRead++; 
						break;
					}
				}
				linesRead++;
			}

			foodDeliveryOrderArea.setText(orderDetails.toString());

			List<String> remainingLines = fileLines.subList(linesRead, fileLines.size());
			Files.write(filePath, remainingLines);
			isOrderAccepted = false;

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
		}
	}



	
	private void onRequestBoardButtonClicked(ActionEvent e) {

		if (isOrderAccepted) {
		
			ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
			JOptionPane.showMessageDialog(this, "Order has already been accepted.", "Error", JOptionPane.ERROR_MESSAGE,blankImg);
		
		} else {
			if (riderTakenOrder < MAX_ORDERS) {
				riderTakenOrder++;
				orderCountLabel.setText("Orders Taken: " + riderTakenOrder);
				isOrderAccepted = true; 
				
				ImageIcon approve = new ImageIcon("Src_ImageStore/Approved.png");
				JOptionPane.showMessageDialog(this, "Order has been accepted.", "Congratulation", JOptionPane.ERROR_MESSAGE,approve);
				
				foodDeliveryOrderArea.setText("");
				
			} else {
				
				ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
				JOptionPane.showMessageDialog(this, "Maximum orders have been accepted.", "Error", JOptionPane.ERROR_MESSAGE,blankImg);
			}
		}
		
	}
	
	private void goBack(ActionEvent e) {
      
        JFrame mainPage = new ProjectMainPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
		this.dispose();
    }
	
}  