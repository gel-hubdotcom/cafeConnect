package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.WindowFrame;

public class Cart {

	public static JPanel panel = new JPanel(new BorderLayout());
	public static JPanel panel2 = new JPanel(new BorderLayout());
	public static JTextArea cartTextArea;
	private static int totalPrice = 0;
	
	public List<String> items;
	
	JButton checkOutButton;
	JButton resetCartButton;

	JLabel cartPanel;
	JLabel logoName;

	public Cart() {
		// panels
		panel2.setBounds(88, 60, 782, 82);
		panel.setBounds(962, 0, 280, 706);
		items = new ArrayList<>();

		// cafe connect logo
		logoName = new JLabel();
		logoName.setIcon(new ImageIcon("images/cafe connect word.png"));
		panel2.add(logoName);

		// cart background image
		cartPanel = new JLabel();
		cartPanel.setIcon(new ImageIcon("images/cart panel.png"));
		panel.add(cartPanel);


		// cart text box
		Color backgroundColor = new Color(22, 117, 68);
		
		cartTextArea = new JTextArea(10, 20);
		cartTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cartTextArea.setBounds(50, 50, 179, 550);
//		cartTextArea.setForeground(Color.white);
		cartTextArea.setFocusable(false);
		cartTextArea.setEditable(false);
//		cartTextArea.setOpaque(false);
		cartPanel.add(cartTextArea);

		
		// checkout button
		checkOutButton = new JButton();
		checkOutButton.setIcon(new ImageIcon("images/checkout.png"));
		checkOutButton.setBounds(50, 610, 180, 45);
		checkOutButton.setVisible(true);
		cartPanel.add(checkOutButton);
	
		// checkout action listener
		checkOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CheckOut checkOut = new CheckOut(null);
				
				//adding queue number and total price panel 
				WindowFrame.L1.removeAll();
				CheckOut.generateQueueTotalPriceNumber();
				WindowFrame.L1.add(checkOut.checkoutPanel);
				WindowFrame.L1.repaint();
				WindowFrame.L1.revalidate();
			
			}

		});
		
		resetCartButton = new JButton();
		resetCartButton.setIcon(new ImageIcon("images/reset cart.png"));
		resetCartButton.setBounds(75, 660, 130, 30);
		resetCartButton.setVisible(true);
		cartPanel.add(resetCartButton);
		
		resetCartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					resetCartTextArea();
					cartTextArea.repaint();
					cartTextArea.revalidate();
			}
			
		});
		}
	
	//reset cart
	public void resetCartTextArea() {
		cartTextArea.setText("");
		items.clear();
        totalPrice = 0;
        
        CheckOut. updateQueueTotalPriceNumber(totalPrice);
       
    }

	// items adding to cart
	public void addItemToCart(String itemName, int itemPrice) {
		items.add(itemName);
		totalPrice += itemPrice;
		cartTextArea.append(itemName + " - ₱" + itemPrice +  "\n");
		cartTextArea.repaint();
		CheckOut. updateQueueTotalPriceNumber(totalPrice);
	}
	//returning value of total price
	public static int getTotalPrice() {
		return totalPrice;
	}
	
}

