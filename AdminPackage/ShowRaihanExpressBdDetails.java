package AdminPackage;

import CustomerPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import DashboardPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ShowRaihanExpressBdDetails extends JFrame {
    private JTextArea textArea;
    private JLabel welcomeLabel, noticeLabel, footerLabel,imageLabel;
    private JButton showDetailsButton, terminateButton, searchButton,backButton;
    private JTextField searchField;
	private JScrollPane scrollPane;
    private final String filePath = "src/AdminPackage/RaihanExpressBdRiderDetails.txt";

    public ShowRaihanExpressBdDetails() {
        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));
		
		Font headerFont = new Font("Arial", Font.BOLD, 30);
		Font noticeLebelFont= new Font("Arial", Font.BOLD, 20);
		Font labelFont = new Font("Arial", Font.PLAIN, 18);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

		
		welcomeLabel = new JLabel("Welcome to Raihan Express Bd Rider Management", JLabel.CENTER);
        welcomeLabel.setBounds(100, 10, 600, 60);
        welcomeLabel.setFont(headerFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(welcomeLabel);

   
        noticeLabel = new JLabel("Notice Board", JLabel.CENTER);
        noticeLabel.setFont(noticeLebelFont);
        noticeLabel.setBounds(150, 80, 300, 30);
		noticeLabel.setForeground(Color.RED);
		noticeLabel.setOpaque(true);
		noticeLabel.setBackground(Color.WHITE);
        container.add(noticeLabel);

		
		showDetailsButton = new JButton("Show Rider Details ");
		showDetailsButton.setBounds(200, 120, 220, 30);
		showDetailsButton.setFont(new Font("Arial", Font.BOLD, 16));
		showDetailsButton.setBackground(new Color(50, 150, 255));
		showDetailsButton.setForeground(Color.WHITE);
		showDetailsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showDetailsButton.addActionListener(this::loadRiderDetails);
		container.add(showDetailsButton);	
		
		
		textArea = new JTextArea();
        textArea.setFont(noticeLebelFont);
        textArea.setBackground(new Color(240, 255, 240));
        textArea.setLineWrap(true);
		textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 128, 255), 2),
            BorderFactory.createEmptyBorder(35, 10, 35, 10)
        ));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 150, 500, 250);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 2));
        container.add(scrollPane);

		
		searchField = new JTextField("Search rider by name...");
		searchField.setBounds(50, 410, 300, 40);
		searchField.setFont(labelFont);
		searchField.setBackground(Color.WHITE);
		searchField.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 255), 2));


		searchField.addFocusListener(new FocusListener() {
		@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equals("Search rider by name...")) {
					searchField.setText(""); 
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().isEmpty()) {
					searchField.setText("Search rider by name..."); 
				}
			}
		});

		container.add(searchField);
		
		searchButton = new JButton("Search Rider");
        searchButton.setBounds(370, 410, 180, 40);
        searchButton.setFont(new Font("Arial", Font.BOLD, 22));
        searchButton.setBackground(new Color(255, 99, 71));
        searchButton.setForeground(Color.WHITE);
        searchButton.setCursor(cursor);
		searchButton.addActionListener(this::searchRider);
        container.add(searchButton);


		terminateButton = new JButton("Wanna Terminate Rider ?");
		terminateButton.setBounds(150, 470, 300, 40);
		terminateButton.setFont(noticeLebelFont);
		terminateButton.setBackground(new Color(178, 34, 34)); 
		terminateButton.setForeground(Color.WHITE);
		terminateButton.setCursor(cursor);
		terminateButton.addActionListener(this::terminateRider);
		container.add(terminateButton);
		
		
		Font boldFont = new Font("Arial", Font.BOLD, 18);
        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(8, 525, 870, 30);
        footerLabel.setFont(boldFont);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);
		
		imageLabel = new JLabel(new ImageIcon("Src_ImageStore/RiderLogin.png"));
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);
		
    }
	
	private void goBack(ActionEvent e) {
			
			this.setVisible(false);
            
			RaihanExpressDetails raihanExpressBdRiderDetails = new RaihanExpressDetails();
			raihanExpressBdRiderDetails.setTitle("RaihanExpressBd Rider Details");
			raihanExpressBdRiderDetails.setSize(900, 600);
			raihanExpressBdRiderDetails.setLocationRelativeTo(null);
			raihanExpressBdRiderDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			raihanExpressBdRiderDetails.setVisible(true);	
    }

    private void loadRiderDetails(ActionEvent e) {
        textArea.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length >= 4) {
                    textArea.append("Rider Name: " + details[0] +"\n "+ " \t Phone: " + details[2] +"\n "+ " \t Email: " + details[3] + "\n"+"\n" );
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading rider details!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchRider(ActionEvent e) {
		
		ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
		ImageIcon wrongImg = new ImageIcon("Src_ImageStore/wrongimg2.png");
		ImageIcon okImg = new ImageIcon("Src_ImageStore/okImg.png");
		
        String searchQuery = searchField.getText().trim();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name to search!", "Warning", JOptionPane.WARNING_MESSAGE,blankImg);
            return;
        }

        textArea.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length >= 4 && details[0].equalsIgnoreCase(searchQuery)) {
					textArea.append("Rider Name: " + details[0] +"\n "+ " \t Phone: " + details[2] +"\n "+ " \t Email: " + details[3] + "\n"+"\n" );                   
				   found = true;
                }
            }
            if (!found) {
                textArea.setText("No rider found with the name: " + searchQuery);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error searching rider details!", "Error", JOptionPane.ERROR_MESSAGE,wrongImg);
        }
    }

	
