package CustomerPackage;

import AdminPackage.*;
import ReviewPackage.*;
import RiderPackage.*;
import  DashboardPackage.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class ThankYouPage extends JFrame {
    public ThankYouPage() {
        setupThankYouPage();
    }

    private void setupThankYouPage() {
        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255)); 

 
        Font messageFont = new Font("Arial", Font.BOLD, 24);
        JLabel messageLabel = new JLabel("Thank You for Ordering!", JLabel.CENTER);
        messageLabel.setBounds(50, 50, 400, 50);
        messageLabel.setFont(messageFont);
        messageLabel.setForeground(new Color(0, 100, 0)); 
        container.add(messageLabel);

    
        Font subMessageFont = new Font("Arial", Font.PLAIN, 16);
        JLabel subMessageLabel = new JLabel("We hope to serve you again soon.", JLabel.CENTER);
        subMessageLabel.setBounds(50, 120, 400, 30);
        subMessageLabel.setFont(subMessageFont);
        subMessageLabel.setForeground(Color.BLACK);
        container.add(subMessageLabel);

        
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(175, 180, 150, 40);
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBackground(new Color(255, 99, 71)); 
        closeButton.setForeground(Color.WHITE); 
        closeButton.addActionListener(e -> handleCloseAction());
        container.add(closeButton);

        
        setTitle("Thank You");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    
    private void handleCloseAction() {
        
        JFrame mainPage = new ProjectMainPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
        dispose(); 
    }
}
