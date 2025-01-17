import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;

class CustomerFoodServiceOptionsPage extends JFrame {
    private JLabel welcomeLabel, footerLabel;
	private JButton backButton;
	private String username;
    CustomerFoodServiceOptionsPage(String username) {
		
		this.username=username;
        setUpFoodServiceOptionsPage();
    }

    private void setUpFoodServiceOptionsPage() {
        Container container = getContentPane();
        container.setLayout(null);

        JPanel scrollablePanel = new JPanel();
        scrollablePanel.setLayout(null);
        scrollablePanel.setBackground(new Color(255, 223, 186));
        scrollablePanel.setOpaque(true);
        scrollablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);


        welcomeLabel = new JLabel("Welcome to the Customer FoodService Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 650, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        int panelHeight = 100 + 10 * 50;
        scrollablePanel.setPreferredSize(new Dimension(580, panelHeight));

        JLabel aLabel = new JLabel("A      ", JLabel.CENTER);
        aLabel.setBounds(5, 10, 560, 30);
        aLabel.setForeground(Color.RED);
        aLabel.setOpaque(true);
        aLabel.setBackground(Color.WHITE);
        aLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(aLabel);

        JLabel bLabel = new JLabel("B      ", JLabel.CENTER);
        bLabel.setBounds(5, 420, 560, 30);
        bLabel.setForeground(Color.RED);
        bLabel.setOpaque(true);
        bLabel.setBackground(Color.WHITE);
        bLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(bLabel);

        String buttonMessage = "<html><div style='text-align: center;'><b>Order</b><br>Now</div></html>";

		createFoodItemButton(scrollablePanel, 1, buttonMessage, 60,new Color(255, 99, 71));
        createFoodLabel(scrollablePanel, "Chicken Dum Biriyani", 60);
        createFoodImageLabel(scrollablePanel, "Food Image 1", "chikenbiriyani.png", 60);

        createFoodItemButton(scrollablePanel, 2, buttonMessage, 180,new Color(60, 179, 113));
        createFoodLabel(scrollablePanel, "Beef Burger", 180);
        createFoodImageLabel(scrollablePanel, "beef burger", "beef burger.png", 180);

        createFoodItemButton(scrollablePanel, 3, buttonMessage, 300,new Color(50, 150, 255));
        createFoodLabel(scrollablePanel, "Creammy Pasta ", 300);
        createFoodImageLabel(scrollablePanel, "Food Image 3", "pasta.png", 300);

        createFoodItemButton(scrollablePanel, 4, buttonMessage, 470,new Color(255, 99, 71));
        createFoodLabel(scrollablePanel, "Japaness Ramen", 470);
        createFoodImageLabel(scrollablePanel, "Food Image 4", "rammen.png", 470);

        JScrollPane scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(200, 130, 500, 410);
        container.add(scrollPane);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(380, 500, 250, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.BLACK);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(255, 255, 255, 150));
        container.add(footerLabel);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);	

        JLabel backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }

    private void createFoodItemButton(JPanel panel, int buttonIndex, String label, int yPosition, Color backgroundColor) {
    JButton button = new JButton(label);
    button.setBounds(370, yPosition + 12, 100, 75);
    button.setFont(new Font("Arial", Font.BOLD, 16));
    button.setBackground(backgroundColor); // Use the custom background color
    button.setForeground(Color.WHITE);
    button.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
    button.addActionListener(e -> handleButtonAction(buttonIndex));
    panel.add(button);
}

    private void createFoodLabel(JPanel panel, String labelText, int yPosition) {
        JLabel label = new JLabel(labelText, JLabel.CENTER);
        label.setBounds(150, yPosition + 25, 200, 50);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBackground(new Color(240, 255, 240));
        label.setForeground(Color.RED);
        label.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        label.setOpaque(true);
        panel.add(label);
    }

    private void createFoodImageLabel(JPanel panel, String labelText, String imagePath, int yPosition) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(20, yPosition, 110, 110);
        panel.add(imageLabel);
    }

    private void handleButtonAction(int buttonIndex) {
        switch (buttonIndex) {
            case 1:
               
			ChikenDumBiriyaniOrderDetails chikenDumBiriyani = new ChikenDumBiriyaniOrderDetails(username);
			chikenDumBiriyani.setTitle("Food Order Details");
			chikenDumBiriyani.setSize(900, 600);
			chikenDumBiriyani.setLocationRelativeTo(null);
			chikenDumBiriyani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			chikenDumBiriyani.setVisible(true);
			chikenDumBiriyani.setResizable(false);
			
			this.setVisible(false); 
    
                break;
            case 2:
				
				
				BeefBurgerOrderDetails beefBurger = new BeefBurgerOrderDetails(username);
				beefBurger.setTitle("Food Order Details");
				beefBurger.setSize(900, 600);
				beefBurger.setLocationRelativeTo(null);
				beefBurger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				beefBurger.setVisible(true);
				beefBurger.setResizable(false);
                
				this.setVisible(false); 
                break;
            case 3:
				
				
				CreammyPastaDetails creammyPasta = new CreammyPastaDetails(username);
				creammyPasta.setTitle("Food Order Details");
				creammyPasta.setSize(900, 600);
				creammyPasta.setLocationRelativeTo(null);
				creammyPasta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				creammyPasta.setVisible(true);
				creammyPasta.setResizable(false);
                
				this.setVisible(false); 
                
                break;
            case 4:
                
				JapanessRamenDetails japanessRamen = new JapanessRamenDetails(username);
				japanessRamen.setTitle("Food Order Details");
				japanessRamen.setSize(900, 600);
				japanessRamen.setLocationRelativeTo(null);
				japanessRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				japanessRamen.setVisible(true);
				japanessRamen.setResizable(false);
                
				this.setVisible(false); 
				
                break;
           
            default:
                JOptionPane.showMessageDialog(this, "Food Item " + buttonIndex + " selected");
                break;
        }
    }
		
		 private void goBack(ActionEvent e) {     
			
			this.setVisible(false);
   
			CustomerFoodService page = new CustomerFoodService(username);
            page.setTitle("Customer Food Service");
            page.setSize(900, 600);
            page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page.setLocationRelativeTo(null);
            page.setVisible(true);
				
		}
}


