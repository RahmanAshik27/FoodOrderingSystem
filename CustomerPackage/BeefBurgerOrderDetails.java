package CustomerPackage;

import AdminPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;

public class BeefBurgerOrderDetails extends JFrame {
    private Container container;
    private JLabel welcomeLabel, availableFoodLabel, footerLabel, quantityLabel, itemCountLabel,imageLabel,backgroundImageLabel,foodPriceLabel;
    private JButton addItemButton, removeItemButton, orderConfirmButton, addQuantityButton,addMoreButton,proceedToMemoButton,backButton;
    private JSpinner quantitySpinner;
	private String username;

    private int itemCount = 0; 
    private String selectedFood = "Beef Burger"; 
    private int availableQuantity; 
	private int price;
	
    private JTextArea reviewArea;
	private JTextField ratingDisplayTextField;
    private JScrollPane scrollPane;

    private static final String FILE_PATH = "src/AdminPackage/food_inventory.txt"; 
		private String orderConfirm;

public BeefBurgerOrderDetails(String username) {
		this.username=username;
        loadFoodInventoryFromFile();
        setupOrderPage();
    }

 private void loadFoodInventoryFromFile() {
    try {
        
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            Files.write(path, "Beef Burger,50,350\n burger,30,400".getBytes()); 
        }
      
        String[] lines = new String(Files.readAllBytes(path)).split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].trim().equalsIgnoreCase(selectedFood)) {
                availableQuantity = Integer.parseInt(parts[1].trim()); 
                 price = Integer.parseInt(parts[2].trim()); 
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        availableQuantity = 10; 
    }
}
private void saveFoodInventoryToFile() {
    try {
        StringBuilder updatedContent = new StringBuilder();
        
        String[] lines = new String(Files.readAllBytes(Paths.get(FILE_PATH))).split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].trim().equalsIgnoreCase(selectedFood)) {
                updatedContent.append(parts[0]).append(",").append(availableQuantity).append(",")
                        .append(parts[2]).append("\n"); 
            } else {
                updatedContent.append(line).append("\n");
            }
        }
 
        Files.write(Paths.get(FILE_PATH), updatedContent.toString().getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    private void setupOrderPage() {
        container = getContentPane();
        container.setLayout(null); 
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
		Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
		Font ratingLabelFont = new Font("Arial", Font.BOLD, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        
        welcomeLabel = new JLabel("Welcome to the Customer FoodService Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 15, 650, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);


		availableFoodLabel = new JLabel("Available Food: " + selectedFood + " - " + availableQuantity + " Available", JLabel.CENTER);
		availableFoodLabel.setBounds(440, 112, 420, 30);
		availableFoodLabel.setFont(labelFont);
		availableFoodLabel.setOpaque(true);
		availableFoodLabel.setBackground(Color.WHITE);
		availableFoodLabel.setForeground(Color.BLACK);
		container.add(availableFoodLabel);
		
		
		foodPriceLabel = new JLabel(selectedFood + " - Price is : " + price + "  Taka", JLabel.CENTER);
		foodPriceLabel.setBounds(440, 149, 420, 30);
		foodPriceLabel.setFont(labelFont);
		foodPriceLabel.setOpaque(true);
		foodPriceLabel.setBackground(Color.WHITE);
		foodPriceLabel.setForeground(Color.BLACK);
		container.add(foodPriceLabel);
	
 
        addItemButton = new JButton("Add Item 1X ");
        addItemButton.setBounds(490, 187, 150, 40);
        addItemButton.setFont(new Font("Arial", Font.BOLD, 16));
        addItemButton.setBackground(new Color(50, 150, 255));
        addItemButton.setForeground(Color.WHITE);
        addItemButton.setCursor(cursor);
        addItemButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        addItemButton.addActionListener(this::addItemAction);
        container.add(addItemButton);

       
        removeItemButton = new JButton("Remove Item 1x ");
        removeItemButton.setBounds(650, 187, 150, 40);
        removeItemButton.setFont(new Font("Arial", Font.BOLD, 16));
        removeItemButton.setBackground(new Color(255, 99, 71));
        removeItemButton.setForeground(Color.WHITE);
        removeItemButton.setCursor(cursor);
        removeItemButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        removeItemButton.addActionListener(this::removeItemAction);
        container.add(removeItemButton);
		
		addMoreButton = new JButton("Want to add more Food ? ");
        addMoreButton.setBounds(600, 420 , 250 , 40);
        addMoreButton.setFont(new Font("Arial", Font.BOLD, 16));
        addMoreButton.setBackground(new Color(50, 150, 255));
        addMoreButton.setForeground(Color.WHITE);
        addMoreButton.setCursor(cursor);
        addMoreButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        addMoreButton.addActionListener(this::addMoreItemAction);
        container.add(addMoreButton);
		
		proceedToMemoButton = new JButton("Proceed To Cash Memo ");
        proceedToMemoButton.setBounds(600, 470 , 250 , 40);
        proceedToMemoButton.setFont(new Font("Arial", Font.BOLD, 16));
        proceedToMemoButton.setBackground(new Color(255, 99, 71));
        proceedToMemoButton.setForeground(Color.WHITE);
        proceedToMemoButton.setCursor(cursor);
        proceedToMemoButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        proceedToMemoButton.addActionListener(this::proccedToMemoAction);
        container.add(proceedToMemoButton);

      
        itemCountLabel = new JLabel("   Items in Order: " + itemCount);
        itemCountLabel.setBounds(555, 240, 150, 30);
        itemCountLabel.setFont(labelFont);
		itemCountLabel.setOpaque(true);
		itemCountLabel.setBackground(Color.WHITE);
		itemCountLabel.setForeground(Color.BLACK);
        container.add(itemCountLabel);

    
        quantityLabel = new JLabel("Quantity: ");
        quantityLabel.setBounds(490, 285, 80, 30);
        quantityLabel.setFont(labelFont);
		quantityLabel.setOpaque(true);
		quantityLabel.setBackground(Color.WHITE);
		quantityLabel.setForeground(Color.BLACK);
        container.add(quantityLabel);

    
        quantitySpinner = new JSpinner(new SpinnerNumberModel(0, 0, availableQuantity, 1));
        quantitySpinner.setBounds(570, 280, 80, 40); 


		JComponent editor = quantitySpinner.getEditor();
			if (editor instanceof JSpinner.DefaultEditor)
			{
				JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
			
				JTextField textField = spinnerEditor.getTextField();
				textField.setHorizontalAlignment(JTextField.CENTER);
				textField.setFont(new Font("Arial", Font.BOLD, 16));
				textField.setBackground(new Color(240, 255, 240));
				textField.setForeground(new Color(50, 50, 50));  
				textField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true)); 
				textField.setEditable(false); 
				
			}

		container.add(quantitySpinner);

        addQuantityButton = new JButton("Add Quantity");
        addQuantityButton.setBounds(660, 285, 150, 30);
        addQuantityButton.setFont(new Font("Arial", Font.BOLD, 14));
        addQuantityButton.setBackground(new Color(60, 179, 113));
        addQuantityButton.setForeground(Color.WHITE);
        addQuantityButton.setCursor(cursor);
        addQuantityButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        addQuantityButton.addActionListener(this::addQuantityAction);
        container.add(addQuantityButton);


        orderConfirmButton = new JButton("Order Confirm");
        orderConfirmButton.setBounds(565, 335, 150, 40);
        orderConfirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        orderConfirmButton.setBackground(new Color(50, 150, 255));
        orderConfirmButton.setForeground(Color.WHITE);
        orderConfirmButton.setCursor(cursor);
        orderConfirmButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        orderConfirmButton.addActionListener(this::orderConfirmAction);
        container.add(orderConfirmButton);
		

		reviewArea = new JTextArea();
		reviewArea.setEditable(false); 
		reviewArea.setFont(new Font("Arial", Font.PLAIN, 20));  
		reviewArea.setLineWrap(true);  
		reviewArea.setWrapStyleWord(true); 
		reviewArea.setBackground(new Color(240, 255, 240));  
		reviewArea.setForeground(new Color(0, 0, 0));  
		reviewArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
		
		readCustomerReviews();


		scrollPane = new JScrollPane(reviewArea);
		scrollPane.setBounds(30, 420, 400, 150); 
		container.add(scrollPane);
		
		
		String message = "<html><div style='text-align: center;'><b>How much Our Customers</b><br>Rate it?.</div></html>";
		JLabel ratingLabel2 = new JLabel(message, JLabel.CENTER);
        ratingLabel2.setBounds(435, 385, 150, 70);
        ratingLabel2.setFont(ratingLabelFont);
        ratingLabel2.setForeground(Color.WHITE);
        ratingLabel2.setOpaque(true);
        ratingLabel2.setBackground(new Color(0, 0, 0, 150));
        container.add(ratingLabel2);
		
		ratingDisplayTextField = new JTextField();
        ratingDisplayTextField.setBounds(450, 460, 100, 50);
        ratingDisplayTextField.setFont(new Font("Arial", Font.BOLD, 20));
        ratingDisplayTextField.setHorizontalAlignment(JTextField.CENTER);
        ratingDisplayTextField.setEditable(false);
        ratingDisplayTextField.setBackground(new Color(220, 240, 255));
        ratingDisplayTextField.setForeground(Color.RED);
        ratingDisplayTextField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 2));
		loadAverageRating("ReviewPackage/CustomersReviewsForBeefBurger.txt");
        container.add(ratingDisplayTextField);

		JLabel RatingLabel = new JLabel("Customers Review for Beef Burger", JLabel.CENTER);
		RatingLabel.setBounds(30, 385, 400, 30);
		RatingLabel.setFont(ratingLabelFont);
		RatingLabel.setForeground(Color.WHITE);
		RatingLabel.setOpaque(true);
		RatingLabel.setBackground(new Color(0, 0, 0, 150));
		container.add(RatingLabel);		
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(ratingLabelFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

		imageLabel = new JLabel(new ImageIcon("Src_ImageStore/BigBeefBurger.png"));
        imageLabel.setBounds(50, 95, 380, 270);
        container.add(imageLabel);

		backgroundImageLabel = new JLabel(new ImageIcon("Src_ImageStore/Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	private void readCustomerReviews() {
		File reviewFile = new File("ReviewPackage/CustomersReviewsForBeefBurger.txt");
			if (!reviewFile.exists()) {
				JOptionPane.showMessageDialog(this, "Review file not found!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

        StringBuilder reviewsBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(reviewFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                reviewsBuilder.append(line).append("\n");
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error reading reviews file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        reviewArea.setText(reviewsBuilder.toString());
	}
	
	private void loadAverageRating(String filePath) {
			File reviewFile = new File(filePath);
			if (!reviewFile.exists()) {
				JOptionPane.showMessageDialog(this, "Review file not found!", "Error", JOptionPane.ERROR_MESSAGE);
				ratingDisplayTextField.setText("N/A");
				return;
			}

			int totalRating = 0;
			int ratingCount = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(reviewFile))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.contains("Rating:")) {
						int ratingIndex = line.lastIndexOf("Rating:") + 8;
						int rating = Integer.parseInt(line.substring(ratingIndex).trim());
						totalRating += rating;
						ratingCount++;
					}
				}
			} catch (IOException | NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error reading rating file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ratingDisplayTextField.setText("N/A");
				return;
			}

			if (ratingCount > 0) {
				double averageRating = (double) totalRating / ratingCount;
				ratingDisplayTextField.setText(String.format("%.2f", averageRating));
			} else {
				ratingDisplayTextField.setText("N/A");
			}
		}
	
    private void addItemAction(ActionEvent e) {
        if (itemCount < availableQuantity) {
            itemCount++; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
			
            JOptionPane.showMessageDialog(this, "Not enough " + selectedFood + " available. Please reduce the quantity.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }

    private void removeItemAction(ActionEvent e) {
        if (itemCount > 0) {
            itemCount--; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Cannot remove more items than currently in order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }
	

	private void addMoreItemAction(ActionEvent e) {
		
		ImageIcon icon = new ImageIcon("Src_ImageStore/Eating Cat.png"); 

		int response = JOptionPane.showConfirmDialog(
			this, 
			"Are you sure you want to order more?", 
			"Confirm Order", 
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE, 
			icon
		);

		if (response == JOptionPane.YES_OPTION) {
			CustomerFoodServiceOptionsPage customerFoodServiceOptionsPage = new CustomerFoodServiceOptionsPage(username);
			customerFoodServiceOptionsPage.setTitle("Food Delivery System");
			customerFoodServiceOptionsPage.setSize(900, 600);
			customerFoodServiceOptionsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			customerFoodServiceOptionsPage.setLocationRelativeTo(null);
			customerFoodServiceOptionsPage.setVisible(true);
			customerFoodServiceOptionsPage.setResizable(false);
			this.dispose();
		}
	}

	
	private void proccedToMemoAction(ActionEvent e) {
    ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");

   
    if (orderConfirm == null) {
        JOptionPane.showMessageDialog(this, "Please Confirm Your Order.", "Error", JOptionPane.WARNING_MESSAGE, BlankImg);
    } else {
       
        int response = JOptionPane.showConfirmDialog(
            this, 
            "Are you sure you want to proceed with your order?", 
            "Confirm Order", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            BlankImg
        );

        
        if (response == JOptionPane.YES_OPTION) {
            CashMemoPage cashMemoPage = new CashMemoPage(username);
            cashMemoPage.setTitle("Cash Memo Page");
            cashMemoPage.setSize(900, 600);
            cashMemoPage.setLocationRelativeTo(null);
            cashMemoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cashMemoPage.setVisible(true);
            cashMemoPage.setResizable(false);
            this.dispose();
        }
    }
}


    private void addQuantityAction(ActionEvent e) {
        int quantity = (int) quantitySpinner.getValue();
        if (quantity > 0 && itemCount + quantity <= availableQuantity) {
            itemCount += quantity;
            itemCountLabel.setText("Items in Order: " + itemCount);
            quantitySpinner.setValue(0); 
        } else if (quantity == 0) {
			ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please select a valid quantity.", "Error", JOptionPane.WARNING_MESSAGE, BlankImg);
        } else {
			ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Not enough " + selectedFood + " available. Please reduce the quantity.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }

	
	private void orderConfirmAction(ActionEvent e) {
    if (itemCount > 0) {
        availableQuantity -= itemCount;
        int quantity = itemCount; 
        itemCount = 0;
        itemCountLabel.setText("Items in Order: " + itemCount);
		
		saveFoodInventoryToFile();
        writeOrderDetails(selectedFood, quantity, price);  

        availableFoodLabel.setText("Available Food: " + selectedFood + " - " + availableQuantity + " Available");

        ImageIcon okImg = new ImageIcon("Src_ImageStore/okImg.png");
        JOptionPane.showMessageDialog(this, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);

        availableFoodLabel.setOpaque(true);
        availableFoodLabel.setBackground(Color.WHITE);
        availableFoodLabel.setForeground(Color.BLACK);
    } else {
    
        ImageIcon BlankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
        JOptionPane.showMessageDialog(this, "Please add items to your order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
    }
	orderConfirm="done";
}

	
	private void writeOrderDetails(String foodItem, int quantity, double price) {
    
	String filename ="src/AdminPackage/"+ username + ".txt"; 
    double totalPrice = quantity * price; 

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        writer.write("Food Item: " + foodItem + ", Quantity: " + quantity + ", Price: " + price + ", Total Price: " + totalPrice + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

	
	  private void goBack(ActionEvent e) {
      
        this.setVisible(false); 
        CustomerFoodServiceOptionsPage customerFoodServiceOptionsPage = new CustomerFoodServiceOptionsPage(username);
        customerFoodServiceOptionsPage.setTitle("Food Delivery System");
        customerFoodServiceOptionsPage.setSize(900, 600);
        customerFoodServiceOptionsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFoodServiceOptionsPage.setLocationRelativeTo(null);
        customerFoodServiceOptionsPage.setVisible(true);
        customerFoodServiceOptionsPage.setResizable(false);
    }

}

