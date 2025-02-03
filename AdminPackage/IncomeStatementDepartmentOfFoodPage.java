package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class IncomeStatementDepartmentOfFoodPage extends JFrame {
    private JLabel welcomeLabel, messageLabel, imageLabel, backgroundImageLabel;
    private JButton backButton, buttonOne, buttonTwo, buttonThree, buttonFour,incomeStatementBoardButton,addBoardButton;
    private JLabel ChikhenDumBiriyani, BeefBurger, CreammyPasta, JapanessRamen, sellchickenDumBiriyaniLabel,sellQuantitychickenDumBiriyaniLabel,sellBeefBurgerLabel,sellQuantityBeefBurgerLabel;
	private JLabel sellQuantityCreammyPastaLabel,sellCreammyPastaLabel,sellQuantityJapaneseRamenLabel,sellJapaneseRamenLabel;
	private JTextArea reviewArea;
	private JScrollPane scrollPane;

  public IncomeStatementDepartmentOfFoodPage() {
    
	setUpIncomeStatementDepartmentOfFoodPage();
	
	loadAndCountChikhenDumBiriyaniQuantityAndSales();
	loadAndCountBeefBurgerQuantityAndSales();
	loadAndCountCreammyPastaQuantityAndSales();
	loadAndCountJapanessRamenQuantityAndSales();
	
	}
    private void setUpIncomeStatementDepartmentOfFoodPage() {
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

        welcomeLabel = new JLabel("Welcome to the Income Statement Page", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 650, 70);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

        int panelHeight = 100 + 10 * 50;
        scrollablePanel.setPreferredSize(new Dimension(650, panelHeight));

        JScrollPane scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(280, 110, 590, 410);
        container.add(scrollPane);

        JLabel aLabel = new JLabel("A      ", JLabel.CENTER);
        aLabel.setBounds(5, 10, 560, 30);
        aLabel.setForeground(Color.RED);
        aLabel.setOpaque(true);
        aLabel.setBackground(Color.WHITE);
        aLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(aLabel);

		String boxMessage = "<html><div style='text-align: center;'><b>Total Selling</b><br>Quantity</div></html>";

        JLabel boxlabel = new JLabel(boxMessage, JLabel.CENTER);
        boxlabel.setBounds(343, 45, 117, 40);
        boxlabel.setForeground(Color.BLACK);
        boxlabel.setOpaque(true);
        boxlabel.setBackground(Color.WHITE);
		boxlabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        boxlabel.setFont(new Font("Arial", Font.BOLD, 14));
        scrollablePanel.add(boxlabel);
		
		JLabel boxlabel2 = new JLabel(boxMessage, JLabel.CENTER);
        boxlabel2.setBounds(343, 455, 117, 40);
        boxlabel2.setForeground(Color.BLACK);
        boxlabel2.setOpaque(true);
		boxlabel2.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        boxlabel2.setBackground(Color.WHITE);
        boxlabel2.setFont(new Font("Arial", Font.BOLD, 14));
        scrollablePanel.add(boxlabel2);
		
		String sellMessage = "<html><div style='text-align: center;'><b>Total Selling</b><br>Price</div></html>";
		
		JLabel selllabel = new JLabel(sellMessage, JLabel.CENTER);
        selllabel.setBounds(460, 45, 112, 40);
        selllabel.setForeground(Color.BLACK);
        selllabel.setOpaque(true);
		selllabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        selllabel.setBackground(Color.WHITE);
        selllabel.setFont(new Font("Arial", Font.BOLD, 14));
        scrollablePanel.add(selllabel);
		
		JLabel selllabel2 = new JLabel(sellMessage, JLabel.CENTER);
        selllabel2.setBounds(460, 455, 112, 40);
        selllabel2.setForeground(Color.BLACK);
        selllabel2.setOpaque(true);
        selllabel2.setBackground(Color.WHITE);
		selllabel2.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
        selllabel2.setFont(new Font("Arial", Font.BOLD, 14));
        scrollablePanel.add(selllabel2);
		
        JLabel bLabel = new JLabel("B      ", JLabel.CENTER);
        bLabel.setBounds(5, 420, 560, 30);
        bLabel.setForeground(Color.RED);
        bLabel.setOpaque(true);
        bLabel.setBackground(Color.WHITE);
        bLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scrollablePanel.add(bLabel);
		

        createFoodLabel(scrollablePanel, "Chicken Dum Biriyani", 70);
        createFoodImageLabel(scrollablePanel, "Food Image 1", "Src_ImageStore/chikenbiriyani.png", 60);
        
		sellQuantitychickenDumBiriyaniLabel = new JLabel();
		sellQuantitychickenDumBiriyaniLabel.setBounds(350, 95, 100, 50); 
		sellQuantitychickenDumBiriyaniLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellQuantitychickenDumBiriyaniLabel.setForeground(Color.RED);
		sellQuantitychickenDumBiriyaniLabel.setOpaque(true);
		sellQuantitychickenDumBiriyaniLabel.setBackground(new Color(240, 255, 240));
		sellQuantitychickenDumBiriyaniLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellQuantitychickenDumBiriyaniLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellQuantitychickenDumBiriyaniLabel);
		
		sellchickenDumBiriyaniLabel = new JLabel();
		sellchickenDumBiriyaniLabel.setBounds(465, 95, 100, 50); 
		sellchickenDumBiriyaniLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellchickenDumBiriyaniLabel.setForeground(Color.RED);
		sellchickenDumBiriyaniLabel.setOpaque(true);
		sellchickenDumBiriyaniLabel.setBackground(new Color(240, 255, 240));
		sellchickenDumBiriyaniLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellchickenDumBiriyaniLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellchickenDumBiriyaniLabel);
		

        createFoodLabel(scrollablePanel, "Beef Burger", 180);
        createFoodImageLabel(scrollablePanel, "beef burger", "Src_ImageStore/beef burger.png", 180);
        
		sellQuantityBeefBurgerLabel = new JLabel();
		sellQuantityBeefBurgerLabel.setBounds(350, 205, 100, 50); 
		sellQuantityBeefBurgerLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellQuantityBeefBurgerLabel.setForeground(Color.RED);
		sellQuantityBeefBurgerLabel.setOpaque(true);
		sellQuantityBeefBurgerLabel.setBackground(new Color(240, 255, 240));
		sellQuantityBeefBurgerLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellQuantityBeefBurgerLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellQuantityBeefBurgerLabel);
		
		sellBeefBurgerLabel = new JLabel();
		sellBeefBurgerLabel.setBounds(465, 205, 100, 50); 
		sellBeefBurgerLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellBeefBurgerLabel.setForeground(Color.RED);
		sellBeefBurgerLabel.setOpaque(true);
		sellBeefBurgerLabel.setBackground(new Color(240, 255, 240));
		sellBeefBurgerLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellBeefBurgerLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellBeefBurgerLabel);


        createFoodLabel(scrollablePanel, "Creammy Pasta", 300);
        createFoodImageLabel(scrollablePanel, "Food Image 3", "Src_ImageStore/pasta.png", 300);
        
		sellQuantityCreammyPastaLabel = new JLabel();
		sellQuantityCreammyPastaLabel.setBounds(350, 325, 100, 50); 
		sellQuantityCreammyPastaLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellQuantityCreammyPastaLabel.setForeground(Color.RED);
		sellQuantityCreammyPastaLabel.setOpaque(true);
		sellQuantityCreammyPastaLabel.setBackground(new Color(240, 255, 240));
		sellQuantityCreammyPastaLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellQuantityCreammyPastaLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellQuantityCreammyPastaLabel);
		
		sellCreammyPastaLabel = new JLabel();
		sellCreammyPastaLabel.setBounds(465, 325, 100, 50); 
		sellCreammyPastaLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellCreammyPastaLabel.setForeground(Color.RED);
		sellCreammyPastaLabel.setOpaque(true);
		sellCreammyPastaLabel.setBackground(new Color(240, 255, 240));
		sellCreammyPastaLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellCreammyPastaLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellCreammyPastaLabel);
		
	
      
        createFoodLabel(scrollablePanel, "Japanese Ramen", 483);
        createFoodImageLabel(scrollablePanel, "Food Image 4", "Src_ImageStore/rammen.png", 470);
        
		sellQuantityJapaneseRamenLabel = new JLabel();
		sellQuantityJapaneseRamenLabel.setBounds(350, 510, 100, 50); 
		sellQuantityJapaneseRamenLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellQuantityJapaneseRamenLabel.setForeground(Color.RED);
		sellQuantityJapaneseRamenLabel.setOpaque(true);
		sellQuantityJapaneseRamenLabel.setBackground(new Color(240, 255, 240));
		sellQuantityJapaneseRamenLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellQuantityJapaneseRamenLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellQuantityJapaneseRamenLabel);
		
		sellJapaneseRamenLabel = new JLabel();
		sellJapaneseRamenLabel.setBounds(465, 510, 100, 50); 
		sellJapaneseRamenLabel.setFont(new Font("Arial", Font.BOLD, 20));
		sellJapaneseRamenLabel.setForeground(Color.RED);
		sellJapaneseRamenLabel.setOpaque(true);
		sellJapaneseRamenLabel.setBackground(new Color(240, 255, 240));
		sellJapaneseRamenLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		sellJapaneseRamenLabel.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 50), 2));
		scrollablePanel.add(sellJapaneseRamenLabel);

        
        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(boldFont);
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

		String addMessage = "<html><div style='text-align: center;'><b>Wanna Terminate any </b><br> Food ?</div></html>";
		
		addBoardButton = new JButton(addMessage);
        addBoardButton.setBounds(25, 457, 220, 80);
        addBoardButton.setFont(largeLabelFont);
        addBoardButton.setBackground(new Color(255, 99, 71));
        addBoardButton.setForeground(Color.WHITE);
        addBoardButton.setCursor(cursor);
		addBoardButton.addActionListener(this::toTerminateFood);		
        container.add(addBoardButton);

		String incomeStatementMessage = "<html><div style='text-align: center;'><b>Show Total</b><br>Income Statement</div></html>";
		
		incomeStatementBoardButton = new JButton(incomeStatementMessage);
		incomeStatementBoardButton.setBounds(30, 100, 220, 50);
		incomeStatementBoardButton.setFont(new Font("Arial", Font.BOLD, 20));
		incomeStatementBoardButton.setBackground(new Color(50, 150, 255));
		incomeStatementBoardButton.setForeground(Color.WHITE);
		incomeStatementBoardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		incomeStatementBoardButton.addActionListener(this::onIncomeStatementBoardButtonClicked); 
		container.add(incomeStatementBoardButton);


		
		reviewArea = new JTextArea();
		reviewArea.setEditable(false); 
		reviewArea.setFont(new Font("Arial", Font.PLAIN, 15));  
		reviewArea.setLineWrap(true);  
		reviewArea.setWrapStyleWord(true); 
		reviewArea.setBackground(new Color(240, 255, 240));  
		reviewArea.setForeground(new Color(0, 0, 0));  		
		reviewArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 128, 255), 2),
				BorderFactory.createEmptyBorder(20, 10, 20, 3)
		));
		
		scrollPane = new JScrollPane(reviewArea);
		scrollPane.setBounds(10, 153, 267, 300); 
		container.add(scrollPane);
		
        backgroundImageLabel = new JLabel(new ImageIcon("Src_ImageStore/Mainpage.png"));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        container.add(backgroundImageLabel);

       
    }
	


