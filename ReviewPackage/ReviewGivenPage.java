package ReviewPackage;

import AdminPackage.*;
import CustomerPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ReviewGivenPage extends JFrame {
    private JLabel welcomeLabel, messageLabel,imageLabel,backgroundImageLabel;
	private JButton backButton, buttonOne,buttonTwo,buttonThree,buttonFour;
	private String username;
	
   public ReviewGivenPage(String username) {
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
		Font largeLabelFont = new Font("Arial", Font.BOLD, 20);
		Font buttonFont= new Font("Arial", Font.BOLD, 16);
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);


        welcomeLabel = new JLabel("Welcome to the Customer Food Review Page", JLabel.CENTER);
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

        String buttonMessage = "<html><div style='text-align: center;'><b>Review</b><br>Now</div></html>";

		buttonOne = new JButton(buttonMessage);
		buttonOne.setBounds(370, 72, 100, 75);
		buttonOne.setFont(buttonFont);
		buttonOne.setBackground(new Color(255, 99, 71));
		buttonOne.setForeground(Color.WHITE);
		buttonOne.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		buttonOne.setCursor(cursor);
		buttonOne.addActionListener(this::orderChickenBiriyani);
		scrollablePanel.add(buttonOne);	
		createFoodLabel(scrollablePanel, "Chicken Dum Biriyani", 60);
		createFoodImageLabel(scrollablePanel, "Food Image 1", "chikenbiriyani.png", 60);
		
		buttonTwo = new JButton(buttonMessage);
		buttonTwo.setBounds(370, 192, 100, 75);
		buttonTwo.setFont(buttonFont);
		buttonTwo.setBackground(new Color(60, 179, 113));
		buttonTwo.setForeground(Color.WHITE);
		buttonTwo.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		buttonTwo.setCursor(cursor);
		buttonTwo.addActionListener(this::orderBeefBurger);
		scrollablePanel.add(buttonTwo);	
		createFoodLabel(scrollablePanel, "Beef Burger", 180);
        createFoodImageLabel(scrollablePanel, "beef burger", "beef burger.png", 180);
      		
		buttonThree = new JButton(buttonMessage);
		buttonThree.setBounds(370, 312, 100, 75);
		buttonThree.setFont(buttonFont);
		buttonThree.setBackground(new Color(50, 150, 255));
		buttonThree.setForeground(Color.WHITE);
		buttonThree.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		buttonThree.setCursor(cursor);
		buttonThree.addActionListener(this::orderCreamyPasta);
		scrollablePanel.add(buttonThree);	
		createFoodLabel(scrollablePanel, "Creammy Pasta ", 300);
        createFoodImageLabel(scrollablePanel, "Food Image 3", "pasta.png", 300);
       
		buttonFour = new JButton(buttonMessage);
		buttonFour.setBounds(370, 482, 100, 75);
		buttonFour.setFont(buttonFont);
		buttonFour.setBackground(new Color(255, 99, 71));
		buttonFour.setForeground(Color.WHITE);
		buttonFour.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		buttonFour.setCursor(cursor);
		buttonFour.addActionListener(this::orderRamen);
		scrollablePanel.add(buttonFour);	
		createFoodLabel(scrollablePanel, "Japaness Ramen", 470);
        createFoodImageLabel(scrollablePanel, "Food Image 4", "rammen.png", 470);

        JScrollPane scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(350, 110, 500, 410);
        container.add(scrollPane);
		
		messageLabel = new JLabel("Your opinion is valuable to us", JLabel.CENTER);
        messageLabel.setBounds(40, 420, 300, 40);
        messageLabel.setFont(largeLabelFont);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(messageLabel);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);	
		
		imageLabel = new JLabel(new ImageIcon("Reviewer is Hungry.png"));
        imageLabel.setBounds(70, 80, 250, 400);
        container.add(imageLabel);
		
        backgroundImageLabel = new JLabel(new ImageIcon("Review.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);
    }

	
private boolean isFoodOrderedByUser(String foodItem) {
   
    File file = new File("AdminPackage/"+username + ".txt");
    String line;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        while ((line = br.readLine()) != null) {
            
            if (line.toLowerCase().contains(foodItem.toLowerCase())) {
                return true; 
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false; 
}
private void orderChickenBiriyani(ActionEvent e) {
    String foodItem = "Chikhen Dum Biriyani"; 
	
	ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
    ImageIcon okImg = new ImageIcon("okImg.png");
	
    if (isFoodOrderedByUser(foodItem)) {
        JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
		
		this.setVisible(false);
		ReviewForChikhenDumBiriyani frame = new ReviewForChikhenDumBiriyani(username);
        frame.setTitle("Food Ordering sysytem");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		frame.setResizable(false);
		
    } else {
        JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
    }
}

    private void orderBeefBurger(ActionEvent e) {
         String foodItem = "Beef Burger"; 
	
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
	
		if (isFoodOrderedByUser(foodItem)) {
			JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
			
			this.setVisible(false);
			ReviewForBeefBurger frame = new ReviewForBeefBurger(username);
			frame.setTitle("Food Ordering sysytem");
			frame.setSize(900, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
		}
		}

    private void orderCreamyPasta(ActionEvent e) {
        String foodItem = "Creammy Pasta"; 
	
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
	
		if (isFoodOrderedByUser(foodItem)) {
			JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
			
			this.setVisible(false);
			ReviewForCreammyPasta frame = new ReviewForCreammyPasta(username);
			frame.setTitle("Food Ordering sysytem");
			frame.setSize(900, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
		}
    }

    private void orderRamen(ActionEvent e) {
        String foodItem = "Japaness Ramen"; 
	
		ImageIcon BlankImg = new ImageIcon("FillAllbox.png");
		ImageIcon okImg = new ImageIcon("okImg.png");
	
		if (isFoodOrderedByUser(foodItem)) {
			JOptionPane.showMessageDialog(this, "You can give a review for " + foodItem, "Review", JOptionPane.INFORMATION_MESSAGE,okImg);
			
			this.setVisible(false);
			ReviewForJapanessRamen frame = new ReviewForJapanessRamen(username);
			frame.setTitle("Food Ordering sysytem");
			frame.setSize(900, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
						
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you have not ordered " + foodItem + " yet. You are not eligible to review it.", "Error", JOptionPane.ERROR_MESSAGE,BlankImg);
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
	
		 private void goBack(ActionEvent e) {
			
			this.setVisible(false);

            GiveReviewService page = new GiveReviewService(username);
            page.setTitle("Customer Food Service");
			page.setSize(900, 600);
			page.setLocationRelativeTo(null);
			page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			page.setVisible(true);
			page.setResizable(false);
    			
			
		}
		
}