class ChikenDumBiriyaniOrderDetails extends JFrame {
    private Container container;
    private JLabel welcomeLabel, availableFoodLabel, footerLabel, quantityLabel, itemCountLabel,imageLabel,backgroundImageLabel,foodPriceLabel;
    private JButton addItemButton, removeItemButton, orderConfirmButton, addQuantityButton,addMoreButton,proceedToMemoButton,backButton;
    private JSpinner quantitySpinner;
	private String username;

    private int itemCount = 0; 
    private String selectedFood = "Chikhen Dum Biriyani"; 
    private int availableQuantity; 
	private int price;
	
    private JTextArea reviewArea;
    private JScrollPane scrollPane;

    private static final String FILE_PATH = "food_inventory.txt"; 

    ChikenDumBiriyaniOrderDetails(String username) {
		
		this.username=username;
        loadFoodInventoryFromFile();
        setupOrderPage();
    }

 private void loadFoodInventoryFromFile() {
    try {
        
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            Files.write(path, "Chiken Dum,50,350\nBiryani,30,400".getBytes()); 
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
		scrollPane.setBounds(50, 435, 400, 100); 
		container.add(scrollPane);

		JLabel RatingLabel = new JLabel("Customers Review for chicken Dum Biriyani", JLabel.CENTER);
		RatingLabel.setBounds(50, 400, 400, 30);
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

		imageLabel = new JLabel(new ImageIcon("ChikhenDum.png"));
        imageLabel.setBounds(50, 95, 395, 290);
        container.add(imageLabel);

		backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	
private void readCustomerReviews() {
    try {
        File file = new File("CustomersReviewsForChikhenDumBiriyani.txt");  
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            
            String[] parts = line.split(",", 3);
            if (parts.length == 3) {
                String username = parts[1].trim();  
                String comment = parts[2].trim();  
                String starRating = parts[0].trim();  
                
                int rating = 0;
                try {
                    rating = Integer.parseInt(starRating); 
                } catch (NumberFormatException e) {
            
                    rating = 0;
                    System.out.println("Invalid rating in review: " + starRating);
                }	
			
                String review = username + " - " + comment + " - " + starRating + " star \n";
                reviewArea.append(review);
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
        reviewArea.append("Error reading customer reviews.\n");
    }
}
    private void addItemAction(ActionEvent e) {
        if (itemCount < availableQuantity) {
            itemCount++; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
			
            JOptionPane.showMessageDialog(this, "Not enough " + selectedFood + " available. Please reduce the quantity.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }

    private void removeItemAction(ActionEvent e) {
        if (itemCount > 0) {
            itemCount--; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Cannot remove more items than currently in order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }
	
	private void addMoreItemAction(ActionEvent e) {
        
		CustomerFoodServiceOptionsPage customerFoodServiceOptionsPage = new CustomerFoodServiceOptionsPage(username);
        customerFoodServiceOptionsPage.setTitle("Food Delivery System");
        customerFoodServiceOptionsPage.setSize(900, 600);
        customerFoodServiceOptionsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFoodServiceOptionsPage.setLocationRelativeTo(null);
        customerFoodServiceOptionsPage.setVisible(true);
        customerFoodServiceOptionsPage.setResizable(false);
		  this.dispose();
    }
	
	private void proccedToMemoAction(ActionEvent e) {
            JOptionPane.showMessageDialog(this, "page are under construction .- IT Department", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addQuantityAction(ActionEvent e) {
        int quantity = (int) quantitySpinner.getValue();
        if (quantity > 0 && itemCount + quantity <= availableQuantity) {
            itemCount += quantity;
            itemCountLabel.setText("Items in Order: " + itemCount);
            quantitySpinner.setValue(0); 
        } else if (quantity == 0) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please select a valid quantity.", "Error", JOptionPane.WARNING_MESSAGE, BlankImg);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
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

        ImageIcon okImg = new ImageIcon("okImg.png");
        JOptionPane.showMessageDialog(this, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);

        availableFoodLabel.setOpaque(true);
        availableFoodLabel.setBackground(Color.WHITE);
        availableFoodLabel.setForeground(Color.BLACK);
    } else {
    
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
        JOptionPane.showMessageDialog(this, "Please add items to your order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
    }
}

	
	private void writeOrderDetails(String foodItem, int quantity, double price) {
    
	String filename = username + ".txt"; 
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


class BeefBurgerOrderDetails extends JFrame {
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
    private JScrollPane scrollPane;

    private static final String FILE_PATH = "food_inventory.txt"; 

    BeefBurgerOrderDetails(String username) {
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
		scrollPane.setBounds(50, 435, 400, 100); 
		container.add(scrollPane);

		JLabel RatingLabel = new JLabel("Customers Review for Beef Burger", JLabel.CENTER);
		RatingLabel.setBounds(50, 400, 400, 30);
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

		imageLabel = new JLabel(new ImageIcon("BigBeefBurger.png"));
        imageLabel.setBounds(50, 95, 380, 270);
        container.add(imageLabel);

		backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	
private void readCustomerReviews() {
    try {
        File file = new File("CustomersReviewsForBeefBurger.txt");  
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            
            String[] parts = line.split(",", 3);
            if (parts.length == 3) {
                String username = parts[1].trim();  
                String comment = parts[2].trim();  
                String starRating = parts[0].trim();  
                
                int rating = 0;
                try {
                    rating = Integer.parseInt(starRating); 
                } catch (NumberFormatException e) {
            
                    rating = 0;
                    System.out.println("Invalid rating in review: " + starRating);
                }	
			
                String review = username + " - " + comment + " - " + starRating + " star \n";
                reviewArea.append(review);
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
        reviewArea.append("Error reading customer reviews.\n");
    }
}
    private void addItemAction(ActionEvent e) {
        if (itemCount < availableQuantity) {
            itemCount++; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
			
            JOptionPane.showMessageDialog(this, "Not enough " + selectedFood + " available. Please reduce the quantity.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }

    private void removeItemAction(ActionEvent e) {
        if (itemCount > 0) {
            itemCount--; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Cannot remove more items than currently in order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }
	
	private void addMoreItemAction(ActionEvent e) {
        
		CustomerFoodServiceOptionsPage customerFoodServiceOptionsPage = new CustomerFoodServiceOptionsPage(username);
        customerFoodServiceOptionsPage.setTitle("Food Delivery System");
        customerFoodServiceOptionsPage.setSize(900, 600);
        customerFoodServiceOptionsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFoodServiceOptionsPage.setLocationRelativeTo(null);
        customerFoodServiceOptionsPage.setVisible(true);
        customerFoodServiceOptionsPage.setResizable(false);
		  this.dispose();
    }
	
	private void proccedToMemoAction(ActionEvent e) {
            JOptionPane.showMessageDialog(this, "page are under construction .- IT Department", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addQuantityAction(ActionEvent e) {
        int quantity = (int) quantitySpinner.getValue();
        if (quantity > 0 && itemCount + quantity <= availableQuantity) {
            itemCount += quantity;
            itemCountLabel.setText("Items in Order: " + itemCount);
            quantitySpinner.setValue(0); 
        } else if (quantity == 0) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please select a valid quantity.", "Error", JOptionPane.WARNING_MESSAGE, BlankImg);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
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

        ImageIcon okImg = new ImageIcon("okImg.png");
        JOptionPane.showMessageDialog(this, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);

        availableFoodLabel.setOpaque(true);
        availableFoodLabel.setBackground(Color.WHITE);
        availableFoodLabel.setForeground(Color.BLACK);
    } else {
    
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
        JOptionPane.showMessageDialog(this, "Please add items to your order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
    }
}

	
	private void writeOrderDetails(String foodItem, int quantity, double price) {
    
	String filename = username + ".txt"; 
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





class CreammyPastaDetails extends JFrame {
    private Container container;
    private JLabel welcomeLabel, availableFoodLabel, footerLabel, quantityLabel, itemCountLabel,imageLabel,backgroundImageLabel,foodPriceLabel;
    private JButton addItemButton, removeItemButton, orderConfirmButton, addQuantityButton,addMoreButton,proceedToMemoButton,backButton;
    private JSpinner quantitySpinner;
	
	private String username;

    private int itemCount = 0; 
    private String selectedFood = "Creammy Pasta"; 
    private int availableQuantity; 
	private int price;
	
    private JTextArea reviewArea;
    private JScrollPane scrollPane;

    private static final String FILE_PATH = "food_inventory.txt"; 

    CreammyPastaDetails(String username) {
		
		this.username=username;
        loadFoodInventoryFromFile();
        setupOrderPage();
    }

 private void loadFoodInventoryFromFile() {
    try {
        
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            Files.write(path, "Creammy ,50,350\n Pasta,30,400".getBytes()); 
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
		scrollPane.setBounds(50, 435, 400, 100); 
		container.add(scrollPane);

		JLabel RatingLabel = new JLabel("Customers Review for Creammy Pasta", JLabel.CENTER);
		RatingLabel.setBounds(50, 400, 400, 30);
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

		imageLabel = new JLabel(new ImageIcon("Creammy Pasta.png"));
        imageLabel.setBounds(50, 95, 380, 270);
        container.add(imageLabel);

		backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	
private void readCustomerReviews() {
    try {
        File file = new File("CustomersReviewsForCreamyPasta.txt");  
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            
            String[] parts = line.split(",", 3);
            if (parts.length == 3) {
                String username = parts[1].trim();  
                String comment = parts[2].trim();  
                String starRating = parts[0].trim();  
                
                int rating = 0;
                try {
                    rating = Integer.parseInt(starRating); 
                } catch (NumberFormatException e) {
            
                    rating = 0;
                    System.out.println("Invalid rating in review: " + starRating);
                }	
			
                String review = username + " - " + comment + " - " + starRating + " star \n";
                reviewArea.append(review);
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
        reviewArea.append("Error reading customer reviews.\n");
    }
}
    private void addItemAction(ActionEvent e) {
        if (itemCount < availableQuantity) {
            itemCount++; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
			
            JOptionPane.showMessageDialog(this, "Not enough " + selectedFood + " available. Please reduce the quantity.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }

    private void removeItemAction(ActionEvent e) {
        if (itemCount > 0) {
            itemCount--; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Cannot remove more items than currently in order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }
	
	private void addMoreItemAction(ActionEvent e) {
		
        CustomerFoodServiceOptionsPage customerFoodServiceOptionsPage = new CustomerFoodServiceOptionsPage(username);
        customerFoodServiceOptionsPage.setTitle("Food Delivery System");
        customerFoodServiceOptionsPage.setSize(900, 600);
        customerFoodServiceOptionsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFoodServiceOptionsPage.setLocationRelativeTo(null);
        customerFoodServiceOptionsPage.setVisible(true);
        customerFoodServiceOptionsPage.setResizable(false);
		  this.dispose();
    }
	
	private void proccedToMemoAction(ActionEvent e) {
            JOptionPane.showMessageDialog(this, "page are under construction .- IT Department", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addQuantityAction(ActionEvent e) {
        int quantity = (int) quantitySpinner.getValue();
        if (quantity > 0 && itemCount + quantity <= availableQuantity) {
            itemCount += quantity;
            itemCountLabel.setText("Items in Order: " + itemCount);
            quantitySpinner.setValue(0); 
        } else if (quantity == 0) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please select a valid quantity.", "Error", JOptionPane.WARNING_MESSAGE, BlankImg);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
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

        ImageIcon okImg = new ImageIcon("okImg.png");
        JOptionPane.showMessageDialog(this, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);

        availableFoodLabel.setOpaque(true);
        availableFoodLabel.setBackground(Color.WHITE);
        availableFoodLabel.setForeground(Color.BLACK);
    } else {
    
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
        JOptionPane.showMessageDialog(this, "Please add items to your order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
    }
}

	
	private void writeOrderDetails(String foodItem, int quantity, double price) {
    
	String filename = username + ".txt"; 
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



class JapanessRamenDetails extends JFrame {
    private Container container;
    private JLabel welcomeLabel, availableFoodLabel, footerLabel, quantityLabel, itemCountLabel,imageLabel,backgroundImageLabel,foodPriceLabel;
    private JButton addItemButton, removeItemButton, orderConfirmButton, addQuantityButton,addMoreButton,proceedToMemoButton,backButton;
    private JSpinner quantitySpinner;
	
	private String username;
	
    private int itemCount = 0; 
    private String selectedFood = "Japaness Ramen"; 
    private int availableQuantity; 
	private int price;
	
    private JTextArea reviewArea;
    private JScrollPane scrollPane;

    private static final String FILE_PATH = "food_inventory.txt"; 

    JapanessRamenDetails(String username) {
		
		this.username=username;
        loadFoodInventoryFromFile();
        setupOrderPage();
    }

 private void loadFoodInventoryFromFile() {
    try {
        
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            Files.write(path, "Japaness ,50,350\n Ramen,30,400".getBytes()); 
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
		scrollPane.setBounds(50, 435, 400, 100); 
		container.add(scrollPane);

		JLabel RatingLabel = new JLabel("Customers Review for Japaness Ramen", JLabel.CENTER);
		RatingLabel.setBounds(50, 400, 400, 30);
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

		imageLabel = new JLabel(new ImageIcon("Japaness Ramen img.png"));
        imageLabel.setBounds(50, 95, 380, 270);
        container.add(imageLabel);

		backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }
	
	
private void readCustomerReviews() {
    try {
        File file = new File("CustomersReviewsForJapaneseRamen.txt");  
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            
            String[] parts = line.split(",", 3);
            if (parts.length == 3) {
                String username = parts[1].trim();  
                String comment = parts[2].trim();  
                String starRating = parts[0].trim();  
                
                int rating = 0;
                try {
                    rating = Integer.parseInt(starRating); 
                } catch (NumberFormatException e) {
            
                    rating = 0;
                    System.out.println("Invalid rating in review: " + starRating);
                }	
			
                String review = username + " - " + comment + " - " + starRating + " star \n";
                reviewArea.append(review);
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
        reviewArea.append("Error reading customer reviews.\n");
    }
}
    private void addItemAction(ActionEvent e) {
        if (itemCount < availableQuantity) {
            itemCount++; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
			
            JOptionPane.showMessageDialog(this, "Not enough " + selectedFood + " available. Please reduce the quantity.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }

    private void removeItemAction(ActionEvent e) {
        if (itemCount > 0) {
            itemCount--; 
            itemCountLabel.setText("Items in Order: " + itemCount);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Cannot remove more items than currently in order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        }
    }
	
	private void addMoreItemAction(ActionEvent e) {
           CustomerFoodServiceOptionsPage customerFoodServiceOptionsPage = new CustomerFoodServiceOptionsPage(username);
        customerFoodServiceOptionsPage.setTitle("Food Delivery System");
        customerFoodServiceOptionsPage.setSize(900, 600);
        customerFoodServiceOptionsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFoodServiceOptionsPage.setLocationRelativeTo(null);
        customerFoodServiceOptionsPage.setVisible(true);
        customerFoodServiceOptionsPage.setResizable(false);
		  this.dispose();
    }
	
	private void proccedToMemoAction(ActionEvent e) {
            JOptionPane.showMessageDialog(this, "page are under construction .- IT Department", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addQuantityAction(ActionEvent e) {
        int quantity = (int) quantitySpinner.getValue();
        if (quantity > 0 && itemCount + quantity <= availableQuantity) {
            itemCount += quantity;
            itemCountLabel.setText("Items in Order: " + itemCount);
            quantitySpinner.setValue(0); 
        } else if (quantity == 0) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please select a valid quantity.", "Error", JOptionPane.WARNING_MESSAGE, BlankImg);
        } else {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
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

        ImageIcon okImg = new ImageIcon("okImg.png");
        JOptionPane.showMessageDialog(this, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, okImg);

        availableFoodLabel.setOpaque(true);
        availableFoodLabel.setBackground(Color.WHITE);
        availableFoodLabel.setForeground(Color.BLACK);
    } else {
    
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
        JOptionPane.showMessageDialog(this, "Please add items to your order.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
    }
}

	
	private void writeOrderDetails(String foodItem, int quantity, double price) {
    
	String filename = username + ".txt"; 
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