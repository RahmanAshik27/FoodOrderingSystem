import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;


class InventoryOfFoodPage extends JFrame {
    private JLabel welcomeLabel, messageLabel, imageLabel, backgroundImageLabel;
    private JButton backButton, buttonOne, buttonTwo, buttonThree, buttonFour;
    private JLabel foodQuantityOne, foodQuantityTwo, foodQuantityThree, foodQuantityFour;


    InventoryOfFoodPage() {
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

        welcomeLabel = new JLabel("Welcome to the Food Inventory Page", JLabel.CENTER);
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

        JLabel boxlabel = new JLabel("Available Quantity ", JLabel.CENTER);
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
		
		JLabel boxlabel2 = new JLabel("Available Quantity ", JLabel.CENTER);
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
        createFoodLabel(scrollablePanel, "Japanese Ramen", 470);
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

       
        backgroundImageLabel = new JLabel(new ImageIcon("Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);

        
        loadFoodInventory();
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
    JLabel quantityLabel = new JLabel();
    quantityLabel.setBounds(360, yPosition + 25, 100, 50);
    quantityLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
	quantityLabel.setOpaque(true);
    quantityLabel.setBackground(new Color(240, 255, 240));
    quantityLabel.setHorizontalAlignment(SwingConstants.CENTER); 
    quantityLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));

    panel.add(quantityLabel);

    switch (yPosition) {
        case 60: foodQuantityOne = quantityLabel; break;
        case 180: foodQuantityTwo = quantityLabel; break;
        case 300: foodQuantityThree = quantityLabel; break;
        case 470: foodQuantityFour = quantityLabel; break;
    }
}

