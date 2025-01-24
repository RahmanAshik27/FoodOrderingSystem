package CustomerPackage;

import AdminPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import DashboardPackage.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class CashMemoPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, imageLabel;
    private JTextArea memoTextArea;
    private JButton paymentButton, selectRiderButton, proceedButton;
	private String riderChoice;
	private String paymentMethod;
	private String username;

    public CashMemoPage(String username) {
    
	this.username=username;
	setupCashMemoPage();
    loadOrdersFromFile(); 
	
}

    private void setupCashMemoPage() {
        container = getContentPane();
        container.setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to Cash Memo Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);
		
		memoTextArea = new JTextArea();
		memoTextArea.setEditable(false); 
		memoTextArea.setFont(new Font("Arial", Font.BOLD, 16));  
		memoTextArea.setLineWrap(true);  
		memoTextArea.setWrapStyleWord(true); 
		memoTextArea.setBackground(new Color(240, 255, 240));  
		memoTextArea.setForeground(new Color(0, 0, 0));  		
		memoTextArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 128, 255), 2),
				BorderFactory.createEmptyBorder(20, 30, 20, 30)
		));

        JScrollPane scrollPane = new JScrollPane(memoTextArea);
        scrollPane.setBounds(350, 120, 440, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        container.add(scrollPane);

        paymentButton = new JButton("Choice Payment Option ");
        paymentButton.setBounds(80, 200, 250, 50);
        paymentButton.setFont(buttonFont);
        paymentButton.setBackground(new Color(50, 150, 255));
        paymentButton.setForeground(Color.WHITE);
		paymentButton.setCursor(cursor);
        paymentButton.addActionListener(this::handlePaymentMore);
        container.add(paymentButton);
		

        selectRiderButton = new JButton("Select Rider");
        selectRiderButton.setBounds(80, 270, 250, 50);
        selectRiderButton.setFont(buttonFont);
        selectRiderButton.setBackground(new Color(255, 99, 71));
        selectRiderButton.setForeground(Color.WHITE);
        selectRiderButton.addActionListener(this::handleSelectRider);
        container.add(selectRiderButton);

        proceedButton = new JButton("Confirm Order");
        proceedButton.setBounds(80, 340, 250, 50);
        proceedButton.setFont(buttonFont);
        proceedButton.setBackground(new Color(34, 139, 34));
        proceedButton.setForeground(Color.WHITE);
        proceedButton.addActionListener(this::handleProceed);
        container.add(proceedButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(380, 530, 250, 30);
        footerLabel.setFont(buttonFont);
        footerLabel.setForeground(Color.BLACK);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(255, 255, 255, 150));
        container.add(footerLabel);

        imageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
    }

   private void saveMemoToFile(String memoContent) {
    try {
        File outputFile = new File("src/AdminPackage/CustomersOrder.txt");
        
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
        writer.write(memoContent); 
        writer.close();
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());
        ex.printStackTrace();
    }
}

	private void handlePaymentMore(ActionEvent e) {
        String[] paymentMethods = { "Online Payment", "Cash on Delivery" };
        String selectedPaymentMethod = (String) JOptionPane.showInputDialog(
                this,
                "Please select your preferred payment method:",
                "Payment Method Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                paymentMethods,
                paymentMethods[0]);

        if (selectedPaymentMethod == null || selectedPaymentMethod.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a payment method.");
            return;
        }

        
        paymentMethod = selectedPaymentMethod;

        StringBuilder memoBuilder = new StringBuilder();

        if (paymentMethod.equals("Cash on Delivery")) {
            memoTextArea.append("\nPayment Method: Cash on Delivery\n");
            JOptionPane.showMessageDialog(
                    this,
                    "You have selected 'Cash on Delivery'.\nPlease be ready to pay upon delivery.",
                    "Cash on Delivery",
                    JOptionPane.INFORMATION_MESSAGE);
            memoBuilder.append("Payment Method: Cash on Delivery\n");
        } else if (paymentMethod.equals("Online Payment")) {
            
            String[] onlineMethods = { "Bikash", "Nogod", "Rocket" };
            String selectedOnlinePayment = (String) JOptionPane.showInputDialog(
                    this,
                    "Please select your preferred online payment method:",
                    "Online Payment Method",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    onlineMethods,
                    onlineMethods[0]);

            if (selectedOnlinePayment == null || selectedOnlinePayment.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select an online payment method.");
                return;
            }

            String accountNumber = JOptionPane.showInputDialog(
                    this,
                    "Enter your " + selectedOnlinePayment + " account number:",
                    "Account Number Input",
                    JOptionPane.PLAIN_MESSAGE);

            if (accountNumber == null || accountNumber.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Account number is required! Please try again.",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String otp = JOptionPane.showInputDialog(
                    this,
                    "Enter the OTP sent to your registered mobile number:",
                    "OTP Verification",
                    JOptionPane.PLAIN_MESSAGE);

            if (otp == null || otp.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "OTP is required! Please try again.",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (otp.equals("12345")) {
                
				ImageIcon okImg = new ImageIcon("okImg.png");
				
				JOptionPane.showMessageDialog(
                        
						this,
                        "Payment Successful!\nThank you for using " + selectedOnlinePayment + ".",
                        "Payment Confirmation",
                        JOptionPane.INFORMATION_MESSAGE,okImg);
						
                memoTextArea.append("\nPayment Method: " + selectedOnlinePayment + " (" + accountNumber + ")");
                memoTextArea.append("\nPayment Status: Done\n");
                memoBuilder.append("Payment Method: " + selectedOnlinePayment + " (" + accountNumber + ")\n");
                memoBuilder.append("Payment Status: Done\n");
                memoBuilder.append("-------------------------------------------------------------\n");
                saveMemoToFile(memoBuilder.toString());
            } else {
				ImageIcon blankImg = new ImageIcon("FillAllbox.png");
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid OTP! Payment failed. Please try again.",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE,blankImg);
            }
        } 
    }

	private void handleSelectRider(ActionEvent e) {
		
		String[] riderOptions = {
			"Pathao Riders",
			"FoodiBd Riders",
			"IEatray Riders",
			"Jhinku Food Bd Riders",
			"Raihan Express Riders"
		};

	   
		riderChoice = (String) JOptionPane.showInputDialog(
			this,                     
			"Select a Rider:",        
			"Choose Rider",            
			JOptionPane.PLAIN_MESSAGE, 
			null,                     
			riderOptions,              
			riderOptions[0]            
		);

		
		if (riderChoice != null) {
		    ImageIcon okImg = new ImageIcon("okImg.png");
			
			JOptionPane.showMessageDialog(this, "You selected: " + String.valueOf(riderChoice) + " Done", 
                              "Selection", JOptionPane.ERROR_MESSAGE, okImg);

			
		} else {
			
			JOptionPane.showMessageDialog(this, "No rider selected.");
		}
	}

		
	
private void handleProceed(ActionEvent e) {
   
		ImageIcon blankImg = new ImageIcon("FillAllbox.png");
	
    if (riderChoice == null || riderChoice.isEmpty()) {
     
		JOptionPane.showMessageDialog(this, "Please select a rider first.", "Error", JOptionPane.ERROR_MESSAGE,blankImg);
        return;
    }

    if (paymentMethod == null || paymentMethod.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a payment method!", "Error", JOptionPane.ERROR_MESSAGE,blankImg);
		
        return;
    }

    
    String fileName = null;
    switch (riderChoice) {
        case "Pathao Riders":
            fileName = "src/AdminPackage/Pathao Riders Orders.txt";
            break;
        case "FoodiBd Riders":
            fileName = "src/AdminPackage/FoodiBd Riders Orders.txt";
            break;
        case "IEatray Riders":
            fileName = "src/AdminPackage/IEatray Riders Orders.txt";
            break;
        case "Jhinku Food Bd Riders":
            fileName = "src/AdminPackage/Jhinku Food Bd Riders Orders.txt";
            break;
        case "Raihan Express Riders":
            fileName = "src/AdminPackage/Raihan Express Riders Orders.txt";
            break;
        default:
            JOptionPane.showMessageDialog(this, "Invalid rider choice!");
            return;
    }

    
    try {
        File outputFile = new File(fileName);
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
        writer.write(memoTextArea.getText());
        writer.close();

		ImageIcon okImg = new ImageIcon("okImg.png");
		JOptionPane.showMessageDialog(this, "Order successfull ", "Error", JOptionPane.ERROR_MESSAGE,okImg);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());
        ex.printStackTrace();
    }

    
    new ThankYouPage().setVisible(true);
}