private void terminateRider(ActionEvent e) {
    ImageIcon blankImg = new ImageIcon("Src_ImageStore/FillAllbox.png");
    ImageIcon wrongImg = new ImageIcon("Src_ImageStore/wrongimg2.png");
    ImageIcon okImg = new ImageIcon("Src_ImageStore/okImg.png");

    List<String> riders = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            if (details.length >= 1) {
                riders.add(details[0]);
            }
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, 
                                      "Error reading rider details!", 
                                      "Error", 
                                      JOptionPane.ERROR_MESSAGE, 
                                      wrongImg);
        return;
    }

    if (riders.isEmpty()) {
        JOptionPane.showMessageDialog(null, 
                                      "No riders available to terminate.", 
                                      "Info", 
                                      JOptionPane.INFORMATION_MESSAGE, 
                                      wrongImg);
        return;
    }

    String username = searchField.getText().trim();
    if (!username.isEmpty() && riders.contains(username)) {
        int confirm = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to terminate " + username + "?", 
                        "Confirm Termination", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE, 
                        blankImg);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteRider(username);
        }
    } else {
        JOptionPane.showMessageDialog(null, 
                                      "Rider not found!", 
                                      "Error", 
                                      JOptionPane.ERROR_MESSAGE, 
                                      wrongImg);
    }
}

private void deleteRider(String username) {
    List<String> updatedRiders = new ArrayList<>();
    boolean found = false;

    ImageIcon wrongImg = new ImageIcon("Src_ImageStore/wrongimg2.png");
    ImageIcon okImg = new ImageIcon("Src_ImageStore/okImg.png");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            if (details.length >= 1 && details[0].equals(username)) {
                found = true;
                continue; 
            }
            updatedRiders.add(line);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, 
                                      "Error reading rider details!", 
                                      "Error", 
                                      JOptionPane.ERROR_MESSAGE, 
                                      wrongImg);
        return;
    }

    if (!found) {
        JOptionPane.showMessageDialog(null, 
                                      "Rider not found!", 
                                      "Error", 
                                      JOptionPane.ERROR_MESSAGE, 
                                      wrongImg);
        return;
    }

    try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
        for (String rider : updatedRiders) {
            writer.println(rider);
        }
        JOptionPane.showMessageDialog(null, 
                                      "Rider terminated successfully!", 
                                      "Success", 
                                      JOptionPane.INFORMATION_MESSAGE, 
                                      okImg);
        loadRiderDetails(null);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, 
                                      "Error saving updated rider details!", 
                                      "Error", 
                                      JOptionPane.ERROR_MESSAGE, 
                                      wrongImg);
    }
}
}