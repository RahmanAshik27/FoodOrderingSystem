package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.util.List;


public class ManagementDepartmentOfFoodPage extends JFrame {
    private JLabel welcomeLabel, messageLabel, imageLabel, backgroundImageLabel;
    private JButton backButton, buttonOne, buttonTwo, buttonThree, buttonFour,requestBoardButton,addBoardButton;
    private JLabel ChikhenDumBiriyani, BeefBurger, CreammyPasta, JapanessRamen;
	private JTextArea reviewArea;
	private JScrollPane scrollPane;

  public ManagementDepartmentOfFoodPage() {
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
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Font largeLabelFont = new Font("Arial", Font.BOLD, 20);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to the Inventory Managemnet Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 650, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        int panelHeight = 100 + 10 * 50;
        scrollablePanel.setPreferredSize(new Dimension(650, panelHeight));

        JScrollPane scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(250, 110, 600, 410);
        container.add(scrollPane);

        JLabel aLabel = new JLabel("A      ", JLabel.CENTER);
        aLabel.setBounds(5, 10, 560, 30);
        aLabel.setForeground(Color.RED);
        aLabel.setOpaque(true);
        aLabel.setBackground(Color.WHITE);
        aLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(aLabel);

        JLabel boxlabel = new JLabel("Request Quantity ", JLabel.CENTER);
        boxlabel.setBounds(310, 40, 200, 30);
        boxlabel.setForeground(Color.RED);
        boxlabel.setOpaque(true);
        boxlabel.setBackground(new Color(255, 223, 186));
        boxlabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(boxlabel);

        JLabel bLabel = new JLabel("B      ", JLabel.CENTER);
        bLabel.setBounds(5, 420, 560, 30);
        bLabel.setForeground(Color.RED);
        bLabel.setOpaque(true);
        bLabel.setBackground(Color.WHITE);
        bLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(bLabel);
		
		JLabel boxlabel2 = new JLabel("Request Quantity ", JLabel.CENTER);
        boxlabel2.setBounds(310, 452, 200, 30);
        boxlabel2.setForeground(Color.RED);
        boxlabel2.setOpaque(true);
        boxlabel2.setBackground(new Color(255, 223, 186));
        boxlabel2.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(boxlabel2);

        String buttonMessage = "<html><div style='text-align: center;'><b>Add more To</b><br>Inventory</div></html>";

        buttonOne = new JButton(buttonMessage);
        buttonOne.setBounds(470, 72, 100, 75);
        buttonOne.setFont(buttonFont);
        buttonOne.setBackground(new Color(255, 99, 71));
        buttonOne.setForeground(Color.WHITE);
        buttonOne.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        buttonOne.setCursor(cursor);
        buttonOne.addActionListener(this::addChickenDumBiriyaniInventory);
        scrollablePanel.add(buttonOne);
        createFoodLabel(scrollablePanel, "Chicken Dum Biriyani", 60);
        createFoodImageLabel(scrollablePanel, "Food Image 1", "chikenbiriyani.png", 60);
        createQuantityLabel(scrollablePanel, 60);


        buttonTwo = new JButton(buttonMessage);
        buttonTwo.setBounds(470, 192, 100, 75);
        buttonTwo.setFont(buttonFont);
        buttonTwo.setBackground(new Color(60, 179, 113));
        buttonTwo.setForeground(Color.WHITE);
        buttonTwo.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        buttonTwo.setCursor(cursor);
        buttonTwo.addActionListener(this::addBeefBurgerInventory);
        scrollablePanel.add(buttonTwo);
        createFoodLabel(scrollablePanel, "Beef Burger", 180);
        createFoodImageLabel(scrollablePanel, "beef burger", "beef burger.png", 180);
        createQuantityLabel(scrollablePanel, 180);

        
        buttonThree = new JButton(buttonMessage);
        buttonThree.setBounds(470, 312, 100, 75);
        buttonThree.setFont(buttonFont);
        buttonThree.setBackground(new Color(50, 150, 255));
        buttonThree.setForeground(Color.WHITE);
        buttonThree.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        buttonThree.setCursor(cursor);
        buttonThree.addActionListener(this::addCreammyPastaInventory);
        scrollablePanel.add(buttonThree);
        createFoodLabel(scrollablePanel, "Creammy Pasta", 300);
        createFoodImageLabel(scrollablePanel, "Food Image 3", "pasta.png", 300);
        createQuantityLabel(scrollablePanel, 300);

       
        buttonFour = new JButton(buttonMessage);
        buttonFour.setBounds(470, 482, 100, 75);
        buttonFour.setFont(buttonFont);
        buttonFour.setBackground(new Color(255, 99, 71));
        buttonFour.setForeground(Color.WHITE);
        buttonFour.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        buttonFour.setCursor(cursor);
        buttonFour.addActionListener(this::addJapanessRamenInventory);
        scrollablePanel.add(buttonFour);
        createFoodLabel(scrollablePanel, "Japaness Ramen", 470);
        createFoodImageLabel(scrollablePanel, "Food Image 4", "rammen.png", 470);
        createQuantityLabel(scrollablePanel, 470);

        
        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

		String addMessage = "<html><div style='text-align: center;'><b>Add to Request</b><br>Quantity</div></html>";
		
		addBoardButton = new JButton(addMessage);
        addBoardButton.setBounds(20, 426, 220, 60);
        addBoardButton.setFont(largeLabelFont);
        addBoardButton.setBackground(new Color(255, 99, 71));
        addBoardButton.setForeground(Color.WHITE);
        addBoardButton.setCursor(cursor);
		addBoardButton.addActionListener(this::loadFoodInventory);		
        container.add(addBoardButton);

		requestBoardButton = new JButton("Request Board");
		requestBoardButton.setBounds(20, 100, 220, 40);
		requestBoardButton.setFont(new Font("Arial", Font.BOLD, 20));
		requestBoardButton.setBackground(new Color(50, 150, 255));
		requestBoardButton.setForeground(Color.WHITE);
		requestBoardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		requestBoardButton.addActionListener(this::onRequestBoardButtonClicked); 
		container.add(requestBoardButton);

		
		reviewArea = new JTextArea();
		reviewArea.setEditable(false); 
		reviewArea.setFont(new Font("Arial", Font.PLAIN, 20));  
		reviewArea.setLineWrap(true);  
		reviewArea.setWrapStyleWord(true); 
		reviewArea.setBackground(new Color(240, 255, 240));  
		reviewArea.setForeground(new Color(0, 0, 0));  		
		reviewArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 128, 255), 2),
				BorderFactory.createEmptyBorder(35, 10, 35, 10)
		));
		
		scrollPane = new JScrollPane(reviewArea);
		scrollPane.setBounds(30, 132, 200, 300); 
		container.add(scrollPane);
		
        backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);

       
    }
	
	private void onRequestBoardButtonClicked(ActionEvent e) {
    File file = new File("src/AdminPackage/addRequest.txt");

    
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            
           
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            
            if (content.length() > 0) {
                reviewArea.setText(content.toString());
            } else {
                reviewArea.setText("No inventory update message from the admin.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        reviewArea.setText("No inventory update message from the admin.");
    }
}



private void loadFoodInventory(ActionEvent e) {
    try {
        Path path = Paths.get("src/AdminPackage/addRequest.txt");  
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        int lineIndex = 0;

        while ((line = reader.readLine()) != null && lineIndex < 5) {
            String cleanLine = line.replace(" - Quantity", "").trim();
            String[] parts = cleanLine.split(":"); 
            if (parts.length == 2) {
                String foodItem = parts[0].trim();
                String quantity = parts[1].trim();

                switch (foodItem.toLowerCase()) {  
                    case "chikhen dum biriyani": 
                        ChikhenDumBiriyani.setText(quantity);  
                        break;
                    case "beef burger":
                        BeefBurger.setText(quantity);  
                        break;
                    case "creammy pasta":
                        CreammyPasta.setText(quantity);  
                        break;
                    case "Japaness Ramen":
                        JapanessRamen.setText(quantity);  
                        break;
                    default:
                        System.out.println("Unrecognized food item: " + foodItem);  
                        break;
                }
            } else {
                System.out.println("Invalid line format: " + line);  
            }
            lineIndex++;
        }
        reader.close();
        Files.write(path, "".getBytes()); 

    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading food inventory file", "Error", JOptionPane.ERROR_MESSAGE);
    }
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

    private void createQuantityLabel(JPanel panel, int yPosition) {
    JLabel quantityLabel = new JLabel("0");
    quantityLabel.setBounds(360, yPosition + 25, 100, 50);
    quantityLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
	quantityLabel.setOpaque(true);
    quantityLabel.setBackground(new Color(240, 255, 240));
    quantityLabel.setHorizontalAlignment(SwingConstants.CENTER); 
    quantityLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));

    panel.add(quantityLabel);

    switch (yPosition) {
        case 60: ChikhenDumBiriyani = quantityLabel; break;
        case 180: BeefBurger = quantityLabel; break;
        case 300: CreammyPasta = quantityLabel; break;
        case 470: JapanessRamen = quantityLabel; break;
    }
}

