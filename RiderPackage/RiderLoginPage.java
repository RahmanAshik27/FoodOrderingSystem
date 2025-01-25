package RiderPackage;

import AdminPackage.*;
import CustomerPackage.*;
import ReviewPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class RiderLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, imageLabel,pathaoLabel,foodiBdLabel,ieatrayLabel,jhinkuFoodBdLabel,raihanExpressLabel;
    private JButton pathaoButton, foodiBdButton, ieatrayButton, jhinkuFoodBdButton, raihanExpressButton,backButton;
    private ImageIcon backgroundImageIcon;

    public RiderLoginPage() {
       
	   setupRiderLoginPage();
		loadAndCountPathaoOrders();
		loadAndCountFoodiBdOrders();
		loadAndCountIEatrayOrders();
		loadAndCountjhinkuFoodBdOrders();
		loadAndCountRaihanExpressLabelOrders();		
    }

    private void setupRiderLoginPage() {
        container = this.getContentPane();
        container.setLayout(null);
		
		 Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        welcomeLabel = new JLabel("Welcome to Rider Login Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        pathaoButton = createButton("Pathao", 40, 120, new Color(255, 87, 34)); 
		pathaoLabel = new JLabel();
		pathaoLabel.setBounds(290, 130, 130, 30); 
		pathaoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		pathaoLabel.setForeground(Color.RED);
		pathaoLabel.setOpaque(true);
		pathaoLabel.setBackground(new Color(240, 255, 240));
		pathaoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pathaoLabel.setText("Pathao Label");
		container.add(pathaoLabel);
		
        foodiBdButton = createButton("FoodiBd", 40, 190, new Color(34, 193, 195)); 
		foodiBdLabel = new JLabel();
		foodiBdLabel.setBounds(290, 200, 130, 30); 
		foodiBdLabel.setFont(new Font("Arial", Font.BOLD, 15));
		foodiBdLabel.setForeground(Color.RED);
		foodiBdLabel.setOpaque(true);
		foodiBdLabel.setBackground(new Color(240, 255, 240));
		foodiBdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		foodiBdLabel.setText("foodiBd Label");
		container.add(foodiBdLabel);
		
        ieatrayButton = createButton("IEatray", 40, 260, new Color(252, 140, 3));
		ieatrayLabel = new JLabel();
		ieatrayLabel.setBounds(290, 270, 130, 30); 
		ieatrayLabel.setFont(new Font("Arial", Font.BOLD, 15));
		ieatrayLabel.setForeground(Color.RED);
		ieatrayLabel.setOpaque(true);
		ieatrayLabel.setBackground(new Color(240, 255, 240));
		ieatrayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		ieatrayLabel.setText("Ieatray Label");
		container.add(ieatrayLabel);
		
        jhinkuFoodBdButton = createButton("Jhinku Food Bd", 40, 330, new Color(83, 109, 254));
		jhinkuFoodBdLabel = new JLabel();
		jhinkuFoodBdLabel.setBounds(290, 340, 130, 30); 
		jhinkuFoodBdLabel.setFont(new Font("Arial", Font.BOLD, 15));
		jhinkuFoodBdLabel.setForeground(Color.RED);
		jhinkuFoodBdLabel.setOpaque(true);
		jhinkuFoodBdLabel.setBackground(new Color(240, 255, 240));
		jhinkuFoodBdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		jhinkuFoodBdLabel.setText("jhinkuFoodBd Label");
		container.add(jhinkuFoodBdLabel);
		
        raihanExpressButton = createButton("Raihan Express", 40, 400, new Color(255, 82, 82));
		raihanExpressLabel = new JLabel();
		raihanExpressLabel.setBounds(290, 410, 130, 30); 
		raihanExpressLabel.setFont(new Font("Arial", Font.BOLD, 15));
		raihanExpressLabel.setForeground(Color.RED);
		raihanExpressLabel.setOpaque(true);
		raihanExpressLabel.setBackground(new Color(240, 255, 240));
		raihanExpressLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		raihanExpressLabel.setText("raihan Express Label");
		container.add(raihanExpressLabel);
		

        container.add(pathaoButton);
        container.add(foodiBdButton);
        container.add(ieatrayButton);
        container.add(jhinkuFoodBdButton);
        container.add(raihanExpressButton);


        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);
       
        backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
		
    }
	
	 private void loadAndCountPathaoOrders() {
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/AdminPackage/Pathao Riders Orders.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Cash Memo")) {
                    count++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(container, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        
        pathaoLabel.setText("Pending Order " + count);
		pathaoLabel.setHorizontalAlignment(JLabel.CENTER);

    }
	
	private void loadAndCountFoodiBdOrders() {
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/AdminPackage/FoodiBd Riders Orders.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Cash Memo")) {
                    count++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(container, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        foodiBdLabel.setText("Pending Order " + count);
		foodiBdLabel.setHorizontalAlignment(JLabel.CENTER);

    }
	
	private void loadAndCountIEatrayOrders() {
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/AdminPackage/IEatray Riders Orders.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Cash Memo")) {
                    count++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(container, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        ieatrayLabel.setText("Pending Order " + count);
		ieatrayLabel.setHorizontalAlignment(JLabel.CENTER);

    }

	
	private void loadAndCountjhinkuFoodBdOrders() {
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/AdminPackage/Jhinku Food Bd Riders Orders.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Cash Memo")) {
                    count++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(container, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        jhinkuFoodBdLabel.setText("Pending Order " + count);
		jhinkuFoodBdLabel.setHorizontalAlignment(JLabel.CENTER);

    }
	
	
	private void loadAndCountRaihanExpressLabelOrders()	{
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/AdminPackage/Raihan Express Riders Orders.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Cash Memo")) {
                    count++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(container, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        raihanExpressLabel.setText("Pending Order " + count);
		raihanExpressLabel.setHorizontalAlignment(JLabel.CENTER);
    }
	
    private JButton createButton(String text, int x, int y, Color buttonColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBounds(x, y, 250, 50);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(buttonColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(buttonColor, 2));
        button.addActionListener(e -> handleButtonClick(text));  
        return button;
    }
	
	  private void goBack(ActionEvent e) {
      
        this.setVisible(false); 
        ProjectMainPage mainPage = new ProjectMainPage(); 
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }

    private void handleButtonClick(String buttonName) {
        if (buttonName.equals("Pathao")) {
            
            PathaoRider pathaoRiderPage = new PathaoRider();  
            pathaoRiderPage.setTitle("Pathao Rider Login");
            pathaoRiderPage.setSize(900, 600);
            pathaoRiderPage.setLocationRelativeTo(null);
            pathaoRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            pathaoRiderPage.setVisible(true);
			pathaoRiderPage.setResizable(false);


            this.setVisible(false);
        } else if (buttonName.equals("FoodiBd")) {
           
			 
			FoodIBdRider foodIBdRiderRiderPage = new FoodIBdRider();  
            foodIBdRiderRiderPage.setTitle("FoodIBd Rider Login");
            foodIBdRiderRiderPage.setSize(900, 600);
            foodIBdRiderRiderPage.setLocationRelativeTo(null);
            foodIBdRiderRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            foodIBdRiderRiderPage.setVisible(true);
			foodIBdRiderRiderPage.setResizable(false);
			
			this.setVisible(false);
		
        } else if (buttonName.equals("IEatray")) {
			
			IEatRayRider IEatRayRiderPage = new IEatRayRider();  
            IEatRayRiderPage.setTitle("Pathao Rider Login");
            IEatRayRiderPage.setSize(900, 600);
            IEatRayRiderPage.setLocationRelativeTo(null);
            IEatRayRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            IEatRayRiderPage.setVisible(true);
			IEatRayRiderPage.setResizable(false);
			
			this.setVisible(false);
			
		
        } else if (buttonName.equals("Jhinku Food Bd")) {
			
			JhinkuFoodBdRider JhinkuFoodBdRiderPage = new JhinkuFoodBdRider();  
            JhinkuFoodBdRiderPage.setTitle("Pathao Rider Login");
            JhinkuFoodBdRiderPage.setSize(900, 600);
            JhinkuFoodBdRiderPage.setLocationRelativeTo(null);
            JhinkuFoodBdRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            JhinkuFoodBdRiderPage.setVisible(true);
			JhinkuFoodBdRiderPage.setResizable(false);
			
			this.setVisible(false);
    
        } else if (buttonName.equals("Raihan Express")) {

            RaihanExpressFoodBdRider raihanExpressFoodBdRiderPage = new RaihanExpressFoodBdRider();  
            raihanExpressFoodBdRiderPage.setTitle("Pathao Rider Login");
            raihanExpressFoodBdRiderPage.setSize(900, 600);
            raihanExpressFoodBdRiderPage.setLocationRelativeTo(null);
            raihanExpressFoodBdRiderPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            raihanExpressFoodBdRiderPage.setVisible(true);
			raihanExpressFoodBdRiderPage.setResizable(false);
			this.setVisible(false);
        }
    }
}