   private void loadFoodInventory() {
    try {
        
        Path path = Paths.get("food_inventory.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        int lineIndex = 0;

        while ((line = reader.readLine()) != null && lineIndex < 4) {
            String[] parts = line.split(",");
            String quantity = parts[1].trim();

            
            switch (lineIndex) {
                case 0: foodQuantityOne.setText(quantity); break;
                case 1: foodQuantityTwo.setText(quantity); break;
                case 2: foodQuantityThree.setText(quantity); break;
                case 3: foodQuantityFour.setText(quantity); break;
            }

				lineIndex++;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error reading food inventory file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
			
	private void addChickenDumBiriyaniInventory(ActionEvent e) {
       
	    AddChikhenDumBiriyani mainPage = new AddChikhenDumBiriyani();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(300, 400);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
    }
	
	
	 private void addBeefBurgerInventory(ActionEvent e) {
        
		AddBeefBurger mainPage = new AddBeefBurger();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(300, 400);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
		
    }
	
	
	
    private void addCreammyPastaInventory(ActionEvent e) {
		
		AddCreammyPasta mainPage = new AddCreammyPasta();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(300, 400);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
    }
	
	private void addJapanessRamenInventory(ActionEvent e) {
        
		AddJapanessRamen mainPage = new AddJapanessRamen();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(300, 400);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
		
    }
    private void goBack(ActionEvent e) {
			
			AdminDashboard dashboard = new AdminDashboard();
			dashboard.setTitle("Admin Dashboard");
			dashboard.setSize(900, 600);
			dashboard.setLocationRelativeTo(null);
			dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dashboard.setResizable(false);
			dashboard.setVisible(true);
			this.setVisible(false); 
    }

}


class AddChikhenDumBiriyani extends JFrame {
    private Container container;
    private JLabel imageLabel, titleLabel;
    private JSpinner spinner;
    private JTextField textField;
    private JButton addButton, backButton, confirmButton;

    AddChikhenDumBiriyani() {
        ChikhenDumBiriyani();
    }

    private void ChikhenDumBiriyani() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 255, 240));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        titleLabel = new JLabel("Chikhen Dum Biriyani", JLabel.CENTER);
        titleLabel.setBounds(30, 200, 250, 30);
        titleLabel.setFont(boldFont);
        container.add(titleLabel);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 50, 1);
        spinner = new JSpinner(model);
        spinner.setBounds(20, 240, 80, 40);
        spinner.setBorder(new LineBorder(Color.RED, 2));

        JComponent editor = spinner.getEditor();
        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
        spinnerTextField.setFont(new Font("Arial", Font.BOLD, 18));
        spinnerTextField.setHorizontalAlignment(JTextField.CENTER);
        container.add(spinner);

        textField = new JTextField();
        textField.setBounds(200, 240, 50, 40);
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.RED, 2));
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        container.add(textField);

        addButton = new JButton("Add");
        addButton.setBounds(105, 240, 90, 40);
        addButton.setFont(boldFont);
        addButton.setBackground(new Color(255, 99, 71));
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(cursor);
        addButton.addActionListener(this::onAddButtonClick);
        container.add(addButton);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(40, 300, 200, 40);
        confirmButton.setFont(boldFont);
        confirmButton.setBackground(new Color(50, 150, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setCursor(cursor);
        confirmButton.addActionListener(this::onConfirmButtonClick);
        container.add(confirmButton);

        backButton = new JButton("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        imageLabel = new JLabel(new ImageIcon("ChikhenDum.png"));
        imageLabel.setBounds(0, 0, 300, 200);
        container.add(imageLabel);
    }

    private void onAddButtonClick(ActionEvent e) {
        int quantity = (int) spinner.getValue();
        textField.setText(String.valueOf(quantity));
		
    }

    private void onConfirmButtonClick(ActionEvent e) {
        String foodName = "Chikhen Dum Biriyani";
        String quantity = textField.getText();

        if (quantity.isEmpty()) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please add a quantity before confirming.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("addRequest.txt", true))) {
            writer.write(foodName + " - Quantity: " + quantity);
            writer.newLine();
			ImageIcon okImg = new ImageIcon("okImg.png");
            JOptionPane.showMessageDialog(this, "Inventory update massage goes to Management Department", "we will update it soon ", JOptionPane.INFORMATION_MESSAGE,okImg);
			textField.setText("");
        } catch (IOException ex) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
        }
    }

    private void goBack(ActionEvent e) {
			
		InventoryOfFoodPage inventoryPage = new InventoryOfFoodPage();
        inventoryPage.setTitle("Food Delivery System");
        inventoryPage.setSize(900, 600);
        inventoryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPage.setLocationRelativeTo(null);
        inventoryPage.setVisible(true);
        inventoryPage.setResizable(false);
		 this.setVisible(false); 
    }

    
}


class AddBeefBurger extends JFrame {
    private Container container;
    private JLabel imageLabel, titleLabel;
    private JSpinner spinner;
    private JTextField textField;
    private JButton addButton, backButton, confirmButton;

    AddBeefBurger() {
        beefBurgerSetUP();
    }