private void onIncomeStatementBoardButtonClicked(ActionEvent e) {
    File file = new File("src/AdminPackage/CustomersOrder.txt");
    double totalIncome = 0.0;
    double riderInvestment = 0.0;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Total Amount:")) {
               
                String[] parts = line.split(":");
                totalIncome += Double.parseDouble(parts[1].trim());
            } else if (line.contains("VAT (5%):")) {
                
                String[] parts = line.split(":");
                riderInvestment += Double.parseDouble(parts[1].trim());
            }
        }

       
        double chickenDumBiriyaniSales = Double.parseDouble(sellchickenDumBiriyaniLabel.getText().trim());
        double beefBurgerSales = Double.parseDouble(sellBeefBurgerLabel.getText().trim());
        double creammyPastaSales = Double.parseDouble(sellCreammyPastaLabel.getText().trim());
        double japaneseRamenSales = Double.parseDouble(sellJapaneseRamenLabel.getText().trim());

        
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));

        
        String reviewText = "Income Statement as of \n                         " + formattedDate + "\n"
                + "========================\n"
                + "Total Income : " + totalIncome + " Taka "
                + "\n.....................................................\n\n"
                + "Rider Investment : " + riderInvestment + " Taka "
                + "\n.....................................................\n"
                + "Total Sales Summary:\n"
                + ".....................................................\n"
                + "Chicken Dum Biriyani: " + chickenDumBiriyaniSales + " Taka\n"
                + "Beef Burger             : " + beefBurgerSales + " Taka\n"
                + "Creammy Pasta      : " + creammyPastaSales + " Taka\n"
                + "Japanese Ramen    : " + japaneseRamenSales + " Taka\n";

       
        reviewArea.setText(reviewText);

    } catch (IOException ex) {
        reviewArea.setText("Error reading file: " + ex.getMessage());
    } catch (NumberFormatException ex) {
        reviewArea.setText("Error processing numbers: " + ex.getMessage());
    }
}



    private void createFoodLabel(JPanel panel, String labelText, int yPosition) {
        JLabel label = new JLabel(labelText, JLabel.CENTER);
        label.setBounds(135, yPosition + 25, 200, 50);
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
        imageLabel.setBounds(15, yPosition, 110, 110);
        panel.add(imageLabel);
    }
	
