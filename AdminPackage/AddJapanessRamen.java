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

public class AddJapanessRamen extends JFrame {
    private Container container;
    private JLabel imageLabel, titleLabel;
    private JSpinner spinner;
    private JTextField textField;
    private JButton addButton, backButton, confirmButton;

public AddJapanessRamen() {
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
        JOptionPane.showMessageDialog(this, "Please add a quantity before confirming.", "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
        return;
    }

    try {
        File file = new File("src/AdminPackage/addRequest.txt");
        StringBuilder fileContent = new StringBuilder();
        boolean foodFound = false;
        int totalQuantity = 0;

        
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(foodName)) {
                   
                    String[] parts = line.split(" - Quantity: ");
                    if (parts.length == 2) {
                        totalQuantity = Integer.parseInt(parts[1]) + Integer.parseInt(quantity);
                    }
                    foodFound = true;
                   
                    line = foodName + " - Quantity: " + totalQuantity;
                }
               
                fileContent.append(line).append("\n");
            }
            reader.close();
        } else {
            System.out.println("File does not exist. Creating a new file.");
        }

        if (!foodFound) {
            fileContent.append(foodName + " - Quantity: " + quantity + "\n");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(fileContent.toString());
        writer.close();

        ImageIcon okImg = new ImageIcon("okImg.png");
        JOptionPane.showMessageDialog(this, "Inventory update message sent to Management Department", "We will update it soon", JOptionPane.INFORMATION_MESSAGE, okImg);

         this.setVisible(false);

    } catch (IOException ex) {
        ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
        JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, BlankImg);
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