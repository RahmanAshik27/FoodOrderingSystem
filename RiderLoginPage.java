import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class RiderLoginPage extends JFrame {
    private Container container;
    private JLabel welcomeLabel, footerLabel, imageLabel;
    private JButton pathaoButton, foodiBdButton, ieatrayButton, jhinkuFoodBdButton, raihanExpressButton,backButton;
    private ImageIcon backgroundImageIcon;

    public RiderLoginPage() {
        setupRiderLoginPage();
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
        foodiBdButton = createButton("FoodiBd", 40, 190, new Color(34, 193, 195)); 
        ieatrayButton = createButton("IEatray", 40, 260, new Color(252, 140, 3)); 
        jhinkuFoodBdButton = createButton("Jhinku Food Bd", 40, 330, new Color(83, 109, 254)); 
        raihanExpressButton = createButton("Raihan Express", 40, 400, new Color(255, 82, 82)); 

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

class PathaoRider extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel,imageLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;
	private ImageIcon backgroundImageIcon;

    PathaoRider() {
        setupRiderPage();
    }

    private void setupRiderPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
        welcomeLabel = new JLabel("Hello ,i am Mr.pathao rider ", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 180, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(160, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 240, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(415, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(e -> togglePasswordVisibility());
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 310, 120, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(e -> handleLogin(e));
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 310, 120, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(e -> clearFields());
        container.add(clearButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		 backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);;
    }

    private void togglePasswordVisibility() {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

    
    private void clearFields() {
        textField.setText("");
        passwordField.setText("");
    }

    private void handleLogin(ActionEvent e) {
    String username = textField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon blankImg = new ImageIcon("FillAllbox.png"); 

  
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
        return; 
    }

    if ("rider".equals(username) && "riderpassword".equals(password)) {
        String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Please proceed to the Rider page.</div></html>";
        JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
    } else {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}


    private void goBack(ActionEvent e) {
        this.setVisible(false);
        RiderLoginPage mainPage = new RiderLoginPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}


class FoodIBdRider extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel,imageLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;
	private ImageIcon backgroundImageIcon;

    FoodIBdRider() {
        setupRiderPage();
    }

    private void setupRiderPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
        welcomeLabel = new JLabel("Hello i am Mr.FoodIBd Rider  ", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 180, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(160, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 240, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(415, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(e -> togglePasswordVisibility());
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 310, 120, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(e -> handleLogin(e));
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 310, 120, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(e -> clearFields());
        container.add(clearButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		 backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);;
    }

    private void togglePasswordVisibility() {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

 
    private void clearFields() {
        textField.setText("");
        passwordField.setText("");
    }

    private void handleLogin(ActionEvent e) {
    String username = textField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon blankImg = new ImageIcon("FillAllbox.png"); 


    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
        return;
    }

    if ("rider".equals(username) && "riderpassword".equals(password)) {
        String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Please proceed to the Rider page.</div></html>";
        JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
    } else {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}


    private void goBack(ActionEvent e) {
        this.setVisible(false);
        RiderLoginPage mainPage = new RiderLoginPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}



class IEatRayRider extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel,imageLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;
	private ImageIcon backgroundImageIcon;

    IEatRayRider() {
        setupRiderPage();
    }

    private void setupRiderPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
        welcomeLabel = new JLabel("Hello, i am Mr.IEatRay Rider  ", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 180, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(160, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 240, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(415, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(e -> togglePasswordVisibility());
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 310, 120, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(e -> handleLogin(e));
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 310, 120, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(e -> clearFields());
        container.add(clearButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		 backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);;
    }

    private void togglePasswordVisibility() {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

 
    private void clearFields() {
        textField.setText("");
        passwordField.setText("");
    }

    private void handleLogin(ActionEvent e) {
    String username = textField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon blankImg = new ImageIcon("FillAllbox.png"); 

   
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
        return; // 
    }

    if ("rider".equals(username) && "riderpassword".equals(password)) {
        String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Please proceed to the Rider page.</div></html>";
        JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
    } else {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}


    private void goBack(ActionEvent e) {
        this.setVisible(false);
        RiderLoginPage mainPage = new RiderLoginPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}


class JhinkuFoodBdRider extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel,imageLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;
	private ImageIcon backgroundImageIcon;

    JhinkuFoodBdRider() {
        setupRiderPage();
    }

    private void setupRiderPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
        welcomeLabel = new JLabel("Hello, I am Mr.Jhiku Rider  ", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 180, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(160, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 240, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(415, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(e -> togglePasswordVisibility());
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 310, 120, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(e -> handleLogin(e));
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 310, 120, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(e -> clearFields());
        container.add(clearButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		 backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);;
    }

    private void togglePasswordVisibility() {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

 
    private void clearFields() {
        textField.setText("");
        passwordField.setText("");
    }

    private void handleLogin(ActionEvent e) {
    String username = textField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon blankImg = new ImageIcon("FillAllbox.png"); 

   
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
        return; // 
    }

    if ("rider".equals(username) && "riderpassword".equals(password)) {
        String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Please proceed to the Rider page.</div></html>";
        JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
    } else {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}


    private void goBack(ActionEvent e) {
        this.setVisible(false);
        RiderLoginPage mainPage = new RiderLoginPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}


class RaihanExpressFoodBdRider extends JFrame {
    private Container container;
    private JLabel welcomeLabel, userLabel, passwordLabel, footerLabel,imageLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, backButton;
    private JToggleButton eyeButton;
	private ImageIcon backgroundImageIcon;

    RaihanExpressFoodBdRider() {
        setupRiderPage();
    }

    private void setupRiderPage() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(240, 248, 255));

        Font font = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        
        welcomeLabel = new JLabel("Hello, I am Mr.RaihanExpressFood Rider  ", JLabel.CENTER);
        welcomeLabel.setBounds(150, 20, 600, 70);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        container.add(welcomeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(cursor);
        backButton.addActionListener(this::goBack);
        container.add(backButton);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 180, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(userLabel);
        
        textField = new JTextField();
        textField.setBounds(160, 180, 250, 40);
        textField.setFont(labelFont);
        textField.setBackground(Color.WHITE);
        container.add(textField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 240, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 240, 250, 40);
        passwordField.setFont(labelFont);
        passwordField.setBackground(Color.WHITE);
        container.add(passwordField);

        eyeButton = new JToggleButton(new ImageIcon("eye.png"));
        eyeButton.setBounds(415, 240, 50, 40);
        eyeButton.setBorder(null);
        eyeButton.setFocusPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.addActionListener(e -> togglePasswordVisibility());
        container.add(eyeButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 310, 120, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(50, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(cursor);
        loginButton.addActionListener(e -> handleLogin(e));
        container.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 310, 120, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBackground(new Color(255, 99, 71));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.addActionListener(e -> clearFields());
        container.add(clearButton);

        footerLabel = new JLabel("Food Ordering System", JLabel.CENTER);
        footerLabel.setBounds(480, 480, 300, 40);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(0, 0, 0, 150));
        container.add(footerLabel);
		
		 backgroundImageIcon = new ImageIcon("RiderLogin.png");
        imageLabel = new JLabel(backgroundImageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        container.add(imageLabel);;
    }

    private void togglePasswordVisibility() {
        if (eyeButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('\u2022');
        }
    }

 
    private void clearFields() {
        textField.setText("");
        passwordField.setText("");
    }

    private void handleLogin(ActionEvent e) {
    String username = textField.getText();
    String password = new String(passwordField.getPassword());

    ImageIcon okImg = new ImageIcon("okImg.png");
    ImageIcon wrongImg = new ImageIcon("wrongimg2.png");
    ImageIcon blankImg = new ImageIcon("FillAllbox.png"); 

   
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "All fields must be filled!", 
            "Error", 
            JOptionPane.INFORMATION_MESSAGE, 
            blankImg);
        return; // 
    }

    if ("rider".equals(username) && "riderpassword".equals(password)) {
        String successMessage = "<html><div style='text-align: center;'><b>Login Successful!</b><br>Please proceed to the Rider page.</div></html>";
        JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE, okImg);
    } else {
        String errorMessage = "<html><div style='text-align: center;'><b>Incorrect Username or Password!</b><br>Please try again.</div></html>";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, wrongImg);
    }
}

    private void goBack(ActionEvent e) {
        this.setVisible(false);
        RiderLoginPage mainPage = new RiderLoginPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
		mainPage.setResizable(false);
    }
}