public void loadAndCountChikhenDumBiriyaniQuantityAndSales() {
    String fileName = "src/AdminPackage/CustomersOrder.txt";
    int totalQuantity = 0;
    double totalSales = 0.0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Chikhen Dum Biriyani")) {
                String[] parts = line.trim().split("\\s+");

               
                if (parts.length>=6) {
                    try {
                        
                        int quantity = Integer.parseInt(parts[3]);
                        totalQuantity += quantity;

                        double sales = Double.parseDouble(parts[5]);
                        totalSales += sales;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid format in line: " + line);
                    }
                } else {
                    System.err.println("Line does not have enough parts: " + line);
                }
            }
        }
        
        sellQuantitychickenDumBiriyaniLabel.setText(String.valueOf(totalQuantity));
        sellchickenDumBiriyaniLabel.setText(String.format("%.2f", totalSales));

    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + fileName);
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}


public void loadAndCountBeefBurgerQuantityAndSales() {
   
   String fileName = "src/AdminPackage/CustomersOrder.txt";
    int totalQuantity = 0;
    double totalSales = 0.0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Beef Burger")) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length > 3) {
                    try {
                       
                        int quantity = Integer.parseInt(parts[2]);
                        totalQuantity += quantity;

                        double sales = Double.parseDouble(parts[4]);
                        totalSales += sales;
                    } catch (NumberFormatException e) {
                        
                        System.err.println("Invalid format in line: " + line);
                    }
                }
            }
        }

       sellQuantityBeefBurgerLabel.setText(String.valueOf(totalQuantity));
        sellBeefBurgerLabel.setText(String.format("%.2f", totalSales));

    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + fileName);
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}