private void loadOrdersFromFile() {
    try {
        File inputFile = new File("src/AdminPackage/" + username + ".txt");
        if (!inputFile.exists()) {
            JOptionPane.showMessageDialog(this, "Input file not found!");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        String username = null, phone = null, email = null;
        List<String> orderLines = new ArrayList<>();
        StringBuilder memoBuilder = new StringBuilder();
        boolean foundLastLogin = false;

        // Read the file to find the last "Login Successful:"
        List<String> tempOrderLines = new ArrayList<>(); // Temporary storage for orders in a block
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Username:")) {
                username = line.split(":")[1].trim();
            }
            if (line.startsWith("Phone:")) {
                phone = line.split(":")[1].trim();
            }
            if (line.startsWith("Email:")) {
                email = line.split(":")[1].trim();
            }
            if (line.startsWith("Login Successful:")) {
                foundLastLogin = true; // Mark that a "Login Successful:" block has started
                tempOrderLines.clear(); // Reset temp storage for the new block
            } else if (foundLastLogin && line.startsWith("Food Item:")) {
                tempOrderLines.add(line);
            }
        }

        // Use the orders from the last block
        if (!tempOrderLines.isEmpty()) {
            orderLines.addAll(tempOrderLines);
        }

        reader.close();

        // Build the cash memo with the extracted data
        if (!orderLines.isEmpty()) {
            appendCashMemo(memoBuilder, username, phone, email, orderLines);
        }

        // Update the text area with the formatted memo
        memoTextArea.setText(memoBuilder.toString());
        memoTextArea.setCaretPosition(memoTextArea.getDocument().getLength());

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
        ex.printStackTrace();
    }
}


