package main;

import panels.Cart;
import panels.CheckOut;

import menu.Menu;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowFrame extends JFrame {
	public static JLabel L1;
	
	public JPanel panelFrame;
	public Cart cartPanel;
	public Menu menuBar;
	public JLabel L2;
	
	boolean change = true;

	JLabel coffeeLogo;
	JButton checkOut;

	public WindowFrame() {
		//frame
		this.setTitle("Cafe Connect");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50, 0, 1258, 748);
		this.setResizable(false);
		this.setLayout(null);

		// Image Icon
		ImageIcon image = new ImageIcon("images/logo.png");
		this.setIconImage(image.getImage());

		// Background
		L1 = new JLabel();
		L1.setIcon(new ImageIcon("images/background.png"));
		this.setLayout(new BorderLayout());
		this.add(L1, BorderLayout.CENTER);
		
		//cart panel import
		Cart cart = new Cart();
		L1.add(cart.panel2);
		L1.add(cart.panel);
		
		//menu panels import
		Menu menu = new Menu(cart);
		L1.add(menu.panelMenu2);
		L1.add(menu.panelMenu);
		L1.add(menu.pastries);
		L1.add(menu.coffee);
		
		//check out panels import
		CheckOut checkOut = new CheckOut(cart);
		CheckOut.cartInstance(cart);
		
        this.setVisible(true);
	}

}
