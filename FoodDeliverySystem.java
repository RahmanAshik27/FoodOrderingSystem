import javax.swing.JFrame;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        JFrame mainPage = new ProjectMainPage();
        mainPage.setTitle("Food Delivery System");
        mainPage.setSize(900, 600);
        mainPage.setLocationRelativeTo(null);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
    }
}