    private void beefBurgerSetUP() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 255, 240));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        titleLabel = new JLabel("Beef Burger", JLabel.CENTER);
        titleLabel.setBounds(30, 200, 250, 30);
        titleLabel.setFont(boldFont);
        container.add(titleLabel);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 50, 1);
        spinner = new JSpinner(model);
        spinner.setBounds(20, 240, 80, 40);
        spinner.setBorder(new LineBorder(Color.RED, 2));

        JComponent editor = spinner.getEditor();
        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
        spinnerTextField.setFont(new Font("Arial", Font.BOLD, 18));
        spinnerTextField.setHorizontalAlignment(JTextField.CENTER);
        container.add(spinner);

        textField = new JTextField();
        textField.setBounds(200, 240, 50, 40);
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.RED, 2));
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        container.add(textField);

        addButton = new JButton("Add");
        addButton.setBounds(105, 240, 90, 40);
        addButton.setFont(boldFont);
        addButton.setBackground(new Color(255, 99, 71));
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(cursor);
        addButton.addActionListener(this::onAddButtonClick);
        container.add(addButton);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(40, 300, 200, 40);
        confirmButton.setFont(boldFont);
        confirmButton.setBackground(new Color(50, 150, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setCursor(cursor);
        confirmButton.addActionListener(this::onConfirmButtonClick);
        container.add(confirmButton);

        backButton = new JButton("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        imageLabel = new JLabel(new ImageIcon("BigBeefBurger.png"));
        imageLabel.setBounds(0, 0, 300, 200);
        container.add(imageLabel);
    }

    private void onAddButtonClick(ActionEvent e) {
        int quantity = (int) spinner.getValue();
        textField.setText(String.valueOf(quantity));
		
    }

    private void onConfirmButtonClick(ActionEvent e) {
        String foodName = "Beef Burger";
        String quantity = textField.getText();

        if (quantity.isEmpty()) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please add a quantity before confirming.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("addRequest.txt", true))) {
            writer.write(foodName + " - Quantity: " + quantity);
            writer.newLine();
			ImageIcon okImg = new ImageIcon("okImg.png");
            JOptionPane.showMessageDialog(this, "Inventory update massage goes to Management Department", "we will update it soon ", JOptionPane.INFORMATION_MESSAGE,okImg);
			textField.setText("");
        } catch (IOException ex) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
        }
    }

    private void goBack(ActionEvent e) {
        InventoryOfFoodPage inventoryPage = new InventoryOfFoodPage();
        inventoryPage.setTitle("Food Delivery System");
        inventoryPage.setSize(900, 600);
        inventoryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPage.setLocationRelativeTo(null);
        inventoryPage.setVisible(true);
        inventoryPage.setResizable(false);
		 this.setVisible(false);
    }

    
}


class AddCreammyPasta extends JFrame {
    private Container container;
    private JLabel imageLabel, titleLabel;
    private JSpinner spinner;
    private JTextField textField;
    private JButton addButton, backButton, confirmButton;

    AddCreammyPasta() {
        creammyPastaSetUP();
    }

    private void creammyPastaSetUP() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 255, 240));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        titleLabel = new JLabel("Creammy Pasta", JLabel.CENTER);
        titleLabel.setBounds(30, 200, 250, 30);
        titleLabel.setFont(boldFont);
        container.add(titleLabel);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 50, 1);
        spinner = new JSpinner(model);
        spinner.setBounds(20, 240, 80, 40);
        spinner.setBorder(new LineBorder(Color.RED, 2));

        JComponent editor = spinner.getEditor();
        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
        spinnerTextField.setFont(new Font("Arial", Font.BOLD, 18));
        spinnerTextField.setHorizontalAlignment(JTextField.CENTER);
        container.add(spinner);

        textField = new JTextField();
        textField.setBounds(200, 240, 50, 40);
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.RED, 2));
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        container.add(textField);

        addButton = new JButton("Add");
        addButton.setBounds(105, 240, 90, 40);
        addButton.setFont(boldFont);
        addButton.setBackground(new Color(255, 99, 71));
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(cursor);
        addButton.addActionListener(this::onAddButtonClick);
        container.add(addButton);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(40, 300, 200, 40);
        confirmButton.setFont(boldFont);
        confirmButton.setBackground(new Color(50, 150, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setCursor(cursor);
        confirmButton.addActionListener(this::onConfirmButtonClick);
        container.add(confirmButton);

        backButton = new JButton("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        imageLabel = new JLabel(new ImageIcon("Creammy Pasta.png"));
        imageLabel.setBounds(0, 0, 300, 200);
        container.add(imageLabel);
    }

    private void onAddButtonClick(ActionEvent e) {
        int quantity = (int) spinner.getValue();
        textField.setText(String.valueOf(quantity));
		
    }

    private void onConfirmButtonClick(ActionEvent e) {
        String foodName = "Creammy Pasta";
        String quantity = textField.getText();

        if (quantity.isEmpty()) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please add a quantity before confirming.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("addRequest.txt", true))) {
            writer.write(foodName + " - Quantity: " + quantity);
            writer.newLine();
			ImageIcon okImg = new ImageIcon("okImg.png");
            JOptionPane.showMessageDialog(this, "Inventory update massage goes to Management Department", "we will update it soon ", JOptionPane.INFORMATION_MESSAGE,okImg);
			textField.setText("");
        } catch (IOException ex) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
        }
    }

    private void goBack(ActionEvent e) {
        InventoryOfFoodPage inventoryPage = new InventoryOfFoodPage();
        inventoryPage.setTitle("Food Delivery System");
        inventoryPage.setSize(900, 600);
        inventoryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPage.setLocationRelativeTo(null);
        inventoryPage.setVisible(true);
        inventoryPage.setResizable(false);
		 this.setVisible(false);
    }

}