private void addChickenDumBiriyaniInventory(ActionEvent e) {
    try {
        int currentQuantity = Integer.parseInt(ChikhenDumBiriyani.getText());

        if (currentQuantity == 0) {
            JOptionPane.showMessageDialog(this, "No requested inventory update for Chicken Dum Biriyani.");
            return; 
        }

        Path path = Paths.get("src/AdminPackage/food_inventory.txt");
        List<String> lines = Files.readAllLines(path);

        boolean updated = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String foodItem = parts[0].trim();

            if (foodItem.equalsIgnoreCase("Chikhen Dum Biriyani")) {
                int newQuantity = Integer.parseInt(parts[1].trim()) + currentQuantity;
                lines.set(i, foodItem + "," + newQuantity + "," + parts[2].trim());
                updated = true;
                break;
            }
        }

        if (updated) {
            ChikhenDumBiriyani.setText("0");
			  Files.write(path, lines);
            JOptionPane.showMessageDialog(this, "Inventory updated successfully for Chicken Dum Biriyani!");
        } else {
            JOptionPane.showMessageDialog(this, "No requested inventory update.");
        }

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating inventory.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void addBeefBurgerInventory(ActionEvent e) {
    try {
        int currentQuantity = Integer.parseInt(BeefBurger.getText());

        if (currentQuantity == 0) {
            JOptionPane.showMessageDialog(this, "No requested inventory update for Beef Burger.");
            return; 
        }

        Path path = Paths.get("src/AdminPackage/food_inventory.txt");
        List<String> lines = Files.readAllLines(path);

        boolean updated = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String foodItem = parts[0].trim();

            if (foodItem.equalsIgnoreCase("Beef Burger")) {
                int newQuantity = Integer.parseInt(parts[1].trim()) + currentQuantity;
                lines.set(i, foodItem + "," + newQuantity + "," + parts[2].trim());
                updated = true;
                break;
            }
        }

        if (updated) {
            BeefBurger.setText("0");
			  Files.write(path, lines);
            JOptionPane.showMessageDialog(this, "Inventory updated successfully for Beef Burger!");
        } else {
            JOptionPane.showMessageDialog(this, "No requested inventory update.");
        }

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating inventory.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void addCreammyPastaInventory(ActionEvent e) {
    try {
        int currentQuantity = Integer.parseInt(CreammyPasta.getText());

        
        if (currentQuantity == 0) {
            JOptionPane.showMessageDialog(this, "No requested inventory update for Creammy Pasta.");
            return; 
        }

        Path path = Paths.get("src/AdminPackage/food_inventory.txt");
        List<String> lines = Files.readAllLines(path);

        boolean updated = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String foodItem = parts[0].trim();

            
            if (foodItem.equalsIgnoreCase("Creammy Pasta")) {
                int newQuantity = Integer.parseInt(parts[1].trim()) + currentQuantity;
                lines.set(i, foodItem + "," + newQuantity + "," + parts[2].trim());
                updated = true;
                break;
            }
        }

        if (updated) {
            CreammyPasta.setText("0");
			  Files.write(path, lines);
            JOptionPane.showMessageDialog(this, "Inventory updated successfully for Creammy Pasta!");
        } else {
            JOptionPane.showMessageDialog(this, "No requested inventory update.");
        }

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating inventory.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void addJapanessRamenInventory(ActionEvent e) {
    try {
        int currentQuantity = Integer.parseInt(JapanessRamen.getText());

        
        if (currentQuantity == 0) {
            JOptionPane.showMessageDialog(this, "No requested inventory update for Japanese Ramen.");
            return; 
        }

        Path path = Paths.get("Asrc/AdminPackage/food_inventory.txt");
        List<String> lines = Files.readAllLines(path);

        boolean updated = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String foodItem = parts[0].trim();

            if (foodItem.equalsIgnoreCase("Japaness Ramen")) {
                int newQuantity = Integer.parseInt(parts[1].trim()) + currentQuantity;
                lines.set(i, foodItem + "," + newQuantity + "," + parts[2].trim());
                updated = true;
                break;
            }
        }

        if (updated) {
            JapanessRamen.setText("0");
			  Files.write(path, lines);
            JOptionPane.showMessageDialog(this, "Inventory updated successfully for Japanese Ramen!");
        } else {
            JOptionPane.showMessageDialog(this, "No requested inventory update.");
        }

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating inventory.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void goBack(ActionEvent e) {
       
	   ManagementDepartment managementDepartmentPage = new ManagementDepartment ();
        managementDepartmentPage.setTitle("Food Reviews Page");
        managementDepartmentPage.setSize(900, 600);
        managementDepartmentPage.setLocationRelativeTo(null);
        managementDepartmentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managementDepartmentPage.setVisible(true);
        managementDepartmentPage.setResizable(false);
		this.setVisible(false);
    }

}