public void loadAndCountCreammyPastaQuantityAndSales() {
   
   String fileName = "src/AdminPackage/CustomersOrder.txt";
    int totalQuantity = 0;
    double totalSales = 0.0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Creammy Pasta")) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length > 3) {
                    try {
                       
                        int quantity = Integer.parseInt(parts[2]);
                        totalQuantity += quantity;

                        double sales = Double.parseDouble(parts[4]);
                        totalSales += sales;
                    } catch (NumberFormatException e) {
                        
                        System.err.println("Invalid format in line: " + line);
                    }
                }
            }
        }

        sellQuantityCreammyPastaLabel.setText(String.valueOf(totalQuantity));
        sellCreammyPastaLabel.setText(String.format("%.2f", totalSales));

    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + fileName);
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}


public void loadAndCountJapanessRamenQuantityAndSales() {
    String fileName = "src/AdminPackage/CustomersOrder.txt";
    int totalQuantity = 0;
    double totalSales = 0.0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Japaness Ramen")) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length > 3) {
                    try {
                       
                        int quantity = Integer.parseInt(parts[2]);
                        totalQuantity += quantity;

                        double sales = Double.parseDouble(parts[4]);
                        totalSales += sales;
                    } catch (NumberFormatException e) {
                        
                        System.err.println("Invalid format in line: " + line);
                    }
                }
            }
        }

        sellQuantityJapaneseRamenLabel.setText(String.valueOf(totalQuantity));
        sellJapaneseRamenLabel.setText(String.format("%.2f", totalSales));

    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + fileName);
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}

	
	private void toTerminateFood(ActionEvent e) {
						
			TerminateChikhenDumBiriyani mainPage = new TerminateChikhenDumBiriyani();
			mainPage.setTitle("Food Delivery System");
			mainPage.setSize(300, 400);
			mainPage.setLocationRelativeTo(null);
			mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainPage.setVisible(true);
			mainPage.setResizable(false);
			
		}


    private void goBack(ActionEvent e) {
			
			this.setVisible(false);
			AdminDashboard dashboard = new AdminDashboard();
			dashboard.setTitle("Admin Dashboard");
			dashboard.setSize(900, 600);
			dashboard.setLocationRelativeTo(null);
			dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dashboard.setResizable(false);
			dashboard.setVisible(true);			 
			
    }

}