private void appendCashMemo(StringBuilder memoBuilder, String username, String phone, String email, List<String> orderLines) {
    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append("                  Cash Memo\n");
    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append("Order No: 1\n");  // You can adjust this for multiple orders if needed
    memoBuilder.append("Date: ").append(java.time.LocalDate.now())
                .append("          Time: ").append(java.time.LocalTime.now().withNano(0)).append("\n\n");
    memoBuilder.append("Customer Name: ").append(username != null ? username : "Not Available").append("\n");
    memoBuilder.append("Contact Number: ").append(phone != null ? phone : "Not Available").append("\n");
    memoBuilder.append("Email: ").append(email != null ? email : "Not Available").append("\n");
    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append("Item Name         Quantity       Unit Price     Total\n");
    memoBuilder.append("-------------------------------------------------------------\n");

    double subtotal = 0.0;
    for (String order : orderLines) {
        String[] parts = order.split(", ");
        String itemName = parts[0].split(":")[1].trim();
        String quantity = parts[1].split(":")[1].trim();
        String unitPrice = parts[2].split(":")[1].trim();
        String totalPrice = parts[3].split(":")[1].trim();

        memoBuilder.append(String.format("%-16s %-14s %-14s %s\n", itemName, quantity, unitPrice, totalPrice));
        subtotal += Double.parseDouble(totalPrice);
    }

    double vat = subtotal * 0.05;
    double totalAmount = subtotal + vat;

    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append(String.format("Subtotal: %38.2f\n", subtotal));
    memoBuilder.append(String.format("VAT (5%%): %37.2f\n", vat));
    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append(String.format("Total Amount: %33.2f\n", totalAmount));
    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append("Payment Method: Cash\n");
    memoBuilder.append("-------------------------------------------------------------\n");
    memoBuilder.append("          Thank You for Your Visit!\n");
    memoBuilder.append("       Visit Again at Food Ordering System\n");
    memoBuilder.append("-------------------------------------------------------------\n");

    // Optionally save to a file
    saveMemoToFile(memoBuilder.toString());
}



}

