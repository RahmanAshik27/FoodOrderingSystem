package CustomerPackage;

import AdminPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;

public class CustomerFoodServiceOptionsPage extends JFrame {
    private JLabel welcomeLabel, footerLabel;
	private JButton backButton;
	private String username;
    
public CustomerFoodServiceOptionsPage(String username) {
		
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