class AddJapanessRamen extends JFrame {
    private Container container;
    private JLabel imageLabel, titleLabel;
    private JSpinner spinner;
    private JTextField textField;
    private JButton addButton, backButton, confirmButton;

    AddJapanessRamen() {
        japanessRamenSetUP();
    }

    private void japanessRamenSetUP() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 255, 240));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font backFont = new Font("Arial", Font.BOLD, 16);
        Font welcomeFont = new Font("Arial", Font.BOLD, 30);
        Font boldFont = new Font("Arial", Font.BOLD, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        titleLabel = new JLabel("Japaness Ramen", JLabel.CENTER);
        titleLabel.setBounds(30, 200, 250, 30);
        titleLabel.setFont(boldFont);
        container.add(titleLabel);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 50, 1);
        spinner = new JSpinner(model);
        spinner.setBounds(20, 240, 80, 40);
        spinner.setBorder(new LineBorder(Color.RED, 2));

        JComponent editor = spinner.getEditor();
        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
        spinnerTextField.setFont(new Font("Arial", Font.BOLD, 18));
        spinnerTextField.setHorizontalAlignment(JTextField.CENTER);
        container.add(spinner);

        textField = new JTextField();
        textField.setBounds(200, 240, 50, 40);
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.RED, 2));
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        container.add(textField);

        addButton = new JButton("Add");
        addButton.setBounds(105, 240, 90, 40);
        addButton.setFont(boldFont);
        addButton.setBackground(new Color(255, 99, 71));
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(cursor);
        addButton.addActionListener(this::onAddButtonClick);
        container.add(addButton);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(40, 300, 200, 40);
        confirmButton.setFont(boldFont);
        confirmButton.setBackground(new Color(50, 150, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setCursor(cursor);
        confirmButton.addActionListener(this::onConfirmButtonClick);
        container.add(confirmButton);

        backButton = new JButton("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.setFont(backFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        imageLabel = new JLabel(new ImageIcon("Japaness Ramen img.png"));
        imageLabel.setBounds(0, 0, 300, 200);
        container.add(imageLabel);
    }

    private void onAddButtonClick(ActionEvent e) {
        int quantity = (int) spinner.getValue();
        textField.setText(String.valueOf(quantity));
		
    }

    private void onConfirmButtonClick(ActionEvent e) {
        String foodName = "Japaness Ramen";
        String quantity = textField.getText();

        if (quantity.isEmpty()) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Please add a quantity before confirming.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("addRequest.txt", true))) {
            writer.write(foodName + " - Quantity: " + quantity);
            writer.newLine();
			ImageIcon okImg = new ImageIcon("okImg.png");
            JOptionPane.showMessageDialog(this, "Inventory update massage goes to Management Department", "we will update it soon ", JOptionPane.INFORMATION_MESSAGE,okImg);
			textField.setText("");
        } catch (IOException ex) {
			ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
        }
    }

    private void goBack(ActionEvent e) {
        InventoryOfFoodPage inventoryPage = new InventoryOfFoodPage();
        inventoryPage.setTitle("Food Delivery System");
        inventoryPage.setSize(900, 600);
        inventoryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPage.setLocationRelativeTo(null);
        inventoryPage.setVisible(true);
        inventoryPage.setResizable(false);
		 this.setVisible(false);
    }
}	