package menu;

import panels.Cart;
import panels.CheckOut;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu  {
	public JPanel panelMenu2 = new JPanel(new GridLayout(2, 2));
	public JPanel panelMenu = new JPanel(new GridLayout(2, 2));
	public JPanel pastries = new JPanel(new BorderLayout());
	public JPanel coffee = new JPanel(new BorderLayout());
	
	public Cart Cart = new Cart();
	
	JLabel pastriesPic;
	JLabel coffeePic;
	

	public Menu(Cart cart) {
		// coffee sign
		coffee.setBounds(380, 410, 200, 25);
		coffeePic = new JLabel();
		coffeePic.setIcon(new ImageIcon("images/coffee.png"));
		coffee.add(coffeePic);

		// pastries sign
		pastries.setBounds(380, 660, 200, 25);
		pastriesPic = new JLabel();
		pastriesPic.setIcon(new ImageIcon("images/pastries.png"));
		pastries.add(pastriesPic);

		// panels
		panelMenu.setBounds(30, 200, 900, 200);
		panelMenu.setLayout(null);
		panelMenu2.setBounds(30,450, 900, 200);
		panelMenu2.setLayout(null);

		// coffee buttons
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JButton button6 = new JButton();

		// pastries buttons
		JButton button7 = new JButton();
		JButton button8 = new JButton();
		JButton button9 = new JButton();
		JButton button10 = new JButton();
		JButton button11 = new JButton();
		JButton button12 = new JButton();

		// coffee placement and size
		button1.setBounds(0, 0, 150, 200);
		button2.setBounds(150, 0, 150, 200);
		button3.setBounds(300, 0, 150, 200);
		button4.setBounds(450, 0, 150, 200);
		button5.setBounds(600, 0, 150, 200);
		button6.setBounds(750, 0, 150, 200);

		// pastries placement and size
		button7.setBounds(0, 0, 150, 200);
		button8.setBounds(150, 0, 150, 200);
		button9.setBounds(300, 0, 150, 200);
		button10.setBounds(450, 0, 150, 200);
		button11.setBounds(600, 0, 150, 200);
		button12.setBounds(750, 0, 150, 200);

		// coffee info
		addButtonActionListener(button1, "Matcha Latte", 250,"items/MatchaLatte.png");
		addButtonActionListener(button2, "Espresso", 110,"items/Espresso.png");
		addButtonActionListener(button3, "Caramel Macchiato",200 ,"items/CarMacchiato.png");
		addButtonActionListener(button4, "Choco Coffee Frappe", 170,"items/ChocoCoffFrap.png");
		addButtonActionListener(button5, "Iced Latte",99 ,"items/IcedLatte.png");
		addButtonActionListener(button6, "Coffee Milk Latte",220 ,"items/CoffeeLatte.png");

		// pastries info
		addButtonActionListener(button7, "Cheesecake Mousse", 300,"items/Cheesecake.png");
		addButtonActionListener(button8, "Red Velvet Cake", 270,"items/RedCake.png");
		addButtonActionListener(button9, "Chocolate Mousse",229 ,"items/ChocoCheesecake.png");
		addButtonActionListener(button10, "Garlic Bread",99 ,"items/GarlicBread.png");
		addButtonActionListener(button11, "Glazed Donut", 70,"items/GlazedDonut.png");
		addButtonActionListener(button12, "Croissant", 99,"items/Croissant.png");
		
		// coffee buttons
		panelMenu.add(button1);
		panelMenu.add(button2);
		panelMenu.add(button3);
		panelMenu.add(button4);
		panelMenu.add(button5);
		panelMenu.add(button6);

		// pastries buttons
		panelMenu2.add(button7);
		panelMenu2.add(button8);
		panelMenu2.add(button9);
		panelMenu2.add(button10);
		panelMenu2.add(button11);
		panelMenu2.add(button12);

		//panels visible
		panelMenu.setVisible(true);
		panelMenu2.setVisible(true);
		coffee.setVisible(true);
		pastries.setVisible(true);
	}
	
	
	//buttons function
	private void addButtonActionListener(JButton button, String itemName, int price, String iconPath) {
		button.setIcon(new ImageIcon(iconPath));

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add the selected item to the cart
				Cart.addItemToCart(itemName, price);
			}
		});
	}
}

