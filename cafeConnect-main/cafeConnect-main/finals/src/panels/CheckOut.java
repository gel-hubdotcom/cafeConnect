package panels;
import main.WindowFrame;
import menu.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CheckOut {
	public JPanel checkoutPanel = new JPanel(new BorderLayout());	
	public static int currentQueueNumber = 0;
	public static LinkedList<Integer> queue;
	public static JTextArea queTotalNumber;
    public static List<String> items;
    
    public static Cart cartInstance;
    
    JButton backButton;
    JLabel check;

    public CheckOut(Cart cart) {
        //checkout panel
    	checkoutPanel.setBounds(380, 100, 500, 500);
        check = new JLabel();
        check.setIcon(new ImageIcon("images/Queue number.png"));
        checkoutPanel.add(check);

        //back button
        backButton = new JButton();
        backButton.setIcon(new ImageIcon("images/menu button.png"));
        backButton.setBounds(190, 440, 133, 30);
        check.add(backButton);
        
        //back button action listener
        backButton.addActionListener(new ActionListener() {
		
        	@Override 
			public void actionPerformed(ActionEvent e) {
        		
        		//reseting cart jtextarea
        		Cart cart = new Cart();
        		cart.resetCartTextArea();
        		//removing old menu panels
        		WindowFrame.L1.removeAll();
        		
        		//adding new menu panels
        		Menu menu = new Menu(cart);
        		WindowFrame.L1.add(menu.panelMenu2);
        		WindowFrame.L1.add(menu.panelMenu);
        		WindowFrame.L1.add(menu.pastries);
        		WindowFrame.L1.add(menu.coffee);
        		WindowFrame.L1.add(cart.panel2);
        		WindowFrame.L1.add(cart.panel);
        		
        		WindowFrame.L1.repaint();
        		WindowFrame.L1.revalidate();
			}
			
		});
       
        //queing and total print
        queTotalNumber = new JTextArea();
        queTotalNumber.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        queTotalNumber.setBounds(115, 220, 350, 115);
        queTotalNumber.setForeground(Color.white);
        queTotalNumber.setFocusable(false);
        queTotalNumber.setEditable(false);
        queTotalNumber.setOpaque(false);
        check.add(queTotalNumber);
        
        //adding array in queue variable
        queue = new LinkedList<>();
       
    }
    
    //cart instance
    public static void cartInstance(Cart cart) {
    	cartInstance = cart;
    }
    
    //generating and updating queue number and total price
    public static void generateQueueTotalPriceNumber() {
        currentQueueNumber++;
        queue.add(currentQueueNumber);
        updateQueueTotalPriceNumber(Cart.getTotalPrice());
    }

    //printing in text area
    static void updateQueueTotalPriceNumber(int totalPrice) {
    	queTotalNumber.setText("Total Price: " + totalPrice + "\nQueue Number: " +currentQueueNumber);
    		
    }
}


